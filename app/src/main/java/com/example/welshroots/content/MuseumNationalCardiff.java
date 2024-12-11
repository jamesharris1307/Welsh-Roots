package com.example.welshroots.content;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.annotation.SuppressLint;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.welshroots.R;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.SupportStreetViewPanoramaFragment;

public class MuseumNationalCardiff extends Fragment {

    private static final String NationalMuseumCardiffVideoID = "XQw2r6jJ6sE";
    private static final String ExhibitOneVideoID = "7NqxprOsWcc";
    private static final LatLng NationalMuseumCardiffLocation = new LatLng(51.485759959665586, -3.17685395480321);

    @SuppressLint("SetJavaScriptEnabled")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_fragment_museum_national_cardiff, container, false);

        // National Museum Cardiff Youtube Video
        WebView nationalCardiffYoutube = view.findViewById(R.id.NationalMuseumCardiffYoutube);
        WebSettings webSettingsNationalCardiffVideo = nationalCardiffYoutube.getSettings();
        webSettingsNationalCardiffVideo.setJavaScriptEnabled(true);
        nationalCardiffYoutube.loadUrl("https://www.youtube-nocookie.com/embed/" + NationalMuseumCardiffVideoID);
        nationalCardiffYoutube.setWebViewClient(new WebViewClient());

        // National Museum Cardiff Exhibit One Youtube Video
        WebView exhibitOneYoutube = view.findViewById(R.id.exhibitOneYoutube);
        WebSettings webSettingsExhibitOneVideo = exhibitOneYoutube.getSettings();
        webSettingsExhibitOneVideo.setJavaScriptEnabled(true);
        exhibitOneYoutube.setWebViewClient(new WebViewClient());
        exhibitOneYoutube.loadUrl("https://www.youtube-nocookie.com/embed/" + ExhibitOneVideoID);

        // National Museum Cardiff Street View
        SupportStreetViewPanoramaFragment streetViewFragment = new SupportStreetViewPanoramaFragment();
        FragmentTransaction streetViewTransaction = getChildFragmentManager().beginTransaction();
        streetViewTransaction.replace(R.id.streetViewContainer, streetViewFragment);
        streetViewTransaction.commit();

        streetViewFragment.getStreetViewPanoramaAsync(panorama ->
                panorama.setPosition(NationalMuseumCardiffLocation)
        );

        // National Museum Cardiff Map Location
        SupportMapFragment mapFragment = new SupportMapFragment();
        FragmentTransaction mapTransaction = getChildFragmentManager().beginTransaction();
        mapTransaction.replace(R.id.mapContainer, mapFragment);
        mapTransaction.commit();

        mapFragment.getMapAsync(googleMap -> {
            LatLng NationalCardiffLocation = new LatLng(51.48576664060906, -3.1768754124607455);
            googleMap.addMarker(new MarkerOptions().position(NationalCardiffLocation).title("National Museum Cardiff"));
            googleMap.moveCamera(com.google.android.gms.maps.CameraUpdateFactory.newLatLngZoom(NationalCardiffLocation, 15));
        });

        return view;
    }
}
