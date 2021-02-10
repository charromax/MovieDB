package com.example.moviedb;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.moviedb.models.Movie;
import com.example.moviedb.request.Service;
import com.example.moviedb.response.MovieSearchResponse;
import com.example.moviedb.ui.movielist.MovieListViewModel;
import com.example.moviedb.utils.MovieApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.moviedb.utils.Credentials.API_KEY;


public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MAINACTIVITY";
    private Button testButton;

    private MovieListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testButton = findViewById(R.id.testButton);
        viewModel = new ViewModelProvider(this).get(MovieListViewModel.class);

    }

    //observe data changes
    private void observe() {
        viewModel.getMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                Log.i(TAG, "onChanged: " + movies);
            }
        });
    }

    private void getRetrofitResponse() {
        MovieApi movieApi = Service.getMovieApi();

        Call<MovieSearchResponse> responseCall = movieApi.searchMovie(API_KEY, "dead");
        responseCall.enqueue(new Callback<MovieSearchResponse>() {
            @Override
            public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {
                if (response.code() == 200) {
                    Log.i(TAG, "onResponse: " + response.body().toString());
                    List<Movie> movies = new ArrayList<>(response.body().getMovies());

                    for (Movie movie: movies) {
                        Log.i(TAG, "onResponse: " + movie.getTitle());
                    }
                } else {
                    try {
                        Log.i(TAG, "onResponse: " + response.errorBody().toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieSearchResponse> call, Throwable t) {

            }
        });
    }

    private void getSingleMovie() {
        MovieApi movieApi = Service.getMovieApi();

        Call<Movie> responseCall = movieApi.getMovie(550, API_KEY);
        responseCall.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (response.code() == 200) {
                    Movie movie = response.body();
                    Log.i(TAG, "onResponse: " + movie);
                } else {
                    try {
                        Log.i(TAG, "onResponse: " + response.errorBody().toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

            }
        });
    }

}