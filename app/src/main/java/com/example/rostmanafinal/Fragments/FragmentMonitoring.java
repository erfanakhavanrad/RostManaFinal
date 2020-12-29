package com.example.rostmanafinal.Fragments;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.rostmanafinal.Pojo.HistoricalDataResponse;
import com.example.rostmanafinal.R;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentMonitoring extends Fragment {
    LineChartView lineChartView;
    String[] axisData = {"شنبه", "یکشنبه", "دوشنبه", "سه شنبه", "چهارشنبه", "پنجشنبه", "جمعه"};
    int[] yAxisData = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    Button btnclicl;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewMonitoring = inflater.inflate(R.layout.fragment_monitoring, container, false);

        return viewMonitoring;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        LineChartView lineChartView = view.findViewById(R.id.chart);

        btnclicl = view.findViewById(R.id.btnclicl);
        btnclicl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentMonitoring_to_fragmentTables);
            }
        });


        lineChartView = view.findViewById(R.id.chart);

        List yAxisValues = new ArrayList();
        List axisValues = new ArrayList();


        Line line = new Line(yAxisValues).setColor(Color.parseColor("#26a653"));

        for (int i = 0; i < axisData.length; i++) {
            axisValues.add(i, new AxisValue(i).setLabel(axisData[i]));
        }
        Toast.makeText(getContext(), "" + axisData.length, Toast.LENGTH_SHORT).show();
//        int g = 0;
//        while ( g < axisData.length){
//
//
//
//        }


        for (int i = 0; i < yAxisData.length; i++) {

            yAxisValues.add(new PointValue(i, yAxisData[i]));
//            yAxisValues.add(50);
        }

//       yAxisValues.remove(36);
//            yAxisValues.remove(1);
//            yAxisValues.add(10);
//            yAxisValues.add(50);
//            yAxisValues.remove(12);
//            yAxisValues.remove(19);
//            yAxisValues.add(13);
//            yAxisValues.add(19);
//            yAxisValues.remove(16);
//
//            yAxisValues.add(11);
//            yAxisValues.add(13);
//        }

        List lines = new ArrayList();
        lines.add(line);

        LineChartData data = new LineChartData();
        data.setLines(lines);

        Axis axis = new Axis();
        axis.setValues(axisValues);
        axis.setTextSize(16);
        axis.setTextColor(Color.parseColor("#000000"));
        data.setAxisXBottom(axis);

        Axis yAxis = new Axis();
        yAxis.setName("رطوبت");
        yAxis.setTextColor(Color.parseColor("#000000"));
        yAxis.setTextSize(16);
        data.setAxisYLeft(yAxis);

        lineChartView.setLineChartData(data);
        Viewport viewport = new Viewport(lineChartView.getMaximumViewport());
        viewport.top = 100;
        lineChartView.setMaximumViewport(viewport);
        lineChartView.setCurrentViewport(viewport);
    }

}


