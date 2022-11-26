package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreServices {

    @Autowired
    private GenreRepository genreRepository;

    public List<GenreDTO> findAll(){
        List<Genre> list = genreRepository.findAll();
        List<GenreDTO> dto = list.stream().map(x -> new GenreDTO(x)).collect(Collectors.toList());
        return dto;
    }

}
