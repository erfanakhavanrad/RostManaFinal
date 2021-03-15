package com.example.rostmanafinal.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rostmanafinal.Adapters.MainPage.DifferentViewsAdapter;
import com.example.rostmanafinal.Adapters.MainPage.MainPageFinalAdapter;
import com.example.rostmanafinal.Fragments.dialogs.LoadingDialogFragment;
import com.example.rostmanafinal.Interfaces.RetrofitApiService;
import com.example.rostmanafinal.LoginRegisterActivity;
import com.example.rostmanafinal.Pojo.ModelFirstPage.AllUserInfoModel;
import com.example.rostmanafinal.Pojo.ModelFirstPage.Builder;
import com.example.rostmanafinal.Pojo.ModelFirstPage.Plant;
import com.example.rostmanafinal.R;
import com.example.rostmanafinal.Retrofit.TokenInterceptor;
import com.example.rostmanafinal.UserManagerSharedPrefs;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
    MainPageFinalAdapter mainPageFinalAdapter;
    TextView message;
    AllUserInfoModel allUserInfoModel5 = new AllUserInfoModel();
    Bundle bundle5 = new Bundle();
//    SecondMainPageFinalAdapter secondMainPageFinalAdapter;
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
//        image1 = view.findViewById(R.id.image1);
        constraintProgress = view.findViewById(R.id.constraintLoading);
//        imageView2 = view.findViewById(R.id.imageView2);
//        imageViewtest = view.findViewById(R.id.imageViewtest);
        menuIconImage = view.findViewById(R.id.menuIconImage);
        fifthItem = view.findViewById(R.id.fifthItem);
        imageAddUser = view.findViewById(R.id.imageAddUser);
        recylcerView1 = view.findViewById(R.id.mainPageRecycler);
        message = view.findViewById(R.id.message);
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

        imageAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentHome_to_fragmentProfile);
//                Toast.makeText(getContext(), "به زودی...", Toast.LENGTH_SHORT).show();
            }
        });

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
//        BottomNavigationView bottomNavigationView = null;
//                bottomNavigationView.getMenu().getItem(1).setEnabled(false);

//        Log.i(TAG, "onViewCreated: "+ saveRequest++ );
/**        request = APIClient.getApiClient(url).create(RetrofitApiService.class);*/
//        Toast.makeText(getContext(), "ye "+saveRequest, Toast.LENGTH_SHORT).show();

//        if (saveRequest < 1)
        sendRequest(view);
//        saveRequest++;
//        Intent i = new Intent(getContext(), FragmentGreenHouse.class);
//        i.putExtra("MYKEY", "MYKEY");
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentHome_to_fragmentGreenHouse, bundle5);
            }
        });
    }


    public void sendRequest(View view) {
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
        loadingDialogFragment.show(getFragmentManager(), LoadingDialogFragment.TAG);
        call.enqueue(new Callback<AllUserInfoModel>() {
            @Override
            public void onResponse(Call<AllUserInfoModel> call, Response<AllUserInfoModel> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();


//                    startActivity(intent);
                    //   ArrayList<AllUserInfoModel> allUserInfoModelArrayList = new ArrayList<>();
                    //  allUserInfoModelArrayList.addAll(response.body());
//                    allUserInfoModel.setBuilder(allUserInfoModel.getBuilder());
//                    allUserInfoModel.setUser(allUserInfoModel.getUser());
//                    secondMainPageFinalAdapter.setList(allUserInfoModel);
//secondMainPageFinalAdapter.setList(allUserInfoModelArrayList);
//                    ArrayList<AllUserInfoModel> list = response.body();

//                    mainPageFinalAdapter = new MainPageFinalAdapter(allUserInfoModel);
                    recylcerView1.setLayoutManager(new GridLayoutManager(getContext(), 2));

                    mainPageFinalAdapter = new MainPageFinalAdapter(getContext(), response.body()).setOnItemClickListener(new MainPageFinalAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(int position, Builder builder) {
                            String builderSerialize = new Gson().toJson(builder); //Serialize
 //                           Builder unSerialize = new Gson().fromJson(serialize, Builder.class); // UnSerialize
                            Bundle bundle = new Bundle();
//                            AllUserInfoModel allUserInfoModel = response.body();
                            bundle.putString("BUILDER", builderSerialize);
//
                            Navigation.findNavController(view).navigate(R.id.action_fragmentHome_to_fragmentGreenHouse, bundle);
//                            Intent theIntent = new Intent(getContext(), FragmentGreenHouse.class);
//                            theIntent.putExtra("name", allUserInfoModel.getBuilder().get(position).getName());
//                            startActivity(theIntent);
//                            Intent mIntent = new Intent(getContext(), FragmentGreenHouse.class);
//                            SeasonalModel obj = new SeasonalModel();
//                            bundle.putSerializable("seasonalBundle", obj);

                        }
                    });
                    recylcerView1.setAdapter(mainPageFinalAdapter);


                    allUserInfoModel5 = response.body();
//                    FragmentHome fragmentHome = new FragmentHome();

//                    bundle5.putString("username", allUserInfoModel5.getBuilder().get(1).getName());
//                    Toast.makeText(getContext(), allUserInfoModel5.getBuilder().get(1).getName(), Toast.LENGTH_SHORT).show();
//                    bundle.putString("token", token);
//                    fragmentHome.setArguments(bundle);

//                    message.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            Navigation.findNavController(view).navigate(R.id.action_fragmentHome_to_fragmentGreenHouse, bundle);
//                        }
//                    });
//                    getSupportFragmentManager().beginTransaction().replace(R.id.your_container,carFragment).commit();


                } else if (response.code() == 400) {
                    Toast.makeText(getContext(), "400", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getContext(), "onResponse" + response.message(), Toast.LENGTH_SHORT).show();
                loadingDialogFragment.dismiss();

            }

            @Override
            public void onFailure(Call<AllUserInfoModel> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

