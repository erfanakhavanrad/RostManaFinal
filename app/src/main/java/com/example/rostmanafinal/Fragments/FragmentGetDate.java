package com.example.rostmanafinal.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.rostmanafinal.R;

import ir.hamsaa.persiandatepicker.Listener;
import ir.hamsaa.persiandatepicker.PersianDatePickerDialog;
import ir.hamsaa.persiandatepicker.util.PersianCalendar;

public class FragmentGetDate extends Fragment {
    PersianCalendar initDate = new PersianCalendar();
    TextView txtStart, txtEnd;
    private PersianDatePickerDialog picker;
    String endForPass, startForPass;
    Button btn_check;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewGetDate = inflater.inflate(R.layout.fragment_getdate, container, false);
        return viewGetDate;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btn_check = view.findViewById(R.id.btn_check);
        txtStart = view.findViewById(R.id.txtStart);
        txtStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                initDate.setPersianDate(1370, 3, 13);

                picker = new PersianDatePickerDialog(getContext())
                        .setPositiveButtonString("تایید")
                        .setNegativeButton("لغو")
                        .setTodayButtonVisible(false)
                        .setMinYear(1300)
                        .setMaxYear(PersianDatePickerDialog.THIS_YEAR)
                        .setInitDate(initDate)
                        .setActionTextColor(Color.BLACK)
//                        .setTypeFace(typeface)
                        .setTitleType(PersianDatePickerDialog.WEEKDAY_DAY_MONTH_YEAR)
                        .setShowInBottomSheet(false)
                        .setListener(new Listener() {
                            @Override
                            public void onDateSelected(PersianCalendar persianCalendar) {
                                startForPass = persianCalendar.getPersianYear() + "-" + persianCalendar
                                        .getPersianMonth() + "-" + persianCalendar.getPersianDay();
                                txtStart.setText(startForPass);
                            }

                            @Override
                            public void onDismissed() {

                            }
                        });

                picker.show();

            }
        });

        txtEnd = view.findViewById(R.id.txtEnd);
        txtEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initDate.setPersianDate(1370, 3, 13);

                picker = new PersianDatePickerDialog(getContext())
                        .setPositiveButtonString("تایید")
                        .setNegativeButton("لغو")
                        .setTodayButtonVisible(false)
                        .setMinYear(1300)
                        .setMaxYear(PersianDatePickerDialog.THIS_YEAR)
                        .setInitDate(initDate)
                        .setActionTextColor(Color.BLACK)
//                        .setTypeFace(typeface)
                        .setTitleType(PersianDatePickerDialog.WEEKDAY_DAY_MONTH_YEAR)
                        .setShowInBottomSheet(false)
                        .setListener(new Listener() {
                            @Override
                            public void onDateSelected(PersianCalendar persianCalendar) {
//                                Toast.makeText(getContext(), persianCalendar.getPersianYear() + "/" + persianCalendar.getPersianMonth() + "/" + persianCalendar.getPersianDay(), Toast.LENGTH_SHORT).show();
                                endForPass = persianCalendar.getPersianYear() + "-" + persianCalendar
                                        .getPersianMonth() + "-" + persianCalendar.getPersianDay();
                                txtEnd.setText(endForPass);

                            }

                            @Override
                            public void onDismissed() {

                            }
                        });

                picker.show();
            }
        });
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentGetDate_to_fragmentMonitoring);
            }
        });



    }
}
