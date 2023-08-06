package com.example.onlineacademy.Homeactivity.Fragments.profile;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;

import com.example.onlineacademy.R;


public class video_player_fragment extends Fragment {

    WebView video_player;
    private View customView;
    private WebChromeClient.CustomViewCallback customViewCallback;
    private String videoURL;
    public video_player_fragment(String Video_URL){
        this.videoURL=Video_URL;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_video_player_fragment, container, false);
        UIInit(view);
        VideoLoader(view);
        return view;
    }


    private void VideoLoader(View view) {
        video_player.getSettings().setJavaScriptEnabled(true);

        video_player.setWebChromeClient(new WebChromeClient() {
        });

        video_player.loadUrl(videoURL);
    }
    private void UIInit(View view) {

        video_player=(WebView) view.findViewById(R.id.video_player);
    }
}