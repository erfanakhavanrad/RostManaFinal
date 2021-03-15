package com.example.rostmanafinal.Fragments.dialogs;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.example.rostmanafinal.R;


public class LoadingDialogFragment extends DialogFragment {

    public static final String TAG = "LOADING_DIALOG";
    View fragmentView;

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_dialog_loading, container, false);

        return fragmentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setCancelable(getArguments().getBoolean("CANCELABLE"));
        getDialog().setCanceledOnTouchOutside(getArguments().getBoolean("CANCELABLE"));
        ImageView imv = fragmentView.findViewById(R.id.progressBar);
        Glide.with(this).asGif().load(R.drawable.tenor).into(imv);


        if (!getArguments().getBoolean("CANCELABLE")) {
            new CountDownTimer(6000, 6000) {
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    dismiss();
                }
            }.start();
        }

    }

    @Override
    public int getTheme() {
        return R.style.DialogTheme;
    }

    /*
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
*/
}
