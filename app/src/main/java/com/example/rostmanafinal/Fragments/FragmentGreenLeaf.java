package com.example.rostmanafinal.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rostmanafinal.Adapters.FlowersAdapter;
import com.example.rostmanafinal.Interfaces.ChangingFragmentsInterface;
import com.example.rostmanafinal.Interfaces.RetrofitApiService;
import com.example.rostmanafinal.Pojo.FlowerListClass;
import com.example.rostmanafinal.Pojo.ModelChoosePlant.SeasonalModel;
import com.example.rostmanafinal.R;
import com.example.rostmanafinal.Retrofit.TokenInterceptor;
import com.example.rostmanafinal.UserManagerSharedPrefs;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentGreenLeaf extends Fragment implements ChangingFragmentsInterface, FlowersAdapter.CallBack {
    RecyclerView recycler;
    static String BASE_URL = "Mobile/Category/";
    UserManagerSharedPrefs userManagerSharedPrefs;
    RetrofitApiService request;
    String SURL, token, url = "http://rostmana.com/api/";
    List<SeasonalModel> seasonalModels22 = new ArrayList<>();
    FlowersAdapter adapter = new FlowersAdapter(this::callBack);
    static String SEASONAL_URL = "3";
    View secondView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewGreenLeaf = inflater.inflate(R.layout.recycler_for_flowers, container, false);

        return viewGreenLeaf;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycler = view.findViewById(R.id.recycler);
        SURL = url + BASE_URL + SEASONAL_URL;
        sendRequest(SURL);
        initView();
        secondView = view;
//        ArrayList<FlowerListClass> names = new ArrayList();
//        names.add(new FlowerListClass("اپونتیا", R.drawable.limo));
//        names.add(new FlowerListClass("اچینو", R.drawable.benjamin));
//        names.add(new FlowerListClass("استرافینوم", R.drawable.ic_seasonalflowers));
//        names.add(new FlowerListClass("افوربیا لاکتی", R.drawable.benjamin));
//        names.add(new FlowerListClass("آلوئه ورا", R.drawable.ic_cactus));
//        names.add(new FlowerListClass("پایه چرمی", R.drawable.benjamin));
//        names.add(new FlowerListClass("خورشیدی", R.drawable.limo));
//        names.add(new FlowerListClass("ژمینو", R.drawable.limo));
//        names.add(new FlowerListClass("ژمینوکالیسیم", R.drawable.ic_greenleaf));
//        names.add(new FlowerListClass("سانسوریا", R.drawable.ic_shrub));
//        names.add(new FlowerListClass("سولکو", R.drawable.ic_cactus));
//        names.add(new FlowerListClass("فرو", R.drawable.ic_organic));
//        names.add(new FlowerListClass("ماملاریا", R.drawable.ic_shrub));
//        names.add(new FlowerListClass("نولآبی", R.drawable.limo));
//        names.add(new FlowerListClass("نازقرمز", R.drawable.ic_seasonalflowers));
//        names.add(new FlowerListClass("نخل ماداگاسکار", R.drawable.benjamin));
//        names.add(new FlowerListClass("هاورتیا گورخری", R.drawable.ic_organic));
//
//
//        //Adapter
//        FlowersAdapter adapter = new FlowersAdapter(names, requireActivity(), this);
//        recycler.setAdapter(adapter);
//
//        recycler.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));


    }

    private void initView() {


        adapter = new FlowersAdapter(this);
        recycler.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        recycler.setAdapter(adapter);
    }

    public void sendRequest(String getPageUrl) {
        userManagerSharedPrefs = new UserManagerSharedPrefs(getContext());
        token = userManagerSharedPrefs.getToken();
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


        Call<List<SeasonalModel>> call = request.getPlantList(getPageUrl);
        call.enqueue(new Callback<List<SeasonalModel>>() {
            @Override
            public void onResponse(Call<List<SeasonalModel>> call, Response<List<SeasonalModel>> response) {
                if (response.isSuccessful()) {
//                    ArrayList<SeasonalModel> seasonalModels = new ArrayList<>();
//                    ArrayList<Task> tmp = new ArrayList<Task>(mTrackytAdapter.getAllTasks(token));
//                    ArrayList<SeasonalModel> sml = new ArrayList<SeasonalModel>();
//seasonalModel = response.body();
//                    list<modelet>  a=response.body
                    seasonalModels22 = response.body();
                    adapter.setList(seasonalModels22);


//Adapter
//                    ArrayList<SeasonalModel> names = new ArrayList<>();
//                    names.add(response.body());
//                    seasonalModels.get
//                    Toast.makeText(getContext(), "model s" + seasonalModels.get(2), Toast.LENGTH_SHORT).show();
                    //                    Toast.makeText(getContext(), "success " + seasonalModel.getName(), Toast.LENGTH_SHORT).show();
//                    Toast.makeText(getContext(), "success" + seasonalModel.getName(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), " else" + response.body(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<SeasonalModel>> call, Throwable t) {
                Toast.makeText(getContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemSelected() {
        NavController navController = NavHostFragment.findNavController(FragmentGreenLeaf.this);
        navController.navigate(R.id.fragment_Plant_Details);
    }

    @Override
    public void callBack(SeasonalModel seasonalModel) {
        Bundle bundle = new Bundle();

        bundle.putString("getId", seasonalModel.getId().toString());
        bundle.putString("getName", seasonalModel.getName().toString());
        bundle.putString("getPhoto", seasonalModel.getPhoto().toString());
        /**
         bundle.putString("getEName", seasonalModel.getEName().toString());
         bundle.putString("getPWaterS", seasonalModel.getPWaterS().toString());
         bundle.putString("getPWaterW", seasonalModel.getPWaterW().toString());
         bundle.putString("getTimeFertilizer", seasonalModel.getTimeFertilizer().toString());
         bundle.putString("getPrune", seasonalModel.getPrune().toString());
         bundle.putString("getPrune", seasonalModel.getPrune().toString());
         bundle.putString("getPlanttype", seasonalModel.getPlanttype().toString());
         bundle.putString("getTemp", seasonalModel.getTemp().toString());
         bundle.putString("getLight", seasonalModel.getLight().toString());
         bundle.putString("getHumiditySoil", seasonalModel.getHumiditySoil().toString());
         bundle.putString("getHumidityAir", seasonalModel.getHumidityAir().toString());
         bundle.putString("getSoilId", seasonalModel.getSoilId().toString());
         bundle.putString("getFertilizerId", seasonalModel.getFertilizerId().toString());
         */

        Navigation.findNavController(secondView).navigate(R.id.action_fragmentGreenLeaf_to_fragment_Plant_Details2, bundle);
    }
}
