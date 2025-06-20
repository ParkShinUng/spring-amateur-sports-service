package com.spring.amateur_sports_service.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String title;

    private String kind;

    private String stadiumName;

    private String stadiumLocation;

    private String category;

//    @ManyToOne
//    private SiteUser author;
    private String nickname;

    private LocalDate matchDate;

    private LocalTime startTime;

    private LocalTime endTime;

    private String level;

    private String totalPrice;

    private String cost;

    private String phoneNumber;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
}
