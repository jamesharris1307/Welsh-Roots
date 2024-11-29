package com.example.welshroots.content;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.welshroots.R;

public class MuseumVirtualTour2 extends Fragment {

    private static final String VIDEO_ID = "NgigITMSLIg";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content_museum_virtual_tour_1, container, false);

        WebView youtubeWebView = view.findViewById(R.id.youtubeWebView);
        WebSettings webSettings = youtubeWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);

        // Load the YouTube video in the WebView with an embed link
        String videoUrl = "https://www.youtube.com/watch?v=" + VIDEO_ID;
        youtubeWebView.loadUrl(videoUrl);

        // Ensure links within the WebView open in the WebView itself
        youtubeWebView.setWebViewClient(new WebViewClient());

        return view;
    }
}
