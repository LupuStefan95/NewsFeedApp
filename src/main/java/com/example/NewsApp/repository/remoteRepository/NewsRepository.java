package com.example.NewsApp.repository.remoteRepository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepository {

    private static NewsRepository instance;
    private MutableLiveData<NewsFeed> feed;

    private NewsRepository() {
        feed = new MutableLiveData<NewsFeed>();
    }

    public static synchronized NewsRepository getInstance() {
        if (instance == null) {
            instance = new NewsRepository();
        }
        return instance;
    }

    public LiveData<NewsFeed> getNewsFeed() {
        return feed;
    }

    public void updateNewsFeed() {
        NewsApi newsApi = ServiceGenerator.getNewsApi();
        Call<NewsRespons> call = newsApi.getNews();
        call.enqueue(new Callback<NewsRespons>() {
            @Override
            public void onResponse(Call<NewsRespons> call, Response<NewsRespons> response) {
                if (response.code() == 200) {
                    feed.setValue(response.body().getNewsFeed());
                }
            }

            @Override
            public void onFailure(Call<NewsRespons> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }
}
