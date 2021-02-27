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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rostmanafinal.Adapters.MainPage.DifferentViewsAdapter;
import com.example.rostmanafinal.Adapters.MainPage.MainPageAdapter;
import com.example.rostmanafinal.Interfaces.RetrofitApiService;
import com.example.rostmanafinal.LoginRegisterActivity;
import com.example.rostmanafinal.Pojo.HeydariTest;
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
    Boolean number = true;
    ConstraintLayout constraintProgress;
    RecyclerView recylcerView1;
    ImageView imageView2, imageViewtest;
    int saveRequest = 0;
    View _view;
    private DifferentViewsAdapter differentViewsAdapter;

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

//        BottomNavigationView bottomNavigationView = null;
//                bottomNavigationView.getMenu().getItem(1).setEnabled(false);

//        Log.i(TAG, "onViewCreated: "+ saveRequest++ );
/**        request = APIClient.getApiClient(url).create(RetrofitApiService.class);*/
//        Toast.makeText(getContext(), "ye "+saveRequest, Toast.LENGTH_SHORT).show();

        if (saveRequest < 1)
            sendRequest(view);
        saveRequest++;
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
//                Navigation.findNavController(view).navigate(R.id.action_fragmentHome_to_fragmentProfile);
                Toast.makeText(getContext(), "به زودی...", Toast.LENGTH_SHORT).show();
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

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        Log.i(TAG, "onAttach: ");

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach: ");
    }


    private void showLoading() {

        if (number) {
            constraintProgress.setVisibility(View.GONE);

        } else {
            constraintProgress.setVisibility(View.VISIBLE);
        }
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

        number = false;
//        showLoading();
        Call<Example> call = request.postLoggedInUser();

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (response.isSuccessful()) {
                    saveRequest = 1;
//                    number = true;
//                    showLoading();
                    /**
                     *
                     * End of success
                     *
                     * */

                    Example example;
                    example = response.body();
//                    Toast.makeText(getContext(), "" + example.getUser().getPhonenumber(), Toast.LENGTH_SHORT).show();
                    number = true;
                    showLoading();
                    imageView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
//                                String data = "192.168.88.134:8000" + example.getProfile().getAvatar();
//                                Toast.makeText(getContext(), data, Toast.LENGTH_SHORT).show();
//
                            Picasso.get().load("https://raw.githubusercontent.com/square/picasso/master/website/static/sample.png").placeholder(R.drawable.logo).into(imageViewtest);
                            Toast.makeText(getContext(), "clicked", Toast.LENGTH_SHORT).show();
                        }
                    });
                    recylcerView1 = view.findViewById(R.id.recylcerView1);
                    recylcerView1.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
//        HeydariTest heydariTest = new HeydariTest(R.drawable.limo);
//        HeydariTest heydariTest2 = new HeydariTest(R.drawable.benjamin);
//        HeydariTest heydariTest3 = new HeydariTest(R.drawable.limo);
//        recylcerView1.setAdapter(new MainPageAdapter(array_image));
//        HeydariTest heydariTest = new HeydariTest(R.drawable.limo);
                    /**
                     ArrayList<HeydariTest> heydariTests = new ArrayList<>();
                     heydariTests.add(new HeydariTest(R.drawable.limo));
                     heydariTests.add(new HeydariTest(R.drawable.benjamin));
                     MainPageAdapter mainPageAdapter = new MainPageAdapter(heydariTests);
                     */
                    List<Item> items = new ArrayList<>();
//         ModelClass1 modelClass1= new fsdfsfffsf;
//         modelClass1.add(new Item(1, modelClass1));
                    ModelFlowersMainPage modelFlowersMainPage = new ModelFlowersMainPage(R.drawable.limo);
                    items.add(new Item(0, modelFlowersMainPage));


//                    items.add(new Item(0, data));
//                  ModelFlowersMainPage modelFlowersMainPage = new ModelFlowersMainPage(R.drawable.limo);
//                  items.add(0, modelFlowersMainPage);

                    ModelAddItem modelAddItem = new ModelAddItem(R.drawable.ic_baseline_add_24);
                    items.add(new Item(1, modelAddItem));

//        Car car = new Car();
                    List<Car> cars = new ArrayList<>();
//       cars.set()
                    cars.add(new Car(R.drawable.benjamin));
                    recylcerView1.setAdapter(new DifferentViewsAdapter(items, cars));
//         recylcerView1.setAdapter(mainPageAdapter);
                    /**
                     *
                     * End of onSuccess
                     *
                     * */

                    Picasso.get().load("https://static.farakav.com/files/pictures/thumb/01572384.jpg").placeholder(R.drawable.logo).into(image1);

//                    number = false;
//                    showLoading();
                    constraintProgress.setVisibility(View.GONE);
                    if (example.getProfile() == null) {
                        Toast.makeText(getContext(), "nistg", Toast.LENGTH_SHORT).show();
//                        number = true;
//                        showLoading();
                    } else if (response.code() == 400) {
                        Toast.makeText(getContext(), "user exists", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(getContext(), "onResponseError", Toast.LENGTH_SHORT).show();
                    saveRequest = 0;
//                    number = true;
//                    showLoading();
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(getContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
//                number = true;
//                showLoading();
            }
        });


    }

//    BottomNavigationItemView bottomNavigationItemView;


    //    val navView: BottomNavigationView = findViewById(R.id.nav_view)
//BottomNavigationView bottomNavigationView = _view.findViewById(R.id.navigationBottom)
    // Find the menu item and then disable it
//    navView.menu.findItem(R.id.navigation_home).isEnabled = false

//    onBackpressed
//    getActivity().moveTaskToBack(true);
//    getActivity().finish();
}

