package com.example.onlineacademy.Homeactivity.Adapters;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineacademy.API.Instance;
import com.example.onlineacademy.API.Models.HomeResponse;
import com.example.onlineacademy.R;
import com.example.onlineacademy.Utils.ClickHandler;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class home_fragment_recycler_adapter extends RecyclerView.Adapter<home_fragment_recycler_adapter.ViewHolder>{
    Context context;
    List<HomeResponse> arrlist;
    ProgressDialog progressDialog;
    int raw_id;
    public home_fragment_recycler_adapter(Context context, List<HomeResponse> arrlist, int raw_id){
        this.context=context;
        this.arrlist=arrlist;
        this.raw_id=raw_id;
        Log.e("adapter_home_set","Adapter Constructor called...");
        System.out.println("Adapter Constructor called...");

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(context).inflate(raw_id,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        System.out.println("ViewHolder created");
        Log.e("adapter_home_set","View Holder created");
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String imageUrl = "https://brahminnerbrain.com/online_tuition_class/storage/app/"+arrlist.get(position).getCourse_image();
        Log.e("img_url",imageUrl);
        Picasso.get().load(imageUrl).into(holder.img);
        holder.desc.setText(arrlist.get(position).getCourse_description());
        holder.prog.setText("");
        holder.title.setText(arrlist.get(position).getCourse_name().toUpperCase()+" by "+arrlist.get(position).getCourse_teacher_name());
        clickSetter(holder,position);
        System.out.println("TextView binded...");
        System.out.println("Binding complete..");
        Log.e("adapter_home_set","Bindind=g complete");


    }

    private void clickSetter(ViewHolder holder,int position) {
        holder.desc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickHandler.HomeRecyclerClick(view,arrlist.get(position));
            }
        });holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickHandler.HomeRecyclerClick(view,arrlist.get(position));
            }
        });holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickHandler.HomeRecyclerClick(view,arrlist.get(position));
            }
        });holder.prog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickHandler.HomeRecyclerClick(view,arrlist.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.e("adapter_home_set",Integer.toString(arrlist.size()));
        return arrlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView desc;
        TextView prog;
        ImageView img;
        public ViewHolder(@NonNull View view) {
            super(view);
            title=view.findViewById(R.id.home_recycler_title);
            desc=view.findViewById(R.id.home_recycler_description);
            prog=view.findViewById(R.id.home_recycler_progress);
            img=view.findViewById(R.id.home_recycler_img);
        }
    }
}
