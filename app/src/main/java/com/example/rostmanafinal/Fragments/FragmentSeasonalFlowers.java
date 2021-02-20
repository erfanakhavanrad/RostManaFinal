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
//
public class FragmentSeasonalFlowers extends Fragment implements ChangingFragmentsInterface {
    RecyclerView recycler;
    static String BASE_URL = "Mobile/Category/";
    UserManagerSharedPrefs userManagerSharedPrefs;
    RetrofitApiService request;
    String SURL, token, url = "http://192.168.88.134:8000/api/";
    SeasonalModel seasonalModel = new SeasonalModel();
    static String SEASONAL_URL = "1";

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
        SURL = url + BASE_URL + SEASONAL_URL;
        sendRequest(SURL);

//        ArrayList<FlowerListClass> names2 = new ArrayList();
//        names2.add(new FlowerListClass("اپونتیا", R.drawable.limo));


        //Adapter
//        FlowersAdapter adapter = new FlowersAdapter(names, requireActivity(), this);
//        recycler.setAdapter(adapter);
//        recycler.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));




    }

    @Override
    public void onItemSelected() {
        NavController navController = NavHostFragment.findNavController(FragmentSeasonalFlowers.this);
        navController.navigate(R.id.fragment_Plant_Details);
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
                    List<SeasonalModel> seasonalModels = response.body();

//Adapter
//                    ArrayList<SeasonalModel> names = new ArrayList<>();
//                    names.add(response.body());
                    FlowersAdapter adapter = new FlowersAdapter(seasonalModels, requireActivity());
                    recycler.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
                    recycler.setAdapter(adapter);
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

}
