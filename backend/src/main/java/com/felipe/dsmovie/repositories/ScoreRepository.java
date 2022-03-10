package com.felipe.dsmovie.repositories;

import com.felipe.dsmovie.entities.Score;
import com.felipe.dsmovie.entities.ScorePK;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
    
}
