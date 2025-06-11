package com.spring.amateur_sports_service.controller;

import com.spring.amateur_sports_service.form.UserSignUpForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@RequiredArgsConstructor
@Controller
public class UserController {
    @GetMapping("/login")
    public String login() {
        return "sign_in_form";
    }

    @GetMapping("/signup")
    public String signUp(UserSignUpForm userSignUpForm) {
        return "sign_up_form";
    }
}
