package com.example.rostmanafinal.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.rostmanafinal.R;


public class FirstFragment extends Fragment {

    TextView firstText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewFirst = inflater.inflate(R.layout.fragment_first, container, false);

        return viewFirst;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        firstText = getView().findViewById(R.id.firstText);
        firstText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Navigation.findNavController(view).navigate(R.id.action_firstFragment2_to_secondFragment2);

                //NavHostFragment.findNavController(SecondFragment);
//                Navigation.findNavController(Activity, @IdRes int viewId)
//                Navigation.findNavController(View)
            }
        });
    }
}
