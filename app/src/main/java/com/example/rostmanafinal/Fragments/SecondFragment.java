package com.example.rostmanafinal.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import com.example.rostmanafinal.R;

import java.util.Objects;

public class SecondFragment extends Fragment {

    Button secondBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewSecond = inflater.inflate(R.layout.fragment_second, container, false);

        secondBtn = viewSecond.findViewById(R.id.secondBtn);
        secondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "clicked", Toast.LENGTH_SHORT).show();

//                Fragment newFragment = new Fragment_Plant_Details();
//                FragmentTransaction ft = getChildFragmentManager().beginTransaction();
//                ft.replace(R.id., newFragment);
//                ft.commit();
//                getSup().beginTransaction().replace(R.id.fragment_Plant_Details, new Fragment_Plant_Details()).addToBackStack(null).commit();

//           requireActivity().getSupportFragmentManager();
//                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                Fragment_Plant_Details fn = new Fragment_Plant_Details();
//                fragmentTransaction.replace(R.id.nav_host_fragment, fn);
//                fragmentTransaction.commit();

                Navigation.findNavController(view).navigate(R.id.fragment_Plant_Details);

            }
        });


        return viewSecond;
    }
}
