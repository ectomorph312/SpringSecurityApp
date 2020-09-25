package org.example.spring_security_app.service;

import org.example.spring_security_app.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Map;

@Service
public interface MessageService {
    void main(Model model, String filter);
    void addMessage(User user, String text, String tag, Map<String, Object> model);
}
