package com.spring.amateur_sports_service;

import com.spring.amateur_sports_service.domain.Match;
import com.spring.amateur_sports_service.repository.MatchRepository;
import jakarta.persistence.Column;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class AmateurSportsServiceApplicationTests {

	@Autowired
	private MatchRepository matchRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testCreateMatch() {
		Match match = new Match();
		match.setTitle("Test Title 1");
		match.setKind("Test kind 1");
		match.setStadiumName("Test Stadium 1");
		match.setStadiumLocation("Test Stadium Location 1");

		match.setStartTime(LocalDateTime.now());
		match.setEndTime(LocalDateTime.now());
		match.setCreateDate(LocalDateTime.now());

		match.setTeamName("Test name 1");
		match.setLevel("Test Level 1");
		match.setPhoneNumber("Test Phone Number 1");

		match.setTotalPrice("Test Total Price 1");
		match.setCost("Test Cost 1");

		match.setContent("Test Content 1");

		this.matchRepository.save(match);
	}

}
