package com.example.rostmanafinal.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FragmentTables extends Fragment {
    private static final String TAG = "FragmentTables";
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

        tableReport = view.findViewById(R.id.tableReport);

        String temp = "\n" +
                "   {\n" +
                "      \"res\":{\n" +
                "         \"status\":\"200\",\n" +
                "         \"info\":[\n" +
                "            {\n" +
                "               \"day\":{\n" +
                "                  \"watering\":5,\n" +
                "                  \"fan\":1,\n" +
                "                  \"element\":2,\n" +
                "                  \"slight\":85,\n" +
                "                  \"sfogger\":3\n" +
                "               }\n" +
                "            },\n" +
                "            {\n" +
                "               \"day\":{\n" +
                "                  \"watering\":3,\n" +
                "                  \"fan\":5,\n" +
                "                  \"element\":6,\n" +
                "                  \"slight\":55,\n" +
                "                  \"sfogger\":4\n" +
                "               }\n" +
                "            },\n" +
                "            {\n" +
                "               \"day\":{\n" +
                "                  \"watering\":1,\n" +
                "                  \"fan\":7,\n" +
                "                  \"element\":0,\n" +
                "                  \"slight\":44,\n" +
                "                  \"sfogger\":0\n" +
                "               }\n" +
                "            },\n" +
                "            {\n" +
                "               \"day\":{\n" +
                "                  \"watering\":9,\n" +
                "                  \"fan\":4,\n" +
                "                  \"element\":2,\n" +
                "                  \"slight\":45,\n" +
                "                  \"sfogger\":5\n" +
                "               }\n" +
                "            },\n" +
                "            {\n" +
                "               \"day\":{\n" +
                "                  \"watering\":1,\n" +
                "                  \"fan\":5,\n" +
                "                  \"element\":7,\n" +
                "                  \"slight\":45,\n" +
                "                  \"sfogger\":5\n" +
                "               }\n" +
                "            },\n" +
                "            {\n" +
                "               \"day\":{\n" +
                "                  \"watering\":0,\n" +
                "                  \"fan\":5,\n" +
                "                  \"element\":6,\n" +
                "                  \"slight\":15,\n" +
                "                  \"sfogger\":5\n" +
                "               }\n" +
                "            },\n" +
                "            {\n" +
                "               \"day\":{\n" +
                "                  \"watering\":3,\n" +
                "                  \"fan\":9,\n" +
                "                  \"element\":2,\n" +
                "                  \"slight\":95,\n" +
                "                  \"sfogger\":4\n" +
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
//                    TableLayout table = view.findViewById(R.id.tableReport);
//
                    setRowTable("day", day, tableReport);


                }
//                System.out.println("");
            }
        } catch (Exception e) {
            System.out.println(e);
            Log.d(TAG, "onViewCreated: " + e.getMessage());
        }

    }

    public void setRowTable(String Dayn, JSONObject day, TableLayout tableLayout) throws JSONException {
        JSONObject row = day.getJSONObject(Dayn);
        Object water = row.get("watering");
        Object fan = row.get("fan");
        Object element = row.get("element");
        Object light = row.get("slight");
        Object fogger = row.get("sfogger");
//        flight
//                sfogge
//        Object water=row.get("watering");
//        Object water=row.get("watering");
//        Object water=row.get("watering");


            TableRow rowTable = new TableRow(getContext());
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            rowTable.setLayoutParams(lp);
            TextView textView = new TextView(getContext());
            textView.setText("          " + water + "               " + fan + "                " + element + "                " + light + "               " + fogger + "\n");

//            watering
//            fan":75s
//            element\
//            thlight\
//            sfogger\
//            textView.setText("watering" + " " + j + "fan" + "   " + row.get("fan") + "   " + row.get("element") + "    "
//                    + row.get("thlight") + "   " + row.get("sfogger"));
//
            EditText editText = new EditText(getContext());
            rowTable.addView(textView);
            tableLayout.addView(rowTable);



    }

}
