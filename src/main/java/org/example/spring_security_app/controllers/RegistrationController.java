package org.example.spring_security_app.controllers;


import org.example.spring_security_app.entity.User;
import org.example.spring_security_app.service.UserDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private final UserDetailService userDetailService;

    public RegistrationController(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute User user) {
        userDetailService.addUser(user);
        return "redirect:/login";
    }
}
