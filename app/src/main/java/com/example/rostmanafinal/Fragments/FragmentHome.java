package com.example.rostmanafinal.Fragments;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.ColorSpace;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rostmanafinal.Adapters.MainPage.MainPageAdapter;
import com.example.rostmanafinal.Interfaces.RetrofitApiService;
import com.example.rostmanafinal.LoginRegisterActivity;
import com.example.rostmanafinal.Pojo.HeydariTest;
import com.example.rostmanafinal.Pojo.ModelLogedinUser;
import com.example.rostmanafinal.Pojo.PojoEnterPost.Example;
import com.example.rostmanafinal.Pojo.ResponseObj;
import com.example.rostmanafinal.R;
import com.example.rostmanafinal.Retrofit.APIClient;
import com.example.rostmanafinal.Retrofit.TokenInterceptor;
import com.example.rostmanafinal.UserManagerSharedPrefs;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

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
    //    Button btnGet, btnPost;
//    TextView textView7, textView8, txtToken;
    boolean doubleBackToExitPressedOnce = false;
    String token, url = "http://192.168.88.134:8000/api/";
    RetrofitApiService request;
    Boolean number = true;
    ConstraintLayout constraintProgress;
    RecyclerView recylcerView1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewHome = inflater.inflate(R.layout.fragment_home, container, false);

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
        constraintProgress = view.findViewById(R.id.constraintProgress);
        Picasso.get().load("http://i.imgur.com/DvpvklR.png").placeholder(R.drawable.logo).into(image1);
        recylcerView1 = view.findViewById(R.id.recylcerView1);
        recylcerView1.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
//        HeydariTest heydariTest = new HeydariTest(R.drawable.limo);
//        HeydariTest heydariTest2 = new HeydariTest(R.drawable.benjamin);
//        HeydariTest heydariTest3 = new HeydariTest(R.drawable.limo);
//        recylcerView1.setAdapter(new MainPageAdapter(array_image));
        MainPageAdapter mainPageAdapter = new MainPageAdapter();
        recylcerView1.setAdapter(mainPageAdapter);
/**        request = APIClient.getApiClient(url).create(RetrofitApiService.class);*/

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

//        Toast.makeText(getContext(), "" + token, Toast.LENGTH_SHORT).show();
//token = userManagerSharedPrefs.getToken();

        number = true;
        showLoading();
        Call<Example> call = request.postLoggedInUser();
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (response.isSuccessful()) {
                    Example example;
                    example = response.body();
//                    Toast.makeText(getContext(), "" + example.toString(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(getContext(), "" + example.getUser().getPhonenumber(), Toast.LENGTH_SHORT).show();
                    if (example.getProfile() == null) {
                        Toast.makeText(getContext(), "nistg", Toast.LENGTH_SHORT).show();

                    }
                } else {
                    Toast.makeText(getContext(), "onResponseError", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(getContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


//        Call<ResponseObj> call = request.postLoggedInUser();
//        call.enqueue(new Callback<ResponseObj>() {
//            @Override
//            public void onResponse(Call<ResponseObj> call, Response<ResponseObj> response) {
//                if (response.isSuccessful()) {
//                    ResponseObj responseObj;
//                    responseObj = response.body();
//                    Toast.makeText(getContext(), "" + responseObj.toString(), Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(getContext(), "onResponse", Toast.LENGTH_SHORT).show();
//                }
//
//
//            }
//
//            @Override
//            public void onFailure(Call<ResponseObj> call, Throwable t) {
//                if (getContext() != null){
//                Toast.makeText(getContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
//                }
//                }
//        });


//        call.enqueue(new Callback<ResponseObj>() {
//            @Override
//            public void onResponse(Call<ModelLogedinUser> call, Response<ModelLogedinUser> response) {
//                ModelLogedinUser modelLogedinUser = response.body();
//                Log.e(TAG, "onResponse: " +  modelLogedinUser);
//                if (modelLogedinUser != null){
//                    String name;
//                    name = modelLogedinUser.getName();
//                    Log.d(TAG, "onResponse: " + name);
//                    Toast.makeText(getContext(), ""+ name, Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    Toast.makeText(getContext(), "error onResponse", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ModelLogedinUser> call, Throwable t) {
//                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//                number = true;
//                showLoading();
//            }
//        });
//


        fourthItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userManagerSharedPrefs.clearAllInformation();

                Intent i = new Intent(getActivity(), LoginRegisterActivity.class);
                Toast.makeText(getContext(), "از حساب خود خارج شدید", Toast.LENGTH_SHORT).show();
                getActivity().finish();
                startActivity(i);
                ((Activity) getActivity()).overridePendingTransition(0, 0);

            }
        });


        fifthItem = view.findViewById(R.id.fifthItem);
        fifthItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_MAIN);
//                intent.addCategory(Intent.CATEGORY_HOME);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
                System.exit(0);

            }
        });

        imageAddUser = view.findViewById(R.id.imageAddUser);
        imageAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentHome_to_fragmentProfile);
            }
        });

        menuIconImage = view.findViewById(R.id.menuIconImage);
        menuIconImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                containerd.openDrawer(GravityCompat.START);
            }
        });

        imageClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                containerd.closeDrawer(Gravity.LEFT);
            }
        });

        firstItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentHome_to_fragmnetCallUs);
            }
        });

        secondItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentHome_to_fragmentAboutUs);
            }
        });

    }


    private void showLoading() {

        if (number) {
            constraintProgress.setVisibility(View.GONE);

        } else {
            constraintProgress.setVisibility(View.VISIBLE);
        }
    }
//    onBackpressed
//    getActivity().moveTaskToBack(true);
//    getActivity().finish();
}

