package com.spring.amateur_sports_service.repository;

import com.spring.amateur_sports_service.domain.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Integer>{

}
