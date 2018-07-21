package com.example.c4q.soccernews.model;

import com.google.gson.annotations.SerializedName;

public class Articles {
    @SerializedName("publishedAt")
    private String publishedat;
    @SerializedName("urlToImage")
    private String urltoimage;
    @SerializedName("url")
    private String url;
    @SerializedName("description")
    private String description;
    @SerializedName("title")
    private String title;
    @SerializedName("author")
    private String author;
    @SerializedName("source")
    private Source source;

    public String getPublishedat() {
        return publishedat;
    }

    public String getUrltoimage() {
        return urltoimage;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Source getSource() {
        return source;
    }
}
