package com.example.rostmanafinal.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.rostmanafinal.R;

public class FragmentLoginRegister extends Fragment {
    Button btn_register, btn_login, btn_forgetPassword_label;
    EditText etxt_fname, etxt_lname, etxt_username_login, etxt_password_login, etxt_username_register, etxt_password_register,
            etxt_forgetPassword_label, etxt_phonenumber_register;
    TextView txt_lname, txt_fname, txt_username_login, txt_password_login, txt_username_register, txt_password_register, txt_forgetPassword,
            txt_forgetPassword_label, txt_phonenumber_register;
    ImageView image_check, image_cancel;
    Integer statement = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewLoginRegister = inflater.inflate(R.layout.fragment_login_register, container, false);


        return viewLoginRegister;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


//Button on top of screen
        image_check = view.findViewById(R.id.image_check);
        btn_login = view.findViewById(R.id.btn_login);
        btn_register = view.findViewById(R.id.btn_register);
        image_cancel = view.findViewById(R.id.image_cancel);

        //      Login Views
        etxt_username_login = view.findViewById(R.id.etxt_username_login);
        txt_username_login = view.findViewById(R.id.txt_username_login);
        txt_password_login = view.findViewById(R.id.txt_password_login);
        etxt_password_login = view.findViewById(R.id.etxt_password_login);
        txt_forgetPassword = view.findViewById(R.id.txt_forgetPassword);

//        Register Views
        txt_username_register = view.findViewById(R.id.txt_username_register);
        etxt_username_register = view.findViewById(R.id.etxt_username_register);
        txt_password_register = view.findViewById(R.id.txt_password_register);
        etxt_password_register = view.findViewById(R.id.etxt_password_register);
        etxt_fname = view.findViewById(R.id.etxt_fname);
        etxt_lname = view.findViewById(R.id.etxt_lname);
        txt_fname = view.findViewById(R.id.txt_fname);
        txt_lname = view.findViewById(R.id.txt_lname);
        etxt_phonenumber_register = view.findViewById(R.id.etxt_phonenumber_register);
        txt_phonenumber_register = view.findViewById(R.id.txt_phonenumber_register);

//        forget password
        etxt_forgetPassword_label = view.findViewById(R.id.etxt_forgetPassword_label);
        txt_forgetPassword_label = view.findViewById(R.id.txt_forgetPassword_label);
        btn_forgetPassword_label = view.findViewById(R.id.btn_forgetPassword_label);
        statement = 1;

        image_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().onBackPressed();
//              app.set_fragment2(requireActivity(),new fr);
            }
        });

        btn_forgetPassword_label.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().onBackPressed();
            }
        });


        txt_forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Hide everything
                etxt_forgetPassword_label.setVisibility(View.VISIBLE);
                txt_forgetPassword_label.setVisibility(View.VISIBLE);
                btn_forgetPassword_label.setVisibility(View.VISIBLE);
                etxt_password_login.setVisibility(View.INVISIBLE);
                etxt_username_login.setVisibility(View.INVISIBLE);
                txt_username_login.setVisibility(View.INVISIBLE);
                txt_password_login.setVisibility(View.INVISIBLE);
                txt_forgetPassword.setVisibility(View.INVISIBLE);

            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                statement = 2;
//                btn_register.setBackground(Color.RGB());;

                btn_login.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.lGreen2OnSelected));
                btn_register.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.lGreen2));

                etxt_forgetPassword_label.setVisibility(View.GONE);
                txt_forgetPassword_label.setVisibility(View.GONE);
                btn_forgetPassword_label.setVisibility(View.GONE);
                etxt_fname.setVisibility(View.VISIBLE);
                txt_fname.setVisibility(View.VISIBLE);
                etxt_lname.setVisibility(View.VISIBLE);
                txt_lname.setVisibility(View.VISIBLE);
                etxt_phonenumber_register.setVisibility(View.VISIBLE);
                txt_phonenumber_register.setVisibility(View.VISIBLE);


                txt_password_register.setVisibility(View.VISIBLE);
                etxt_password_register.setVisibility(View.VISIBLE);
                txt_username_register.setVisibility(View.VISIBLE);
                etxt_username_register.setVisibility(View.VISIBLE);
                etxt_password_login.setVisibility(View.GONE);
                etxt_username_login.setVisibility(View.GONE);
                txt_username_login.setVisibility(View.GONE);
                txt_password_login.setVisibility(View.GONE);
                txt_forgetPassword.setVisibility(View.GONE);

                if (!etxt_fname.getText().toString().equals("") &&
                        !etxt_lname.getText().toString().equals("") &&
                        !etxt_password_register.getText().toString().equals("") &&
                        !etxt_username_register.getText().toString().equals("")
                ) {
                    String firstName = etxt_fname.getText().toString();
                    String lastName = etxt_lname.getText().toString();
                    String passwordRegister = etxt_password_register.getText().toString();
                    String userRegister = etxt_username_register.getText().toString();

                    Intent intentUser = new Intent(getContext(), FragmentHome.class);
                    intentUser.putExtra("firstName", firstName);
                    intentUser.putExtra("lastName", lastName);
                    intentUser.putExtra("passwordRegister", passwordRegister);
                    intentUser.putExtra("userRegister", userRegister);
                    startActivity(intentUser);
                }
//                else
//                    Toast.makeText(getContext(), "please fill all the fields!", Toast.LENGTH_SHORT).show();

            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                statement = 1;
                btn_register.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.lGreen2OnSelected));
                btn_login.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.lGreen2));
//                btn_register.setBackgroundColor(Color.lg);

                etxt_forgetPassword_label.setVisibility(View.GONE);
                txt_forgetPassword_label.setVisibility(View.GONE);
                btn_forgetPassword_label.setVisibility(View.GONE);
                etxt_fname.setVisibility(View.GONE);
                txt_fname.setVisibility(View.GONE);
                etxt_lname.setVisibility(View.GONE);
                txt_lname.setVisibility(View.GONE);
                txt_password_register.setVisibility(View.GONE);
                etxt_password_register.setVisibility(View.GONE);
                txt_username_register.setVisibility(View.GONE);
                etxt_username_register.setVisibility(View.GONE);
                txt_phonenumber_register.setVisibility(View.GONE);
                etxt_phonenumber_register.setVisibility(View.GONE);


                etxt_password_login.setVisibility(View.VISIBLE);
                etxt_username_login.setVisibility(View.VISIBLE);
                txt_username_login.setVisibility(View.VISIBLE);
                txt_password_login.setVisibility(View.VISIBLE);
                txt_forgetPassword.setVisibility(View.VISIBLE);


//                going to the Scan page
//                if (!etxt_password_login.getText().toString().equals("") && !etxt_username_login.getText().toString().equals("")) {
//                    String userName = etxt_username_login.getText().toString();
//                    Intent intentUser = new Intent(getContext(), Scan_Tabbed_Activity.class);
//                    intentUser.putExtra("title", userName);
//                    startActivity(intentUser);
//
//                    String passWord = etxt_password_login.getText().toString();
//                    Intent intentPass = new Intent(getContext(), Scan_Tabbed_Activity.class);
//                    intentPass.putExtra("title", passWord);
//                    startActivity(intentPass);
//                }


//                else {
//                    Toast.makeText(getContext(), "Fill al the fields!", Toast.LENGTH_SHORT).show();
//                }

            }
        });

        image_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (statement) {
                    case 1:
// it starts here
                        String data = etxt_password_login.getText().toString();
                        String data2 = etxt_username_login.getText().toString();
                        if (data.isEmpty() || data2.isEmpty()) {
                            Toast.makeText(getContext(), "لطفا تمام کادرها را پر کنید", Toast.LENGTH_SHORT).show();
                        } else {

                            if (statement == 1) {
                                Toast.makeText(getContext(), "Login page", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getContext(), "Register page", Toast.LENGTH_SHORT).show();
                            }
                        }
//                   write break after this
                        break;
                    case 2:
                        // it starts here

                        String data3 = etxt_username_register.getText().toString();
                        String data4 = etxt_password_register.getText().toString();
                        String data5 = etxt_fname.getText().toString();
                        String data7 = etxt_lname.getText().toString();
                        if (data3.isEmpty() || data4.isEmpty() | data5.isEmpty() || data7.isEmpty()) {
                            Toast.makeText(getContext(), "لطفا تمام کادرها را پر کنید", Toast.LENGTH_SHORT).show();
                        } else {

                            if (statement == 1) {
                                Toast.makeText(getContext(), "Login page", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getContext(), "Register page", Toast.LENGTH_SHORT).show();
                            }
                        }
//                   write break after this
                        break;

                }


//                if (statement == 1) {
//                    String data = etxt_password_login.getText().toString();
//                    String data2 = etxt_username_login.getText().toString();
//                    if (data.isEmpty() || data2.isEmpty()) {
//                        Toast.makeText(getContext(), "all fields must be filled", Toast.LENGTH_SHORT).show();
//                    } else {
//
//                        if (statement == 1) {
//                            Toast.makeText(getContext(), "Login page", Toast.LENGTH_SHORT).show();
//                        } else {
//                            Toast.makeText(getContext(), "Register page", Toast.LENGTH_SHORT).show();
//                        }
//
//                    }
//                }

            }
        });


    }
}
