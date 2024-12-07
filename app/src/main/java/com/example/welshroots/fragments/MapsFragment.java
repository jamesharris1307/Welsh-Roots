package com.example.welshroots.fragments;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.welshroots.R;

import java.util.ArrayList;
import java.util.List;

public class MapsFragment extends Fragment implements OnMapReadyCallback {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_maps, container, false);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapFragment);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        List<MarkerData> markerDataList = new ArrayList<>();
        markerDataList.add(new MarkerData(new LatLng(51.480243346629436, -3.177351003155592), "St Fagans National Museum of History", R.drawable.ic_museum));
        markerDataList.add(new MarkerData(new LatLng(51.485706738816766, -3.1768579362347222), "Big Pit National Coal Museum", R.drawable.ic_museum));
        markerDataList.add(new MarkerData(new LatLng(51.485706738816766, -3.1768579362347222), "National Museum Cardiff", R.drawable.ic_museum));
        markerDataList.add(new MarkerData(new LatLng(51.485706738816766, -3.1768579362347222), "National Waterfront Museum", R.drawable.ic_museum));


        for (MarkerData markerData : markerDataList) {
            //BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(markerData.iconResId);
            googleMap.addMarker(new MarkerOptions()
                    .position(markerData.latLng)
                    .title(markerData.title));
                    //.icon(icon));
        }


        if (!markerDataList.isEmpty()) {
            googleMap.moveCamera(com.google.android.gms.maps.CameraUpdateFactory.newLatLngZoom(markerDataList.get(0).latLng, 11));
        }
    }

    private static class MarkerData {
        LatLng latLng;
        String title;
        int iconResId;

        MarkerData(LatLng latLng, String title, int iconResId) {
            this.latLng = latLng;
            this.title = title;
            this.iconResId = iconResId;
        }
    }
}
