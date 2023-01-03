package edu.upc.dsa.retrofittracks.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

import edu.upc.dsa.retrofittracks.Api;
import edu.upc.dsa.retrofittracks.R;
import edu.upc.dsa.retrofittracks.RetrofitClient;
import edu.upc.dsa.retrofittracks.models.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class addMapActivity extends AppCompatActivity {


    Api apiService;
    TextInputEditText id_create;
    TextInputEditText name_create;
    TextInputEditText type_create;
    TextInputEditText size_create;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_map);
        apiService= RetrofitClient.getInstance().getMyApi();
        id_create = (TextInputEditText) findViewById(R.id.id_create);
        name_create = (TextInputEditText) findViewById(R.id.name_create);
        type_create = (TextInputEditText) findViewById(R.id.type_create);
        size_create = (TextInputEditText) findViewById(R.id.size_create);

    }
    public void createMap(View view){
        String id =id_create.getText().toString();
        String name =name_create.getText().toString();
        String type =type_create.getText().toString();
        String size =size_create.getText().toString();
        Call<Map> call= apiService.addMap(new Map(id,name,type,size));
        call.enqueue(new Callback<Map>() {
            @Override
            public void onResponse(Call<Map> call, Response<Map> response) {

            }

            @Override
            public void onFailure(Call<Map> call, Throwable t) {

            }
        });
        Intent intentTracks = new Intent(addMapActivity.this, MainActivity.class);
        addMapActivity.this.startActivity(intentTracks);
    }
    public void back_button2(View view){
        Intent intentTracks = new Intent(addMapActivity.this, MainActivity.class);
        addMapActivity.this.startActivity(intentTracks);
    }

}