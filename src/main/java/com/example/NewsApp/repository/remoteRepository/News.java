package com.example.NewsApp.repository.remoteRepository;

import java.util.Date;

public class News {
    private String title;
    private String description;
    private String url;
    private Date published_at;

   /* public News(String title, String description, String url, String publishied_at) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.publishied_at = publishied_at;
    }*/


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public Date getPublishDate() {
        return published_at;
    }
}