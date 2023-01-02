package edu.upc.dsa.retrofittracks;

import edu.upc.dsa.retrofittracks.models.Map;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.List;


public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder> {

    public List<Map> maps;
    public ViewHolder viewHolder;

    private static RecyclerViewClickListener itemListener;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView id, name,description,size;
        ImageView fotoMap;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id=(TextView)itemView.findViewById(R.id.tvid);
            name =(TextView)itemView.findViewById(R.id.tvname);
            description=(TextView)itemView.findViewById(R.id.tvdescription);
            size=(TextView)itemView.findViewById(R.id.tvsize);
            fotoMap =(ImageView) itemView.findViewById(R.id.imgMap);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            itemListener.recyclerViewListClicked(this.getLayoutPosition());
        }
    }


    public RecyclerViewAdaptador(List<Map> maps,RecyclerViewClickListener itemListener) throws IOException {
        this.maps = maps;
        this.itemListener=itemListener;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gadget,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.id.setText(maps.get(position).getId());
        holder.description.setText(maps.get(position).getType());
        holder.name.setText(maps.get(position).getName());
        holder.size.setText(maps.get(position).getSize());
        holder.fotoMap.setImageResource(R.drawable.paisaje);
    }

    @Override
    public int getItemCount() {
        return maps.size();
    }
}

