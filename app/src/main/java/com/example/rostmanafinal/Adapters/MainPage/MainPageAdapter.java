package com.example.rostmanafinal.Adapters.MainPage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rostmanafinal.Interfaces.ChangingFragmentsInterface;
import com.example.rostmanafinal.Pojo.FlowerListClass;
import com.example.rostmanafinal.Pojo.HeydariTest;
import com.example.rostmanafinal.Pojo.PojoEnterPost.Example;
import com.example.rostmanafinal.R;
import com.loopj.android.http.BlackholeHttpResponseHandler;

import java.util.ArrayList;
import java.util.List;

public class MainPageAdapter extends RecyclerView.Adapter<MainPageAdapter.MainPageViewHolder> {
    ArrayList<HeydariTest> myList;
    public MainPageAdapter(ArrayList<HeydariTest> list) {
        myList = list;
    }

    @NonNull
    @Override
    public MainPageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        View v = inflater.inflate(R.layout.main_page_recycler_item, parent, false);
//        MainPageAdapter holder = new MainPageAdapter(v);
//        return holder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_page_recycler_item, parent, false);
        return new MainPageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainPageViewHolder holder, int position) {
        /** FlowerListClass flower = mylist.get(position);
         holder.flowerName.setText(flower.getName());
         holder.iamgeEach.setImageResource(flower.getPic()); */
//        HeydariTest heydariTest = mylist.get(position);
//        holder.itemView
        HeydariTest heydari = myList.get(position);
        holder.imageView.setImageResource(heydari.getPic());
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class MainPageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public MainPageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.itemImageFlowerMainPage);
        }
    }

}
