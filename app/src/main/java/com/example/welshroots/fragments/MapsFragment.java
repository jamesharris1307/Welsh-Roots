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
        markerDataList.add(new MarkerData(new LatLng(51.48722473313164, -3.2723620534115585), "St Fagans National Museum of History", R.drawable.ic_museum));
        markerDataList.add(new MarkerData(new LatLng(51.77256387585435, -3.1045690206749548), "Big Pit National Coal Museum", R.drawable.ic_museum));
        markerDataList.add(new MarkerData(new LatLng(51.485772068873864, -3.176852611411994), "National Museum Cardiff", R.drawable.ic_museum));
        markerDataList.add(new MarkerData(new LatLng(51.616701290235795, -3.9391617532728214), "National Waterfront Museum", R.drawable.ic_museum));

        // Custom Icons look bad
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
