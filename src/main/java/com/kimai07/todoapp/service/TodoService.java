package com.kimai07.todoapp.service;

import com.kimai07.todoapp.entity.TodoEntity;
import com.kimai07.todoapp.generated.model.Todo;
import com.kimai07.todoapp.mapper.TodoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;

@Service
public class TodoService {

    private final TodoMapper todoMapper;

    public TodoService(TodoMapper todoMapper) {
        this.todoMapper = todoMapper;
    }

    @Transactional
    public Todo create(String title, String description, String deadline) throws ParseException {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setTitle(title);
        todoEntity.setDescription(description);
        todoEntity.setDeadline(deadline);
        todoEntity.setDone(false);

        todoMapper.create(todoEntity);

        return new Todo().id(todoEntity.getId()).title(todoEntity.getTitle()).description(todoEntity.getDescription())
                .deadline(todoEntity.getDeadline()).done(todoEntity.isDone());
    }

    @Transactional(readOnly = true)
    public TodoEntity findById(Long id) {
        return todoMapper.findById(id);
    }

    @Transactional(readOnly = true)
    public List<TodoEntity> findAll() {
        return todoMapper.findAll();
    }
}