package com.devsuperior.movieflix.resources;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.services.GenreServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/genres")
@RestController
public class GenreResources {

    @Autowired
    private GenreServices genreServices;

    @GetMapping
    public ResponseEntity<List<GenreDTO>> findAll(){
        return ResponseEntity.ok().body(genreServices.findAll());
    }
}
