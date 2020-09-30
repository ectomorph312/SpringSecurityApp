package org.example.spring_security_app.controllers;

import org.example.spring_security_app.entity.Todo;
import org.example.spring_security_app.entity.TodoStatus;
import org.example.spring_security_app.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public String todoList(Model model, Principal principal) {
        List<Todo> todoList = todoService.todoList(principal.getName());
        model.addAttribute("todoList" , todoList);
        return "todoList";
    }

    @GetMapping("/add")
    public String todoAdd() {
        return "todoAdd";
    }

    @PostMapping("/add")
    public String todoAdd(@ModelAttribute Todo todo, Principal principal) {
        todoService.todoAdd(todo, principal.getName());
        return "redirect:/todo";
    }

    @GetMapping("/{id}/delete")
    public String todoDelete(@PathVariable(value = "id") Long id) {
        todoService.todoDelete(id);
        return "redirect:/todo";
    }

    @GetMapping("/{id}/edit")
    public String todoEdit(@PathVariable Long id, Model model) {
        Todo todo = todoService.findById(id);
        model.addAttribute("todo", todo);
        return "todoEdit";
    }

    @PostMapping
    public String todoEditForm(@ModelAttribute Todo todo) {
        todoService.todoEditForm(todo);
        return "redirect:/todo";

    }
}
