package org.example.spring_security_app.controllers;


import org.example.spring_security_app.entity.User;
import org.example.spring_security_app.repository.UserRepository;
import org.example.spring_security_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    @Autowired
    UserRepository userRepository;

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String userList(Model model) {
        userService.userList(model);
        return "userList";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        userService.userEditForm(user, model);
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
        userService.userSave(deactivate , username, name,
                                    surname, patronymic, form, user);
        return "redirect:/user";
    }
}
