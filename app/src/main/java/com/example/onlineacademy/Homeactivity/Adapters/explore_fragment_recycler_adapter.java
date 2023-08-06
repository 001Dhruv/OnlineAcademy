package com.example.onlineacademy.Homeactivity.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineacademy.API.Models.ExploreResponse;
import com.example.onlineacademy.Homeactivity.Fragments.profile.Explore;
import com.example.onlineacademy.R;
import com.example.onlineacademy.Utils.ClickHandler;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class explore_fragment_recycler_adapter extends RecyclerView.Adapter<explore_fragment_recycler_adapter.ViewHolder>{
    Context context;
    List<ExploreResponse> arrlist;
    int raw_id;
    public explore_fragment_recycler_adapter(Context context, List<ExploreResponse> arrlist, int raw_id){
        this.context=context;
        this.arrlist=arrlist;
        this.raw_id=raw_id;
        System.out.println("Adapter Constructor called...");

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(context).inflate(raw_id,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        System.out.println("ViewHolder created");
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String imageUrl = arrlist.get(position).getCourse_image();
        Picasso.get().load(imageUrl).into(holder.img);
        holder.desc.setText(arrlist.get(position).getCourse_description());
        holder.title.setText(arrlist.get(position).getCourse_name()+" by "+arrlist.get(position).getCourse_teacher_name());
        clickSetter(holder,position);
        System.out.println("TextView binded...");
        System.out.println("Binding complete..");
    }
    private void clickSetter(explore_fragment_recycler_adapter.ViewHolder holder, int position) {
            holder.desc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ClickHandler.ExploreRecyclerClick(arrlist.get(position));
                }
            });holder.title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ClickHandler.ExploreRecyclerClick(arrlist.get(position));
                }
            });holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ClickHandler.ExploreRecyclerClick(arrlist.get(position));
                }
            });
    }

    @Override
    public int getItemCount() {
        return arrlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView desc;
        ImageView img;
        public ViewHolder(@NonNull View view) {
            super(view);
            title=view.findViewById(R.id.explore_recycler_title);
            desc=view.findViewById(R.id.explore_recycler_description);
            img=view.findViewById(R.id.explore_recycler_img);
        }
    }
}
