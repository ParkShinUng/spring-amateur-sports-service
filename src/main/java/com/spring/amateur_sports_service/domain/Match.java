package com.spring.amateur_sports_service.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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
    private String teamName;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String level;

    private String totalPrice;

    private String cost;

    private String phoneNumber;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
}
