package com.example.welshroots.main_fragments;

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
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        // Button to St Fagans
        Button buttonMuseumStFagans = rootView.findViewById(R.id.buttonMuseumStFagans);
        buttonMuseumStFagans.setOnClickListener(v ->
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, new MuseumStFagans())
                        .addToBackStack(null)
                        .commit()
        );

        // Button to Big Pit
        Button buttonMuseumBigPit = rootView.findViewById(R.id.buttonMuseumBigPit);
        buttonMuseumBigPit.setOnClickListener(v ->
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, new MuseumBigPit())
                        .addToBackStack(null)
                        .commit()
        );

        // Button to National Museum Cardiff
        Button buttonMuseumNationalCardiff = rootView.findViewById(R.id.buttonMuseumNationalCardiff);
        buttonMuseumNationalCardiff.setOnClickListener(v ->
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, new MuseumNationalCardiff())
                        .addToBackStack(null)
                        .commit()
        );

        // Button to Waterfront Museum
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
