package com.example.NewsApp.repository.remoteRepository;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl("https://api.thenewsapi.com")
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static NewsApi newsApi = retrofit.create(NewsApi.class);

    public static NewsApi getNewsApi() {
        return newsApi;
    }


}
