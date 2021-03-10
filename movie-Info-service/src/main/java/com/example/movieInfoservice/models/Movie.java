package com.example.movieInfoservice.models;

public class Movie {

    private String movieid;
    private String name;

    public Movie(String movieid, String name) {
        this.movieid = movieid;
        this.name = name;
    }

    public String getMovieid() {
        return movieid;
    }

    public String getName() {
        return name;
    }

    public void setMovieid(String movieid) {
        this.movieid = movieid;
    }

    public void setName(String name) {
        this.name = name;
    }
}
