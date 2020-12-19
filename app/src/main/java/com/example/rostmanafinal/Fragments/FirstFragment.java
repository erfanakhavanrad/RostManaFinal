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
        image_cactus= view.findViewById(R.id.image_cactus);
        image_greenLeaf= view.findViewById(R.id.image_greenLeaf);
        image_organic= view.findViewById(R.id.image_organic);
        image_shrub= view.findViewById(R.id.image_shrub);
        image_seasonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "clicked", Toast.LENGTH_SHORT).show();

                requireActivity().getSupportFragmentManager();
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FragmentSeasonalFlowers fn = new FragmentSeasonalFlowers();
                fragmentTransaction.replace(R.id.nav_host_fragment, fn);
                fragmentTransaction.commit();

            }
        });



    }
}
