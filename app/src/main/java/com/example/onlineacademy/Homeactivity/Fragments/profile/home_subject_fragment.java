package com.example.onlineacademy.Homeactivity.Fragments.profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onlineacademy.Homeactivity.Adapters.home_fragment_recycler_adapter;
import com.example.onlineacademy.Homeactivity.Adapters.home_subject_fragment_recycler_adapter;
import com.example.onlineacademy.Homeactivity.Models.HomeFragmentModel;
import com.example.onlineacademy.R;
import java.util.ArrayList;


public class home_subject_fragment extends Fragment {


    ArrayList<HomeFragmentModel> arr_home_subject_items;
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        UIInit(view);
        recyclerViewSetter(view);


        return view;
    }

    private void recyclerViewSetter(View view) {
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        home_subject_fragment_recycler_adapter adapter = new home_subject_fragment_recycler_adapter(getContext(), arr_home_subject_items, R.layout.fragment_home_subject_raw);
        recyclerView.setAdapter(adapter);

        arr_home_subject_items.add(new HomeFragmentModel("Android Tut by Innerbrain","This course coverse the the entide tut of adroid for bigginers till advance","https://i.ytimg.com/vi/FEqF1_jDV-A/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLB2vyiSPCPrintn0roLbV0T6O-cTA"));
        arr_home_subject_items.add(new HomeFragmentModel("Android Tut by Innerbrain","This course coverse the the entide tut of adroid for bigginers till advance","https://i.ytimg.com/vi/FEqF1_jDV-A/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLB2vyiSPCPrintn0roLbV0T6O-cTA"));
        arr_home_subject_items.add(new HomeFragmentModel("Android Tut by Innerbrain","This course coverse the the entide tut of adroid for bigginers till advance","https://i.ytimg.com/vi/FEqF1_jDV-A/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLB2vyiSPCPrintn0roLbV0T6O-cTA"));
        arr_home_subject_items.add(new HomeFragmentModel("Android Tut by Innerbrain","This course coverse the the entide tut of adroid for bigginers till advance","https://i.ytimg.com/vi/FEqF1_jDV-A/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLB2vyiSPCPrintn0roLbV0T6O-cTA"));
        arr_home_subject_items.add(new HomeFragmentModel("Android Tut by Innerbrain","This course coverse the the entide tut of adroid for bigginers till advance","https://i.ytimg.com/vi/FEqF1_jDV-A/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLB2vyiSPCPrintn0roLbV0T6O-cTA"));
        arr_home_subject_items.add(new HomeFragmentModel("Android Tut by Innerbrain","This course coverse the the entide tut of adroid for bigginers till advance","https://i.ytimg.com/vi/FEqF1_jDV-A/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLB2vyiSPCPrintn0roLbV0T6O-cTA"));
        arr_home_subject_items.add(new HomeFragmentModel("Android Tut by Innerbrain","This course coverse the the entide tut of adroid for bigginers till advance","https://i.ytimg.com/vi/FEqF1_jDV-A/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLB2vyiSPCPrintn0roLbV0T6O-cTA"));
        arr_home_subject_items.add(new HomeFragmentModel("Android Tut by Innerbrain","This course coverse the the entide tut of adroid for bigginers till advance","https://i.ytimg.com/vi/FEqF1_jDV-A/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLB2vyiSPCPrintn0roLbV0T6O-cTA"));
        arr_home_subject_items.add(new HomeFragmentModel("Android Tut by Innerbrain","This course coverse the the entide tut of adroid for bigginers till advance","https://i.ytimg.com/vi/FEqF1_jDV-A/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLB2vyiSPCPrintn0roLbV0T6O-cTA"));
        arr_home_subject_items.add(new HomeFragmentModel("Android Tut by Innerbrain","This course coverse the the entide tut of adroid for bigginers till advance","https://i.ytimg.com/vi/FEqF1_jDV-A/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLB2vyiSPCPrintn0roLbV0T6O-cTA"));
        arr_home_subject_items.add(new HomeFragmentModel("Android Tut by Innerbrain","This course coverse the the entide tut of adroid for bigginers till advance","https://i.ytimg.com/vi/FEqF1_jDV-A/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLB2vyiSPCPrintn0roLbV0T6O-cTA"));
        arr_home_subject_items.add(new HomeFragmentModel("Android Tut by Innerbrain","This course coverse the the entide tut of adroid for bigginers till advance","https://i.ytimg.com/vi/FEqF1_jDV-A/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLB2vyiSPCPrintn0roLbV0T6O-cTA"));
        arr_home_subject_items.add(new HomeFragmentModel("Android Tut by Innerbrain","This course coverse the the entide tut of adroid for bigginers till advance","https://i.ytimg.com/vi/FEqF1_jDV-A/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLB2vyiSPCPrintn0roLbV0T6O-cTA"));
        arr_home_subject_items.add(new HomeFragmentModel("Android Tut by Innerbrain","This course coverse the the entide tut of adroid for bigginers till advance","https://i.ytimg.com/vi/FEqF1_jDV-A/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLB2vyiSPCPrintn0roLbV0T6O-cTA"));

    }

    private void UIInit(View view) {
        arr_home_subject_items=new ArrayList<>();
        RecyclerView recyclerView=view.findViewById(R.id.recyclerview_home_fragment);
    }
}