package com.spring.amateur_sports_service.service;

import com.spring.amateur_sports_service.common.DataNotFoundException;
import com.spring.amateur_sports_service.domain.Match;
import com.spring.amateur_sports_service.form.MatchRegisterForm;
import com.spring.amateur_sports_service.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MatchService {
    private final MatchRepository matchRepository;
    private final ApiService apiService;

    public List<Match> getMatchList() {
        return this.matchRepository.findAll();
    }

    public Match getMatch(Integer id) {
        Optional<Match> match = this.matchRepository.findById(id);
        if (match.isPresent()) {
            return match.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }

    public void create(MatchRegisterForm matchRegisterForm) {
        Match match = new Match();
        match.setTitle(matchRegisterForm.getTitle());
        match.setStadiumLocation(matchRegisterForm.getLocation());
        match.setCategory("match");
        match.setKind(matchRegisterForm.getSportsKind());
        match.setNickname(matchRegisterForm.getNickname());
        match.setMatchDate(matchRegisterForm.getMatchDate());
        match.setStartTime(matchRegisterForm.getStartTime());
        match.setEndTime(matchRegisterForm.getEndTime());
        match.setStadiumName(matchRegisterForm.getStadium());
        match.setLevel(matchRegisterForm.getLevel());
        match.setTotalPrice(matchRegisterForm.getTotalPrice());
        match.setCost(matchRegisterForm.getCost());
        match.setPhoneNumber(matchRegisterForm.getPhoneNumber());
        match.setContent(matchRegisterForm.getContent());
        match.setCreateDate(LocalDateTime.now());

        this.matchRepository.save(match);
    }

    public Map<String, List<String>> getAdministrativeData() {
        return apiService.getAdministrativeData();
    }

}
