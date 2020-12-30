package com.example.rostmanafinal.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.rostmanafinal.Adapters.TableListViewAdapter;
import com.example.rostmanafinal.Pojo.DaysOfWeek;
import com.example.rostmanafinal.Pojo.TableModel;
import com.example.rostmanafinal.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FragmentTables extends Fragment {
    //    Map<String, String> watering = new HashMap<String, String>();
//    HashMap<String,Person> persons = new  HashMap<String,Person>();
//    Map<String, String[]> fan = new HashMap<String, String>();
//    Map<String, String[]> element = new HashMap<String, String>();
//    Map<String, String[]> lighting = new HashMap<String, String>();
//    Map<String, String[]> fogger = new HashMap<String, String>();


    private ArrayList<TableModel> productList;
    private ArrayList<DaysOfWeek> days;

    Map<String, String[]> daysHash = new HashMap<String, String[]>();
    Map<String, String[]> watering = new HashMap<String, String[]>();
    Map<String, String[]> fan = new HashMap<String, String[]>();
    Map<String, String[]> element = new HashMap<String, String[]>();
    Map<String, String[]> lighting = new HashMap<String, String[]>();
    Map<String, String[]> fogger = new HashMap<String, String[]>();

    Button btnFetchNext, btnFetchPrevious;
    int CountNumberOfTables = 0, NumberOfTables = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewTables = inflater.inflate(R.layout.fragment_tables, container, false);

        return viewTables;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        daysHash.put("days", new String[]{"شنبه", "یکشنبه", "دوشنبه", "سه شنبه", "چهارشنبه", "پنجشنبه", "جمعه"});
        watering.put("milk", new String[]{"1", "3", "2"});


//        watering.put("sunday", "sec");
//fan.put("sunday", {},);


        ListView lview = (ListView) view.findViewById(R.id.listview);
        btnFetchPrevious = view.findViewById(R.id.btnFetchPrevious);
        btnFetchPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                days = new ArrayList<DaysOfWeek>();
//                TableListViewAdapter adapter2 = new TableListViewAdapter(getActivity(), productList);


                productList = new ArrayList<TableModel>();
                TableListViewAdapter adapter = new TableListViewAdapter(getActivity(), productList);
                lview.setAdapter(adapter);
                populateList();
                adapter.notifyDataSetChanged();
            }
        });


        btnFetchNext = view.findViewById(R.id.btnFetchNext);
        btnFetchNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                days = new ArrayList<DaysOfWeek>();
                productList = new ArrayList<TableModel>();
                TableListViewAdapter adapter = new TableListViewAdapter(getActivity(), productList);
                lview.setAdapter(adapter);
                setDays();
                populateList2();
                adapter.notifyDataSetChanged();
            }
        });


        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                String sno = ((TextView) view.findViewById(R.id.sNo)).getText().toString();
                String product = ((TextView) view.findViewById(R.id.product)).getText().toString();
                String category = ((TextView) view.findViewById(R.id.category)).getText().toString();
                String price = ((TextView) view.findViewById(R.id.price)).getText().toString();

                Toast.makeText(getContext(),
                        "S no : " + sno + "\n"
                                + "Product : " + product + "\n"
                                + "Category : " + category + "\n"
                                + "Price : " + price, Toast.LENGTH_SHORT).show();
            }
        });


//        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//
//                String sno = ((TextView)view.findViewById(R.id.sNo)).getText().toString();
//                String product = ((TextView)view.findViewById(R.id.product)).getText().toString();
//                String category = ((TextView)view.findViewById(R.id.category)).getText().toString();
//                String price = ((TextView)view.findViewById(R.id.price)).getText().toString();
//
//                Toast.makeText(getApplicationContext(),
//                        "S no : " + sno +"\n"
//                                +"Product : " + product +"\n"
//                                +"Category : " +category +"\n"
//                                +"Price : " +price, Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    public void setDays() {
        DaysOfWeek day1, day2, day3, day4, day5, day6, day7;
        day1 = new DaysOfWeek("شنبه", " 1", "2", "2", "3", "4", "5");
        days.add(day1);
    }


    private void populateList() {
//        CountNumberOfTables ++1;
//productList.clear();
        TableModel item1, item2, item3, item4, item5;

        item1 = new TableModel("1", "Apple (Northern Spy)", "Fruits", "₹. 200", "fogger");
        productList.add(item1);

        item2 = new TableModel("2", "Orange (Sunkist navel)", "Fruits", "₹. 100", "fogger");
        productList.add(item2);

        item3 = new TableModel("3", "Tomato", "Vegetable", "₹. 50", "fogger");
        productList.add(item3);

        item4 = new TableModel("4", "Carrot", "Vegetable", "₹. 80", "fogger");
        productList.add(item4);

        item5 = new TableModel("5", "Banana (Cavendish)", "Fruits", "₹. 100", "fogger");
        productList.add(item5);
    }
//    Map<String>


    private void populateList2() {
//        days
        TableModel item1, item2, item3, item4, item5;

        productList.clear();

        item1 = new TableModel("50", "dadaaawdawd (Northern Spy)", "Fruits", "₹. 200", "fogger");
        productList.add(item1);

        item2 = new TableModel("100", "Osefefsfscel)", "Frvdfvfdvdfvdvdvfvuits", "₹. 1bb00", "fogger");
        productList.add(item2);

        item3 = new TableModel("300", "fsdfsdfsdfsdf", "Vegetable", "₹. 50", "fogger");
        productList.add(item3);

        item4 = new TableModel("400", "efee423", "dffdvfdvvfd", "₹. 8bbb0", "fogger");
        productList.add(item4);

        item5 = new TableModel("500", "77544terdvc", "trhrtrgbits", "₹. 10bbb0", "fogger");
        productList.add(item5);
    }


}
