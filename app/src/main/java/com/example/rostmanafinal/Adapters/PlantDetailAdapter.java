package com.example.rostmanafinal.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rostmanafinal.Pojo.ModelChoosePlant.SeasonalModel;
import com.example.rostmanafinal.Pojo.ModelChoosePlant.SingleFlowerModel;
import com.example.rostmanafinal.R;

import java.util.ArrayList;
import java.util.List;

public class PlantDetailAdapter extends RecyclerView.Adapter<com.example.rostmanafinal.Adapters.PlantDetailAdapter.ViewHolder> {
    //    ArrayList<PlantDetailClass> plantDetailsList2;
    List<SeasonalModel> seasonalModels;

    Context context;

    public PlantDetailAdapter(List<SeasonalModel> plantDetails1, Context context) {
//        plantDetailsList2 = plantDetails1;
        seasonalModels = plantDetails1;
        this.context = context;
    }


    public void setList(List<SeasonalModel> list){
        this.seasonalModels = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_item_plant_details, parent, false);
        com.example.rostmanafinal.Adapters.PlantDetailAdapter.ViewHolder holder = new ViewHolder(view);
        return holder;

    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        SeasonalModel plantdetailsClass = seasonalModels.get(position);
        //        holder.imageView.setImageResource(R.drawable.s_one);
//        holder.imageView.setImageResource(plantdetailsClass.getPhoto());
        holder.txtTitle.setText(plantdetailsClass.getName());
        holder.txtDescription.setText(plantdetailsClass.getName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "clicked" + position, Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return seasonalModels.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView txtDescription, txtTitle;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            txtDescription = itemView.findViewById(R.id.txtValue);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            imageView = itemView.findViewById(R.id.imageIcon);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SeasonalModel item = seasonalModels.get(getAdapterPosition());
                    Toast.makeText(itemView.getContext(), "position is " + item.getId(), Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}