package com.example.c4q.soccernews.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.c4q.soccernews.R;
import com.example.c4q.soccernews.model.Articles;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SoccerAdapter extends RecyclerView.Adapter<SoccerViewHolder> {

    @SerializedName("competitions")
    private List<Articles> articlesList;

    public SoccerAdapter(List<Articles> articlesList) {
        this.articlesList = articlesList;
    }

    @NonNull
    @Override
    public SoccerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview_layout,parent,false);
        return new SoccerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SoccerViewHolder holder, int position) {
        holder.onBind(articlesList.get(position));
    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }
}
