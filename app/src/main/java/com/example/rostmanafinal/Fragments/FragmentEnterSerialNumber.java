package com.example.rostmanafinal.Fragments;

import android.os.Bundle;
import android.os.Trace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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


    }
}
