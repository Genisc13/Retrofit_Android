package edu.upc.dsa.retrofittracks.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import edu.upc.dsa.retrofittracks.R;
import edu.upc.dsa.retrofittracks.RecyclerViewAdaptador;
import edu.upc.dsa.retrofittracks.models.Gadget;

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
    public List<Gadget> getGadgets(){
        List<Gadget> lista= new ArrayList<>();
        lista.add(new Gadget("dawe4123432",4,"Cazatormentas",R.drawable.daddyyankee));
        lista.add(new Gadget("dawe532",4,"Lobo nocturno",R.drawable.pitbull));
        lista.add(new Gadget("dawe4123546432",4,"Predicemientos",R.drawable.shakira));
        return lista;
    }
}