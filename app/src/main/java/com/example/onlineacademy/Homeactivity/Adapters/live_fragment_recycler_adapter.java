package com.example.onlineacademy.Homeactivity.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineacademy.Homeactivity.Models.HomeFragmentModel;
import com.example.onlineacademy.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class live_fragment_recycler_adapter extends RecyclerView.Adapter<live_fragment_recycler_adapter.ViewHolder>{
    Context context;
    ArrayList<HomeFragmentModel> arrlist;
    int raw_id;
    public live_fragment_recycler_adapter(Context context, ArrayList<HomeFragmentModel> arrlist, int raw_id){
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
        String imageUrl = arrlist.get(position).img;
        Picasso.get().load(imageUrl).into(holder.img);
        holder.desc.setText(arrlist.get(position).desc);
        holder.title.setText(arrlist.get(position).title);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Call the method which passes intent to the video player. pass the link of that video as parameter to the method.
                //Do the same thing for image,prog and title.
//                this will work for live classes too
            }
        });
        System.out.println("TextView binded...");
        System.out.println("Binding complete..");
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