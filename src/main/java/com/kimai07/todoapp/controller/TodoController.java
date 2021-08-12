package com.kimai07.todoapp.controller;

import com.kimai07.todoapp.domain.Todo;
import com.kimai07.todoapp.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping(value = "/todo", consumes = "application/json")
    @ResponseBody
    public void create(@RequestBody Todo todo) {
        todoService.create(todo);
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<Todo> read(@PathVariable Long id) {
        return new ResponseEntity<>(todoService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> list() {
        return new ResponseEntity<>(todoService.findAll(), HttpStatus.OK);
    }
}