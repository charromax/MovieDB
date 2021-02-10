package com.example.moviedb.repositories;

import androidx.lifecycle.LiveData;

import com.example.moviedb.models.Movie;
import com.example.moviedb.request.MovieApiClient;

import java.util.List;

public class MovieRepository {
    private static MovieRepository instance;
    private MovieApiClient client;


    public static MovieRepository getInstance() {
        if (instance == null) {
            instance = new MovieRepository();
        }
        return instance;
    }

    private MovieRepository() {
        client = MovieApiClient.getInstance();
    }

    public LiveData<List<Movie>> getMovies() {
        return client.getMovies();
    }
}
