package com.example.moviedb.response;

import com.example.moviedb.models.Movie;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieResponse {
    @SerializedName("results")
    @Expose()
    private Movie movie;

    public Movie getMovie(){
        return movie;
    }

    @Override
    public String toString() {
        return "MovieResponse{" +
                "movie=" + movie.getTitle() +
                '}';
    }
}
