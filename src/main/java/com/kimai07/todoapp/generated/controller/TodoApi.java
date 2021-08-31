/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.21).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.kimai07.todoapp.generated.controller;

import com.kimai07.todoapp.generated.model.CreateTodoBody;
import com.kimai07.todoapp.generated.model.Todo;
import com.kimai07.todoapp.generated.model.Todos;
import com.kimai07.todoapp.generated.model.UpdateTodoBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Api(value = "todo", description = "the todo API")
public interface TodoApi {

    Logger log = LoggerFactory.getLogger(TodoApi.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "create todo ", nickname = "create", notes = "create todo ", response = Todo.class, tags = {})
    @ApiResponses(value = { @ApiResponse(code = 201, message = "created todo", response = Todo.class) })
    @RequestMapping(value = "/todo/create", produces = { "application/json" }, consumes = {
            "application/json" }, method = RequestMethod.POST)
    default ResponseEntity<Todo> create(
            @ApiParam(value = "create todo body", required = true) @Valid @RequestBody CreateTodoBody body) {
        if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue(
                            "{\n  \"description\" : \"PCを買う\",\n  \"id\" : 1,\n  \"title\" : \"買い物\",\n  \"deadline\" : \"2021-12-31\",\n  \"done\" : false\n}",
                            Todo.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn(
                    "ObjectMapper or HttpServletRequest not configured in default TodoApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @ApiOperation(value = "delete todo ", nickname = "delete", notes = "delete todo ", tags = {})
    @ApiResponses(value = {})
    @RequestMapping(value = "/todo/delete", method = RequestMethod.DELETE)
    default ResponseEntity<Void> delete(@ApiParam(value = "ID", required = true) @PathVariable("id") Long id) {
        if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn(
                    "ObjectMapper or HttpServletRequest not configured in default TodoApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @ApiOperation(value = "list todos ", nickname = "list", notes = "list todos ", response = Todos.class, tags = {})
    @ApiResponses(value = { @ApiResponse(code = 200, message = "list todos", response = Todos.class) })
    @RequestMapping(value = "/todo/list", produces = { "application/json" }, method = RequestMethod.GET)
    default ResponseEntity<Todos> list() {
        if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue(
                            "[ {\n  \"description\" : \"PCを買う\",\n  \"id\" : 1,\n  \"title\" : \"買い物\",\n  \"deadline\" : \"2021-12-31\",\n  \"done\" : false\n}, {\n  \"description\" : \"PCを買う\",\n  \"id\" : 1,\n  \"title\" : \"買い物\",\n  \"deadline\" : \"2021-12-31\",\n  \"done\" : false\n} ]",
                            Todos.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn(
                    "ObjectMapper or HttpServletRequest not configured in default TodoApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @ApiOperation(value = "read todo ", nickname = "read", notes = "read todo ", response = Todo.class, tags = {})
    @ApiResponses(value = { @ApiResponse(code = 200, message = "todo", response = Todo.class) })
    @RequestMapping(value = "/todo/read", produces = { "application/json" }, method = RequestMethod.GET)
    default ResponseEntity<Todo> read(@ApiParam(value = "ID", required = true) @PathVariable("id") Long id) {
        if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue(
                            "{\n  \"description\" : \"PCを買う\",\n  \"id\" : 1,\n  \"title\" : \"買い物\",\n  \"deadline\" : \"2021-12-31\",\n  \"done\" : false\n}",
                            Todo.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn(
                    "ObjectMapper or HttpServletRequest not configured in default TodoApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @ApiOperation(value = "update todo ", nickname = "update", notes = "update todo ", response = Todo.class, tags = {})
    @ApiResponses(value = { @ApiResponse(code = 200, message = "todo", response = Todo.class) })
    @RequestMapping(value = "/todo/update", produces = { "application/json" }, consumes = {
            "application/json" }, method = RequestMethod.PUT)
    default ResponseEntity<Todo> update(@ApiParam(value = "ID", required = true) @PathVariable("id") Long id,
            @ApiParam(value = "update todo body", required = true) @Valid @RequestBody UpdateTodoBody body) {
        if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue(
                            "{\n  \"description\" : \"PCを買う\",\n  \"id\" : 1,\n  \"title\" : \"買い物\",\n  \"deadline\" : \"2021-12-31\",\n  \"done\" : false\n}",
                            Todo.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn(
                    "ObjectMapper or HttpServletRequest not configured in default TodoApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
