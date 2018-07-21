package com.example.c4q.soccernews.networking;

import com.example.c4q.soccernews.service.SoccerService;

public class Common {

    private static final String BASE_URL = "https://newsapi.org";

    public static SoccerService getSoccer() {
        return RetrofitClient.getRetrofitClient(BASE_URL).create(SoccerService.class);
    }
}
