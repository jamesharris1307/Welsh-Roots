package com.example.welshroots.content;

// Imports
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.example.welshroots.R;
import android.view.LayoutInflater;
import androidx.fragment.app.Fragment;

public class WelshNews extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.content_fragment_welsh_news, container, false);
    }
}
