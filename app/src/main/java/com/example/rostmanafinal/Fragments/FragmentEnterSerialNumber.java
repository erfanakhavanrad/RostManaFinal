package com.example.rostmanafinal.Fragments;

import android.os.Bundle;
import android.os.Trace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import com.example.rostmanafinal.R;

public class FragmentEnterSerialNumber extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewEnterSerial = inflater.inflate(R.layout.fragment_enter_serialnumber, container, false);


        return viewEnterSerial;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText serialEntered = view.findViewById(R.id.serialEntered);
        serialEntered.setImeOptions(EditorInfo.IME_ACTION_DONE);
        serialEntered.isSingleLine();

        Button btnConfirm = view.findViewById(R.id.btnConfirm);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                requireActivity().getSupportFragmentManager();
//                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                FirstFragment fn = new FirstFragment();
//                fragmentTransaction.replace(R.id.nav_host_fragment, fn);
//                fragmentTransaction.commit();


//                Toast.makeText(getContext(), "clicked", Toast.LENGTH_SHORT).show();
                Navigation.findNavController(view).navigate(R.id.action_fragmentViewPagerTabbed23_to_fragmentEnterSerialNumber);
                Navigation.findNavController(view).navigate(R.id.action_fragmentEnterSerialNumber_to_firstFragment22);


            }
        });

    }
}
