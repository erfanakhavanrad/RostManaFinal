package com.example.rostmanafinal.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
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
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.rostmanafinal.Interfaces.RetrofitApiService;
import com.example.rostmanafinal.Pojo.GetHello;
import com.example.rostmanafinal.Pojo.ModelEditProfile;
import com.example.rostmanafinal.R;
import com.example.rostmanafinal.UserManagerSharedPrefs;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import ir.hamsaa.persiandatepicker.Listener;
import ir.hamsaa.persiandatepicker.PersianDatePickerDialog;
import ir.hamsaa.persiandatepicker.util.PersianCalendar;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.app.Activity.RESULT_OK;
import static android.content.ContentValues.TAG;

// TODO: 1/23/2021 makeImage global so it can pass the data and get gender boolean

public class FragmentProfile extends Fragment {
    ImageView imageViewReturn, circularImageView2, imgCheck;
    MaterialButtonToggleGroup materialButtonToggleGroup;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;
    private PersianDatePickerDialog picker;
    TextView txtBirthday;
    Button buttonMaleGender, buttonFemaleGender;
    EditText nameETxtUsername2, lastNameETxtUsername, eTxtPhoneNumber, eTxtAddress;
    String imageb64, lastName, token;
    boolean gender;
    //    RetrofitApiService request;
    private static final String BASE_URL = "http://rostmana.com/api/Mobile/";
    UserManagerSharedPrefs userManagerSharedPrefs;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewProfile = inflater.inflate(R.layout.fragment_profile, container, false);
        return viewProfile;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        userManagerSharedPrefs = new UserManagerSharedPrefs(getContext());
        super.onViewCreated(view, savedInstanceState);
        nameETxtUsername2 = view.findViewById(R.id.etxtUsername2); // First name
        lastNameETxtUsername = view.findViewById(R.id.etxtUsername); // Last name
        eTxtPhoneNumber = view.findViewById(R.id.etxtPhoneNumber); // PhoneNumber
        eTxtAddress = view.findViewById(R.id.etxtAddress);  // Address
        txtBirthday = view.findViewById(R.id.txtBirthday); // birth
        imgCheck = view.findViewById(R.id.imgCheck);

//       Gendre
//        image  profileimage

        imageViewReturn = view.findViewById(R.id.imageViewReturn);
        circularImageView2 = view.findViewById(R.id.circularImageView2);

//        buttonMaleGender = view.findViewById(R.id.buttonMaleGender);
//        buttonFemaleGender = view.findViewById(R.id.buttonFemaleGender);
//
//        buttonMaleGender.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        Toast.makeText(getContext(), "Male", Toast.LENGTH_SHORT).show();
//    }
//});
//        buttonFemaleGender.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        Toast.makeText(getContext(), "Female", Toast.LENGTH_SHORT).show();
//    }
//});


        txtBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PersianCalendar initDate = new PersianCalendar();
                initDate.setPersianDate(1370, 3, 13);

                picker = new PersianDatePickerDialog(getContext())
                        .setPositiveButtonString("تایید")
                        .setNegativeButton("لغو")
                        .setTodayButtonVisible(false)
                        .setMinYear(1300)
                        .setMaxYear(PersianDatePickerDialog.THIS_YEAR)
                        .setInitDate(initDate)
                        .setActionTextColor(Color.BLACK)
//                        .setTypeFace(typeface)
                        .setTitleType(PersianDatePickerDialog.WEEKDAY_DAY_MONTH_YEAR)
                        .setShowInBottomSheet(false)
                        .setListener(new Listener() {
                            @Override
                            public void onDateSelected(PersianCalendar persianCalendar) {
//                                Toast.makeText(getContext(), persianCalendar.getPersianYear() + "/" + persianCalendar.getPersianMonth() + "/" + persianCalendar.getPersianDay(), Toast.LENGTH_SHORT).show();
                                txtBirthday.setText(persianCalendar.getPersianYear() + "/" + persianCalendar.getPersianMonth() + "/" + persianCalendar.getPersianDay());
                            }

                            @Override
                            public void onDismissed() {

                            }
                        });

                picker.show();
            }
        });

        final CharSequence[] options = {"عکس با دوربین", "انتخاب از گالری", "لغو"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("انتخاب عکس پروفایل");

        circularImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                builder.setItems(options, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int item) {

                        if (options[item].equals("عکس با دوربین")) {
                            Intent takePicture = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(takePicture, 0);

                        } else if (options[item].equals("انتخاب از گالری")) {
                            openGallery();


                        } else if (options[item].equals("لغو")) {
                            dialog.dismiss();
                        }
                    }
                });
                builder.show();
            }
        });


        materialButtonToggleGroup = view.findViewById(R.id.toggleButton);
        int buttonId = materialButtonToggleGroup.getCheckedButtonId();
        MaterialButton button = materialButtonToggleGroup.findViewById(buttonId);

        imageViewReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentProfile_to_fragmentHome);
            }
        });


//        Toast.makeText(getContext(), "" + image, Toast.LENGTH_SHORT).show();

// TODO: 1/23/2021 remove these lines
//        imageViewReturn = view.findViewById(R.id.imageViewReturn);
//        circularImageView2 = view.findViewById(R.id.circularImageView2);


        imgCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                token = userManagerSharedPrefs.getToken();
                String firstName = nameETxtUsername2.getText().toString();
                lastName = lastNameETxtUsername.getText().toString();
                String phoneNumber = eTxtPhoneNumber.getText().toString();
                String address = eTxtAddress.getText().toString();
                String birth = txtBirthday.getText().toString();
                String avatar = imageb64;
                Toast.makeText(getContext(), "CLICKED", Toast.LENGTH_SHORT).show();
//                Toast.makeText(getContext(), firstName.toString() + lastName + phoneNumber + address, Toast.LENGTH_SHORT).show();
//                Toast.makeText(getContext(), "fuck" + lastName.toString(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(getContext(), ""  + txtBirthday.toString(), Toast.LENGTH_SHORT).show();
                Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                RetrofitApiService retrofitApiService = retrofit.create(RetrofitApiService.class);
                retrofitApiService.PostEditProfileAPIService(token, gender, imageb64, firstName, lastName,
                        phoneNumber, address, birth
                ).enqueue(new Callback<ModelEditProfile>() {
                    @Override
                    public void onResponse(Call<ModelEditProfile> call, Response<ModelEditProfile> response) {
                        ModelEditProfile modelEditProfile = response.body();
                        if (modelEditProfile != null) {
                            Toast.makeText(getContext(), "" + modelEditProfile.getBirth(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ModelEditProfile> call, Throwable t) {
                        Toast.makeText(getContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

//        Call<ModelEditProfile> call = request.PostEditProfileAPIService(gender, image,
//                firstName, lastName, phoneNumber, address, birth);
//        call.enqueue(new Callback<ModelEditProfile>() {
//            @Override
//            public void onResponse(Call<ModelEditProfile> call, Response<ModelEditProfile> response) {
//                ModelEditProfile modelEditProfile = response.body();
//                if (modelEditProfile != null) {
//                    Toast.makeText(getContext(), "" + modelEditProfile.getSex(), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ModelEditProfile> call, Throwable t) {
//                Toast.makeText(getContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });


    }


    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);

        startActivityForResult(gallery, PICK_IMAGE);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            circularImageView2.setImageURI(imageUri);
            Bitmap bitmap = null;
            try {
                bitmap = BitmapFactory.decodeStream(getActivity().getContentResolver().openInputStream(imageUri));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 500, 500, false);
            imageb64 = ConvertBitmapToString(resizedBitmap);
            //decode base64 string to image
//            Log.d(TAG, "onActivityResult: "+ imageUri.toString());
//            Base 64 is here
            Log.i(TAG, "onActivityResult: " + imageb64.toString());
//            Log.i(TAG, "onActivityResult: " + circularImageView2.toString());

        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        Toast.makeText(getContext(), "" + image, Toast.LENGTH_SHORT).show();
    }

    public static String ConvertBitmapToString(Bitmap bitmap) {
        String encodedImage = "";

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        try {
            encodedImage = URLEncoder.encode(Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT), "UTF-8");

            Log.i(TAG, "ConvertBitmapToString: " + encodedImage);

//            String encodedImage2 = encodedImage;

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return encodedImage;
    }

}