package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

//    @Query("SELECT DISTINCT obj FROM Movie obj INNER JOIN obj.genre.id genres WHERE " +
//            ":genres IS NULL OR genres IN :genres)")
//    Page<Movie> find(Genre genres, Pageable pageable);

   // Page<Movie> findMovieByGenre(Long genreId, Pageable pageable);

//    @Query("SELECT obj FROM Movie obj JOIN FETCH obj.genre WHERE obj.id = :id ")
//    Optional<Movie> findByIdComplety(Long id);

    Page<Movie> findMovieByGenre(Genre one, Pageable pageable);

    Page<Movie> findAllByOrderByTitleAsc(Pageable pageable);
}
