package edu.upc.dsa.retrofittracks.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import edu.upc.dsa.retrofittracks.R;
import edu.upc.dsa.retrofittracks.RecyclerViewAdaptador;
import edu.upc.dsa.retrofittracks.models.Map;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewGadget;
    private RecyclerViewAdaptador adaptadorGadget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewGadget= (RecyclerView) findViewById(R.id.recyclerTrack);
        recyclerViewGadget.setLayoutManager(new LinearLayoutManager(this));

        adaptadorGadget=new RecyclerViewAdaptador(getGadgets());
        recyclerViewGadget.setAdapter(adaptadorGadget);
    }
    public List<Map> getGadgets(){
        List<Map> lista= new ArrayList<>();
        lista.add(new Map("Mordor","Vacío","Grande",""));
        lista.add(new Map("Mordor","Vacío","Grande",""));
        lista.add(new Map("Mordor","Vacío","Grande",""));
        return lista;
    }
}