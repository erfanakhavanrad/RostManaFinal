package com.example.rostmanafinal.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.rostmanafinal.R;
import com.example.rostmanafinal.UserManagerSharedPrefs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

public class FragmentHumidity extends Fragment {
    LineChartView lineChartView, lineChartView2;
    UserManagerSharedPrefs userManagerSharedPrefs;
    String[] axisDataDays = {"شنبه", "یکشنبه", "دوشنبه", "سه شنبه", "چهارشنبه", "پنجشنبه", "جمعه"};
    //    ImageView ;
    TextView txtMoreDetails;
    ImageView imageLogo;
    Button btn_fetch;
    private static final String TAG = "FragmentMonitoring";
    //    First Chart
    private HashMap<String, String[]> exampleDays = new HashMap<String, String[]>();
    private HashMap<String, float[]> exampleHum = new HashMap<String, float[]>();

    //    Second Chart
    private HashMap<String, float[]> exampleTemp = new HashMap<String, float[]>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewWeather = inflater.inflate(R.layout.fragment_humidity, container, false);
        return viewWeather;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        userManagerSharedPrefs = new UserManagerSharedPrefs(getContext());
        imageLogo = view.findViewById(R.id.imageLogo);
        lineChartView = view.findViewById(R.id.chart);
//        lineChartView2 = view.findViewById(R.id.chart2);
        List yAxisValues = new ArrayList();
        List axisValues = new ArrayList();
        if (userManagerSharedPrefs.getToken() != null) {
//            imageLogo.setVisibility(View.VISIBLE);

            exampleHum.put("hum", new float[]{10, 0, 5, 40, 20, 60, 40});

            Line line = new Line(yAxisValues).setColor(Color.parseColor("#68431F"));
//            018786
            for (int i = 0; i < axisDataDays.length; i++) {
                axisValues.add(i, new AxisValue(i).setLabel(axisDataDays[i]));
            }

            for (int i = 0; i < exampleHum.get("hum").length; i++) {
                yAxisValues.add(new PointValue(i, exampleHum.get("hum")[i]));

            }

            List lines = new ArrayList();
            lines.add(line);

            LineChartData data = new LineChartData();
            data.setLines(lines);

            Axis axis = new Axis();

            axis.setValues(axisValues);
            axis.setName("رطوبت");
            axis.setTextSize(16);
            axis.setTextColor(Color.parseColor("#000000"));
            data.setAxisXBottom(axis);

            Axis yAxis = new Axis();
//        yAxis2.setName("رطوبت");
            yAxis.setTextColor(Color.parseColor("#000000"));
//        yAxis2.setTextSize(16);
            data.setAxisYLeft(yAxis);

            lineChartView.setLineChartData(data);
            Viewport viewport = new Viewport(lineChartView.getMaximumViewport());
            viewport.top = 100;
            lineChartView.setMaximumViewport(viewport);
            lineChartView.setCurrentViewport(viewport);

        }
    }
}
