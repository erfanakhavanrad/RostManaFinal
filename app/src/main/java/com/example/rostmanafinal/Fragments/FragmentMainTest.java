package com.example.rostmanafinal.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.rostmanafinal.Interfaces.RetrofitApiService;
import com.example.rostmanafinal.Pojo.GetHello;
import com.example.rostmanafinal.R;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentMainTest extends Fragment {
    TextView txtError;

   private static final String BASE_URL = "http://192.168.88.134:8000/api/";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewMain = inflater.inflate(R.layout.fragment_main_test, container, false);

        return viewMain;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtError = view.findViewById(R.id.txtError);


        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        RetrofitApiService retrofitApiService = retrofit.create(RetrofitApiService.class);
        retrofitApiService.getHellovalue().enqueue(new Callback<GetHello>() {
            @Override
            public void onResponse(Call<GetHello> call, Response<GetHello> response) {
                txtError.setText(response.body().getReceivehello());
            }

            @Override
            public void onFailure(Call<GetHello> call, Throwable t) {
txtError.setText(t.toString());
            }
        });

    }
}
