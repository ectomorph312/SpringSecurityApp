package org.example.spring_security_app.service;

import org.example.spring_security_app.entity.Todo;
import org.example.spring_security_app.entity.TodoStatus;

import java.util.List;

public interface TodoService {
    void todoAdd(Todo todo, String username);
    List<Todo> todoList(String  username);
    void todoDelete(Long id);
    Todo findById(Long id);
    void todoEditForm(String title, String description, TodoStatus status, Todo todo);
}
