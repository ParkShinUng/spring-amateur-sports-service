package com.spring.amateur_sports_service.repository;

import com.spring.amateur_sports_service.domain.Supporter;

import java.util.List;
import java.util.Optional;

public interface SupporterRepository {
    Supporter save(Supporter supporter);
    Optional<Supporter> findById(Long id);
    Optional<Supporter> findByGroundName(String groundName);
    Optional<Supporter> findByMatchDate(String date);
    Optional<Supporter> findByGroundAddress(String groundAddress);
    List<Supporter> findAll();
}
