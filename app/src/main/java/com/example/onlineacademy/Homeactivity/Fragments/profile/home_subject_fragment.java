package com.example.onlineacademy.Homeactivity.Fragments.profile;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlineacademy.API.Instance;
import com.example.onlineacademy.API.Models.HomeResponse;
import com.example.onlineacademy.API.Models.SubjectData;
import com.example.onlineacademy.Homeactivity.Adapters.HomeFragmentModel;
import com.example.onlineacademy.Homeactivity.Adapters.home_subject_fragment_recycler_adapter;
import com.example.onlineacademy.R;
import com.example.onlineacademy.Utils.ProgressBarHandler;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class home_subject_fragment extends Fragment {
    public home_subject_fragment(HomeResponse homeResponse){
        this.homeResponse=homeResponse;
    }

    static RecyclerView recyclerView;
    static ProgressDialog progressDialog;
    static HomeResponse homeResponse;
    static List<SubjectData> subjectData;
    TextView subject_name;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home_subject, container, false);
        UIInit(view);
        progressDialog = new ProgressDialog(view.getContext());
        ProgressBarHandler.showProgressDialog(progressDialog,getString(R.string.loading));
        subjectNameSetter();
        getDataForHome(view);
        return view;
    }

    private void subjectNameSetter() {
        subject_name.setText(homeResponse.getCourse_name());
    }

    private static void getDataForHome(View view) {
        Instance.getInstance().apiinterface.getSubjectData(homeResponse.getId()).enqueue(new Callback<List<SubjectData>>() {
            @Override
            public void onResponse(Call<List<SubjectData>> call, Response<List<SubjectData>> response) {
                subjectData=response.body();
                Log.e("home_subject_success","success in getting data");
                Log.e("home_subject_success",Integer.toString(subjectData.size()));
                ProgressBarHandler.hideProgressDialog(progressDialog);
                recyclerViewSetterForHome(view);


            }
            @Override
            public void onFailure(Call<List<SubjectData>> call, Throwable t) {
                ProgressBarHandler.hideProgressDialog(progressDialog);
                Toast.makeText(view.getContext(), R.string.something_went_wrong, Toast.LENGTH_SHORT).show();
                Log.e("home_subject_failure","onfaliure:"+t.getLocalizedMessage());
            }
        });

    }
    private static void recyclerViewSetterForHome(View view) {
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        home_subject_fragment_recycler_adapter adapter = new home_subject_fragment_recycler_adapter(view.getContext(), subjectData, R.layout.fragment_home_subject_raw);
        recyclerView.setAdapter(adapter);
    }

    private void UIInit(View view) {
        subjectData=new ArrayList<>();
        recyclerView=view.findViewById(R.id.recyclerview_home_subject_fragment);
        subject_name=view.findViewById(R.id.subject_name);
        Log.e("home_subject_success","recycler View set");
        System.out.println(recyclerView);
    }
}