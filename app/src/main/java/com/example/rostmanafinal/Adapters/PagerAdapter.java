package com.example.rostmanafinal.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.rostmanafinal.Fragments.FragmentEnterSerialNumber;
import com.example.rostmanafinal.Fragments.FragmentScanQR;

public class PagerAdapter extends FragmentPagerAdapter {

    private int numOfTabs;

    public PagerAdapter(FragmentManager fragmentManager, int numOfTabs) {
        super(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.numOfTabs = numOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
//        return null;
    switch (position) {
        case 0:
            return new FragmentScanQR();
        case 1:
            return new FragmentEnterSerialNumber();
        default: return null;
    }

    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
