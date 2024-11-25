package com.example.welshroots.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

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

        // ImageButton to replace the entire parent fragment with WelshHistoryFragment
        ImageButton imageButtonWelshHistory = rootView.findViewById(R.id.imageButtonWelshHistoryContent);
        imageButtonWelshHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace ExploreFragment with WelshHistoryFragment
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, new WelshHistoryFragment()) // Replace parent fragment
                        .addToBackStack(null)  // Add to back stack to enable back navigation
                        .commit();
            }
        });
        // Button to replace with MuseumExhibit1Fragment
        ImageButton imageButtonMuseumExhibit1 = rootView.findViewById(R.id.imageButtonWelshMuseumExhibit1);
        imageButtonMuseumExhibit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace ExploreFragment with MuseumExhibit1Fragment
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, new MuseumExhibit1Fragment()) // Replace with MuseumExhibit1Fragment
                        .addToBackStack(null)  // Add to back stack
                        .commit();
            }
        });
        // Button to replace with MuseumExhibit2Fragment
        ImageButton imageButtonMuseumExhibit2 = rootView.findViewById(R.id.imageButtonWelshMuseumExhibit2);
        imageButtonMuseumExhibit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace ExploreFragment with MuseumExhibit2Fragment
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, new MuseumExhibit2Fragment()) // Replace with MuseumExhibit2Fragment
                        .addToBackStack(null)  // Add to back stack
                        .commit();
            }
        });
        // Button to replace with WelshUrbanLegends
        ImageButton imageButtonWelshUrbanLegends = rootView.findViewById(R.id.imageButtonWelshUrbanLegends);
        imageButtonWelshUrbanLegends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace ExploreFragment with WelshUrbanLegends
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, new WelshUrbanLegends()) // Replace with MuseumExhibit2Fragment
                        .addToBackStack(null)  // Add to back stack
                        .commit();
            }
        });
        // Button to replace with WelshNews
        ImageButton imageButtonWelshNews = rootView.findViewById(R.id.imageButtonWelshNews);
        imageButtonWelshNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace ExploreFragment with WelshNews
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, new WelshNews()) // Replace with MuseumExhibit2Fragment
                        .addToBackStack(null)  // Add to back stack
                        .commit();
            }
        });
        return rootView;
    }
}
