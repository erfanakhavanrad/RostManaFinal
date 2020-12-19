package com.example.rostmanafinal.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rostmanafinal.Adapters.FlowersAdapter;
import com.example.rostmanafinal.Pojo.FlowerListClass;
import com.example.rostmanafinal.R;

import java.util.ArrayList;

public class FragmentSeasonalFlowers extends Fragment {
    RecyclerView recycler;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewSeasonal = inflater.inflate(R.layout.recycler_for_flowers, container, false);

        return viewSeasonal;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycler = view.findViewById(R.id.recycler);
        ArrayList<FlowerListClass> names = new ArrayList();
        names.add(new FlowerListClass("اپونتیا", R.drawable.limo));
        names.add(new FlowerListClass("اچینو", R.drawable.benjamin));
        names.add(new FlowerListClass("استرافینوم", R.drawable.ic_seasonalflowers));
        names.add(new FlowerListClass("افوربیا لاکتی", R.drawable.benjamin));
        names.add(new FlowerListClass("آلوئه ورا", R.drawable.ic_cactus));
        names.add(new FlowerListClass("پایه چرمی", R.drawable.benjamin));
        names.add(new FlowerListClass("خورشیدی", R.drawable.limo));
        names.add(new FlowerListClass("ژمینو", R.drawable.limo));
        names.add(new FlowerListClass("ژمینوکالیسیم", R.drawable.ic_greenleaf));
        names.add(new FlowerListClass("سانسوریا", R.drawable.ic_shrub));
        names.add(new FlowerListClass("سولکو", R.drawable.ic_cactus));
        names.add(new FlowerListClass("فرو", R.drawable.ic_organic));
        names.add(new FlowerListClass("ماملاریا", R.drawable.ic_shrub));
        names.add(new FlowerListClass("نولآبی", R.drawable.limo));
        names.add(new FlowerListClass("نازقرمز", R.drawable.ic_seasonalflowers));
        names.add(new FlowerListClass("نخل ماداگاسکار", R.drawable.benjamin));
        names.add(new FlowerListClass("هاورتیا گورخری", R.drawable.ic_organic));


        //Adapter
        FlowersAdapter adapter = new FlowersAdapter(names);
        recycler.setAdapter(adapter);

        recycler.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));


    }
}
