package com.example.rostmanafinal.Fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.rostmanafinal.MainActivity;
import com.example.rostmanafinal.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;

import static android.app.Activity.RESULT_OK;

public class FragmentProfile extends Fragment {
    ImageView imageViewReturn, circularImageView2;
    Button btn_male, btn_female;
    MaterialButtonToggleGroup materialButtonToggleGroup;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;


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


//        circularImageView2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
//                startActivityForResult(intent, 0);
//
//            }
//        });

        final CharSequence[] options = {"Take Photo", "Choose from Gallery", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Choose your profile picture");

        circularImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                builder.setItems(options, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int item) {

                        if (options[item].equals("Take Photo")) {
                            Intent takePicture = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(takePicture, 0);
//circularImageView2.setImageResource();
                        } else if (options[item].equals("Choose from Gallery")) {
//                    Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                    startActivityForResult(pickPhoto , 1);
                            openGallery();


                        } else if (options[item].equals("Cancel")) {
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
        }
    }
}
