package com.example.NewsApp.repository.remoteRepository;

import java.util.List;

public class NewsFeed {

    private List<News> feed;

    public List<News> getFeed() {
        return feed;
    }

    public NewsFeed(List<News> feed) {
        this.feed = feed;
    }
}
