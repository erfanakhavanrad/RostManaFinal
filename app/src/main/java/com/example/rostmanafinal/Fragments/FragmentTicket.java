package com.example.rostmanafinal.Fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.rostmanafinal.Interfaces.RetrofitApiService;
import com.example.rostmanafinal.Pojo.TicketModel;
import com.example.rostmanafinal.R;
import com.example.rostmanafinal.Retrofit.TokenInterceptor;
import com.example.rostmanafinal.UserManagerSharedPrefs;
import com.google.gson.JsonArray;

import java.security.PublicKey;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentTicket extends Fragment {
    Spinner staticSpinner;
    TextView txtMessage;
    Button btn_send;
    String spinnerValue, description, token, type_tiket = "1", url = "http://192.168.88.134:8000/api/";
    //    Integer type_tiket = 1;
    UserManagerSharedPrefs userManagerSharedPrefs;
    RetrofitApiService request;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewTicket = inflater.inflate(R.layout.fragment_ticket, container, false);
        return viewTicket;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        staticSpinner = view.findViewById(R.id.static_spinner);
        btn_send = view.findViewById(R.id.btn_send);
        txtMessage = view.findViewById(R.id.txtMessage);
        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(getContext(), R.array.subjectArray,
                        android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        staticAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        staticSpinner.setAdapter(staticAdapter);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item,list);
        staticSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerValue = staticSpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getContext(), spinnerValue, Toast.LENGTH_SHORT).show();
//                description = null;
//                description = txtMessage.getText().toString();
//                txtMessage = null;
//                String pass = edtPassword.getText().toString();
//                if (TextUtils.isEmpty(pass) || TextUtils.isEmpty(user)
                description = txtMessage.getText().toString();
                if (TextUtils.isEmpty(description)) {
                    Toast.makeText(getContext(), "fill eveything", Toast.LENGTH_SHORT).show();
                } else {

                    sendRequest();
                }
                //                if (description.matches("")) sendRequest();
//                else Toast.makeText(getContext(), "fill everything", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void sendRequest() {
        userManagerSharedPrefs = new UserManagerSharedPrefs(getContext());
//        token = userManagerSharedPrefs.getToken();
        token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiNDJiMjJiM2NlYzRhOWE5ODM4MmNjMmJlOTMxNmFkMTk1YWE3NTBmNjQxYjllYzliNjZlOGE5MWVjZDQ2M2VkNjJlMTYxODM2MjE1Y2E0MTAiLCJpYXQiOiIxNjE0NzU5NzgxLjk5OTQ2OCIsIm5iZiI6IjE2MTQ3NTk3ODEuOTk5NDczIiwiZXhwIjoiMTY0NjI5NTc4MS45OTIwNjUiLCJzdWIiOiI1NSIsInNjb3BlcyI6W119.HrwNMsO993TDIKW7G1ZLKct5B7PDqmwciVU3AMRG59zg6gt36QiLVqKGIF2oPZmnv_quFU3TrMqMDdXeWXPWv5MhIXaM3TAyGzPluYCh_ebYYBZDP1xExrjVL4gbLS9NQ6otaPhcKlRx8iIuSQej6NBjCXrvr04rJnVVCv2m4cYgLcfduVqyyVaCIB7UuWUideFm54AB7rbHTa80CVZseg2JIRkkCH6yiajn_octUi9ADIkyiVbI7InDvhyZyMkwY76sT67CiL7atSEwgGwGBYPaokuUllX3zAmd1hFzxf7de3acgjIB-w1kiUg912GstOzxEFFFDtbS6n6Zg8JRs1NFRs81IJidOMnCqEabuUAEW4FC_UoFHm94bd-_rFRx4soAZBeNOp2RbBDrVVBe9B3Pl8qF_TSQcG_nnP7Ozy8H_Jw_OLRn6c-9lMH5kCkr1dleLGCQA3haUj5nk85RtsjHtopN0KeJb8GCIzLRQkXRg3E9DAnLcKRigclpqdwrrQPwgUCuvnn1h9WMT4_K3Pi_F3GCVXzZpp2i76NqDBqB9NDnaY5-F8V_cdIi-2IW3pNtSAh5mkSYL6o--uHm9xw_sG1tB8M4QpI7" +
                "2zBGLAd9PYSJt_KkFdleCCHCPidlhunhgpCRg6OV0RkzMonResWWNryz9pq5tg-0BE2H8Vo";
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
        Call<TicketModel> call = request.postTicket(type_tiket, spinnerValue, description);
        call.enqueue(new Callback<TicketModel>() {
            @Override
            public void onResponse(Call<TicketModel> call, Response<TicketModel> response) {
                if (response.isSuccessful())
                    Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getContext(), "on respnse " + response.message(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<TicketModel> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
