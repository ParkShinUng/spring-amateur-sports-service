package com.spring.amateur_sports_service.dto;

import com.spring.amateur_sports_service.domain.Match;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class MatchDto {
    private Integer id;
    private String title;
    private String kind;
    private String nickname;
    private String phoneNumber;
    private String stadiumLocation;
    private String stadiumName;
    private String level;
    private String content;
    private String startTime;
    private String endTime;
    private String totalPrice;
    private String cost;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public MatchDto(Match match) {
        this.id = match.getId();
        this.title = match.getTitle();
        this.kind = match.getKind();
        this.nickname = match.getNickname();
        this.phoneNumber = match.getPhoneNumber();
        this.stadiumLocation = match.getStadiumLocation();
        this.stadiumName = match.getStadiumName();
        this.level = match.getLevel();
        this.content = match.getContent();
        this.startTime = format(match.getStartTime());
        this.endTime = format(match.getEndTime());
        this.totalPrice = match.getTotalPrice();
        this.cost = match.getCost();
    }

    private String format(LocalDateTime time) {
        return (time != null) ? time.format(FORMATTER) : null;
    }
}
