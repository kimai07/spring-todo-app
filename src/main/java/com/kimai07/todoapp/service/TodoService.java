package com.kimai07.todoapp.service;

import com.kimai07.todoapp.entity.TodoEntity;
import com.kimai07.todoapp.generated.model.Todo;
import com.kimai07.todoapp.mapper.TodoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;
import java.util.Objects;

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

    @Transactional
    public Todo update(Long id, String title, String description, String deadline, Boolean done) throws ParseException {
        TodoEntity todoEntity = todoMapper.findById(id);
        if (Objects.isNull(todoEntity)) {
            return null;
        }

        if (Objects.nonNull(title)) {
            todoEntity.setTitle(title);
        }
        if (Objects.nonNull(description)) {
            todoEntity.setDescription(description);
        }
        if (Objects.nonNull(deadline)) {
            todoEntity.setDeadline(deadline);
        }
        if (Objects.nonNull(done)) {
            todoEntity.setDone(done);
        }

        boolean ret = todoMapper.update(todoEntity);
        if (!ret) {
            return null;
        }

        return new Todo().id(todoEntity.getId()).title(todoEntity.getTitle()).description(todoEntity.getDescription())
                .deadline(todoEntity.getDeadline()).done(todoEntity.isDone());
    }

    @Transactional
    public boolean deleteById(Long id) {
        TodoEntity todoEntity = todoMapper.findById(id);
        if (Objects.isNull((todoEntity))) {
            return false;
        }
        todoMapper.deleteById(id);

        return true;
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