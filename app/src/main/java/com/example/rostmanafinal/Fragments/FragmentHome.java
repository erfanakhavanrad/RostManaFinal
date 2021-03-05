package com.example.rostmanafinal.Fragments;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.ColorSpace;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rostmanafinal.Adapters.MainPage.DifferentViewsAdapter;
import com.example.rostmanafinal.Adapters.MainPage.MainPageAdapter;
import com.example.rostmanafinal.Fragments.dialogs.LoadingDialogFragment;
import com.example.rostmanafinal.Interfaces.RetrofitApiService;
import com.example.rostmanafinal.LoginRegisterActivity;
import com.example.rostmanafinal.MainActivity;
import com.example.rostmanafinal.Pojo.HeydariTest;
import com.example.rostmanafinal.Pojo.ModelFirstPage.AllUserInfoModel;
import com.example.rostmanafinal.Pojo.ModelLogedinUser;
import com.example.rostmanafinal.Pojo.ModelMainPage.Car;
import com.example.rostmanafinal.Pojo.ModelMainPage.Item;
import com.example.rostmanafinal.Pojo.ModelMainPage.ModelAddItem;
import com.example.rostmanafinal.Pojo.ModelMainPage.ModelFlowersMainPage;
import com.example.rostmanafinal.Pojo.PojoEnterPost.Example;
import com.example.rostmanafinal.Pojo.ResponseObj;
import com.example.rostmanafinal.R;
import com.example.rostmanafinal.Retrofit.APIClient;
import com.example.rostmanafinal.Retrofit.TokenInterceptor;
import com.example.rostmanafinal.UserManagerSharedPrefs;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToDoubleBiFunction;
import java.util.zip.Inflater;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

public class FragmentHome extends Fragment {
    UserManagerSharedPrefs userManagerSharedPrefs;
    DrawerLayout containerd;
    ImageView menuIconImage, imageClose, imageAddUser, image1;
    LinearLayout firstItem, secondItem, fourthItem, fifthItem;
    boolean doubleBackToExitPressedOnce = false;
    String token, url = "http://rostmana.com/api/";
    RetrofitApiService request;
    ConstraintLayout constraintProgress;
    RecyclerView recylcerView1;
    ImageView imageView2, imageViewtest;
    int saveRequest = 0;
    View _view;
    LoadingDialogFragment loadingDialogFragment = LoadingDialogFragment.newInstance(false);
    private DifferentViewsAdapter differentViewsAdapter;
//    MainActivity mainActivity = new MainActivity();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewHome = inflater.inflate(R.layout.fragment_home, container, false);
//        Log.i(TAG, "onCreateView: " + saveRequest++ );
        return viewHome;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userManagerSharedPrefs = new UserManagerSharedPrefs(getContext());
        containerd = view.findViewById(R.id.containerd);
        imageClose = view.findViewById(R.id.imageClose);
        firstItem = view.findViewById(R.id.firstItem);
        fourthItem = view.findViewById(R.id.fourthItem);
        secondItem = view.findViewById(R.id.secondItem);
        image1 = view.findViewById(R.id.image1);
        constraintProgress = view.findViewById(R.id.constraintLoading);
        imageView2 = view.findViewById(R.id.imageView2);
        imageViewtest = view.findViewById(R.id.imageViewtest);
        menuIconImage = view.findViewById(R.id.menuIconImage);
        fifthItem = view.findViewById(R.id.fifthItem);
        imageAddUser = view.findViewById(R.id.imageAddUser);
//        BottomNavigationView bottomNavigationView = null;
//                bottomNavigationView.getMenu().getItem(1).setEnabled(false);

//        Log.i(TAG, "onViewCreated: "+ saveRequest++ );
/**        request = APIClient.getApiClient(url).create(RetrofitApiService.class);*/
//        Toast.makeText(getContext(), "ye "+saveRequest, Toast.LENGTH_SHORT).show();

        if (saveRequest < 1)
            sendRequest(view);
        saveRequest++;

    }


    public void sendRequest(View view) {
//        Toast.makeText(getContext(), "ye chizi", Toast.LENGTH_SHORT).show();
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

//        Call<Example> call = request.postLoggedInUser();
        Call<AllUserInfoModel> call = request.postLoggedInUser();
        /** inja shorro she*/
        loadingDialogFragment.show(getFragmentManager(), LoadingDialogFragment.TAG);
        call.enqueue(new Callback<AllUserInfoModel>() {
            @Override
            public void onResponse(Call<AllUserInfoModel> call, Response<AllUserInfoModel> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();
                    AllUserInfoModel allUserInfoModel;
                    allUserInfoModel = response.body();

                } else if (response.code() == 400) {
                    Toast.makeText(getContext(), "400", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getContext(), "onResponse" + response.message(), Toast.LENGTH_SHORT).show();
         loadingDialogFragment.dismiss();
            }

            @Override
            public void onFailure(Call<AllUserInfoModel> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}

