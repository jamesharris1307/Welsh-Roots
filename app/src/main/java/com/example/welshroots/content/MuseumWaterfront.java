package com.example.welshroots.content;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.welshroots.R;
import com.google.android.gms.maps.SupportStreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.MarkerOptions;

public class MuseumWaterfront extends Fragment {

    private static final String MuseumWaterfrontVideoID = "pJ6JyO01pRg";
    private static final LatLng MuseumWaterfrontLocation = new LatLng(51.61673750255924, -3.9392431852011995);

    @SuppressLint("SetJavaScriptEnabled")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_fragment_museum_waterfront, container, false);

        // Configure WebView for YouTube
        WebView stFagansYoutube = view.findViewById(R.id.waterfrontMuseumYoutube);
        WebSettings webSettingsStFagansVideo = stFagansYoutube.getSettings();
        webSettingsStFagansVideo.setJavaScriptEnabled(true);
        stFagansYoutube.loadUrl("https://www.youtube-nocookie.com/embed/" + MuseumWaterfrontVideoID);
        stFagansYoutube.setWebViewClient(new WebViewClient());

        // Add Street View Fragment
        SupportStreetViewPanoramaFragment streetViewFragment = new SupportStreetViewPanoramaFragment();
        FragmentTransaction streetViewTransaction = getChildFragmentManager().beginTransaction();
        streetViewTransaction.replace(R.id.streetViewContainer, streetViewFragment);
        streetViewTransaction.commit();

        streetViewFragment.getStreetViewPanoramaAsync(panorama ->
                panorama.setPosition(MuseumWaterfrontLocation)
        );

        // Add Map Fragment
        SupportMapFragment mapFragment = new SupportMapFragment();
        FragmentTransaction mapTransaction = getChildFragmentManager().beginTransaction();
        mapTransaction.replace(R.id.mapContainer, mapFragment);
        mapTransaction.commit();

        mapFragment.getMapAsync(googleMap -> {

            // Add Marker
            LatLng StFagansLocation = new LatLng(51.61690800009929, -3.939158499999999);
            googleMap.addMarker(new MarkerOptions().position(StFagansLocation).title("National Waterfront Museum"));

            googleMap.moveCamera(com.google.android.gms.maps.CameraUpdateFactory.newLatLngZoom(StFagansLocation, 15));
        });

        return view;
    }
}
