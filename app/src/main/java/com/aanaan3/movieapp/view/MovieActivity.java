package com.aanaan3.movieapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.aanaan3.movieapp.R;
import com.aanaan3.movieapp.databinding.ActivityMovieBinding;
import com.aanaan3.movieapp.model.Movie;

public class MovieActivity extends AppCompatActivity {
    private Movie movie;
    private ActivityMovieBinding activityMovieBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);


//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        activityMovieBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie);

        Intent i = getIntent();

        if (i != null) {
            movie = i.getParcelableExtra("movie");
            activityMovieBinding.setMovie(movie);
            getSupportActionBar().setTitle(movie.getTitle());

        }


    }
}