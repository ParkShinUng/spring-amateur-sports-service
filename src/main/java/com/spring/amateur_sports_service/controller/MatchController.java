package com.spring.amateur_sports_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/match")
@RequiredArgsConstructor
@Controller
public class MatchController {
    @GetMapping("/list")
    public String search() {
        return "/match/match_list";
    }
}
