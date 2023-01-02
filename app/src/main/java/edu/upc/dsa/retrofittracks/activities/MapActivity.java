package edu.upc.dsa.retrofittracks.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import edu.upc.dsa.retrofittracks.Api;
import edu.upc.dsa.retrofittracks.R;
import edu.upc.dsa.retrofittracks.RetrofitClient;
import edu.upc.dsa.retrofittracks.models.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapActivity extends AppCompatActivity {

    Api apiService;

    String id;
    String name;
    String type;
    String size;

    TextInputEditText name_edit;
    TextInputEditText type_edit;
    TextInputEditText size_edit;

    TextView id_tv;
    TextView name_tv;
    TextView type_tv;
    TextView size_tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_actual);
        apiService= RetrofitClient.getInstance().getMyApi();
        name_edit = (TextInputEditText) findViewById(R.id.name_edit);
        type_edit = (TextInputEditText) findViewById(R.id.type_edit);
        size_edit = (TextInputEditText) findViewById(R.id.size_edit);

        id_tv = (TextView) findViewById(R.id.idtv);
        name_tv = (TextView) findViewById(R.id.nametv);
        type_tv = (TextView) findViewById(R.id.typetv);
        size_tv = (TextView) findViewById(R.id.sizetv);

        Bundle content = getIntent().getExtras();
        if(content != null){
            this.id = content.getString("id");
            this.name = content.getString("name");
            this.type = content.getString("type");
            this.size=content.getString("size");
            refreshTextViews();
        }
    }
    public void editMap(View view){
        if(!name_edit.getText().toString().equals("")){
            this.name=name_edit.getText().toString();
        }
        if(!type_edit.getText().toString().equals("")){
            this.type=type_edit.getText().toString();
        }
        if(!size_edit.getText().toString().equals("")){
            this.size=size_edit.getText().toString();
        }
        Call<Void> call= apiService.updateMap(new Map(id,name,type,size));
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
    private void refreshTextViews(){
        id_tv.setText(this.id);
        name_tv.setText(this.name);
        type_tv.setText(this.type);
        size_tv.setText(this.size);
    }
    public void back_button(View view){
        Intent intentTracks = new Intent(MapActivity.this, MainActivity.class);
        MapActivity.this.startActivity(intentTracks);
    }
}