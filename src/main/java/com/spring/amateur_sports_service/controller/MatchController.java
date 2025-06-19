package com.spring.amateur_sports_service.controller;

import com.spring.amateur_sports_service.domain.Match;
import com.spring.amateur_sports_service.dto.MatchRegisterForm;
import com.spring.amateur_sports_service.service.MatchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/match")
@Controller
public class MatchController {
    private final MatchService matchService;

    @GetMapping("/list")
    public String search(Model model) {
        List<Match> matchList =  this.matchService.getMatchList();
        model.addAttribute("matchList", matchList);

        return "/match/match_list";
    }

    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Match match = this.matchService.getMatch(id);
        model.addAttribute("match", match);
        return "/match/match_detail";
    }

    @GetMapping("/register")
    public String register(MatchRegisterForm matchRegisterForm, Model model) {
        List<String> sportsKindList = List.of("축구", "풋살", "농구", "야구", "배드민턴", "테니스");
        model.addAttribute("sportsKindList", sportsKindList);
        model.addAttribute("matchRegisterForm", new MatchRegisterForm());
        return "match/match_form";
    }

    @PostMapping("/register")
    public String register(@Valid MatchRegisterForm matchRegisterForm, Model model,
                           BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "match/register";
        }

        this.matchService.create(matchRegisterForm);
        return "match/match_list";
    }
}
