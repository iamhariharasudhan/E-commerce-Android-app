package com.payment.phonepe;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;

public class Web_Fragment extends Fragment {

    private WebView mywebView;

    public Web_Fragment() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_web_, container, false);

        mywebView = view.findViewById(R.id.webView);
        mywebView.setWebViewClient(new mywebClient());
        mywebView.loadUrl("https://gemini.google.com/app?hl=en-IN");

        WebSettings webSettings = mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true); // Enable DOM storage if needed
        webSettings.setAllowFileAccess(true);   // Allow file access if needed
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);

        return view;
    }

    private class mywebClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.startsWith("https://gemini.google.com")) {
                view.loadUrl(url);
                return true;
            }
            return false; // Let WebView handle other URLs
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mywebView != null) {
            mywebView.onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mywebView != null) {
            mywebView.onPause();
        }
    }

    @Override
    public void onDestroyView() {
        if (mywebView != null) {
            mywebView.destroy();
        }
        super.onDestroyView();
    }
}
