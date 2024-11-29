package com.example.welshroots.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.example.welshroots.R;
import com.example.welshroots.maps.MapsView;
import com.example.welshroots.maps.StreetView;

public class MapsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_maps, container, false);


        ImageButton imageButtonGoogleStreetView = rootView.findViewById(R.id.googleStreetView);
        imageButtonGoogleStreetView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace ExploreFragment with WelshHistoryFragment
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, new StreetView())
                        .addToBackStack(null)
                        .commit();
            }
        });

        ImageButton imageButtonGoogleMapsView = rootView.findViewById(R.id.googleMapsButton);
        imageButtonGoogleMapsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace ExploreFragment with MuseumExhibit1Fragment
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, new MapsView())
                        .addToBackStack(null)
                        .commit();
            }
        });
        return rootView;
    }
}

