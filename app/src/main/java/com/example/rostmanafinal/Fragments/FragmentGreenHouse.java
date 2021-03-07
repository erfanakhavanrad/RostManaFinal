package com.example.rostmanafinal.Fragments;

import android.content.Intent;
import android.os.Bundle;
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
import com.example.rostmanafinal.Pojo.FogFunctionByUser;
import com.example.rostmanafinal.Pojo.GreenHouseItems;
import com.example.rostmanafinal.Pojo.ModelFirstPage.Builder;
import com.example.rostmanafinal.Pojo.StringStatusGreenHouse;
import com.example.rostmanafinal.Pojo.SwitchStatusGreenHouse;
import com.example.rostmanafinal.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class FragmentGreenHouse extends Fragment {
    RecyclerView recyclerView;
        Bundle bundle = new Bundle();
    TextView textview;
    TextView textview2;
    String name;
    String job;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewGreenHouse = inflater.inflate(R.layout.fragment_greenhouse, container, false);
        return viewGreenHouse;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        Intent intent = getIntent();
//        MessageID = intent.getStringExtra("message_id");

//        Bundle extras = intent.getIntent().getExtras();
//        String MYKEY = (extras != null) ? extras.getString("MYKEY"):"";


//         extras = getIntent().getExtras();
//        String MYKEY = (extras != null) ? extras.getString("MYKEY"):"";

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
//        name = getArguments().getString("Name");
//        Toast.makeText(getContext(), name.toString(), Toast.LENGTH_SHORT).show();
        bundle = this.getArguments();
//        Bundle bundle = getArguments();
        int username2 = bundle.getInt("username");
        String fsffsf = String.valueOf(username2);
//        String token = bundle.getString("token");
        Toast.makeText(getContext(), fsffsf, Toast.LENGTH_SHORT).show();
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
        FogFunctionByUser fogFunctionByUser1 = new FogFunctionByUser(R.drawable.limo, "banafshe", "روشن خاموش کردن مه ساز");
        items.add(new GreenHouseItems(0, fogFunctionByUser1));
//        Trip trip2 = new Trip(R.drawable.secondphoto, "banafshe", "قرمزه");
//        items.add(new Item(0, trip2));
//        Trip trip3 = new Trip(R.drawable.limo, "banafshe", "لیمو");
//        items.add(new Item(0, trip3));

//        Ads
        SwitchStatusGreenHouse ads1 = new SwitchStatusGreenHouse("ad: christmas", "گلایل", R.drawable.benjamin, true);
        items.add(new GreenHouseItems(1, ads1));
        SwitchStatusGreenHouse ads2 = new SwitchStatusGreenHouse("ad: christmas", "رزماری", R.drawable.ic_cactus, false);
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
}
