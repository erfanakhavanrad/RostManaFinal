package com.example.rostmanafinal.Fragments;

import android.os.Bundle;
import android.text.BoringLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rostmanafinal.Adapters.GreenHouseAdapter;
import com.example.rostmanafinal.Interfaces.RetrofitApiService;
import com.example.rostmanafinal.Pojo.FogFunctionByUser;
import com.example.rostmanafinal.Pojo.GreenHouseItems;
import com.example.rostmanafinal.Pojo.ModelFirstPage.Builder;
import com.example.rostmanafinal.Pojo.ModelFirstPage.BuilderStatusModel;
import com.example.rostmanafinal.Pojo.StringStatusGreenHouse;
import com.example.rostmanafinal.Pojo.SwitchStatusGreenHouse;
import com.example.rostmanafinal.R;
import com.example.rostmanafinal.Retrofit.TokenInterceptor;
import com.example.rostmanafinal.UserManagerSharedPrefs;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentGreenHouse extends Fragment {
    RecyclerView recyclerView;
    Bundle bundle = new Bundle();
    Builder builder;
    String SURL, token, url = "http://192.168.88.134:8000/api/";
    UserManagerSharedPrefs userManagerSharedPrefs;
    RetrofitApiService request;
    static String BASE_URL = "Mobile/lastLog/";
    static String SEASONAL_URL = "7";
    BuilderStatusModel builderStatusModel;
    Boolean builderStatus;
    Boolean integerStatus;
    Integer integerStatusFan, integerStatusElement, integerStatusLight, integerStatusWatering, integerStatusVaporizer,
            integerStatusSprayer, integerStatusPower;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewGreenHouse = inflater.inflate(R.layout.fragment_greenhouse, container, false);
        return viewGreenHouse;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
//        name = getArguments().getString("Name");
//        Toast.makeText(getContext(), name.toString(), Toast.LENGTH_SHORT).show();
        bundle = this.getArguments();
        builder = new Gson().fromJson(bundle.getString("BUILDER"), Builder.class);

        SURL = url + BASE_URL + SEASONAL_URL;
        sendRequest(SURL);
//        Bundle bundle = getArguments();
//        int username2 = bundle.getInt("username");
//        String fsffsf = String.valueOf(username2);
//        String token = bundle.getString("token");
//        Toast.makeText(getContext(), fsffsf, Toast.LENGTH_SHORT).show();
//        Intent i= getIntent();
//        i.getStringExtra("name");
//        if (bundle != null) {
//            String getName = bundle.getString("getNameMain");
//            Intent intent2 = new Intent();
//            String getName2  = intent2.getStringExtra("getNameMain");
//            Toast.makeText(getContext(), getName2.toString(), Toast.LENGTH_SHORT).show();
//        }
        List<GreenHouseItems> items = new ArrayList<>();
//        Here types are: 0 = Trip, 1 =Ads, 2 = News

//        Trip
        FogFunctionByUser fogFunctionByUser1 = new FogFunctionByUser(R.drawable.limo, builder.getName(), "روشن خاموش کردن مه ساز");
        items.add(new GreenHouseItems(0, fogFunctionByUser1));
//        Trip trip2 = new Trip(R.drawable.secondphoto, "banafshe", "قرمزه");
//        items.add(new Item(0, trip2));
//        Trip trip3 = new Trip(R.drawable.limo, "banafshe", "لیمو");
//        items.add(new Item(0, trip3));


//        Ads
        SwitchStatusGreenHouse ads1 = new SwitchStatusGreenHouse("ad: christmas", "adwddw", R.drawable.benjamin, true);
        items.add(new GreenHouseItems(1, ads1));
        SwitchStatusGreenHouse ads2 = new SwitchStatusGreenHouse("ad: christmas", "رزماری", R.drawable.ic_cactus, integerStatus);
        items.add(new GreenHouseItems(1, ads2));
        SwitchStatusGreenHouse ads3 = new SwitchStatusGreenHouse("ad: christmas", "درخت چینی", R.drawable.limo, true);
        items.add(new GreenHouseItems(1, ads3));

//        News
        StringStatusGreenHouse news1 = new StringStatusGreenHouse("هفته ای دو بار", "آبیاری", R.drawable.limo);
        items.add(new GreenHouseItems(2, news1));
        StringStatusGreenHouse news2 = new StringStatusGreenHouse("25 درجه", "دما", R.drawable.ic_greenleaf);
        items.add(new GreenHouseItems(2, news2));
        StringStatusGreenHouse news3 = new StringStatusGreenHouse("کود حیوانی", "کوددهی", R.drawable.ic_cactus);
        items.add(new GreenHouseItems(2, news3));
// Excessive items
        StringStatusGreenHouse news4 = new StringStatusGreenHouse("bali, indonesia", "نوع خاک", R.drawable.ic_organic);
        items.add(new GreenHouseItems(2, news4));
        StringStatusGreenHouse news5 = new StringStatusGreenHouse("bali, indonesia", "میزان رطوبت", R.drawable.limo);
        items.add(new GreenHouseItems(2, news5));
        StringStatusGreenHouse news6 = new StringStatusGreenHouse("bali, indonesia", "زمان کاشت", R.drawable.ic_shrub);
        items.add(new GreenHouseItems(2, news6));
        StringStatusGreenHouse news7 = new StringStatusGreenHouse("bali, indonesia", "زمان برداشت", R.drawable.ic_shrub);
        items.add(new GreenHouseItems(2, news7));
        StringStatusGreenHouse news8 = new StringStatusGreenHouse("bali, indonesia", "this is the news field.", R.drawable.limo);
        items.add(new GreenHouseItems(2, news8));
        StringStatusGreenHouse news9 = new StringStatusGreenHouse("bali, indonesia", "this is the news field.", R.drawable.benjamin);
        items.add(new GreenHouseItems(2, news9));
        StringStatusGreenHouse news10 = new StringStatusGreenHouse("bali, indonesia", "this is the news field.", R.drawable.ic_organic);
        items.add(new GreenHouseItems(2, news10));
        StringStatusGreenHouse news11 = new StringStatusGreenHouse("bali, indonesia", "this is the news field.", R.drawable.ic_shrub);
        items.add(new GreenHouseItems(2, news11));
        StringStatusGreenHouse news12 = new StringStatusGreenHouse("bali, indonesia", "this is the news field.", R.drawable.ic_cactus);
        items.add(new GreenHouseItems(2, news12));
        StringStatusGreenHouse news13 = new StringStatusGreenHouse("bali, indonesia", "this is the news field.", R.drawable.ic_greenleaf);
        items.add(new GreenHouseItems(2, news13));
        StringStatusGreenHouse news14 = new StringStatusGreenHouse("bali, indonesia", "this is the news field.", R.drawable.limo);
        items.add(new GreenHouseItems(2, news14));

        recyclerView.setAdapter(new GreenHouseAdapter(items));

    }

    //    @Override
//    public void onBackPressed(){
//        super.onBackPressed();
//        drawer.close();
//    }
    public void sendRequest(String getPageUrl) {
        userManagerSharedPrefs = new UserManagerSharedPrefs(getContext());
//        token = userManagerSharedPrefs.getToken();
        token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiNGFjNjQ2MDAyYmFkZjI4ZjcwYThhYWY0MDFmNTMyNjE1ODc2MThiYTc4MTAzZTFhY2Q5Y2M4ODEwNzkyODFkNjhlMWVhZjE3M2U3ZTVmMTQiLCJpYXQiOiIxNjE1Mjg4MTA0Ljg5NTQ3OCIsIm5iZiI6IjE2MTUyODgxMDQuODk1NDgxIiwiZXhwIjoiMTY0NjgyNDEwNC44ODI2MzQiLCJzdWIiOiI1NSIsInNjb3BlcyI6W119.Z4Y183gJp4EvHpzqsVb8PPgx1P519CUMhOjQh04PzJetxtdcDJiXvHkO_9gJEyaF__cR0Iqoy3tRe5ND8R7BCjNrjhj-4otwiKgrCTY2xhRwSR3v-KLDQU-CgX1TPUTuZCjXpu5km2um69x-ux9HZxgEfurbNjzcHCPwyiZdblyiJHGJRp-sYUqGszeABFY31btFVbbVTG9Ow8soqJES32vvNl2lg6yDqYZVN2ugq1pbkr2WbBOF6WvEOc60dzaZ9SFDHzy7C1fexgPqzWgICLrsf_fQzpCGV2OXU0j8QNWB9QhAp1vT5oCyu75OM9ujIjAJDH_wa--MgL08es4Zb0kMPmWhS7WTyY8gh3j1Fkn6hmiP2Yl2gmh6XUeuIdc07T1g8uiDOpo49iq-jqT7m44F5-7hoAYhsZIHa9etG5RDy4sJcBo85vNWyLQ7jfQk_GKq_oz0b6YIVa5EjXs-_HYA4JJqU0PFFTPPCaXwX_3JQDMpERMUr_04HEoW9Q6_K_MT2YvjHmquQe5DVm2Ds0LHtTJyUSA8guiNNdrDLd8RWpoZfRY0_dR1hSBgv7pRLm-EXevSfEIprTC27HTXkSj" +
                "ZrHD8bE0vI5xcXYI5UUAIjQ6yuU9SWOBItAt6tjBF-7QdQDeen7Ex7QWCYUKKE3H_KdEUcqW3Zo9cI60HDLw";
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
        Call<BuilderStatusModel> call = request.postBuilderStatusData(getPageUrl);
        call.enqueue(new Callback<BuilderStatusModel>() {
            @Override
            public void onResponse(Call<BuilderStatusModel> call, Response<BuilderStatusModel> response) {
                if (response.isSuccessful()) {
//                    Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();
                    builderStatusModel = response.body();
                    integerStatus = intToBoolean(builderStatusModel.getTemp());

                } else {
                    Toast.makeText(getContext(), "onResponse" + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BuilderStatusModel> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public Boolean intToBoolean(Integer integerStatus) {

        if (integerStatus == 1) {
            return true;
        } else
            return false;
    }
}
