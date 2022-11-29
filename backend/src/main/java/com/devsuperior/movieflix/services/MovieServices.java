package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieServices {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Transactional(readOnly = true)
    public Page<MovieDTO> findByGenre(Long genreId, Pageable pageable) {
        if(genreId == 0){
            Page<Movie> list1 = movieRepository.findAllByOrderByTitleAsc(pageable);
            return list1.map(x -> new MovieDTO(x));
        }
        Page<Movie> list = movieRepository.findMovieByGenre(genreRepository.getOne(genreId), pageable);
        return list.map(x -> new MovieDTO(x, x.getGenre()));
    }


    public MovieDTO findById(Long id){
        Optional<Movie> obj = movieRepository.findById(id);
        Movie entity = obj.orElseThrow(() -> new ResourceNotFoundException("objeto nao encontrado"));
        return new MovieDTO(entity);
    }


    public List<ReviewDTO> findReviewsByMovie(Long id) {
        List<Review> list = reviewRepository.findByMovie_Id(id);
        return list.stream().map(x -> new ReviewDTO(x)).collect(Collectors.toList());
    }
}
