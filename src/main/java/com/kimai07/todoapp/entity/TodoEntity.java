package com.kimai07.todoapp.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TodoEntity {
    private Long id;
    private String title;
    private String description;
    private LocalDate deadline;
    private boolean done;
}
