package com.example.c4q.soccernews.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TopHeadlines {

    @SerializedName("articles")
    private List<Articles> articles;
    @SerializedName("totalResults")
    private int totalresults;
    @SerializedName("status")
    private String status;

    public List<Articles> getArticles() {
        return articles;
    }

    public int getTotalresults() {
        return totalresults;
    }

    public String getStatus() {
        return status;
    }
}
