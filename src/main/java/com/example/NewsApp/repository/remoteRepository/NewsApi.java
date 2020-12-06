package com.example.NewsApp.repository.remoteRepository;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsApi {
        @GET("/v1/news/all?api_token=fKbRJM4L2DE0TylOeqRPPV4toZzEaEjGcwtlwaEg")
        Call<NewsRespons> getNews();
}
