package edu.upc.dsa.retrofittracks;

import edu.upc.dsa.retrofittracks.models.Gadget;
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
        ImageView fotoGadget;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id=(TextView)itemView.findViewById(R.id.tvid);
            cost=(TextView)itemView.findViewById(R.id.tvcost);
            description=(TextView)itemView.findViewById(R.id.tvdescription);
            fotoGadget=(ImageView) itemView.findViewById(R.id.imgGadget);
        }
    }
    public List<Gadget> gadgets;

    public RecyclerViewAdaptador(List<Gadget> gadgets) {
        this.gadgets = gadgets;
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
        holder.id.setText(gadgets.get(position).getId());
        holder.description.setText(gadgets.get(position).getDescription());
        holder.cost.setText(Integer.toString(gadgets.get(position).getCost()));
        holder.fotoGadget.setImageResource(gadgets.get(position).getUnityShape());
    }

    @Override
    public int getItemCount() {
        return gadgets.size();
    }
}

