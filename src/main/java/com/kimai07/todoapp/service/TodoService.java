package com.kimai07.todoapp.service;

import com.kimai07.todoapp.domain.Todo;
import com.kimai07.todoapp.mapper.TodoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TodoService {

    private final TodoMapper todoMapper;

    public TodoService(TodoMapper todoMapper) {
        this.todoMapper = todoMapper;
    }

    @Transactional
    public void create(Todo todo) {
        todoMapper.create(todo);
    }

    @Transactional(readOnly = true)
    public Todo findById(Long id) {
        return todoMapper.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Todo> findAll() {
        return todoMapper.findAll();
    }
}