package com.example.rostmanafinal.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Trace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.rostmanafinal.R;
import com.example.rostmanafinal.TestActivity;

public class FragmentEnterSerialNumber extends Fragment {

//    final FragmentManager fm = getActivity().getSupportFragmentManager();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewEnterSerial = inflater.inflate(R.layout.fragment_enter_serialnumber, container, false);


        return viewEnterSerial;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText serialEntered = view.findViewById(R.id.serialEntered);
        serialEntered.setImeOptions(EditorInfo.IME_ACTION_DONE);
        serialEntered.isSingleLine();

        Button btnConfirm = view.findViewById(R.id.btnConfirm);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "ccccc", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent();
//                getActivity().startActivity(TestActivity.class);
//                getActivity().startActivity(new Intent(TestActivity.class, getActivity());
//                Intent intent = new Intent(getActivity(), TestActivity.class);
//                startActivity(intent);
//                Navigation.findNavController(view).navigate(R.id.action_fragmentEnterSerialNumber_to_firstFragment2);
//                requireActivity().getSupportFragmentManager();
//                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                FirstFragment fn = new FirstFragment();
//                fragmentTransaction.replace(R.id.nav_host_fragment, fn);
//                fragmentTransaction.commit();
//                Toast.makeText(getContext(), "until", Toast.LENGTH_SHORT).show();

//                Toast.makeText(getContext(), "clicked", Toast.LENGTH_SHORT).show();
                Navigation.findNavController(view).navigate(R.id.action_fragmentViewPagerTabbed23_to_fragmentEnterSerialNumber);
//                Navigation.findNavController(view).navigate(R.id.action_fragmentEnterSerialNumber_to_firstFragment22);
//                Navigation.findNavController(view).navigate(R.id.action_fragmentEnterSerialNumber_to_firstFragment22);
//                Navigation.findNavController(view).navigate(R.id.action_fragmentEnterSerialNumber_to_firstFragment2);
//                Navigation.findNavController(view).navigate(R.id.action_fragmentViewPagerTabbed23_to_fragmentEnterSerialNumber);
//                Navigation.findNavController(view).navigate(R.id.action_fragmentEnterSerialNumber_to_firstFragment22);

//                NavController navController;

//                if (navController.currentDestination?.id == R.id.fragmentA) {
//                    navController.navigate(R.id.action_fragmentA_to_fragmentB)

//                 Navigation.findNavController(view).navigate(R.id.action_fragmentEnterSerialNumber_to_firstFragment2);
//                if (navController.currentDestination?.id == R.id.fragmentA) {
//                    navController.navigate(R.id.action_fragmentA_to_fragmentB)
//                }

//                }
//                fm.beginTransaction().add(R.id.nav_host_fragment, fragment1, "1").commit();
//                fm.beginTransaction().hide(active).show(fragment2).commit();
//                active = fragment2;
                /**
                 FirstFragment fragment = new FirstFragment();
                 FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                 FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                 fragmentTransaction.replace(R.id.fragmentEnterSerialNumber, fragment);
                 fragmentTransaction.addToBackStack(null);
                 fragmentTransaction.commit(); */


//                FirstFragment nextFrag= new FirstFragment();
//                getActivity().getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.nav_host_fragment, nextFrag, "findThisFragment")
//                        .addToBackStack(null)
//                        .commit();
                Navigation.findNavController(view).navigate(R.id.action_fragmentEnterSerialNumber_to_firstFragment2);
            }
        });

    }
}
