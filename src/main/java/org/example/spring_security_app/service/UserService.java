package org.example.spring_security_app.service;

import org.example.spring_security_app.entity.User;
import org.springframework.ui.Model;

import java.util.Map;

public interface UserService {
    void userEditForm(User user, Model model);
    void userList(Model model);
    void addUser(User user);
    void userSave(boolean deactivate,
                  String username,
                  String name,
                  String surname,
                  String patronymic,
                  Map<String, String> form,
                  User user
    );

}
