package com.felipe.dsmovie.controllers;

import com.felipe.dsmovie.dto.MovieDTO;
import com.felipe.dsmovie.dto.ScoreDTO;
import com.felipe.dsmovie.services.ScoreService;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @PutMapping
    public MovieDTO saveScore(@RequestBody ScoreDTO dto){
        try {
            MovieDTO movieDto = scoreService.saveScore(dto);
            return movieDto;
        } catch (Exception e) {
            throw e;
        }
        
    }
}
