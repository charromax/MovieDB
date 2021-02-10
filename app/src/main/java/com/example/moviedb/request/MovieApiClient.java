package com.example.moviedb.request;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.moviedb.models.Movie;

import java.util.List;

public class MovieApiClient {
    private MutableLiveData<List<Movie>> mMovies;

    private static MovieApiClient instance;

    public static MovieApiClient getInstance() {
        if (instance == null) instance = new MovieApiClient();
        return instance;
    }

    private MovieApiClient() {
        mMovies = new MutableLiveData<>();
    }

    public LiveData<List<Movie>> getMovies() {
        return mMovies;
    }
}
