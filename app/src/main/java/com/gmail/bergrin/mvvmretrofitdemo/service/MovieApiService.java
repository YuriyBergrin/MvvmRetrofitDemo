package com.gmail.bergrin.mvvmretrofitdemo.service;

import com.gmail.bergrin.mvvmretrofitdemo.model.MovieApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {
    @GET("movie/popular")
    Call<MovieApiResponse> getPopularMovies(@Query("api_key") String apiKey);
}
