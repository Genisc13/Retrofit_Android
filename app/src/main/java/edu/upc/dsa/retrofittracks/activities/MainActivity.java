package edu.upc.dsa.retrofittracks.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.upc.dsa.retrofittracks.Api;
import edu.upc.dsa.retrofittracks.R;
import edu.upc.dsa.retrofittracks.RecyclerViewAdaptador;
import edu.upc.dsa.retrofittracks.RecyclerViewClickListener;
import edu.upc.dsa.retrofittracks.RetrofitClient;
import edu.upc.dsa.retrofittracks.models.Map;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity implements RecyclerViewClickListener {

    private RecyclerView recyclerViewGadget;
    private RecyclerViewAdaptador adaptadorGadget;
    Api APIservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewGadget= (RecyclerView) findViewById(R.id.recyclerTrack);
        recyclerViewGadget.setLayoutManager(new LinearLayoutManager(this));
        APIservice = RetrofitClient.getInstance().getMyApi();
        Call<List<Map>> call = APIservice.getMaps();
        try {
            List<Map> maps=call.execute().body();
            adaptadorGadget = new RecyclerViewAdaptador(maps,this::recyclerViewListClicked);
        }
        catch (IOException e){
            e.printStackTrace();
        }
            recyclerViewGadget.setAdapter(adaptadorGadget);
        }
    @Override
    public void recyclerViewListClicked(int position) {
        Map map=adaptadorGadget.maps.get(position);
        Intent intent=new Intent(MainActivity.this,MainActivity.class);
        Bundle adapterInfo = new Bundle();
        adapterInfo.putString("id",map.getId());
        adapterInfo.putString("name",map.getName());
        adapterInfo.putString("type",map.getType());
        adapterInfo.putString("size",map.getSize());
        intent.putExtras(adapterInfo);
        MainActivity.this.startActivity(intent);
    }
}