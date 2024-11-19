package com.example.welshroots.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.welshroots.R;

public class AboutFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        // Find the ImageView by ID if needed
        ImageView imageView2 = view.findViewById(R.id.imageView2);

        // Find the ImageView by ID if needed
        ImageView imageView3 = view.findViewById(R.id.imageView3);
        return view;
    }
}
