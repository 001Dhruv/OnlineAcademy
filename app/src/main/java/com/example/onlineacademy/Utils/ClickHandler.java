package com.example.onlineacademy.Utils;

import android.app.ProgressDialog;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineacademy.API.Instance;
import com.example.onlineacademy.API.Models.ExploreResponse;
import com.example.onlineacademy.API.Models.HomeActivityInstance;
import com.example.onlineacademy.API.Models.HomeResponse;
import com.example.onlineacademy.API.Models.SubjectData;
import com.example.onlineacademy.Homeactivity.Adapters.home_fragment_recycler_adapter;
import com.example.onlineacademy.Homeactivity.Adapters.home_subject_fragment_recycler_adapter;
import com.example.onlineacademy.Homeactivity.Fragments.profile.fragment_course_description;
import com.example.onlineacademy.Homeactivity.Fragments.profile.home_subject_fragment;
import com.example.onlineacademy.Homeactivity.Fragments.profile.video_player_fragment;
import com.example.onlineacademy.R;

import java.util.ArrayList;
import java.util.List;



public class ClickHandler {

    public static void HomeRecyclerClick(View view, HomeResponse homeResponse) {
        HomeActivityInstance.getHomeActivity().loadFragment(new home_subject_fragment(homeResponse));
    }


    public static void HomeVideoPlayer(String videoURL) {
        HomeActivityInstance.getHomeActivity().loadFragment(new video_player_fragment(videoURL));
    }

    public static void ExploreRecyclerClick(ExploreResponse exploreResponse) {
        HomeActivityInstance.getHomeActivity().loadFragment(new fragment_course_description(exploreResponse));

    }
}
