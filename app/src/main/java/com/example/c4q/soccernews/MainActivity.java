package com.example.c4q.soccernews;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.c4q.soccernews.model.Articles;
import com.example.c4q.soccernews.model.TopHeadlines;
import com.example.c4q.soccernews.networking.Common;
import com.example.c4q.soccernews.recyclerview.SoccerAdapter;
import com.example.c4q.soccernews.service.SoccerService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView newsSourceTextview;
    private RecyclerView soccerRecyclerView;
    private SoccerService soccerService;
    private SoccerAdapter soccerAdapter;
    private List<Articles> articlesList = new ArrayList<>();
    private String titleNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();
        soccerNetworkingCall();
        checkOrientation();

    }

    private void setViews() {
        newsSourceTextview = findViewById(R.id.newssource_textview);
        soccerRecyclerView = findViewById(R.id.recycler_view_news);
        soccerService = Common.getSoccer();
    }

    private void checkOrientation() {
        if (MainActivity.this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            soccerRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        } else {
            soccerRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        }
    }

    private void soccerNetworkingCall() {
        soccerService.getArticles().enqueue(new Callback<TopHeadlines>() {
            @Override
            public void onResponse(Call<TopHeadlines> call, Response<TopHeadlines> response) {
                articlesList = response.body().getArticles();
                soccerAdapter = new SoccerAdapter(articlesList);
                soccerRecyclerView.setAdapter(soccerAdapter);
            }

            @Override
            public void onFailure(Call<TopHeadlines> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
