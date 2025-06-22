package com.spring.amateur_sports_service.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
public class MatchRegisterForm {

    @NotEmpty(message = "제목은 필수 항목입니다.")
    private String title;

    @NotEmpty(message = "스포츠 종목은 필수 항목입니다.")
    private String sportsKind;

    @NotEmpty(message = "경기장 이름은 필수 항목입니다.")
    private String stadium;

    @NotEmpty(message = "경기장 주소는 필수 항목입니다.")
    private String location;

    @NotEmpty(message = "카테고리는 필수 항목입니다.")
    private String category;

    @NotEmpty(message = "활동명은 필수 항목입니다.")
    private String nickname;

    @NotNull(message = "경기 날짜는 필수 항목입니다.")
    private LocalDate matchDate;

    @NotNull(message = "경기 시작 시간은 필수 항목입니다.")
    private LocalTime startTime;

    @NotNull(message = "경기 종료 시간은 필수 항목입니다.")
    private LocalTime endTime;

    @NotEmpty(message = "경기 수준은 필수 항목입니다.")
    private String level;

    @NotEmpty(message = "경기장 총 비용은 필수 항목입니다.")
    private String totalPrice;

    @NotEmpty(message = "상대 부담 비용은 필수 항목입니다.")
    private String cost;

    @NotEmpty(message = "연락처는 필수 항목입니다.")
    private String phoneNumber;

    private String content;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;
}
