package org.example.spring_security_app.service.Impl;

import org.example.spring_security_app.entity.Todo;
import org.example.spring_security_app.entity.TodoStatus;
import org.example.spring_security_app.entity.User;
import org.example.spring_security_app.repository.TodoRepository;
import org.example.spring_security_app.repository.UserRepository;
import org.example.spring_security_app.service.TodoService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    public TodoServiceImpl(TodoRepository todoRepository, UserRepository userRepository) {
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
    }


    @Override
    public void todoAdd(Todo todo, String username) {
        User user = userRepository.findByUsername(username);
        todo.setCreated(LocalDateTime.now());
        user.getTodoList().add(todo);
        userRepository.save(user);
    }

    @Override
    public List<Todo> todoList(String username) {
        User user = userRepository.findByUsername(username);
        return user.getTodoList();
    }

    @Override
    public void todoDelete(Long id) {
        todoRepository.deleteById(id);
    }

    @Override
    public Todo findById(Long id) {
        return todoRepository.findById(id).orElse(null);
    }

    @Override
    public void todoEditForm(String title, String description,TodoStatus status, Todo todo) {
        todo.setTitle(title);
        todo.setDescription(description);
        todo.setStatus(status);
        todoRepository.save(todo);
    }


}
