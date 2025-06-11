package com.spring.amateur_sports_service.controller;

import com.spring.amateur_sports_service.controller.SupporterForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.Member;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "home/index";
    }

    @GetMapping("/search")
    public String search() {
        return "searchForm";
    }

    @GetMapping("/register")
    public String registerForm() {
        return "registerForm";
    }

    @PostMapping("/register/new")
    public String register(SupporterForm supporterForm)
    {
//        Member supporterMember = new Member();
//        supporterMember.setName(supporterForm.getName());
        return "redirect:/";
    }
}
