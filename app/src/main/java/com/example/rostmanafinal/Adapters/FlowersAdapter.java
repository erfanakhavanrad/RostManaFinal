package com.example.rostmanafinal.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rostmanafinal.Pojo.FlowerListClass;
import com.example.rostmanafinal.R;

import java.util.ArrayList;

public class FlowersAdapter extends RecyclerView.Adapter<FlowersAdapter.TViewHolder> {


    ArrayList<FlowerListClass> mylist;

    public FlowersAdapter(ArrayList<FlowerListClass> list) {
        mylist = list;
    }

    @NonNull
    @Override
    public TViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.recycler_item, parent, false);
        TViewHolder holder = new TViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TViewHolder holder, int position) {
        FlowerListClass flower = mylist.get(position);
        holder.flowerName.setText(flower.getName());
        holder.iamgeEach.setImageResource(flower.getPic());
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    class TViewHolder extends RecyclerView.ViewHolder {
        TextView flowerName;
        ImageView iamgeEach;

        public TViewHolder(@NonNull final View itemView) {
            super(itemView);
            flowerName = itemView.findViewById(R.id.flowerText);
            iamgeEach = itemView.findViewById(R.id.iamgeEach);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FlowerListClass flowerClass = mylist.get(getAdapterPosition());

                    // getAdapterPosition()
//                    Intent intent = new Intent(itemView.getContext(), MainActivity.class);
//                    intent.putExtra("id", flowerClass.getName());
//                    itemView.getContext().startActivity(intent);

                    Toast.makeText(itemView.getContext(), "id is " + flowerClass.getName(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }



}