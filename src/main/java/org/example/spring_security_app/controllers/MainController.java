package org.example.spring_security_app.controllers;

import org.example.spring_security_app.entity.User;
import org.example.spring_security_app.repository.MessageRepository;
import org.example.spring_security_app.service.MessageDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    MessageRepository messageRepository;

    private final MessageDetailService messageDetailService;

    public MainController(MessageDetailService messageDetailService) {
        this.messageDetailService = messageDetailService;
    }


    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam (required = false, defaultValue = "") String filter,
            Model model) {
        messageDetailService.main(model, filter);
        return "main";
    }

    @PostMapping("/main")
    public String addMessage(@AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag, Map<String, Object> model) {
        messageDetailService.addMessage(user, text, tag, model);
        return "main";
    }
}
