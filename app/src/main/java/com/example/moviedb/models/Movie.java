package com.example.moviedb.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Movie implements Parcelable {

    private int id;
    private String title;
    private String poster_path;
    private String release_date;
    private Boolean adult;
    private String original_language;
    private String overview;
    private int runtime;
    private float vote_average;
    private int vote_count;
    private ArrayList<Genre> genres;

    public Movie(int id, String title, String poster_path, String release_date, Boolean adult, String original_language, String overview, int runtime, float vote_average, int vote_count, ArrayList<Genre> genres) {
        this.id = id;
        this.title = title;
        this.poster_path = poster_path;
        this.release_date = release_date;
        this.adult = adult;
        this.original_language = original_language;
        this.overview = overview;
        this.runtime = runtime;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
        this.genres = genres;
    }

    protected Movie(Parcel in) {
        id = in.readInt();
        title = in.readString();
        poster_path = in.readString();
        release_date = in.readString();
        byte tmpAdult = in.readByte();
        adult = tmpAdult == 0 ? null : tmpAdult == 1;
        original_language = in.readString();
        overview = in.readString();
        runtime = in.readInt();
        vote_average = in.readFloat();
        vote_count = in.readInt();
        genres = in.createTypedArrayList(Genre.CREATOR);
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public Boolean getAdult() {
        return adult;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public String getOverview() {
        return overview;
    }

    public int getRuntime() {
        return runtime;
    }

    public float getVote_average() {
        return vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(poster_path);
        parcel.writeString(release_date);
        parcel.writeByte((byte) (adult == null ? 0 : adult ? 1 : 2));
        parcel.writeString(original_language);
        parcel.writeString(overview);
        parcel.writeInt(runtime);
        parcel.writeFloat(vote_average);
        parcel.writeInt(vote_count);
        parcel.writeTypedList(genres);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", release_date='" + release_date + '\'' +
                ", adult=" + adult +
                ", original_language='" + original_language + '\'' +
                ", overview='" + overview + '\'' +
                ", runtime=" + runtime +
                ", vote_average=" + vote_average +
                ", vote_count=" + vote_count +
                ", genres=" + genres +
                '}';
    }
}
