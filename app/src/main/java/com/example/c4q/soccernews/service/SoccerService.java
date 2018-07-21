package com.example.c4q.soccernews.service;

import com.example.c4q.soccernews.model.TopHeadlines;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SoccerService {
    @GET("/v2/top-headlines?sources=four-four-two&apiKey=0d892b23ea954f009704a14c03a32777")
    Call<TopHeadlines> getArticles();
}
