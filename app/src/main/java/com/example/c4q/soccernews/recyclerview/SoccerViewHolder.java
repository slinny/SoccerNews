package com.example.c4q.soccernews.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.c4q.soccernews.MainActivity;
import com.example.c4q.soccernews.R;
import com.example.c4q.soccernews.WebActivity;
import com.example.c4q.soccernews.model.Articles;
import com.example.c4q.soccernews.model.TopHeadlines;
import com.squareup.picasso.Picasso;

public class SoccerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private CardView headlineCardview;
    private TextView newsTitleTextview,descriptionTextview;
    private ImageView newsImageView;
    private String url;
    private Context context;

    public SoccerViewHolder(View itemView) {
        super(itemView);
        headlineCardview = itemView.findViewById(R.id.headline_news_cardview);
        newsImageView = itemView.findViewById(R.id.headline_news_image_view);
        newsTitleTextview = itemView.findViewById(R.id.headline_news_title_textview);
        descriptionTextview = itemView.findViewById(R.id.description_textview);
        context = itemView.getContext();
        headlineCardview.setOnClickListener(this);
    }

    public void onBind(Articles response){
        newsTitleTextview.setText("" + response.getTitle());
        descriptionTextview.setText("" + response.getDescription());
        Picasso.with(itemView.getContext()).load(response.getUrltoimage()).into(newsImageView);
        url = response.getUrl();
    }

    @Override
    public void onClick(View view) {
        Intent intent= new Intent(context, WebActivity.class);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }

}
