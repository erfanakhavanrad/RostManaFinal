package com.example.rostmanafinal.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.rostmanafinal.Adapters.PlantDetailAdapter;
import com.example.rostmanafinal.Pojo.PlantDetailClass;
import com.example.rostmanafinal.R;

import java.util.ArrayList;

public class Fragment_Plant_Details extends Fragment {

    RecyclerView recyclerPlantDetail;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View v = inflater.inflate(R.layout.fragment_plant_details, container, false);


        View view = inflater.inflate(R.layout.fragment_plant_details, container, false);


        PlantDetailClass plantDetailClass;
//                = new StructuresClass("first", "flower", R.drawable.s_two);

        ArrayList<PlantDetailClass> plantDetailListArray = new ArrayList();
        plantDetailListArray.add(new PlantDetailClass("rose", "12", R.drawable.ic_launcher_background, "native",
                12, "wet", "itSprinkles", "twice a month", "natural light",
                "soil", "potasium manure", "twice a week"));


        plantDetailListArray.add(new PlantDetailClass("rose", "12", R.drawable.ic_seasonalflowers, "native",
                12, "wet", "itSprinkles", "twice a month", "natural light",
                "soil", "potasium manure", "twice a week"));

        plantDetailListArray.add(new PlantDetailClass("rose", "12", R.drawable.ic_launcher_background, "native",
                12, "wet", "itSprinkles", "twice a month", "natural light",
                "soil", "potasium manure", "twice a week"));


        recyclerPlantDetail = view.findViewById(R.id.recyclerPlantDetail);
        PlantDetailAdapter plantDetailAdapter = new PlantDetailAdapter(plantDetailListArray, getActivity());
        recyclerPlantDetail.setAdapter(plantDetailAdapter);
//        recyclerPlantDetail.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));
        recyclerPlantDetail.setLayoutManager(new LinearLayoutManager(getContext()
                , RecyclerView.HORIZONTAL, false));
        return view;


    }
}
