package com.example.rostmanafinal.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rostmanafinal.Pojo.PlantDetailClass;
import com.example.rostmanafinal.R;

import java.util.ArrayList;

public class PlantDetailAdapter extends RecyclerView.Adapter<com.example.rostmanafinal.Adapters.PlantDetailAdapter.ViewHolder> {
    ArrayList<PlantDetailClass> plantDetailsList2;


    Context context;

    public PlantDetailAdapter(ArrayList<PlantDetailClass> plantDetails1, Context context) {
        plantDetailsList2 = plantDetails1;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.sweeping_plant_recycler, parent, false);
        com.example.rostmanafinal.Adapters.PlantDetailAdapter.ViewHolder holder = new ViewHolder(view);
        return holder;

    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        PlantDetailClass plantdetailsClass = plantDetailsList2.get(position);
        //        holder.imageView.setImageResource(R.drawable.s_one);
        holder.imageView.setImageResource(plantdetailsClass.getPic());
        holder.txtTitle.setText(plantdetailsClass.getpName());
        holder.txtDescription.setText(plantdetailsClass.getLight());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "clicked" + position, Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return plantDetailsList2.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView txtDescription, txtTitle;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            imageView = itemView.findViewById(R.id.imageCard);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PlantDetailClass item = plantDetailsList2.get(getAdapterPosition());
                    Toast.makeText(itemView.getContext(), "position is " + item.getId(), Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}