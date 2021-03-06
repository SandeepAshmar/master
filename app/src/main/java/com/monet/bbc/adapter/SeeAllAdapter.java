package com.monet.bbc.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.monet.bbc.R;

import java.util.ArrayList;

public class SeeAllAdapter extends RecyclerView.Adapter<SeeAllAdapter.ViewHolder> {

    Context context;
    boolean isGridView = false;
    ArrayList<String> imageList;

    public SeeAllAdapter(Context mContext, ArrayList<String> imageList, boolean isGridView) {
        this.context = mContext;
        this.isGridView = isGridView;
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        if (isGridView) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_trending_grid, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_trending, parent, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(imageList.get(position)).into(holder.imageView);
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.item_animation_fall_down);
        animation.setDuration(500);
        holder.itemView.startAnimation(animation);
    }



    @Override
    public int getItemCount() {
        return imageList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_trending_item);
        }
    }
}
