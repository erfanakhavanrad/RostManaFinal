package com.example.rostmanafinal.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.rostmanafinal.Adapters.ViewPagerAdapter;
import com.example.rostmanafinal.R;
import com.google.android.material.tabs.TabLayout;

public class FragmentAddToHome extends Fragment {


    View view;

    ViewPager viewPager;
    TabLayout tabLayout;

    public FragmentAddToHome(){}



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_add_to_home,container,false);
        viewPager = view.findViewById(R.id.viewpager_news);
        tabLayout = view.findViewById(R.id.tablayout_news);
        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void setUpViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new FragmentScanQR(),"اسکن بارکد");
        adapter.addFragment(new FragmentEnterSerialNumber(),"دستی");
//        adapter.addFragment(new Fragment3(),"Fragment3");





        viewPager.setAdapter(adapter);
    }

}
