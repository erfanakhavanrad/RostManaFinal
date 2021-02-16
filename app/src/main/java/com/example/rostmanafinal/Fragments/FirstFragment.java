package com.example.rostmanafinal.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import com.example.rostmanafinal.R;


public class FirstFragment extends Fragment {

    TextView firstText;
    ImageView image_seasonal, image_cactus, image_greenLeaf, image_organic, image_shrub;
    static String SEASONAL_URL = "192.168.88.134:8000/api/Category/1";
    static String CACTUS_URL = "192.168.88.134:8000/api/Category/2";
    static String GREENLEAF_URL = "192.168.88.134:8000/api/Category/3";
    static String SHRUB_URL = "192.168.88.134:8000/api/Category/4";
    static String ORGANIC_URL = "192.168.88.134:8000/api/Category/5";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewFirst = inflater.inflate(R.layout.fragment_first, container, false);

        return viewFirst;
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//
//       image_seasonal.findViewById(R.id.image_seasonal);
//        image_cactus.findViewById(R.id.image_cactus);
//        image_greenLeaf.findViewById(R.id.image_greenLeaf);
//        image_organic.findViewById(R.id.image_organic);
//        image_shrub.findViewById(R.id.image_shrub);
//
//        firstText = getView().findViewById(R.id.firstText);
//        firstText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {

//                Navigation.findNavController(view).navigate(R.id.action_firstFragment2_to_secondFragment2);

    //NavHostFragment.findNavController(SecondFragment);
//                Navigation.findNavController(Activity, @IdRes int viewId)
//                Navigation.findNavController(View)
//            }
//        });
//    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        image_seasonal = view.findViewById(R.id.image_seasonal);
        image_cactus = view.findViewById(R.id.image_cactus);
        image_greenLeaf = view.findViewById(R.id.image_greenLeaf);
        image_organic = view.findViewById(R.id.image_organic);
        image_shrub = view.findViewById(R.id.image_shrub);

        image_seasonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "clicked", Toast.LENGTH_SHORT).show();

//                requireActivity().getSupportFragmentManager();
//                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                FragmentSeasonalFlowers fn = new FragmentSeasonalFlowers();
//                fragmentTransaction.replace(R.id.nav_host_fragment, fn);
//                fragmentTransaction.commit();
//                Navigation.findNavController(view).navigate(R.id.action_firstFragment2_to_fragmentSeasonalFlowers);
            }
        });
        image_cactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                requireActivity().getSupportFragmentManager();
//                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                FragmentCactus fn = new FragmentCactus();
//                fragmentTransaction.replace(R.id.nav_host_fragment, fn);
//                fragmentTransaction.commit();
//     Navigation.findNavController(view).navigate(R.id.action_firstFragment2_to_fragmentCactus);

            }
        });
        image_greenLeaf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                requireActivity().getSupportFragmentManager();
//                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                FragmentGreenLeaf fn = new FragmentGreenLeaf();
//                fragmentTransaction.replace(R.id.nav_host_fragment, fn);
//                fragmentTransaction.commit();
//                Navigation.findNavController(view).navigate(R.id.action_firstFragment2_to_fragmentGreenLeaf);
            }
        });
        image_organic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                requireActivity().getSupportFragmentManager();
//                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                FragmentOrganic fn = new FragmentOrganic();
//                fragmentTransaction.replace(R.id.nav_host_fragment, fn);
//                fragmentTransaction.commit();
//                Navigation.findNavController(view).navigate(R.id.action_firstFragment2_to_fragmentOrganic2);
            }
        });
        image_shrub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                requireActivity().getSupportFragmentManager();
//                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                FragmentGreenHouse fn = new FragmentGreenHouse();
//                fragmentTransaction.replace(R.id.nav_host_fragment, fn);
//                fragmentTransaction.commit();
//                Navigation.findNavController(view).navigate(R.id.action_firstFragment2_to_fragmentShrub);
            }
        });
    }
}
