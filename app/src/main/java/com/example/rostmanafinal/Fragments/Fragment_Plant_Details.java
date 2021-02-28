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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rostmanafinal.Adapters.FlowersAdapter;
import com.example.rostmanafinal.Adapters.PlantDetailAdapter;
import com.example.rostmanafinal.Interfaces.RetrofitApiService;
import com.example.rostmanafinal.Pojo.ModelChoosePlant.SingleFlowerModel;
import com.example.rostmanafinal.R;
import com.example.rostmanafinal.Retrofit.TokenInterceptor;
import com.example.rostmanafinal.UserManagerSharedPrefs;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class  Fragment_Plant_Details extends Fragment {
    private static final String TAG = "Fragment_Plant_Details";
    RecyclerView recyclerPlantDetail;
    ImageView image_check, image_cancel, imagePlant;
    Bundle bundle = new Bundle();
    TextView txtName, txtEName;
    String showPhoto, getPhoto, getDescription, id, SURL, token, url = "http://rostmana.com/api/";
    Button btn_detail;
    static String BASE_URL = "Mobile/Category/";
    UserManagerSharedPrefs userManagerSharedPrefs;
    RetrofitApiService request;
//    List<SingleFlowerModel> singleFlowerModelArrayList = new ArrayList<>();
//    SingleFlowerModel singleFlowerModel = new SingleFlowerModel();
    SingleFlowerModel singleFlowerModelArrayList = new SingleFlowerModel();
//    PlantDetailAdapter adapter = new PlantDetailAdapter(singleFlowerModelArrayList,getContext());
    static String SEASONAL_URL = "1";

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
        String ssd = "daw" + "dawd";
        SURL = url + BASE_URL + SEASONAL_URL;
        sendRequest(SURL);
        initView();
        recyclerPlantDetail = view.findViewById(R.id.recyclerPlantDetail);
        btn_detail = view.findViewById(R.id.btn_detail);
        imagePlant = view.findViewById(R.id.imagePlant);
        txtName = view.findViewById(R.id.txtName);
        txtEName = view.findViewById(R.id.txtEName);
//        SeasonalModel seasonalModel = (SeasonalModel) bundle.getSerializable("seasonalBundle");
        id = bundle.getString("getId");
        getDescription = bundle.getString("getDescription");
        if (getDescription == null)
            btn_detail.setVisibility(View.INVISIBLE);
// else if (getDescription == null)
//     btn_detail.setVisibility(View.VISIBLE);
        /**
         * get your id from previous fragment
         */
        String getName = bundle.getString("getName");
        getPhoto = bundle.getString("getPhoto");
        showPhoto = "http://rostmana.com" + getPhoto;
        Picasso.get().load(showPhoto).placeholder(R.drawable.logo).into(imagePlant);
        txtName.setText(getName);
        image_cancel = view.findViewById(R.id.image_cancel);
        image_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_fragment_Plant_Details_to_firstFragment2);
            }
        });

        image_check = view.findViewById(R.id.image_check);
        image_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_fragment_Plant_Details_to_fragmentGreenHouse2);
            }
        });

        recyclerPlantDetail.setLayoutManager(new LinearLayoutManager(getContext()
                , RecyclerView.VERTICAL, false));
        btn_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void initView() {


//        adapter = new FlowersAdapter(this);
//        recycler.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
//        recycler.setAdapter(adapter);
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


        Call<SingleFlowerModel> call = request.postIdForDetails(getPageUrl);
        call.enqueue(new Callback<SingleFlowerModel>() {
            @Override
            public void onResponse(Call<SingleFlowerModel> call, Response<SingleFlowerModel> response) {
                if (response.isSuccessful()) {
                    singleFlowerModelArrayList = response.body();
//                    adapter.setList();
                } else {
                    Toast.makeText(getContext(), " else" + response.body(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SingleFlowerModel> call, Throwable t) {
                Toast.makeText(getContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}


//        ArrayList plantDetailListArray = new ArrayList();
//        Arrays.asList(seasonalModel);
//        PlantDetailAdapter plantDetailAdapter = new PlantDetailAdapter(mydataList, getActivity());

//        recyclerPlantDetail.setAdapter(plantDetailAdapter);
//        recyclerPlantDetail.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));

//        PlantDetailClass plantDetailClass;
//                = new StructuresClass("first", "flower", R.drawable.s_two);

//        ArrayList<SeasonalModel> seasonalModels = new ArrayList();

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
 * "soil", "potasium manure", "twice a week"));
 * plantDetailListArray.add(new PlantDetailClass("tulips", "12", R.drawable.limo, "native",
 * 12, "wet", "itSprinkles", "twice a month", "natural light",
 * "soil", "potasium manure", "twice a week"));
 * <p>
 * plantDetailListArray.add(new PlantDetailClass("tulips", "12", R.drawable.limo, "native",
 * 12, "wet", "itSprinkles", "twice a month", "natural light",
 * "soil", "potasium manure", "twice a week"));
 * plantDetailListArray.add(new PlantDetailClass("tulips", "12", R.drawable.limo, "native",
 * 12, "wet", "itSprinkles", "twice a month", "natural light",
 * "soil", "potasium manure", "twice a week"));
 * plantDetailListArray.add(new PlantDetailClass("tulips", "12", R.drawable.limo, "native",
 * 12, "wet", "itSprinkles", "twice a month", "natural light",
 * "soil", "potasium manure", "twice a week"));
 */