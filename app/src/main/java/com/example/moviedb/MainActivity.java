package com.example.moviedb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.moviedb.models.Movie;
import com.example.moviedb.request.Service;
import com.example.moviedb.response.MovieSearchResponse;
import com.example.moviedb.utils.MovieApi;

import java.nio.file.ClosedFileSystemException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.moviedb.utils.Credentials.API_KEY;


public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MAINACTIVITY";
    private Button testButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testButton = findViewById(R.id.testButton);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getRetrofitResponse();
            }
        });
    }

    private void getRetrofitResponse() {
        MovieApi movieApi = Service.getMovieApi();

        Call<MovieSearchResponse> responseCall = movieApi.searchMovie(API_KEY, "Evil Dead");
        responseCall.enqueue(new Callback<MovieSearchResponse>() {
            @Override
            public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {
                if (response.code() == 200) {
                    Log.i(TAG, "onResponse: "+response.body().toString());
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
}