package com.example.rostmanafinal.Fragments;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NavigationRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.rostmanafinal.R;

public class FragmentAboutUs extends Fragment {

    ImageView imageViewReturn, imageLinkedIn, instagramCircularImageView, imageTwitter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewAbout = inflater.inflate(R.layout.fragment_about_us, container, false);


        return viewAbout;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageTwitter = view.findViewById(R.id.imageTwitter);
        imageTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
String url = "https://twitter.com/rostmana/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        imageViewReturn = view.findViewById(R.id.imageViewReturn);
        imageLinkedIn = view.findViewById(R.id.imageLinkedIn);
        imageLinkedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.linkedin.com/authwall?trk=ripf&trkInfo=AQG7Z14SGnQJAAAAAXaPh6RAUJguXSRqtXiIJfnfRakZekMPA7ry-gdV4hJVWDH0_j1GEwPvMiHLVr80zcXAa09HmK13aLhcsnNU_k6h-GuSHf0bdCK0UESKEBDPs590GUN7nX8=&originalReferer=http://rostmana.com/&sessionRedirect=https%3A%2F%2Fwww.linkedin.com%2Fin%2Frostmana-green-house-7782611a1\n";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });


        instagramCircularImageView = view.findViewById(R.id.circularImageView);
        imageViewReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_fragmentAboutUs_to_fragmentHome);
            }
        });

        instagramCircularImageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                https://twitter.com/rostmana/
//                https://instagram.com/rost.mana?igshid=1tgzplmike1rg
//                https://www.linkedin.com/authwall?trk=ripf&trkInfo=AQG7Z14SGnQJAAAAAXaPh6RAUJguXSRqtXiIJfnfRakZekMPA7ry-gdV4hJVWDH0_j1GEwPvMiHLVr80zcXAa09HmK13aLhcsnNU_k6h-GuSHf0bdCK0UESKEBDPs590GUN7nX8=&originalReferer=http://rostmana.com/&sessionRedirect=https%3A%2F%2Fwww.linkedin.com%2Fin%2Frostmana-green-house-7782611a1

                Uri uri = Uri.parse("http://instagram.com/rost.mana?igshid=1tgzplmike1rg");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/xxx")));
                }
            }
        });


    }
}
