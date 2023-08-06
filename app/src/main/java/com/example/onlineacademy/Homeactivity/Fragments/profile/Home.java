package com.example.onlineacademy.Homeactivity.Fragments.profile;

import android.app.ProgressDialog;
import android.content.Intent;
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
import com.example.onlineacademy.API.Models.HomeResponse;
import com.example.onlineacademy.API.Models.LoginResponse;
import com.example.onlineacademy.API.Models.user;
import com.example.onlineacademy.Homeactivity.Homeactivity;
import com.example.onlineacademy.LoginActivity;
import com.example.onlineacademy.R;
import com.example.onlineacademy.Homeactivity.Adapters.home_fragment_recycler_adapter;
import com.example.onlineacademy.Utils.ProgressBarHandler;
import com.example.onlineacademy.Utils.SaveLogInData;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends Fragment {
    List<HomeResponse> arr_home_items;
    RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        progressDialog = new ProgressDialog(view.getContext());
        ProgressBarHandler.showProgressDialog(progressDialog,getString(R.string.loading));
        UIInit(view);
        getHomeData(view);

        return view;
    }

    private void recyclerViewSetter(View view) {
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        home_fragment_recycler_adapter adapter = new home_fragment_recycler_adapter(getContext(), arr_home_items, R.layout.home_fragment_raw);
        recyclerView.setAdapter(adapter);
    }

    private void getHomeData(View view) {
        Instance.getInstance().apiinterface.getHomeData().enqueue(new Callback<List<HomeResponse>>() {
            @Override
            public void onResponse(Call<List<HomeResponse>> call, Response<List<HomeResponse>> response) {
                arr_home_items=response.body();
                recyclerViewSetter(view);
                ProgressBarHandler.hideProgressDialog(progressDialog);
                Log.e("home_success",arr_home_items.get(3).getCourse_name());
                Log.e("home_success",Integer.toString(arr_home_items.size()));
            }
            @Override
            public void onFailure(Call<List<HomeResponse>> call, Throwable t) {
                ProgressBarHandler.hideProgressDialog(progressDialog);
                Toast.makeText(view.getContext(), R.string.something_went_wrong, Toast.LENGTH_SHORT).show();
                Log.e("home_failure","onfaliure:"+t.getLocalizedMessage());
            }
        });
    }
    private void UIInit(View view) {
        recyclerView=view.findViewById(R.id.recyclerview_home_fragment);
        arr_home_items=new ArrayList<>();

    }
}