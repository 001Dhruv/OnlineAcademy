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
        description_fragment_course_name.setText(exploreResponse.getCourse_name().toUpperCase());
        fragment_course_description_description.setText(exploreResponse.getCourse_description());
        Picasso.get().load("https://brahminnerbrain.com/online_tuition_class/storage/app/"+exploreResponse.getCourse_image()).into(fragment_course_description_img);
        if(subjectData.size()>0) {
            intro_title.setText(subjectData.get(0).getYoutube_video_title()+"/"+subjectData.get(0).getTopic_name());
            intro_description.setText(subjectData.get(0).getSubject_name());
            Picasso.get().load("https://brahminnerbrain.com/online_tuition_class/storage/app/").into(introduction_img);
        }

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