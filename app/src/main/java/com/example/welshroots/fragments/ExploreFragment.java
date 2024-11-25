package com.example.welshroots.fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.welshroots.R;
import com.example.welshroots.content.WelshHistory;

public class ExploreFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_explore, container, false);

        // Initialize the ImageButton
        ImageButton imageButton = view.findViewById(R.id.imageButtonWelshHistoryContent);

        // Set an OnClickListener for the button
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Use the fragment's context to start the new activity
                Intent intent = new Intent(getActivity(), WelshHistory.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
