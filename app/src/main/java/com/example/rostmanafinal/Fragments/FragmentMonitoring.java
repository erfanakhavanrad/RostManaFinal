package com.example.rostmanafinal.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.rostmanafinal.R;

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

public class FragmentMonitoring extends Fragment {
    LineChartView lineChartView;
    String[] axisDataDays = {"شنبه", "یکشنبه", "دوشنبه", "سه شنبه", "چهارشنبه", "پنجشنبه", "جمعه"};
    String[] AxisDataHum = {"0", "10", "20", "30", "40", "50", "60", "70", "80", "90", "100"};
    Button btnclicl;
    private static final String TAG = "FragmentMonitoring";
    private HashMap<String, String[]> exampleDays = new HashMap<String, String[]>();
    private HashMap<String, float[]> exampleHum = new HashMap<String, float[]>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewMonitoring = inflater.inflate(R.layout.fragment_monitoring, container, false);
        return viewMonitoring;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        exampleHum.put("hum", new float[]{10, 0, 5, 40, 20, 60, 40});

        lineChartView = view.findViewById(R.id.chart);

        List yAxisValues = new ArrayList();
        List axisValues = new ArrayList();

        Line line = new Line(yAxisValues).setColor(Color.parseColor("#ff0000"));

        for (int i = 0; i < axisDataDays.length; i++) {
            axisValues.add(i, new AxisValue(i).setLabel(axisDataDays[i]));
        }

        for (int i = 0; i < exampleHum.get("hum").length; i++) {
            yAxisValues.add(new PointValue(i, exampleHum.get("hum")[i]));

        }
        int i = 0;

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
//        yAxis.setName("رطوبت");
        yAxis.setTextColor(Color.parseColor("#000000"));
//        yAxis.setTextSize(16);
        data.setAxisYLeft(yAxis);

        lineChartView.setLineChartData(data);
        Viewport viewport = new Viewport(lineChartView.getMaximumViewport());
        viewport.top = 100;
        lineChartView.setMaximumViewport(viewport);
        lineChartView.setCurrentViewport(viewport);


        btnclicl = view.findViewById(R.id.btnclicl);
        btnclicl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentMonitoring_to_fragmentTables);
            }
        });

    }

}


