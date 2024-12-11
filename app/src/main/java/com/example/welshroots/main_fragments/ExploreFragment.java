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

        buttonWelshHistory = rootView.findViewById(R.id.buttonWelshHistoryContent);
        buttonWelshUrbanLegends = rootView.findViewById(R.id.buttonWelshUrbanLegends);
        buttonWelshNews = rootView.findViewById(R.id.buttonWelshNews);

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
        query = query.trim().toLowerCase();

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

        for (int i = 0; i < buttons.length; i++) {
            if (query.isEmpty() || query.equalsIgnoreCase(buttonLabels[i])) {
                buttons[i].setVisibility(View.VISIBLE);
            } else {
                buttons[i].setVisibility(View.GONE);
            }
        }
    }

}
