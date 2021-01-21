package com.example.rostmanafinal.Fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.sax.EndElementListener;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.Navigation;

import com.example.rostmanafinal.MainActivity;
import com.example.rostmanafinal.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

import ir.hamsaa.persiandatepicker.Listener;
import ir.hamsaa.persiandatepicker.PersianDatePickerDialog;
import ir.hamsaa.persiandatepicker.util.PersianCalendar;

import static android.app.Activity.RESULT_OK;
import static android.content.ContentValues.TAG;

public class FragmentProfile extends Fragment {
    ImageView imageViewReturn, circularImageView2, avatar;
    Button btn_male, btn_female, btnAmir;
    MaterialButtonToggleGroup materialButtonToggleGroup;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;
    private PersianDatePickerDialog picker;
    TextView mStart, txttext;
String fuck;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewProfile = inflater.inflate(R.layout.fragment_profile, container, false);
        return viewProfile;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageViewReturn = view.findViewById(R.id.imageViewReturn);
        circularImageView2 = view.findViewById(R.id.circularImageView2);
        mStart = view.findViewById(R.id.txtBirthday);
        btnAmir = view.findViewById(R.id.btnAmir);
        avatar = view.findViewById(R.id.circularImageView2);
        txttext = view.findViewById(R.id.txttext);
        btnAmir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                txttext.setText(encoder);
            }
        });



        mStart.setOnClickListener(new View.OnClickListener() {
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
                                Toast.makeText(getContext(), persianCalendar.getPersianYear() + "/" + persianCalendar.getPersianMonth() + "/" + persianCalendar.getPersianDay(), Toast.LENGTH_SHORT).show();
                                mStart.setText(persianCalendar.getPersianYear() + "/" + persianCalendar.getPersianMonth() + "/" + persianCalendar.getPersianDay());
                            }

                            @Override
                            public void onDismissed() {

                            }
                        });

                picker.show();
            }
        });


//        public void showCalendar(View v) {
//            Typeface typeface = Typeface.createFromAsset(assetManager, "Shabnam-Light-FD.ttf");
//
//
//        }


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
//circularImageView2.setImageResource();
                        } else if (options[item].equals("انتخاب از گالری")) {
//                    Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                    startActivityForResult(pickPhoto , 1);
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
            String image = ConvertBitmapToString(resizedBitmap);

            //decode base64 string to image
//            Log.d(TAG, "onActivityResult: "+ imageUri.toString());
            Log.i(TAG, "onActivityResult: " + imageUri.toString());
            Log.i(TAG, "onActivityResult: " + circularImageView2.toString());

        }
    }
    public static String ConvertBitmapToString(Bitmap bitmap){
        String encodedImage = "";

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        try {
            encodedImage= URLEncoder.encode(Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT), "UTF-8");
//            Toast.makeText(FragmentProfile.clas
//            s, "", Toast.LENGTH_SHORT).show();
            Log.i(TAG, "ConvertBitmapToString: " + encodedImage);
//          String encodedImage2 = encodedImage;

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return encodedImage;
    }

}
