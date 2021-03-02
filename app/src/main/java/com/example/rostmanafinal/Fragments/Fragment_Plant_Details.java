package com.example.rostmanafinal.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rostmanafinal.Adapters.PlantDetailAdapter;
import com.example.rostmanafinal.Adapters.SecondPlantDetailAdapter;
import com.example.rostmanafinal.Pojo.ModelChoosePlant.SeasonalModel;
import com.example.rostmanafinal.Pojo.ModelChoosePlant.SecondSeasonalModel;
import com.example.rostmanafinal.Pojo.ModelChoosePlant.SingleFlowerModel;
import com.example.rostmanafinal.R;
import com.example.rostmanafinal.UserManagerSharedPrefs;
import com.squareup.picasso.Picasso;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

public class Fragment_Plant_Details extends Fragment {
    private static final String TAG = "Fragment_Plant_Details";
    RecyclerView recyclerPlantDetail;
    ImageView image_check, image_cancel, imagePlant;
    TextView txtName, txtEName;
    String showPhoto, id;
    Button btn_detail;
    UserManagerSharedPrefs userManagerSharedPrefs;
    //    List<Mydata> mydataList = new ArrayList<>();
//    List<SeasonalModel> seasonalModels = new ArrayList<>();
    ArrayList<SecondSeasonalModel> secondSeasonalModels = new ArrayList<>();
    //    List<SingleFlowerModel> singleFlowerModelArrayList = new ArrayList<>();
//    SingleFlowerModel singleFlowerModel = new SingleFlowerModel();
    SingleFlowerModel singleFlowerModelArrayList = new SingleFlowerModel();
    //    PlantDetailAdapter adapter;
    SecondPlantDetailAdapter adapter;
    Bundle bundle = new Bundle();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plant_details, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bundle = this.getArguments();
        recyclerPlantDetail = view.findViewById(R.id.recyclerPlantDetail);
        btn_detail = view.findViewById(R.id.btn_detail);
        imagePlant = view.findViewById(R.id.imagePlant);
        txtName = view.findViewById(R.id.txtName);
        txtEName = view.findViewById(R.id.txtEName);
        if (bundle != null) {
            String getIdgetName, getEName, getPWaterS, getPWaterW, getTimeFertilizer, getPrune,
                    getPlanttype, getTemp, getLight, getHumiditySoil, getHumidityAir, getSoilId, getFertilizerId,
                    getPhoto, getDescription, nameExtra, amountExtra;
            nameExtra = bundle.getString("nameKey");
            amountExtra = bundle.getString("amountKey");
            getEName = bundle.getString("getEName");
            id = bundle.getString("getId");
            getTemp = bundle.getString("getTemp");
            getPhoto = bundle.getString("getPhoto");
            showPhoto = "http://rostmana.com" + getPhoto;
            getHumiditySoil = bundle.getString("getHumiditySoil");
            getLight = bundle.getString("getLight");
            getPWaterS = bundle.getString("getPWaterS");
            getPWaterW = bundle.getString("getPWaterW");
            getDescription = bundle.getString("getDescription");
            txtEName.setText(getEName);

            //Just add your data in list
//            Mydata mydata = new Mydata();  // object of Model Class
//            mydata.setAmountExtra(amountExtra );
//            mydata.setNameExtra(nameExtra);
//            mydataList.add(mydata);
//            SeasonalModel seasonalModel = new SeasonalModel();
            if (getDescription == null)
                btn_detail.setVisibility(View.INVISIBLE);

            SecondSeasonalModel secondSeasonalModel = new SecondSeasonalModel(2, "دما", "333333333"
                    , R.drawable.ic_temperatureicon_svg, R.drawable.ic_seasonalflowers, "ddaddad", getTemp, "fsefsff",
                    52, 12, 532, 87,
                    85, 31, 532, 222);
            secondSeasonalModels.add(secondSeasonalModel);

            SecondSeasonalModel secondSeasonalModel2 = new SecondSeasonalModel(2, "رطوبت هوا", "55555555555"
                    , R.drawable.ic_humidity_svg, R.drawable.ic_humidity_svg, "ddaddad",
                    "", "fsfesfsf", "fsefsff",
                    52, 12, 532, 87,
                    85, 31, 532);
            secondSeasonalModels.add(secondSeasonalModel2);

            SecondSeasonalModel secondSeasonalModel3 = new SecondSeasonalModel(2, "نور", "bnvnvbcb"
                    , R.drawable.ic_light_svg, R.drawable.ic_seasonalflowers, "ddaddad",
                    getLight.toString(), "fsfesfsf", "fsefsff",
                    52, 12, 532, 87,
                    85, 31, 532);
            secondSeasonalModels.add(secondSeasonalModel3);

            SecondSeasonalModel secondSeasonalModel4 = new SecondSeasonalModel(2, "آبیاری در تابستان", "bnvnvbcb"
                    , R.drawable.ic_watering_svg, R.drawable.ic_seasonalflowers, "ddaddad",
                    getPWaterS.toString(), "fsfesfsf", "fsefsff",
                    52, 12, 532, 87,
                    85, 31, 532);
            secondSeasonalModels.add(secondSeasonalModel4);
/*

            SecondSeasonalModel secondSeasonalModel5 = new SecondSeasonalModel(2, "آبیاری در زمستان", "bnvnvbcb"
                    , R.drawable.ic_fog_svg, R.drawable.ic_seasonalflowers, "ddaddad",
                    getPWaterW.toString(), "fsfesfsf", "fsefsff",
                    52, 12, 532, 87,
                    85, 31, 532);
            secondSeasonalModels.add(secondSeasonalModel5);

            SecondSeasonalModel secondSeasonalModel6 = new SecondSeasonalModel(2, "کوددهی", "bnvnvbcb"
                    , R.drawable.ic_vaporizer_svg, R.drawable.ic_seasonalflowers, "ddaddad",
                    "fddfddf", "fsfesfsf", "fsefsff",
                    52, 12, 532, 87,
                    85, 31, 532);
            secondSeasonalModels.add(secondSeasonalModel6);

            SecondSeasonalModel secondSeasonalModel7 = new SecondSeasonalModel(2, "سم پاشی", "bnvnvbcb"
                    , R.drawable.ic_spraying, R.drawable.ic_seasonalflowers, "ddaddad",
                    "fddfddf", "fsfesfsf", "fsefsff",
                    52, 12, 532, 87,
                    85, 31, 532);
            secondSeasonalModels.add(secondSeasonalModel7);

            SecondSeasonalModel secondSeasonalModel8 = new SecondSeasonalModel(2, "هرس", "bnvnvbcb"
                    , R.drawable.ic_prune, R.drawable.ic_seasonalflowers, "ddaddad",
                    "fddfddf", "fsfesfsf", "fsefsff",
                    52, 12, 532, 87,
                    85, 31, 532);
            secondSeasonalModels.add(secondSeasonalModel8);

            SecondSeasonalModel secondSeasonalModel9 = new SecondSeasonalModel(2, "برداشت", "bnvnvbcb"
                    , R.drawable.ic_harvest, R.drawable.ic_seasonalflowers, "ddaddad",
                    "fddfddf", "fsfesfsf", "fsefsff",
                    52, 12, 532, 87,
                    85, 31, 532);
            secondSeasonalModels.add(secondSeasonalModel9);
*/

//            seasonalModel.setEName(getEName);

//            seasonalModels.add(seasonalModel);
//            String ssf = seasonalModel.getEName().toString();
//            txtEName.setText(ssf);
//            adapter = new PlantDetailAdapter(secondSeasonalModel, getContext());
            adapter = new SecondPlantDetailAdapter(secondSeasonalModels, getContext());
        }
//txtEName.setText();

//        SeasonalModel seasonalModel = (SeasonalModel) bundle.getSerializable("seasonalBundle");


// else if (getDescription == null)
//     btn_detail.setVisibility(View.VISIBLE);
        /**
         * get your id from previous fragment
         */
        String getName = bundle.getString("getName");
        Picasso.get().load(showPhoto).placeholder(R.drawable.logo).into(imagePlant);
        txtName.setText(getName);
        SeasonalModel seasonalModel;
        ArrayList<SecondSeasonalModel> secondSeasonalModelArrayList = new ArrayList<>();

//        secondSeasonalModelArrayList.add(new SecondSeasonalModel(2, "adawdawd", "bnvnvbcb"
//        , R.drawable.benjamin, "sefsfs", "ddaddad",
//                "fddfddf", "fsfesfsf", "fsefsff",
//                "fsfefsff", "122", "fdsdsd", "231",
//                "34322", "244", "42344"
//        ));

        recyclerPlantDetail.setLayoutManager(new GridLayoutManager(getContext(), 2));
//        recyclerPlantDetail.setLayoutManager(new GridLayoutManager(getContext()
//                , RecyclerView.VERTICAL, false));
        recyclerPlantDetail.setAdapter(adapter);

    }

}


/**
 * plantDetailListArray.add(new PlantDetailClass("rose", "12", R.drawable.ic_launcher_background, "native",
 * 12, "wet", "itSprinkles", "twice a month", "natural light",
 * "soil", "potasium manure", "twice a week"));
 * <p>
 * <p>
 *
 * <p>
 * plantDetailListArray.add(new PlantDetailClass("tulips", "12", R.drawable.limo, "native",
 * 12, "wet", "itSprinkles", "twice a month", "natural light",
 * "soil", "potasium manure", "twice a week"));
 * <p>
 * plantDetailListArray.add(new PlantDetailClass("tulips", "12", R.drawable.benjamin, "native",
 * 12, "wet", "itSprinkles", "twice a month", "natural light",
 * "soil", "potasium manure", "twice a week"));
 * plantDetailListArray.add(new PlantDetailClass("tulips", "12", R.drawable.ic_seasonalflowers, "native",
 * 12, "wet", "itSprinkles", "twice a month", "natural light",
 * "soil", "potasium manure", "twice a week"));
 * plantDetailListArray.add(new PlantDetailClass("tulips", "12", R.drawable.benjamin, "native",
 * 12, "wet", "itSprinkles", "twice a month", "natural light",
 */