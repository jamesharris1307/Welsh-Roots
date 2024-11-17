package com.example.welshroots;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Handle button click (if needed for navigation)
        view.findViewById(R.id.goToExploreButton).setOnClickListener(v -> {
            // Handle navigation to the Explore fragment
            ((HomeActivity) getActivity()).loadFragment(new ExploreFragment());
        });

        return view;
    }
}

