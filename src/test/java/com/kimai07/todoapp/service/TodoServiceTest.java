package com.kimai07.todoapp.service;

import com.kimai07.todoapp.entity.TodoEntity;
import com.kimai07.todoapp.mapper.TodoMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TodoServiceTest {

    @InjectMocks
    TodoService todoService;

    @Mock
    TodoMapper todoMapper;

    @Test
    public void findByIdTest() {
        TodoEntity todo = new TodoEntity();
        todo.setId(1L);
        todo.setTitle("abcde");

        when(todoMapper.findById(anyLong())).thenReturn(todo);

        TodoEntity foundTodo = todoService.findById(1L);

        assertThat(foundTodo.getId(), is(1L));
        assertThat(foundTodo.getTitle(), is("abcde"));
    }
}