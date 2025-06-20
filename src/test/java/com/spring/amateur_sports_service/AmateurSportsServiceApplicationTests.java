package com.spring.amateur_sports_service;

import com.spring.amateur_sports_service.domain.Match;
import com.spring.amateur_sports_service.repository.MatchRepository;
import jakarta.persistence.Column;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@SpringBootTest
class AmateurSportsServiceApplicationTests {

	@Autowired
	private MatchRepository matchRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testCreateMatch() {
		for (int i = 2; i < 7; i++)
		{
			Match match = new Match();
			match.setTitle("Test Title " + i);
			match.setKind("Test kind " + i);
			match.setStadiumName("Test Stadium " + i);
			match.setStadiumLocation("Test Stadium Location " + i);

			match.setMatchDate(LocalDate.now());
			match.setStartTime(LocalTime.now());
			match.setEndTime(LocalTime.now());
			match.setCreateDate(LocalDateTime.now());

			match.setNickname("Test nickname " + i);
			match.setLevel("Test Level " + i);
			match.setPhoneNumber("Test Phone Number " + i);

			match.setTotalPrice("Test Total Price " + i);
			match.setCost("Test Cost " + i);

			match.setContent("Test Content " + i);

			this.matchRepository.save(match);
		}
	}

}
