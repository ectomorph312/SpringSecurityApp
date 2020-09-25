package org.example.spring_security_app.controllers;


import org.example.spring_security_app.entity.User;
import org.example.spring_security_app.service.Impl.UserServiceImpl;
import org.example.spring_security_app.service.UserDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private final UserServiceImpl userServiceImpl;

    public RegistrationController(UserDetailService userDetailService, UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute User user) {
        userServiceImpl.addUser(user);
        return "redirect:/login";
    }
}
