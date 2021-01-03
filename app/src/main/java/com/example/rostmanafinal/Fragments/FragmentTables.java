package com.example.rostmanafinal.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.rostmanafinal.R;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FragmentTables extends Fragment {
    private static final String TAG = "FragmentTables";
    TableLayout tableLayout;
    TextView shanbeC, yekshanbe, txtRow;
    JsonParser jParser;
    TableLayout tableReport;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewTables = inflater.inflate(R.layout.fragment_tables, container, false);

        return viewTables;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        yekshanbe = view.findViewById(R.id.yekshabeC);
        shanbeC = view.findViewById(R.id.shanbeC);
        shanbeC.setText("sdfsff22323q2323");
        String address = "{\"status\":\"200\",\"info\":[{\"userName\": \"sandeep\",\"age\":\"30\"},{\"userName\": \"vivan\",\"age\":\"5\"}]}";
        txtRow = view.findViewById(R.id.txtRow);
        tableReport = view.findViewById(R.id.tableReport);
        String temp = "\n" +
                "   {\n" +
                "      \"res\":{\n" +
                "         \"status\":\"200\",\n" +
                "         \"info\":[\n" +
                "            {\n" +
                "               \"day\":{\n" +
                "                  \"watering\":20,\n" +
                "                  \"fan\":435,\n" +
                "                  \"element\":20,\n" +
                "                  \"slight\":85,\n" +
                "                  \"sfogger\":45\n" +
                "               }\n" +
                "            },\n" +
                "            {\n" +
                "               \"day\":{\n" +
                "                  \"watering\":40,\n" +
                "                  \"fan\":15,\n" +
                "                  \"element\":36,\n" +
                "                  \"sulight\":55,\n" +
                "                  \"sfogger\":45\n" +
                "               }\n" +
                "            },\n" +
                "            {\n" +
                "               \"day\":{\n" +
                "                  \"watering\":20,\n" +
                "                  \"fan\":75,\n" +
                "                  \"element\":0,\n" +
                "                  \"mlight\":44,\n" +
                "                  \"sfogger\":45\n" +
                "               }\n" +
                "            },\n" +
                "            {\n" +
                "               \"day\":{\n" +
                "                  \"watering\":29,\n" +
                "                  \"fan\":4,\n" +
                "                  \"element\":2,\n" +
                "                  \"tlight\":45,\n" +
                "                  \"sfogger\":45\n" +
                "               }\n" +
                "            },\n" +
                "            {\n" +
                "               \"day\":{\n" +
                "                  \"watering\":20,\n" +
                "                  \"fan\":65,\n" +
                "                  \"element\":230,\n" +
                "                  \"wlight\":45,\n" +
                "                  \"sfogger\":45\n" +
                "               }\n" +
                "            },\n" +
                "            {\n" +
                "               \"day\":{\n" +
                "                  \"watering\":10,\n" +
                "                  \"fan\":75,\n" +
                "                  \"element\":206,\n" +
                "                  \"thlight\":15,\n" +
                "                  \"sfogger\":45\n" +
                "               }\n" +
                "            },\n" +
                "            {\n" +
                "               \"day\":{\n" +
                "                  \"watering\":3,\n" +
                "                  \"fan\":49,\n" +
                "                  \"element\":220,\n" +
                "                  \"flight\":95,\n" +
                "                  \"sfogger\":45\n" +
                "               }\n" +
                "            }\n" +
                "         ]\n" +
                "      }\n" +
                "   }\n" +
                "";

        try {
            String in = "[]";
            JSONObject reader = new JSONObject(temp);
            JSONObject sys = reader.getJSONObject("res");
            if (sys.getInt("status") == 200) {
                JSONArray days = sys.getJSONArray("info");
                for (int i = 0; i <= days.length(); i++) {

                    JSONObject day = days.getJSONObject(i);
                    TableLayout table = view.findViewById(R.id.tableReport);

//            Object val=day.get("saturday");
                    setRowTable("day",day,table );


                }
                System.out.println("");
            }
        } catch (Exception e) {
            System.out.println(e);
            Log.d(TAG, "onViewCreated: " + e.getMessage());
        }

    }

    public void setRowTable(String Dayn, JSONObject day, TableLayout tableLayout) throws JSONException {
        JSONObject row = day.getJSONObject(Dayn);
        Object water = row.get("watering");
        Object fan=row.get("fan");
        Object element=row.get("element");
//        Object water=row.get("watering");
//        Object water=row.get("watering");
//        Object water=row.get("watering");

        for (int j = 0; j < 5; j++) {

            TableRow rowTable = new TableRow(getContext());
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            rowTable.setLayoutParams(lp);
            TextView textView = new TextView(getContext());
            textView.setText("watering" + " " + j);
            EditText editText = new EditText(getContext());
            rowTable.addView(textView);
            tableLayout.addView(rowTable);
        }
        txtRow.setText(water.toString());
    }


}
