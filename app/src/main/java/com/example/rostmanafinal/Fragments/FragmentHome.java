package com.example.rostmanafinal.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.rostmanafinal.LoginRegisterActivity;
import com.example.rostmanafinal.R;
import com.example.rostmanafinal.UserManagerSharedPrefs;

public class FragmentHome extends Fragment {
    UserManagerSharedPrefs userManagerSharedPrefs;
    DrawerLayout containerd;
    ImageView menuIconImage, imageClose, imageAddUser;
    LinearLayout firstItem, secondItem, fourthItem, fifthItem;
    Button btnGet, btnPost;
    TextView textView7, textView8, txtToken;
    boolean doubleBackToExitPressedOnce = false;


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
        textView7 = view.findViewById(R.id.textView7);
        textView8 = view.findViewById(R.id.textView8);
        txtToken = view.findViewById(R.id.txtToken);
//        Toast.makeText(getContext(), "" + userManagerSharedPrefs.getToken(), Toast.LENGTH_SHORT).show();
//        fullname.setText(usermanager.getfullname);
        textView7.setText(userManagerSharedPrefs.getFullName());
        textView8.setText(userManagerSharedPrefs.getEmail());
        txtToken.setText(userManagerSharedPrefs.getToken());


        btnPost = view.findViewById(R.id.btnPost);
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentHome_to_fragmentPostTest);
            }
        });


        btnGet = view.findViewById(R.id.btnGet);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentHome_to_fragmentMainTest);
            }
        });

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
//    onBackpressed
//    getActivity().moveTaskToBack(true);
//    getActivity().finish();
}

