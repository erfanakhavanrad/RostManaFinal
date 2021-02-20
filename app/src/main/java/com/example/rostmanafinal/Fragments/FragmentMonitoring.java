package com.example.rostmanafinal.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

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
import pl.droidsonroids.gif.GifImageView;

public class FragmentMonitoring extends Fragment {
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
//    private HashMap<String, String[]> exampleDaysSecond = new HashMap<String, String[]>();
//    private HashMap<String, float[]> exampleHumSecond = new HashMap<String, float[]>();
    private HashMap<String, float[]> exampleTemp = new HashMap<String, float[]>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewMonitoring = inflater.inflate(R.layout.fragment_monitoring, container, false);
        return viewMonitoring;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        userManagerSharedPrefs = new UserManagerSharedPrefs(getContext());
        btn_fetch = view.findViewById(R.id.btn_fetch);
        btn_fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getContext(), "clicked", Toast.LENGTH_SHORT).show();
                Navigation.findNavController(view).navigate(R.id.action_fragmentMonitoring_to_firstFragment2);
            }
        });
        imageLogo = view.findViewById(R.id.imageLogo);
        lineChartView = view.findViewById(R.id.chart);
        lineChartView2 = view.findViewById(R.id.chart2);
        List yAxisValues = new ArrayList();
        List axisValues = new ArrayList();

        if (userManagerSharedPrefs.getToken() != null) {
//            imageLogo.setVisibility(View.VISIBLE);

            exampleHum.put("hum", new float[]{10, 0, 5, 40, 20, 60, 40});

            Line line = new Line(yAxisValues).setColor(Color.parseColor("#018786"));

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


            txtMoreDetails = view.findViewById(R.id.txtMoreDetails);
            txtMoreDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                Navigation.findNavController(view).navigate(R.id.action_fragmentMonitoring_to_fragmentTables);
                    Navigation.findNavController(view).navigate(R.id.action_fragmentMonitoring_to_fragmentParent);
//                    Navigation.findNavController(view).navigate(R.id.action_fragmentMonitoring_to_fragmentParent);
//                    Fragment fragment = new FragmentTables();
//                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                    fragmentTransaction.replace(R.id.fragmentMonitoring, fragment);
//                    fragmentTransaction.addToBackStack(null);
//                    fragmentTransaction.commit();

//                    Fragment FragmentMonitoring  = new FragmentMonitoring();
//                    Fragment fragment = new FragmentTables();
//                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                    fragmentTransaction.replace(R.id.fragmentMonitoring, fragment);
//                    fragmentTransaction.hide(FragmentMonitoring);
//                    fragmentTransaction.addToBackStack(null);
//                    fragmentTransaction.commit();

//                    getActivity().getFragmentManager().beginTransaction().replace(R.id.fragmentTables,
//                            new FragmentMonitoring()).commit();
                }
            });

            //     222222222222222222 SECOND CHART

            List yAxisValues2 = new ArrayList();
            List axisValues2 = new ArrayList();


            exampleTemp.put("temp", new float[]{4, 95, 76, 3, 90, 20, 10});

            Line line2 = new Line(yAxisValues2).setColor(Color.parseColor("#ff0000"));

            for (int i = 0; i < axisDataDays.length; i++) {
                axisValues2.add(i, new AxisValue(i).setLabel(axisDataDays[i]));
            }

            for (int i = 0; i < exampleTemp.get("temp").length; i++) {
                yAxisValues2.add(new PointValue(i, exampleTemp.get("temp")[i]));

            }

            List lines2 = new ArrayList();
            lines2.add(line2);

            LineChartData data2 = new LineChartData();
            data2.setLines(lines2);

            Axis axis2 = new Axis();

            axis2.setValues(axisValues2);
            axis2.setName("دما");
            axis2.setTextSize(16);
            axis2.setTextColor(Color.parseColor("#000000"));
            data2.setAxisXBottom(axis2);

            Axis yAxis2 = new Axis();
//        yAxis2.setName("رطوبت");
            yAxis2.setTextColor(Color.parseColor("#000000"));
//        yAxis2.setTextSize(16);
            data2.setAxisYLeft(yAxis2);

            lineChartView2.setLineChartData(data2);
            Viewport viewport2 = new Viewport(lineChartView2.getMaximumViewport());
            viewport2.top = 100;
            lineChartView2.setMaximumViewport(viewport2);
            lineChartView2.setCurrentViewport(viewport2);


//        } else if (userManagerSharedPrefs.getToken() == null) {
//            imageLogo.setVisibility(View.VISIBLE);
//            lineChartView.setVisibility(View.GONE);
//            lineChartView2.setVisibility(View.GONE);
//            txtMoreDetails.setVisibility(View.GONE);
//        }


//     2222222222222222222   END OF SECOND CHART
        } else if ((userManagerSharedPrefs.getToken() == null)) {
            imageLogo.setVisibility(View.VISIBLE);
//            lineChartView.setVisibility(View.GONE);
//            lineChartView2.setVisibility(View.GONE);
//            txtMoreDetails.setVisibility(View.GONE);
        }

    }
}


