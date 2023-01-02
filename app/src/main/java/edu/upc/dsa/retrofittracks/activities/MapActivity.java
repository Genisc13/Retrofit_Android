package edu.upc.dsa.retrofittracks.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import edu.upc.dsa.retrofittracks.Api;
import edu.upc.dsa.retrofittracks.R;

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
    }
}