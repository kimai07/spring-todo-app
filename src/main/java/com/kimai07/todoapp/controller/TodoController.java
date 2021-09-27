package com.kimai07.todoapp.controller;

import com.kimai07.todoapp.entity.TodoEntity;
import com.kimai07.todoapp.generated.controller.TodoApi;
import com.kimai07.todoapp.generated.model.CreateTodoBody;
import com.kimai07.todoapp.generated.model.Todo;
import com.kimai07.todoapp.generated.model.UpdateTodoBody;
import com.kimai07.todoapp.service.TodoService;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1")
public class TodoController implements TodoApi {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @Override
    @RequestMapping(value = "/todo", produces = "application/json", method = RequestMethod.POST)
    public ResponseEntity<Todo> create(
            @ApiParam(value = "create todo body", required = true) @Valid @RequestBody CreateTodoBody body) {

        Todo todo;
        try {
            todo = todoService.create(body.getTitle(), body.getDescription(), body.getDeadline());
        } catch (ParseException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(todo, HttpStatus.CREATED);
    }

    @Override
    @RequestMapping(value = "/todo/{id}", produces = "application/json", method = RequestMethod.PUT)
    public ResponseEntity<Todo> update(@ApiParam(value = "ID", required = true) @PathVariable("id") Long id,
            @ApiParam(value = "update todo body", required = true) @Valid @RequestBody UpdateTodoBody body) {
        Todo todo;
        try {
            todo = todoService.update(id, body.getTitle(), body.getDescription(), body.getDeadline(), body.getDone());
            if (Objects.isNull(todo)) {
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (ParseException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "/todo/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@ApiParam(value = "ID", required = true) @PathVariable("id") Long id) {
        boolean ret = todoService.deleteById(id);
        if (!ret) {
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "/todo/{id}", method = RequestMethod.GET)
    public ResponseEntity<Todo> read(@ApiParam(value = "ID", required = true) @PathVariable("id") Long id) {
        TodoEntity todoEntity = todoService.findById(id);
        if (Objects.isNull((todoEntity))) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        Todo todo = new Todo().id(todoEntity.getId()).title(todoEntity.getTitle())
                .description(todoEntity.getDescription()).deadline(todoEntity.getDeadline()).done(todoEntity.isDone());
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public ResponseEntity<List<Todo>> list() {
        List<TodoEntity> todoEntities = todoService.findAll();
        List<Todo> todos = new ArrayList<>();
        for (TodoEntity todoEntity : todoEntities) {
            Todo todo = new Todo().id(todoEntity.getId()).title(todoEntity.getTitle())
                    .description(todoEntity.getDescription()).deadline(todoEntity.getDeadline())
                    .done(todoEntity.isDone());
            todos.add(todo);
        }
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }
}