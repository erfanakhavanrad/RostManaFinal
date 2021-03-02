package com.example.rostmanafinal.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rostmanafinal.Pojo.ModelChoosePlant.SeasonalModel;
import com.example.rostmanafinal.Pojo.ModelChoosePlant.SecondSeasonalModel;
import com.example.rostmanafinal.R;

import java.util.ArrayList;
import java.util.List;

public class SecondPlantDetailAdapter extends RecyclerView.Adapter<SecondPlantDetailAdapter.SecondPlantDetailAdapterViewHolder> {
        ArrayList<SecondSeasonalModel> plantDetailsList2;
//    List<SecondSeasonalModel> seasonalModels;

    Context context;
    public SecondPlantDetailAdapter(ArrayList<SecondSeasonalModel> plantDetails1, Context context) {
        plantDetailsList2 = plantDetails1;
//        seasonalModels = plantDetails1;
        this.context = context;
    }
    public void setList(ArrayList<SecondSeasonalModel> list){
        this.plantDetailsList2 = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SecondPlantDetailAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.recycler_item_plant_details, parent, false);
        SecondPlantDetailAdapterViewHolder secondPlantDetailAdapterViewHolder = new SecondPlantDetailAdapterViewHolder(v);
        return secondPlantDetailAdapterViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SecondPlantDetailAdapterViewHolder holder, int position) {
        SecondSeasonalModel plantdetailsClass = plantDetailsList2.get(position);
        //        holder.imageView.setImageResource(R.drawable.s_one);
//        holder.imageView.setImageResource(plantdetailsClass.getPhoto());
        holder.txtTitle.setText(plantdetailsClass.getName());
        holder.txtValue.setText(plantdetailsClass.getTimeFertilizer().toString());
        holder.imageIcon.setImageResource(plantdetailsClass.getPhoto());
    }

    @Override
    public int getItemCount() {
        return plantDetailsList2.size();
    }


    /**
     * ViewHolder
     */
    public class SecondPlantDetailAdapterViewHolder extends RecyclerView.ViewHolder {
        ImageView imageIcon;
        TextView txtTitle, txtValue;


        public SecondPlantDetailAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            txtValue = itemView.findViewById(R.id.txtValue);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            imageIcon = itemView.findViewById(R.id.imageIcon);
        }
    }
}
