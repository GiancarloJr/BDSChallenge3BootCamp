package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServices {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private AuthService authService;


    public ReviewDTO insert(ReviewDTO reviewDTO){
        Review entity = new Review();
        entity.setId(reviewDTO.getId());
        entity.setText(reviewDTO.getText());
        entity.setMovie(movieRepository.getOne(reviewDTO.getMovieId()));
        entity.setUser(authService.authenticated());
        return new ReviewDTO(reviewRepository.save(entity));
    }
}
