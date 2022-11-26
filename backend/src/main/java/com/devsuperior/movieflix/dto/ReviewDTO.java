package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Movie;

public class ReviewDTO {

    private String Text;
    private Long movieId;

    public ReviewDTO(){

    }

    public ReviewDTO(String text, Long movieId) {
        Text = text;
        this.movieId = movieId;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}
