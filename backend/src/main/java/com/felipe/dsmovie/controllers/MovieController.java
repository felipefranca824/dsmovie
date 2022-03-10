package com.felipe.dsmovie.controllers;

import com.felipe.dsmovie.dto.MovieDTO;
import com.felipe.dsmovie.services.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
    
    @Autowired
    private MovieService movieService;

    @GetMapping
    public Page<MovieDTO> findAll(Pageable pageable){
        try {
            return movieService.findAll(pageable);
        } catch (Exception e) {
            throw e;
        }
        
    }

    @GetMapping(value = "/{id}")
    public MovieDTO findById(@PathVariable Long id){
        try {
            return movieService.findById(id);
        } catch (Exception e) {
            throw e;
        }
        
    }
}
