package com.example.rostmanafinal.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    String txtShow2, txtShow1;
    Button btn_check;
    Integer startForPass, endForPass;

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
//                                startForPass = persianCalendar.getPersianYear() + "-" + persianCalendar
//                                        .getPersianMonth() + "-" + persianCalendar.getPersianDay();
//                                txtStart.setText(startForPass);

                                startForPass = persianCalendar.getPersianYear() + persianCalendar
                                        .getPersianMonth() + persianCalendar.getPersianDay();
                                txtShow1 = persianCalendar.getPersianYear() + "-" + persianCalendar
                                        .getPersianMonth() + "-" + persianCalendar.getPersianDay();
                                txtStart.setText(txtShow1);
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
                                endForPass = persianCalendar.getPersianYear() + persianCalendar
                                        .getPersianMonth() + persianCalendar.getPersianDay();
                                txtShow2 = persianCalendar.getPersianYear() + "-" + persianCalendar
                                        .getPersianMonth() + "-" + persianCalendar.getPersianDay();
                                txtEnd.setText(txtShow2);

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
//                String str = startForPass;
//                String str2 = endForPass;
//                int inum = Integer.parseInt(str);
//                int inum2 = Integer.parseInt(str2);
//                Toast.makeText(getContext(), endForPass, Toast.LENGTH_SHORT).show();
                if (startForPass != null && endForPass != null) {
                    if (endForPass > startForPass) {
                        Navigation.findNavController(view).navigate(R.id.action_fragmentGetDate_to_fragmentMonitorsContainer);
                        startForPass = null;
                        endForPass = null;
                    } else
                        Toast.makeText(getContext(), "بازه زمانی معتبر انتخاب کنید", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "هر دو تاریخ را انتخاب کنید", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
