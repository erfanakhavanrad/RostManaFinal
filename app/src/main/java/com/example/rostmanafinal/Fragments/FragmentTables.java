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
import com.example.rostmanafinal.Pojo.TableModel;
import com.example.rostmanafinal.R;

import java.util.ArrayList;

public class FragmentTables extends Fragment {

    private ArrayList<TableModel> productList;
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

        ListView lview = (ListView) view.findViewById(R.id.listview);
        btnFetchPrevious = view.findViewById(R.id.btnFetchPrevious);
        btnFetchPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                productList = new ArrayList<TableModel>();
                TableListViewAdapter adapter = new TableListViewAdapter(getActivity(), productList);
                lview.setAdapter(adapter);
                populateList2();
                adapter.notifyDataSetChanged();
          }
        });


        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                String sno = ((TextView)view.findViewById(R.id.sNo)).getText().toString();
                String product = ((TextView)view.findViewById(R.id.product)).getText().toString();
                String category = ((TextView)view.findViewById(R.id.category)).getText().toString();
                String price = ((TextView)view.findViewById(R.id.price)).getText().toString();

                Toast.makeText(getContext(),
                        "S no : " + sno +"\n"
                                +"Product : " + product +"\n"
                                +"Category : " +category +"\n"
                                +"Price : " +price, Toast.LENGTH_SHORT).show();
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

    private void populateList() {
//        CountNumberOfTables ++1;
productList.clear();
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
