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

public class MuseumStFagans extends Fragment {

    private static final String StFagansVideoID = "621oB889Tns";
    private static final String ExhibitOneVideoID = "8h1Hm-werRs";
    private static final String ExhibitTwoVideoID = "vwIEHin9KSE";
    private static final LatLng StFagansLocation = new LatLng(51.4871873597198, -3.272341703519731);

    @SuppressLint("SetJavaScriptEnabled")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_fragment_museum_st_fagans, container, false);

        // Configure WebView for YouTube
        WebView stFagansYoutube = view.findViewById(R.id.stFagansYoutube);
        WebSettings webSettingsStFagansVideo = stFagansYoutube.getSettings();
        webSettingsStFagansVideo.setJavaScriptEnabled(true);
        stFagansYoutube.loadUrl("https://www.youtube-nocookie.com/embed/" + StFagansVideoID);
        stFagansYoutube.setWebViewClient(new WebViewClient());

        // Configure WebView for YouTube
        WebView exhibitOneYoutube = view.findViewById(R.id.exhibitOneYoutube);
        WebSettings webSettingsExhibitOneVideo = exhibitOneYoutube.getSettings();
        webSettingsExhibitOneVideo.setJavaScriptEnabled(true);
        exhibitOneYoutube.setWebViewClient(new WebViewClient());
        exhibitOneYoutube.loadUrl("https://www.youtube-nocookie.com/embed/" + ExhibitOneVideoID);

        // Configure WebView for YouTube
        WebView exhibitTwoYoutube = view.findViewById(R.id.exhibitTwoYoutube);
        WebSettings webSettingsExhibitTwoVideo = exhibitTwoYoutube.getSettings();
        webSettingsExhibitTwoVideo.setJavaScriptEnabled(true);
        exhibitTwoYoutube.setWebViewClient(new WebViewClient());
        exhibitTwoYoutube.loadUrl("https://www.youtube-nocookie.com/embed/" + ExhibitTwoVideoID);

        // Add Street View Fragment
        SupportStreetViewPanoramaFragment streetViewFragment = new SupportStreetViewPanoramaFragment();
        FragmentTransaction streetViewTransaction = getChildFragmentManager().beginTransaction();
        streetViewTransaction.replace(R.id.streetViewContainer, streetViewFragment);
        streetViewTransaction.commit();

        streetViewFragment.getStreetViewPanoramaAsync(panorama ->
                panorama.setPosition(StFagansLocation)
        );

        // Add Map Fragment
        SupportMapFragment mapFragment = new SupportMapFragment();
        FragmentTransaction mapTransaction = getChildFragmentManager().beginTransaction();
        mapTransaction.replace(R.id.mapContainer, mapFragment);
        mapTransaction.commit();

        mapFragment.getMapAsync(googleMap -> {
            // Add Marker
            LatLng StFagansLocation = new LatLng(51.4871873597198, -3.272341703519731);
            googleMap.addMarker(new MarkerOptions().position(StFagansLocation).title("St.Fagans National Museum of History"));

            googleMap.moveCamera(com.google.android.gms.maps.CameraUpdateFactory.newLatLngZoom(StFagansLocation, 15));
        });

        return view;
    }
}
