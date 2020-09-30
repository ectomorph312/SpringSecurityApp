package org.example.spring_security_app.service.Impl;

import org.example.spring_security_app.entity.Role;
import org.example.spring_security_app.entity.User;
import org.example.spring_security_app.repository.UserRepository;
import org.example.spring_security_app.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void userEditForm(User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
    }

    @Override
    public void userList(Model model) {
        model.addAttribute("users", userRepository.findAll());
    }

    @Override
    public void addUser(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());

        if(userFromDB != null){
            throw new UsernameNotFoundException("Пользватель с таким именем уже существует");
        }

        user.setActive(true);
        user.setSurname(user.getSurname());
        user.setName(user.getName());
        user.setPatronymic(user.getPatronymic());
        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void userSave(boolean deactivate, String username, String name, String surname, String patronymic,String email, Map<String, String> form, User user) {
        user.setUsername(username);
        user.setName(name);
        user.setSurname(surname);
        user.setPatronymic(patronymic);
        user.setEmail(email);
        if(deactivate == true) {
            user.setActive(true);
        } else {
            user.setActive(false);
        }

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }

        userRepository.save(user);
    }
}
