package com.spring.amateur_sports_service.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.amateur_sports_service.domain.Match;
import com.spring.amateur_sports_service.dto.MatchDto;
import com.spring.amateur_sports_service.form.MatchRegisterForm;
import com.spring.amateur_sports_service.service.ApiService;
import com.spring.amateur_sports_service.service.MatchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/match")
@Controller
public class MatchController {
    private final MatchService matchService;

    List<String> sportsKindList = List.of("축구", "풋살", "농구", "야구", "배드민턴", "테니스");

    @GetMapping("/list")
    public String search(Model model) {
        List<Match> matchList =  this.matchService.getMatchList();
        model.addAttribute("matchList", matchList);

        return "/match/match_list";
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchDto> getMatchDetail(@PathVariable Integer id) {
        Match match = this.matchService.getMatch(id);
        return ResponseEntity.ok(new MatchDto(match));
    }

    @GetMapping("/register")
    public String register(MatchRegisterForm matchRegisterForm, Model model) {
        Map<String, List<String>> administrativeData = this.matchService.getAdministrativeData();
        model.addAttribute("sportsKindList", sportsKindList);
        model.addAttribute("sidoList", new ArrayList<>(administrativeData.keySet()));
        model.addAttribute("administrativeData", administrativeData);
        return "match/match_form";
    }

    @PostMapping("/register")
    public String register(@Valid MatchRegisterForm matchRegisterForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("sportsKindList", sportsKindList);
            return "match/match_form";
        }
        this.matchService.create(matchRegisterForm);
        return "redirect:/match/list";
    }

}
