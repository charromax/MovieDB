package com.example.moviedb.response;

import com.example.moviedb.models.Movie;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieSearchResponse {
    @SerializedName("total_results")
    @Expose()
    private int count;

    @SerializedName("results")
    @Expose()
    private ArrayList<Movie> movies;

    public int getCount(){
        return count;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    @Override
    public String toString() {
        return "MovieSearchResponse{" +
                "count=" + count +
                ", movies=" + movies +
                '}';
    }
}
