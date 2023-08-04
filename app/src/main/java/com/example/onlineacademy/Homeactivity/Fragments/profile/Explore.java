package com.example.onlineacademy.Homeactivity.Fragments.profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onlineacademy.Homeactivity.Adapters.explore_fragment_recycler_adapter;
import com.example.onlineacademy.Homeactivity.Adapters.home_fragment_recycler_adapter;
import com.example.onlineacademy.Homeactivity.Models.HomeFragmentModel;
import com.example.onlineacademy.R;

import java.util.ArrayList;


public class Explore extends Fragment {
    ArrayList<HomeFragmentModel> arr_explore_items;
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_explore, container, false);
        UIInit(view);
        recyclerViewSetter(view);
        return view;
    }

    private void recyclerViewSetter(View view) {
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        explore_fragment_recycler_adapter adapter = new explore_fragment_recycler_adapter(getContext(), arr_explore_items, R.layout.explore_fragment_raw);
        recyclerView.setAdapter(adapter);



        arr_explore_items.add(new HomeFragmentModel("https://i.ytimg.com/vi/FEqF1_jDV-A/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLB2vyiSPCPrintn0roLbV0T6O-cTA","Android Tut by Innerbrain","In this ndnn jj njn jn jnj n"));
        arr_explore_items.add(new HomeFragmentModel("https://i.ytimg.com/vi/FEqF1_jDV-A/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLB2vyiSPCPrintn0roLbV0T6O-cTA","Android Tut by Innerbrain","In this ndnn jj njn jn jnj n"));
        arr_explore_items.add(new HomeFragmentModel("https://i.ytimg.com/vi/FEqF1_jDV-A/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLB2vyiSPCPrintn0roLbV0T6O-cTA","Android Tut by Innerbrain","In this ndnn jj njn jn jnj n"));
        arr_explore_items.add(new HomeFragmentModel("https://i.ytimg.com/vi/FEqF1_jDV-A/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLB2vyiSPCPrintn0roLbV0T6O-cTA","Android Tut by Innerbrain","In this ndnn jj njn jn jnj n"));
        arr_explore_items.add(new HomeFragmentModel("https://i.ytimg.com/vi/FEqF1_jDV-A/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLB2vyiSPCPrintn0roLbV0T6O-cTA","Android Tut by Innerbrain","In this ndnn jj njn jn jnj n"));
        arr_explore_items.add(new HomeFragmentModel("https://i.ytimg.com/vi/FEqF1_jDV-A/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLB2vyiSPCPrintn0roLbV0T6O-cTA","Android Tut by Innerbrain","In this ndnn jj njn jn jnj n"));
        arr_explore_items.add(new HomeFragmentModel("https://i.ytimg.com/vi/FEqF1_jDV-A/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLB2vyiSPCPrintn0roLbV0T6O-cTA","Android Tut by Innerbrain","In this ndnn jj njn jn jnj n"));
        arr_explore_items.add(new HomeFragmentModel("https://i.ytimg.com/vi/FEqF1_jDV-A/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLB2vyiSPCPrintn0roLbV0T6O-cTA","Android Tut by Innerbrain","In this ndnn jj njn jn jnj n"));
        arr_explore_items.add(new HomeFragmentModel("https://i.ytimg.com/vi/FEqF1_jDV-A/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLB2vyiSPCPrintn0roLbV0T6O-cTA","Android Tut by Innerbrain","In this ndnn jj njn jn jnj n"));
        arr_explore_items.add(new HomeFragmentModel("https://i.ytimg.com/vi/FEqF1_jDV-A/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLB2vyiSPCPrintn0roLbV0T6O-cTA","Android Tut by Innerbrain","In this ndnn jj njn jn jnj n"));


    }

    private void UIInit(View view) {
        recyclerView=view.findViewById(R.id.recyclerview_explore_fragment);
        arr_explore_items=new ArrayList<>();
    }
}