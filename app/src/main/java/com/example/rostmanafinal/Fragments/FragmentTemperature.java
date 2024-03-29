package com.example.rostmanafinal.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.rostmanafinal.Interfaces.RetrofitApiService;
import com.example.rostmanafinal.Pojo.ModelChartsTables.ChartsModel;
import com.example.rostmanafinal.R;
import com.example.rostmanafinal.Retrofit.TokenInterceptor;
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
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentTemperature extends Fragment {

    static String BASE_URL = "Mobile/histort/";
    UserManagerSharedPrefs userManagerSharedPrefs;
    RetrofitApiService request;
    String date1, date2, SURL, token, url = "http://rostmana.com/api/";
    //    url = "http://rostmana.com/api/"
    //    List<SeasonalModel> seasonalModels22 = new ArrayList<>();
//    FlowersAdapter adapter = new FlowersAdapter(this::callBack);
    static String SEASONAL_URL = "7";

    //    String[] dawdd;
    LineChartView lineChartView;
//    in neveshte paiien nemodare
//    khat paoen x
 //   String[] axisDataDays = {"شنبه", "یکشنبه", "دوشنبه", "سه شنبه", "چهارشنبه", "پنجشنبه", "جمعه"};
    ArrayList<Float> temps = new ArrayList<>();
    ArrayList<String > days = new ArrayList<>();
    ImageView imageLogo;
    private static final String TAG = "FragmentMonitoring";
    //    First Chart
    private HashMap<String, String[]> exampleDays = new HashMap<String, String[]>();
    //        private HashMap<String, float[]> exampleHum = new HashMap<String, float[]>();
   // private HashMap<String, Float[]> exampleHum = new HashMap<String, Float[]>();
//    int[] exampleHum = new int[10];
    //    Second Chart
//    private HashMap<String, float[]> exampleTemp = new HashMap<String, float[]>();
    Bundle bundle = new Bundle();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewWeather = inflater.inflate(R.layout.fragment_temperature, container, false);
        return viewWeather;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userManagerSharedPrefs = new UserManagerSharedPrefs(getContext());
        bundle = this.getArguments();
        imageLogo = view.findViewById(R.id.imageLogo);
        lineChartView = view.findViewById(R.id.chart);
        SURL = url + BASE_URL + SEASONAL_URL;
        List yAxisValues = new ArrayList();
        List axisValues = new ArrayList();
//        date1 = bundle.getString("txtShow1");
//        date2 = bundle.getString("txtShow2");
        //        String all = SURL + date1 + date2;
//        System.out.println(all);
        //        lineChartView2 = view.findViewById(R.id.chart2);
        date1 = "1399-01-20";
        date2 = "1399-12-01";
        sendRequest(SURL, date1, date2);

//in ham megdari ke bayad pass bedim be nemodar ta neshon bede bayad inja bdim behesh
    //    exampleHum.put("hum", temps);

        if (userManagerSharedPrefs.getToken() != null) {
//            imageLogo.setVisibility(View.VISIBLE);

//            exampleHum.put("hum", new float[]{10, 0, 5, 40, 20, 60, 40});

            Line line = new Line(yAxisValues).setColor(Color.parseColor("#ff0000"));
            for (int i = 0; i < days.size(); i++) {
                axisValues.add(i, new AxisValue(i).setLabel(days.get(i)));
            }

//            for (int i = 0; i < exampleHum.get("hum").length; i++) {
//                yAxisValues.add(new PointValue(i, exampleHum.get("hum")[i]));
//
//            }
            for (int i = 0; i < temps.size(); i++) {
                yAxisValues.add(new PointValue(temps.get(i),temps.get(i)));
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

    public void sendRequest(String getPageUrl, String date1, String date2) {
        userManagerSharedPrefs = new UserManagerSharedPrefs(getContext());
        token = userManagerSharedPrefs.getToken();
        TokenInterceptor interceptor = new TokenInterceptor(token);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        request = retrofit.create(RetrofitApiService.class);


        Call<List<ChartsModel>> call = request.postForCharts(getPageUrl, date1, date2);
        call.enqueue(new Callback<List<ChartsModel>>() {
            @Override
            public void onResponse(Call<List<ChartsModel>> call, Response<List<ChartsModel>> response) {
                if (response.isSuccessful()) {
                    ChartsModel chartsModel = new ChartsModel();
//                    List<ChartsModel> chartsModelList = new List<>;
//                    chartsModel = response.body();

                    ArrayList<ChartsModel> chartsModelArrayList = new ArrayList<>();
//                    Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();
//                    chartsModel = response.body();
//                    chartsModelArrayList = response.body();
//                    dawdd = response.body().get(1).getDay();
                    ArrayList<ChartsModel> arrayList = new ArrayList();
                    arrayList.addAll(response.body());
                    for (int i = 0; i < arrayList.size(); i++) {
//                        arrayList.indexOf(i);
                        arrayList.get(i).getDay();
                        days.add(arrayList.get(i).getDay());
//                        temps.add(arrayList.get(i).getTemp())
//                        float afa[] = arrayList.get(i).getNumOFFLight();
//                                    exampleHum.put("hum", afa);
                        Float[] daw;
//daw = arrayList.get(i).getNumOFFLight();


//                        int[] num = new int[args.length];
//                        for (int i = 0; i < args.length; i++) {
//                            int neki = Integer.parseInt(args[i]);
//                            num[i] = neki;
//                        }


//                        Toast.makeText(getContext(), arrayList.get(i).getNumOFFLight().toString(), Toast.LENGTH_SHORT).show();
//                        for (int j = 0; j < arrayList.get(i).getTemp(); j++) {
//                            exampleHum.put("num",arrayList.get(i).getNumOFFLight());
//                            int adawd = arrayList.get(i).getTemp();
                            
//                            int[] daawd = new int[];

//                        }


//exampleHum.put("num", arrayList.get(i).getNumOFFLight());
//                        Integer floatList = arrayList.get(i).getNumOFFLight();

//                        float[] floatArray = new float[floatList.size()];
//                        int i = 0;
//
//                        for (Float f : floatList) {
//                            floatArray[i++] = (f != null ? f : Float.NaN); // Or whatever default you want.
//                        }

//                        exampleHum.put("hum", new float[]{10, 0, 5, 40, 20, 60, 40});
                        int[] nueem = new int[arrayList.size()];
                        for (int j = 0; j < nueem.length; j++) {
//                            nueem[j] = arrayList.get(i).getTemp();
//                            exampleHum = nueem[j];
//                            exampleHum = arrayList.get(i).getNumOFFPumpW();
//                            exampleHum.put("num", nueem[j]);
//                            *****
                            Toast.makeText(getContext(), nueem.toString(), Toast.LENGTH_SHORT).show();
                        }
//                        nueem = arrayList.get(i).getNumOFFFogger();
                    }
                } else if (response.code() == 404) {
                    Toast.makeText(getContext(), "404", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "on resonse" + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ChartsModel>> call, Throwable t) {
                Toast.makeText(getContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        /**
         Call<ChartsModel> call = request.postForCharts(getPageUrl,date1, date2);
         call.enqueue(new Callback<ChartsModel>() {
        @Override public void onResponse(Call<ChartsModel> call, Response<ChartsModel> response) {
        if (response.isSuccessful()) {
        ChartsModel chartsModels = new ChartsModel();
        chartsModels = response.body();
        String sfsfsfsf = chartsModels.getDay();
        } else if (response.code() == 400) {
        Toast.makeText(getContext(), "4000", Toast.LENGTH_SHORT).show();
        } else Toast.makeText(getContext(), "onResponse error", Toast.LENGTH_SHORT).show();
        }

        @Override public void onFailure(Call<ChartsModel> call, Throwable t) {
        Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
        }
        }); */
//Call<ChartModel> call = request.postForCharts(getPageUrl, date1, date2);
//        Call<List<SeasonalModel>> call = request.getPlantList(getPageUrl);
//        call.enqueue(new Callback<List<SeasonalModel>>() {
//            @Override
//            public void onResponse(Call<List<SeasonalModel>> call, Response<List<SeasonalModel>> response) {
//                if (response.isSuccessful()) {
//                    ArrayList<SeasonalModel> seasonalModels = new ArrayList<>();

//                    ArrayList<Task> tmp = new ArrayList<Task>(mTrackytAdapter.getAllTasks(token));
//                    ArrayList<SeasonalModel> sml = new ArrayList<SeasonalModel>();
//seasonalModel = response.body();
//                    list<modelet>  a=response.body
//                    seasonalModels22 = response.body();
//                    adapter.setList(seasonalModels22);


//Adapter
//                    ArrayList<SeasonalModel> names = new ArrayList<>();
//                    names.add(response.body());
//                    seasonalModels.get
//                    Toast.makeText(getContext(), "model s" + seasonalModels.get(2), Toast.LENGTH_SHORT).show();
        //                    Toast.makeText(getContext(), "success " + seasonalModel.getName(), Toast.LENGTH_SHORT).show();
//                    Toast.makeText(getContext(), "success" + seasonalModel.getName(), Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(getContext(), " else" + response.body(), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<SeasonalModel>> call, Throwable t) {
//                Toast.makeText(getContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
