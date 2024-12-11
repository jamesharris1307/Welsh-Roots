package com.example.welshroots.main_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.widget.SearchView;


import androidx.fragment.app.Fragment;

import com.example.welshroots.R;
import com.example.welshroots.content.WelshHistoryFragment;
import com.example.welshroots.content.WelshNews;
import com.example.welshroots.content.WelshUrbanLegends;

public class ExploreFragment extends Fragment {

    private Button buttonWelshHistory;
    private Button buttonWelshUrbanLegends;
    private Button buttonWelshNews;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_explore, container, false);

        // Initialize buttons
        buttonWelshHistory = rootView.findViewById(R.id.buttonWelshHistoryContent);
        buttonWelshUrbanLegends = rootView.findViewById(R.id.buttonWelshUrbanLegends);
        buttonWelshNews = rootView.findViewById(R.id.buttonWelshNews);

        // Set click listeners for navigation (unchanged)
        buttonWelshHistory.setOnClickListener(v ->
            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, new WelshHistoryFragment())
                    .addToBackStack(null)
                    .commit()
        );


        buttonWelshUrbanLegends.setOnClickListener(v ->
            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, new WelshUrbanLegends())
                    .addToBackStack(null)
                    .commit()
        );

        buttonWelshNews.setOnClickListener(v ->
            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, new WelshNews())
                    .addToBackStack(null)
                    .commit()
        );

        // Set up search functionality
        SearchView searchView = rootView.findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterContent(newText);
                return false;
            }
        });

        return rootView;
    }

    private void filterContent(String query) {
        // Trim and convert the query to lowercase for case-insensitive comparison
        query = query.trim().toLowerCase();

        // Array of buttons and their associated labels for matching
        Button[] buttons = {
                buttonWelshHistory,
                buttonWelshUrbanLegends,
                buttonWelshNews
        };
        String[] buttonLabels = {
                "welsh history",
                "welsh urban legends",
                "welsh news"
        };

        // Iterate through each button and show only the matching ones
        for (int i = 0; i < buttons.length; i++) {
            if (query.isEmpty() || query.equalsIgnoreCase(buttonLabels[i])) {
                buttons[i].setVisibility(View.VISIBLE);
            } else {
                buttons[i].setVisibility(View.GONE);
            }
        }
    }

}
