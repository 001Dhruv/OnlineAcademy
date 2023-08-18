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
import android.widget.Toast;

import com.example.onlineacademy.API.Instance;
import com.example.onlineacademy.API.LiveResponse;
import com.example.onlineacademy.API.Models.SubjectData;
import com.example.onlineacademy.Homeactivity.Adapters.HomeFragmentModel;
import com.example.onlineacademy.Homeactivity.Adapters.live_fragment_recycler_adapter;

import com.example.onlineacademy.R;
import com.example.onlineacademy.Utils.ProgressBarHandler;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Live_Classes extends Fragment {
    static List<LiveResponse> arr_live_classes_items;
    static ProgressDialog progressDialog;
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_live__classes, container, false);
        UIInit(view);
        progressDialog = new ProgressDialog(view.getContext());
        ProgressBarHandler.showProgressDialog(progressDialog,getString(R.string.loading));
        getDataForLive(view);
        return view;
    }

    private void getDataForLive(View view) {
        Instance.getInstance().apiinterface.getLiveData().enqueue(new Callback<List<LiveResponse>>() {
            @Override
            public void onResponse(Call<List<LiveResponse>> call, Response<List<LiveResponse>> response) {
                arr_live_classes_items=response.body();
                ProgressBarHandler.hideProgressDialog(progressDialog);
                recyclerViewSetter(view);
            }
            @Override
            public void onFailure(Call<List<LiveResponse>> call, Throwable t) {
                ProgressBarHandler.hideProgressDialog(progressDialog);
                Toast.makeText(view.getContext(), R.string.something_went_wrong, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void recyclerViewSetter(View view) {
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        live_fragment_recycler_adapter adapter = new live_fragment_recycler_adapter(getContext(), arr_live_classes_items, R.layout.fragment_live_classes_raw);
        recyclerView.setAdapter(adapter);
    }

    private void UIInit(View view) {
        arr_live_classes_items=new ArrayList<>();
        recyclerView=view.findViewById(R.id.recyclerview_live_classes);
    }
}