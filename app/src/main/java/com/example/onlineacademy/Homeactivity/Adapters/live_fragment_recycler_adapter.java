package com.example.onlineacademy.Homeactivity.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineacademy.API.LiveResponse;
import com.example.onlineacademy.R;
import com.example.onlineacademy.Utils.ClickHandler;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class live_fragment_recycler_adapter extends RecyclerView.Adapter<live_fragment_recycler_adapter.ViewHolder>{
    Context context;
    List<LiveResponse> arrlist;
    int raw_id;
    public live_fragment_recycler_adapter(Context context, List<LiveResponse> arrlist, int raw_id){
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
        String imageUrl = "https://brahminnerbrain.com/online_tuition_class/storage/app/"+arrlist.get(position).getYoutube_image();
        Picasso.get().load(imageUrl).into(holder.img);
        holder.desc.setText(arrlist.get(position).getYoutube_description());
        holder.title.setText(arrlist.get(position).getYoutube_title());
        clickSetter(holder,position);
        System.out.println("TextView binded...");
        System.out.println("Binding complete..");
    }

    private void clickSetter(ViewHolder holder, int position) {
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClickHandler.HomeVideoPlayer(arrlist.get(position).getYoutube_video_url());
            }
        });holder.desc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClickHandler.HomeVideoPlayer(arrlist.get(position).getYoutube_video_url());
            }
        });holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClickHandler.HomeVideoPlayer(arrlist.get(position).getYoutube_video_url());
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
            title=view.findViewById(R.id.live_classes_recycler_title);
            desc=view.findViewById(R.id.live_classes_recycler_description);
            img=view.findViewById(R.id.live_classes_fragment_recycler_img);
        }
    }
}
