package com.aanaan3.movieapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.aanaan3.movieapp.model.Movie;
import com.aanaan3.movieapp.model.MovieRepository;

import java.util.List;

public class MainActivityViewModel  extends AndroidViewModel {
    private MovieRepository mMovieRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        mMovieRepository = new MovieRepository(application);
    }

    // Live Data
    public LiveData<List<Movie>> getAllMovies(){
        return mMovieRepository.getMutableLiveData();
    }
}
