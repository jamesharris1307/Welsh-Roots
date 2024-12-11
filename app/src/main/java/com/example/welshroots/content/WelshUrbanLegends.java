package com.example.welshroots.content;

// Imports
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.view.LayoutInflater;
import android.webkit.WebViewClient;
import android.annotation.SuppressLint;
import androidx.fragment.app.Fragment;
import com.example.welshroots.R;

public class WelshUrbanLegends extends Fragment {

    // Declare Variables
    private static final String welshUrbanLegendsVideoID = "0W38hBtjJD8";

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_fragment_welsh_urban_legends, container, false);

        // Welsh Urban Legends Youtube Video
        WebView welshUrbanLegendsYoutube1 = view.findViewById(R.id.welshUrbanLegendsVideo1);
        WebSettings webSettingsWelshUrbanLegendsVideo1 = welshUrbanLegendsYoutube1.getSettings();
        webSettingsWelshUrbanLegendsVideo1.setJavaScriptEnabled(true);
        welshUrbanLegendsYoutube1.loadUrl("https://www.youtube-nocookie.com/embed/" + welshUrbanLegendsVideoID);
        welshUrbanLegendsYoutube1.setWebViewClient(new WebViewClient());
        return view;
    }
}
