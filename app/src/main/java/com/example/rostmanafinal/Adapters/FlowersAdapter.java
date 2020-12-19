package com.example.rostmanafinal.Adapters;

import android.app.Activity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rostmanafinal.Fragments.FragmentGreenLeaf;
import com.example.rostmanafinal.Fragments.FragmentOrganic;
import com.example.rostmanafinal.Fragments.Fragment_Plant_Details;
import com.example.rostmanafinal.Pojo.FlowerListClass;
import com.example.rostmanafinal.R;

import java.util.ArrayList;

public class FlowersAdapter extends RecyclerView.Adapter<FlowersAdapter.TViewHolder> {


    ArrayList<FlowerListClass> mylist;
    FragmentActivity activity;

    public FlowersAdapter(ArrayList<FlowerListClass> list,FragmentActivity activity) {
        mylist = list;
        this.activity = activity;
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
                    activity.getSupportFragmentManager();
                    FragmentManager fragmentManager = activity.getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    Fragment_Plant_Details fn = new Fragment_Plant_Details();
                    fragmentTransaction.replace(R.id.nav_host_fragment, fn);
                    fragmentTransaction.commit();
                    Toast.makeText(itemView.getContext(), "id is " + flowerClass.getName(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }



}
