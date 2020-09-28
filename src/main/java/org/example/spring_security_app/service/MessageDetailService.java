package org.example.spring_security_app.service;

import org.example.spring_security_app.entity.Message;
import org.example.spring_security_app.entity.User;
import org.example.spring_security_app.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Map;

@Service
public class MessageDetailService {
    @Autowired
    private MessageRepository messageRepository;

    public void main(Model model,String filter) {
        Iterable<Message> messages;

        if (filter != null && !filter.isEmpty()) {
            messages = messageRepository.findByTag(filter);
        } else {
            messages = messageRepository.findAll();
        }
        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);
    }

    public void addMessage(User user, String text, String tag, Map<String, Object> model) {
        Message message = new Message(text, tag, user);
        messageRepository.save(message);

        Iterable<Message> messages = messageRepository.findAll();
        model.put("messages", messages);
    }

}
