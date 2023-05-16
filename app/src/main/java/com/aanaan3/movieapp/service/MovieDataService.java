package com.aanaan3.movieapp.service;

import com.aanaan3.movieapp.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDataService {
  // End point URL
 @GET("movie/popular")
 Call<Result> getPopularMovie(@Query("api_key") String apiKey);

}
