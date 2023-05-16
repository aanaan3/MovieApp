package com.aanaan3.movieapp.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.aanaan3.movieapp.R;
import com.aanaan3.movieapp.service.MovieDataService;
import com.aanaan3.movieapp.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
   private ArrayList<Movie> mMovies = new ArrayList<>();
   private MutableLiveData<List<Movie>> mMutableLiveData = new MutableLiveData<>();
   private Application mApplication;

    public MovieRepository(Application application) {
        mApplication = application;
    }

    public MutableLiveData<List<Movie>> getMutableLiveData(){
        MovieDataService movieDataService = RetrofitInstance.getService();

        Call<Result> call = movieDataService.getPopularMovie(mApplication.getApplicationContext().getString(R.string.api_key));

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();
                if (result != null && result.getResults() != null){
                    mMovies = (ArrayList<Movie>) result.getResults();
                    mMutableLiveData.setValue(mMovies);
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });

        return mMutableLiveData;
    }
}
