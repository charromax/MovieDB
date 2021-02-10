package com.example.moviedb.ui.movielist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviedb.models.Movie;
import com.example.moviedb.repositories.MovieRepository;

import java.util.List;

public class MovieListViewModel extends ViewModel {

    private MovieRepository repository;

    public MovieListViewModel() {
        repository = MovieRepository.getInstance();
    }

    public LiveData<List<Movie>> getMovies() {
        return repository.getMovies();
    }


}
