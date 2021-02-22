package com.example.rostmanafinal.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rostmanafinal.Adapters.PlantDetailAdapter;
import com.example.rostmanafinal.Pojo.ModelChoosePlant.SeasonalModel;
import com.example.rostmanafinal.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Fragment_Plant_Details extends Fragment {

    RecyclerView recyclerPlantDetail;
    ImageView image_check, image_cancel, imagePlant;
    Bundle bundle = new Bundle();
    TextView txtName, txtEName;
    String showPhoto, getPhoto;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View v = inflater.inflate(R.layout.fragment_plant_details, container, false);


        View view = inflater.inflate(R.layout.fragment_plant_details, container, false);

        return view;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bundle = this.getArguments();

        /**
         * get your id from previous fragment
         */
        imagePlant = view.findViewById(R.id.imagePlant);
        txtName = view.findViewById(R.id.txtName);
        txtEName = view.findViewById(R.id.txtEName);

        String getName = bundle.getString("getName");

        getPhoto = bundle.getString("getPhoto");
        showPhoto = "http://192.168.88.134:8000" + getPhoto;
        Picasso.get().load(showPhoto).placeholder(R.drawable.logo).into(imagePlant);
//        SeasonalModel seasonalModel = new SeasonalModel();
        txtName.setText(getName);
        image_cancel = view.findViewById(R.id.image_cancel);
        image_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_fragment_Plant_Details_to_firstFragment2);
            }
        });

        image_check = view.findViewById(R.id.image_check);
        image_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Navigation.findNavController(view).navigate(R.id.action_fragment_Plant_Details_to_fragmentHome);
                Navigation.findNavController(view).navigate(R.id.action_fragment_Plant_Details_to_fragmentGreenHouse2);
            }
        });


//        PlantDetailClass plantDetailClass;
//                = new StructuresClass("first", "flower", R.drawable.s_two);

        ArrayList<SeasonalModel> seasonalModels = new ArrayList();

        /** plantDetailListArray.add(new PlantDetailClass("rose", "12", R.drawable.ic_launcher_background, "native",
         12, "wet", "itSprinkles", "twice a month", "natural light",
         "soil", "potasium manure", "twice a week"));


         plantDetailListArray.add(new PlantDetailClass("lilly", "12", R.drawable.ic_seasonalflowers, "native",
         12, "wet", "itSprinkles", "twice a month", "natural light",
         "soil", "potasium manure", "twice a week"));

         plantDetailListArray.add(new PlantDetailClass("tulips", "12", R.drawable.limo, "native",
         12, "wet", "itSprinkles", "twice a month", "natural light",
         "soil", "potasium manure", "twice a week"));

         plantDetailListArray.add(new PlantDetailClass("tulips", "12", R.drawable.benjamin, "native",
         12, "wet", "itSprinkles", "twice a month", "natural light",
         "soil", "potasium manure", "twice a week"));
         plantDetailListArray.add(new PlantDetailClass("tulips", "12", R.drawable.ic_seasonalflowers, "native",
         12, "wet", "itSprinkles", "twice a month", "natural light",
         "soil", "potasium manure", "twice a week"));
         plantDetailListArray.add(new PlantDetailClass("tulips", "12", R.drawable.benjamin, "native",
         12, "wet", "itSprinkles", "twice a month", "natural light",
         "soil", "potasium manure", "twice a week"));
         plantDetailListArray.add(new PlantDetailClass("tulips", "12", R.drawable.limo, "native",
         12, "wet", "itSprinkles", "twice a month", "natural light",
         "soil", "potasium manure", "twice a week"));

         plantDetailListArray.add(new PlantDetailClass("tulips", "12", R.drawable.limo, "native",
         12, "wet", "itSprinkles", "twice a month", "natural light",
         "soil", "potasium manure", "twice a week"));
         plantDetailListArray.add(new PlantDetailClass("tulips", "12", R.drawable.limo, "native",
         12, "wet", "itSprinkles", "twice a month", "natural light",
         "soil", "potasium manure", "twice a week"));
         plantDetailListArray.add(new PlantDetailClass("tulips", "12", R.drawable.limo, "native",
         12, "wet", "itSprinkles", "twice a month", "natural light",
         "soil", "potasium manure", "twice a week"));
         */

        recyclerPlantDetail = view.findViewById(R.id.recyclerPlantDetail);
        PlantDetailAdapter plantDetailAdapter = new PlantDetailAdapter(seasonalModels, getActivity());
        recyclerPlantDetail.setAdapter(plantDetailAdapter);
//        recyclerPlantDetail.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));
        recyclerPlantDetail.setLayoutManager(new LinearLayoutManager(getContext()
                , RecyclerView.VERTICAL, false));
    }
}
