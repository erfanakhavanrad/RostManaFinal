package com.example.rostmanafinal.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.rostmanafinal.MainActivity;
import com.example.rostmanafinal.R;

public class FragmentProfile extends Fragment {
    ImageView imageViewReturn;
    Button btn_male, btn_female;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewProfile = inflater.inflate(R.layout.fragment_profile, container, false);
        return viewProfile;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_male = view.findViewById(R.id.btn_male);
        btn_female = view.findViewById(R.id.btn_female);
        imageViewReturn = view.findViewById(R.id.imageViewReturn);
        btn_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_female.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.lGreen2OnSelected));
                btn_male.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.lGreen2));
            }
        });
        btn_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_male.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.lGreen2OnSelected));
                btn_female.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.lGreen2));
            }
        });


        imageViewReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentProfile_to_fragmentHome);
            }
        });

    }
}
