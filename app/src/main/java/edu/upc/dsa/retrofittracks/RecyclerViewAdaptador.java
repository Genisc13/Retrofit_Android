package edu.upc.dsa.retrofittracks;

import edu.upc.dsa.retrofittracks.models.Map;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView id,cost,description;
        ImageView fotoMap;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id=(TextView)itemView.findViewById(R.id.tvid);
            cost=(TextView)itemView.findViewById(R.id.tvname);
            description=(TextView)itemView.findViewById(R.id.tvdescription);
            fotoMap =(ImageView) itemView.findViewById(R.id.imgMap);
        }
    }
    public List<Map> maps;

    public RecyclerViewAdaptador(List<Map> maps) {
        this.maps = maps;
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
        holder.cost.setText(maps.get(position).getName());
        holder.fotoMap.setImageResource(R.drawable.paisaje);
    }

    @Override
    public int getItemCount() {
        return maps.size();
    }
}

