package com.example.welshroots.maps;

import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.SupportStreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.welshroots.R;

public class StreetView extends Fragment {


    private static final LatLng CARDIFF = new LatLng(51.4816, -3.1791);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_maps_street_view, container, false);

        // Get the Street View Fragment from the layout
        SupportStreetViewPanoramaFragment streetViewPanoramaFragment =
                (SupportStreetViewPanoramaFragment) getChildFragmentManager().findFragmentById(R.id.streetViewPanorama);

        if (streetViewPanoramaFragment != null) {
            streetViewPanoramaFragment.getStreetViewPanoramaAsync(new OnStreetViewPanoramaReadyCallback() {
                @Override
                public void onStreetViewPanoramaReady(StreetViewPanorama panorama) {
                    // Set the initial position when the panorama is ready
                    panorama.setPosition(CARDIFF);
                }
            });
        }

        return view;
    }
}
