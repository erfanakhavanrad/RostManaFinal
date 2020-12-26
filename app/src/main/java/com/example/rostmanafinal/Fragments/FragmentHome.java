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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.rostmanafinal.R;

public class FragmentHome extends Fragment {
    DrawerLayout containerd;
    ImageView menuIconImage, imageClose, imageAddUser;
    LinearLayout firstItem, secondItem, fifthItem;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewHome = inflater.inflate(R.layout.fragment_home, container, false);

        return viewHome;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        containerd = view.findViewById(R.id.containerd);
        imageClose = view.findViewById(R.id.imageClose);
        firstItem = view.findViewById(R.id.firstItem);
        secondItem = view.findViewById(R.id.secondItem);
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
                Navigation.findNavController(view).navigate(R.id.action_fragmentHome_to_fragmentLoginRegister);
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
}
