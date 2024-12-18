package com.example.welshroots.main_fragments;

// Imports
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import com.example.welshroots.R;
import com.example.welshroots.content.MuseumNationalCardiff;
import com.example.welshroots.content.MuseumStFagans;
import com.example.welshroots.content.MuseumBigPit;
import com.example.welshroots.content.MuseumWaterfront;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        // Button for St Fagans Museum
        Button buttonMuseumStFagans = rootView.findViewById(R.id.buttonMuseumStFagans);
        buttonMuseumStFagans.setOnClickListener(v ->
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, new MuseumStFagans())
                        .addToBackStack(null)
                        .commit()
        );

        // Button for Big Pit Museum
        Button buttonMuseumBigPit = rootView.findViewById(R.id.buttonMuseumBigPit);
        buttonMuseumBigPit.setOnClickListener(v ->
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, new MuseumBigPit())
                        .addToBackStack(null)
                        .commit()
        );

        // Button for Cardiff National Museum
        Button buttonMuseumNationalCardiff = rootView.findViewById(R.id.buttonMuseumNationalCardiff);
        buttonMuseumNationalCardiff.setOnClickListener(v ->
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, new MuseumNationalCardiff())
                        .addToBackStack(null)
                        .commit()
        );

        // Button for Waterfront Museum
        Button buttonMuseumWaterfront = rootView.findViewById(R.id.buttonMuseumWaterfront);
        buttonMuseumWaterfront.setOnClickListener(v ->
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, new MuseumWaterfront())
                        .addToBackStack(null)
                        .commit()
        );
        return rootView;
    }
}
