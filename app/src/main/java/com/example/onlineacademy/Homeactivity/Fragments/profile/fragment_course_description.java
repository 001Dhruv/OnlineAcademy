package com.example.onlineacademy.Homeactivity.Fragments.profile;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlineacademy.API.Instance;
import com.example.onlineacademy.API.Models.ExploreResponse;
import com.example.onlineacademy.API.Models.SubjectData;
import com.example.onlineacademy.Homeactivity.Adapters.home_subject_fragment_recycler_adapter;
import com.example.onlineacademy.R;
import com.example.onlineacademy.Utils.ClickHandler;
import com.example.onlineacademy.Utils.ProgressBarHandler;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class fragment_course_description extends Fragment {

    ExploreResponse exploreResponse;
    private TextView description_fragment_course_name;
    private TextView fragment_course_description_description;
    private TextView intro_title;
    private TextView intro_description;
    private ImageView fragment_course_description_img;
    private ImageView introduction_img;
    private Button btn_buy_now;
    List<SubjectData> subjectData;
    ProgressDialog progressDialog;
    public fragment_course_description(ExploreResponse exploreResponse) {
        this.exploreResponse=exploreResponse;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_course_description, container, false);
        progressDialog = new ProgressDialog(view.getContext());
        ProgressBarHandler.showProgressDialog(progressDialog,getString(R.string.loading));

        UIInit(view);
        getDataforIntro(view);



        return view;
    }
    private void clickSetterForInto() {
        introduction_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ClickHandler.HomeVideoPlayer(subjectData.get(0).getYoutube_video_url());
            }
        });intro_description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ClickHandler.HomeVideoPlayer(subjectData.get(0).getYoutube_video_url());
            }
        });intro_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ClickHandler.HomeVideoPlayer(subjectData.get(0).getYoutube_video_url());
            }
        });

    }


    private void getDataforIntro(View view) {
        Instance.getInstance().apiinterface.getSubjectData(ExploreResponse.getId()).enqueue(new Callback<List<SubjectData>>() {
            @Override
            public void onResponse(Call<List<SubjectData>> call, Response<List<SubjectData>> response) {
                subjectData=response.body();
                Log.e("Explore_desc_success","success in getting data");
                Log.e("Explore_desc_success",Integer.toString(subjectData.size()));

                dataSetter(view);
                clickSetterForInto();
                ProgressBarHandler.hideProgressDialog(progressDialog);
            }
            @Override
            public void onFailure(Call<List<SubjectData>> call, Throwable t) {
                ProgressBarHandler.hideProgressDialog(progressDialog);
                Toast.makeText(view.getContext(), R.string.something_went_wrong, Toast.LENGTH_SHORT).show();
                Log.e("home_subject_failure","onfaliure:"+t.getLocalizedMessage());
            }
        });
    }

    private void dataSetter(View view) {
        description_fragment_course_name.setText(exploreResponse.getCourse_name());
        fragment_course_description_description.setText(exploreResponse.getCourse_description());
        Picasso.get().load(exploreResponse.getCourse_image()).into(fragment_course_description_img);
//        intro_title.setText(subjectData.get(0).getYoutube_video_title()+"/"+subjectData.get(0).getTopic_name());
//        intro_description.setText(subjectData.get(0).getSubject_name());
        Picasso.get().load("data:image/jpeg;base64,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").into(introduction_img);

    }

    private void UIInit(View view) {
        description_fragment_course_name=view.findViewById(R.id.description_fragment_course_name);
        fragment_course_description_description=view.findViewById(R.id.fragment_course_description_description);
        intro_title=view.findViewById(R.id.intro_title);
        intro_description=view.findViewById(R.id.intro_description);
        fragment_course_description_img=view.findViewById(R.id.fragment_course_description_img);
        introduction_img=view.findViewById(R.id.introduction_img);
        btn_buy_now=view.findViewById(R.id.btn_buy_now);


        subjectData=new ArrayList<>();
    }
}