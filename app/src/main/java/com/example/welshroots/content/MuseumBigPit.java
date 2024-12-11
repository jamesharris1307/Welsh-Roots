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

public class MuseumBigPit extends Fragment {

    private static final String BigPitVideoID = "NgigITMSLIg";
    private static final String ExhibitOneVideoID = "Nt7sPVKs9co";
    private static final LatLng BigPitLocation = new LatLng(51.77259753456756, -3.1045423622336243);

    @SuppressLint("SetJavaScriptEnabled")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_fragment_museum_big_pit, container, false);

        // Big Pit Youtube Video
        WebView bigPitYoutube = view.findViewById(R.id.bigPitYoutube);
        WebSettings webSettingsBigPitVideo = bigPitYoutube.getSettings();
        webSettingsBigPitVideo.setJavaScriptEnabled(true);
        bigPitYoutube.loadUrl("https://www.youtube-nocookie.com/embed/" + BigPitVideoID);
        bigPitYoutube.setWebViewClient(new WebViewClient());

        // Big Pit Exhibit Youtube Video
        WebView exhibitOneYoutube = view.findViewById(R.id.exhibitOneYoutube);
        WebSettings webSettingsExhibitOneVideo = exhibitOneYoutube.getSettings();
        webSettingsExhibitOneVideo.setJavaScriptEnabled(true);
        exhibitOneYoutube.setWebViewClient(new WebViewClient());
        exhibitOneYoutube.loadUrl("https://www.youtube-nocookie.com/embed/" + ExhibitOneVideoID);


        // Big Pit Street View
        SupportStreetViewPanoramaFragment streetViewFragment = new SupportStreetViewPanoramaFragment();
        FragmentTransaction streetViewTransaction = getChildFragmentManager().beginTransaction();
        streetViewTransaction.replace(R.id.streetViewContainer, streetViewFragment);
        streetViewTransaction.commit();

        streetViewFragment.getStreetViewPanoramaAsync(panorama ->
                panorama.setPosition(BigPitLocation)
        );

        // Big Pit Map Location
        SupportMapFragment mapFragment = new SupportMapFragment();
        FragmentTransaction mapTransaction = getChildFragmentManager().beginTransaction();
        mapTransaction.replace(R.id.mapContainer, mapFragment);
        mapTransaction.commit();

        mapFragment.getMapAsync(googleMap -> {
            LatLng bigPitLocation = new LatLng(51.7732414968518, -3.105647432357649);
            googleMap.addMarker(new MarkerOptions().position(bigPitLocation).title("Big Pit National Coal Museum"));
            googleMap.moveCamera(com.google.android.gms.maps.CameraUpdateFactory.newLatLngZoom(bigPitLocation, 15));
        });

        return view;
    }
}
