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
import com.example.onlineacademy.API.Models.ExploreResponse;
import com.example.onlineacademy.API.Models.HomeResponse;
import com.example.onlineacademy.Homeactivity.Adapters.explore_fragment_recycler_adapter;
import com.example.onlineacademy.R;
import com.example.onlineacademy.Utils.ProgressBarHandler;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Explore extends Fragment {
    List<ExploreResponse> arr_explore_items;
    RecyclerView recyclerView;
    ProgressDialog progressDialog;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_explore, container, false);
        progressDialog = new ProgressDialog(view.getContext());
        ProgressBarHandler.showProgressDialog(progressDialog,getString(R.string.loading));
        UIInit(view);
        getExploreData(view);
        return view;
    }

    private void getExploreData(View view) {
        Instance.getInstance().apiinterface.getExploreData().enqueue(new Callback<List<ExploreResponse>>() {
            @Override
            public void onResponse(Call<List<ExploreResponse>> call, Response<List<ExploreResponse>> response) {
                arr_explore_items=response.body();
                recyclerViewSetter(view);
                ProgressBarHandler.hideProgressDialog(progressDialog);
                Log.e("explore_success",arr_explore_items.get(3).getCourse_name());
                Log.e("explore_success",Integer.toString(arr_explore_items.size()));
            }
            @Override
            public void onFailure(Call<List<ExploreResponse>> call, Throwable t) {
                ProgressBarHandler.hideProgressDialog(progressDialog);
                Toast.makeText(view.getContext(), R.string.something_went_wrong, Toast.LENGTH_SHORT).show();
                Log.e("home_failure","onfaliure:"+t.getLocalizedMessage());
            }
        });
    }

    private void recyclerViewSetter(View view) {
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        explore_fragment_recycler_adapter adapter = new explore_fragment_recycler_adapter(getContext(), arr_explore_items, R.layout.explore_fragment_raw);
        recyclerView.setAdapter(adapter);
    }

    private void UIInit(View view) {
        recyclerView=view.findViewById(R.id.recyclerview_explore_fragment);
        arr_explore_items=new ArrayList<>();
    }
}