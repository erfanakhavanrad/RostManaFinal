package com.example.rostmanafinal.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rostmanafinal.Adapters.PlantDetailAdapter;
import com.example.rostmanafinal.Adapters.SecondPlantDetailAdapter;
import com.example.rostmanafinal.Interfaces.RetrofitApiService;
import com.example.rostmanafinal.Pojo.ModelChoosePlant.SeasonalModel;
import com.example.rostmanafinal.Pojo.ModelChoosePlant.SecondSeasonalModel;
import com.example.rostmanafinal.Pojo.ModelChoosePlant.SingleFlowerModel;
import com.example.rostmanafinal.Pojo.TicketModel;
import com.example.rostmanafinal.R;
import com.example.rostmanafinal.Retrofit.TokenInterceptor;
import com.example.rostmanafinal.UserManagerSharedPrefs;
import com.squareup.picasso.Picasso;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fragment_Plant_Details extends Fragment {
    private static final String TAG = "Fragment_Plant_Details";
    RecyclerView recyclerPlantDetail;
    ImageView image_check, image_cancel, imagePlant;
    TextView txtName, txtEName;
    String showPhoto, id, token, url = "http://192.168.88.134:8000/api/";
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
    RetrofitApiService request;

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
        image_cancel = view.findViewById(R.id.image_cancel);
        image_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_fragment_Plant_Details_to_firstFragment2);
            }
        });
        image_check = view.findViewById(R.id.image_check);
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
            getHumidityAir = bundle.getString("getHumidityAir");
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
                    getHumidityAir.toString(), "fsfesfsf", "fsefsff",
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
        image_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
            }
        });
    }

    public void sendRequest() {

        userManagerSharedPrefs = new UserManagerSharedPrefs(getContext());
//        token = userManagerSharedPrefs.getToken();
        token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiNDJiMjJiM2NlYzRhOWE5ODM4MmNjMmJlOTMxNmFkMTk1YWE3NTBmNjQxYjllYzliNjZlOGE5MWVjZDQ2M2VkNjJlMTYxODM2MjE1Y2E0MTAiLCJpYXQiOiIxNjE0NzU5NzgxLjk5OTQ2OCIsIm5iZiI6IjE2MTQ3NTk3ODEuOTk5NDczIiwiZXhwIjoiMTY0NjI5NTc4MS45OTIwNjUiLCJzdWIiOiI1NSIsInNjb3BlcyI6W119.HrwNMsO993TDIKW7G1ZLKct5B7PDqmwciVU3AMRG59zg6gt36QiLVqKGIF2oPZmnv_quFU3TrMqMDdXeWXPWv5MhIXaM3TAyGzPluYCh_ebYYBZDP1xExrjVL4gbLS9NQ6otaPhcKlRx8iIuSQej6NBjCXrvr04rJnVVCv2m4cYgLcfduVqyyVaCIB7UuWUideFm54AB7rbHTa80CVZseg2JIRkkCH6yiajn_octUi9ADIkyiVbI7InDvhyZyMkwY76sT67CiL7atSEwgGwGBYPaokuUllX3zAmd1hFzxf7de3acgjIB-w1kiUg912GstOzxEFFFDtbS6n6Zg8JRs1NFRs81IJidOMnCqEabuUAEW4FC_UoFHm94bd-_rFRx4soAZBeNOp2RbBDrVVBe9B3Pl8qF_TSQcG_nnP7Ozy8H_Jw_OLRn6c-9lMH5kCkr1dleLGCQA3haUj5nk85RtsjHtopN0KeJb8GCIzLRQkXRg3E9DAnLcKRigclpqdwrrQPwgUCuvnn1h9WMT4_K3Pi_F3GCVXzZpp2i76NqDBqB9NDnaY5-F8V_cdIi-2IW3pNtSAh5mkSYL6o--uHm9xw_sG1tB8M4QpI7" +
                "2zBGLAd9PYSJt_KkFdleCCHCPidlhunhgpCRg6OV0RkzMonResWWNryz9pq5tg-0BE2H8Vo";

        TokenInterceptor interceptor = new TokenInterceptor(token);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        request = retrofit.create(RetrofitApiService.class);
        Call<TicketModel> call = request.postPlantId(id);
        call.enqueue(new Callback<TicketModel>() {
            @Override
            public void onResponse(Call<TicketModel> call, Response<TicketModel> response) {
                if (response.isSuccessful())
                    Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();
                else Toast.makeText(getContext(), "on respnse", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<TicketModel> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

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