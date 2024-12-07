package com.example.welshroots.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.example.welshroots.R;
import com.example.welshroots.content.MuseumNationalCardiff;
import com.example.welshroots.content.MuseumStFagans;
import com.example.welshroots.content.MuseumBigPit;
import com.example.welshroots.content.MuseumWaterfront;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        // Image Button to St Fagans
        ImageButton imageButtonMuseumVirtualTour1 = rootView.findViewById(R.id.imageButtonMuseumVirtualTour1);
        imageButtonMuseumVirtualTour1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace ExploreFragment with WelshHistoryFragment
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, new MuseumStFagans()) // Replace parent fragment
                        .addToBackStack(null)  // Add to back stack to enable back navigation
                        .commit();
            }
        });
        // Image Button to Big Pit
        ImageButton imageButtonMuseumVirtualTour2 = rootView.findViewById(R.id.imageButtonMuseumVirtualTour2);
        imageButtonMuseumVirtualTour2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace ExploreFragment with MuseumExhibit1Fragment
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, new MuseumBigPit()) // Replace with MuseumExhibit1Fragment
                        .addToBackStack(null)  // Add to back stack
                        .commit();
            }
        });
        // Image Button to National Museum Cardiff
        ImageButton imageButtonMuseumVirtualTour3 = rootView.findViewById(R.id.imageButtonMuseumVirtualTour3);
        imageButtonMuseumVirtualTour3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace ExploreFragment with MuseumExhibit1Fragment
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, new MuseumNationalCardiff()) // Replace with MuseumExhibit1Fragment
                        .addToBackStack(null)  // Add to back stack
                        .commit();
            }
        });
        // Image Button to Waterfront Museum
        ImageButton imageButtonMuseumVirtualTour4 = rootView.findViewById(R.id.imageButtonMuseumVirtualTour4);
        imageButtonMuseumVirtualTour4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace ExploreFragment with MuseumExhibit1Fragment
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, new MuseumWaterfront()) // Replace with MuseumExhibit1Fragment
                        .addToBackStack(null)  // Add to back stack
                        .commit();
            }
        });
        return rootView;
    }
}

