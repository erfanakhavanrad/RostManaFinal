package com.example.rostmanafinal.Fragments.dialogs;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;

import com.example.rostmanafinal.R;


public class LoadingDialogFragment extends DialogFragment {

    public static final String TAG = "LOADING_DIALOG";

    public static LoadingDialogFragment newInstance(boolean cancelable) {

        Bundle args = new Bundle();
        args.putBoolean("CANCELABLE", cancelable);
        LoadingDialogFragment fragment = new LoadingDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static LoadingDialogFragment newInstance() {

        Bundle args = new Bundle();
        args.putBoolean("CANCELABLE", true);
        LoadingDialogFragment fragment = new LoadingDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        dialog.setCanceledOnTouchOutside(getArguments().getBoolean("CANCELABLE"));
        dialog.setCancelable(getArguments().getBoolean("CANCELABLE"));
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_dialog_loading, null);


        dialog.setContentView(dialogView);
        return dialog;
    }

}
