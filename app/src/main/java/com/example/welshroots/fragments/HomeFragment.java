package com.example.welshroots.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.example.welshroots.R;
import com.example.welshroots.content.MuseumVirtualTour1;
import com.example.welshroots.content.MuseumVirtualTour2;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        // ImageButton to replace the entire parent fragment with WelshHistoryFragment
        ImageButton imageButtonMuseumVirtualTour1 = rootView.findViewById(R.id.imageButtonMuseumVirtualTour1);
        imageButtonMuseumVirtualTour1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace ExploreFragment with WelshHistoryFragment
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, new MuseumVirtualTour1()) // Replace parent fragment
                        .addToBackStack(null)  // Add to back stack to enable back navigation
                        .commit();
            }
        });
        // Button to replace with MuseumExhibit1Fragment
        ImageButton imageButtonMuseumVirtualTour2 = rootView.findViewById(R.id.imageButtonMuseumVirtualTour2);
        imageButtonMuseumVirtualTour2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace ExploreFragment with MuseumExhibit1Fragment
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, new MuseumVirtualTour2()) // Replace with MuseumExhibit1Fragment
                        .addToBackStack(null)  // Add to back stack
                        .commit();
            }
        });
        return rootView;
    }
}

