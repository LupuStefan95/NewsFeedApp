package com.example.NewsApp.repository.remoteRepository;

import java.util.List;

public class NewsRespons {

    private List<News> data;

    public NewsFeed getNewsFeed(){
        return new NewsFeed(data);
    }
}
