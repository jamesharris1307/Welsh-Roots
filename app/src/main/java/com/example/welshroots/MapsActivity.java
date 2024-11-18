package com.example.welshroots;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.welshroots.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add markers for Welsh points of interest
        addCustomMarkers();
    }

    private void addCustomMarkers() {
        // Example: Add a marker for Cardiff Castle
        LatLng cardiffCastle = new LatLng(51.4811, -3.1815);
        mMap.addMarker(new MarkerOptions()
                .position(cardiffCastle)
                .title("Cardiff Castle")
                .icon(bitmapDescriptorFromVector(R.drawable.ic_castle)));

        // Example: Add a marker for National Museum Cardiff
        LatLng nationalMuseum = new LatLng(51.4816, -3.1791);
        mMap.addMarker(new MarkerOptions()
                .position(nationalMuseum)
                .title("National Museum Cardiff")
                .icon(bitmapDescriptorFromVector(R.drawable.ic_museum)));

        // Move the camera to focus on Cardiff
        LatLng initialLocation = new LatLng(51.4816, -3.1815); // Center of Cardiff
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(initialLocation, 14));
    }

    private BitmapDescriptor bitmapDescriptorFromVector(int vectorResId) {
        // Load a bitmap from the drawable resource
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), vectorResId);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}
