package org.example.spring_security_app.service.Impl;

import org.example.spring_security_app.entity.Message;
import org.example.spring_security_app.entity.User;
import org.example.spring_security_app.repository.MessageRepository;
import org.example.spring_security_app.service.MessageService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Map;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    @Override
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

    @Override
    public void addMessage(User user, String text, String tag, Map<String, Object> model) {
        Message message = new Message(text, tag, user);
        messageRepository.save(message);

        Iterable<Message> messages = messageRepository.findAll();
        model.put("messages", messages);
    }
}
