package com.kimai07.todoapp.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kimai07.todoapp.entity.TodoEntity;
import com.kimai07.todoapp.generated.model.Todo;
import com.kimai07.todoapp.service.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TodoController.class)
public class TodoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TodoService todoService;

    @Test
    public void createTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        Todo todo = new Todo().title("aaa").description("bbb").deadline("2021-09-30");
        String todoJson = mapper.writeValueAsString(todo);

        Todo expectedTodo = new Todo().id(1L).title("aaa").description("bbb").deadline("2021-09-30").done(false);
        String expectedTodoJson = mapper.writeValueAsString(expectedTodo);

        when(todoService.create(any(), any(), any())).thenReturn(expectedTodo);

        mockMvc.perform(post("/v1/todo").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                .content(todoJson)).andDo(print()).andExpect(status().isCreated())
                .andExpect(content().string(expectedTodoJson));
    }

    @Test
    public void readTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        TodoEntity entity = new TodoEntity();
        entity.setId(1L);
        entity.setTitle("aaa");
        entity.setDescription("bbb");
        entity.setDeadline("2021-09-30");
        entity.isDone();

        Todo expectedTodo = new Todo().id(1L).title("aaa").description("bbb").deadline("2021-09-30").done(false);
        String expectedTodoJson = mapper.writeValueAsString(expectedTodo);

        when(todoService.findById(anyLong())).thenReturn(entity);

        mockMvc.perform(get("/v1/todo/1").accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(expectedTodoJson));
    }
}