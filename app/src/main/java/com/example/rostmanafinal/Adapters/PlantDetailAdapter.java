package com.example.rostmanafinal.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        View view = inflater.inflate(R.layout.fragment_plant_details, parent, false);
        com.example.rostmanafinal.Adapters.PlantDetailAdapter.ViewHolder holder = new ViewHolder(view);
        return holder;

    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        PlantDetailClass plantdetailsClass = plantDetailsList2.get(position);
//        holder.imageView.setImageResource(plantdetailsClass.getPic());
        //        holder.imageView.setImageResource(R.drawable.s_one);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "clicked" + position, Toast.LENGTH_SHORT).show();

//                app.set_fragment2((FragmentActivity) context, R.id.fragment_Structure_Detail, null);
            }
        });


    }

    @Override
    public int getItemCount() {
        return plantDetailsList2.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;


        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_Structure);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PlantDetailClass item = plantDetailsList2.get(getAdapterPosition());
//If shit happened remove the below line
//                    Intent intentStructure = new Intent(itemView.getContext(), MainActivity.class);
//                    intentStructure.putExtra("id", item.getId());
//                    itemView.getContext().startActivity(intentStructure);

//                    Toast.makeText(itemView.getContext(), "position is " + item.getId(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(itemView.getContext(), "position is " + item.getId(), Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

}