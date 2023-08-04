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
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_video_player_fragment, container, false);
        UIInit(view);
        VideoLoader(view);
        return view;
    }


    private void VideoLoader(View view) {
        video_player = view.findViewById(R.id.video_player);
        video_player.getSettings().setJavaScriptEnabled(true);

        video_player.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onShowCustomView(View view, CustomViewCallback callback) {
                // Handle full-screen video playback here
                // For example, you can add the custom view to the layout and hide the WebView
                video_player.setVisibility(View.GONE);
                FrameLayout frameLayout = view.getRootView().findViewById(android.R.id.content);
                frameLayout.addView(view, new FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                ));
            }

            @Override
            public void onHideCustomView() {
                // Handle exiting full-screen video playback here
                // For example, remove the custom view from the layout and show the WebView again
                video_player.setVisibility(View.VISIBLE);
                FrameLayout frameLayout = video_player.getRootView().findViewById(android.R.id.content);
                frameLayout.removeView(video_player);
            }
        });

        video_player.loadUrl("https://www.youtube.com/embed/DmLF7bcf4tg");
    }




    private void UIInit(View view) {

        video_player=(WebView) view.findViewById(R.id.video_player);
    }
}