package com.felipe.dsmovie.services;

import com.felipe.dsmovie.dto.MovieDTO;
import com.felipe.dsmovie.entities.Movie;
import com.felipe.dsmovie.repositories.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public Page<MovieDTO> findAll(Pageable pageable) {
        try {
            Page<Movie> result = movieRepository.findAll(pageable);

            Page<MovieDTO> page = result.map(x -> new MovieDTO(x));

            return page;
        } catch (Exception e) {
            throw e;
        }

    }

    @Transactional(readOnly = true)
    public MovieDTO findById(Long id) {
        try {
            Movie result = movieRepository.findById(id).get();
            return new MovieDTO(result);
        } catch (Exception e) {
            throw e;
        }

    }
}
