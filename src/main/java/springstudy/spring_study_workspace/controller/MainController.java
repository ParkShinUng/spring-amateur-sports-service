package springstudy.spring_study_workspace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "index";
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
    public String register()
    {
        return "redirect:/";
    }
}
