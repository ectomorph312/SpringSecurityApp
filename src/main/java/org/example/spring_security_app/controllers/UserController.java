package org.example.spring_security_app.controllers;


import org.example.spring_security_app.entity.Role;
import org.example.spring_security_app.entity.User;
import org.example.spring_security_app.repository.UserRepository;
import org.example.spring_security_app.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    @Autowired
    UserRepository userRepository;

    private final UserDetailService userDetailService;

    public UserController(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }


    @GetMapping
    public String userList(Model model) {
        userDetailService.userList(model);
        return "userList";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        userDetailService.userEditForm(user, model);
        return "userEdit";
    }

    @PostMapping
    public String userSave(
            @RequestParam(defaultValue = "false") boolean deactivate,
            @RequestParam String username,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String patronymic,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
    ) {
        userDetailService.userSave(deactivate , username, name,
                                    surname, patronymic, form, user);
        return "redirect:/user";
    }
}
