package com.felipe.dsmovie.services;

import com.felipe.dsmovie.dto.MovieDTO;
import com.felipe.dsmovie.dto.ScoreDTO;
import com.felipe.dsmovie.entities.Movie;
import com.felipe.dsmovie.entities.Score;
import com.felipe.dsmovie.entities.User;
import com.felipe.dsmovie.repositories.MovieRepository;
import com.felipe.dsmovie.repositories.ScoreRepository;
import com.felipe.dsmovie.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScore(ScoreDTO dto){
        User user = userRepository.findByEmail(dto.getEmail());
        if(user == null){
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.saveAndFlush(user);
        }
        
        Movie movie = movieRepository.findById(dto.getMovieId()).get();
        
        Score score = new Score();
        score.setUser(user);
        score.setMovie(movie);
        score.setValue(dto.getScore());

        score = scoreRepository.saveAndFlush(score);

        double sum = 0;
        for (Score s : movie.getScores()) {
            sum += s.getValue();
        }

        double avg = sum / movie.getScores().size();

        movie.setScore(avg);
        movie.setCount(movie.getScores().size());

        movie = movieRepository.save(movie);

        return new MovieDTO(movie);
        
    }
}
