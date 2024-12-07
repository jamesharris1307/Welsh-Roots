package com.example.welshroots.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.welshroots.R;
import com.example.welshroots.content.MuseumExhibit1Fragment;
import com.example.welshroots.content.MuseumExhibit2Fragment;
import com.example.welshroots.content.WelshHistoryFragment;
import com.example.welshroots.content.WelshNews;
import com.example.welshroots.content.WelshUrbanLegends;

public class ExploreFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_explore, container, false);

        // Button to replace the entire parent fragment with WelshHistoryFragment
        Button buttonWelshHistory = rootView.findViewById(R.id.buttonWelshHistoryContent);
        buttonWelshHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, new WelshHistoryFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        // Button to replace with WelshUrbanLegends
        Button buttonWelshUrbanLegends = rootView.findViewById(R.id.buttonWelshUrbanLegends);
        buttonWelshUrbanLegends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, new WelshUrbanLegends())
                        .addToBackStack(null)
                        .commit();
            }
        });

        // Button to replace with WelshNews
        Button buttonWelshNews = rootView.findViewById(R.id.buttonWelshNews);
        buttonWelshNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, new WelshNews())
                        .addToBackStack(null)
                        .commit();
            }
        });

        return rootView;
    }
}
