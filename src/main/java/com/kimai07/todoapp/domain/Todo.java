package com.kimai07.todoapp.domain;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Todo {
    private Long id;
    private String title;
    private String description;
    private Date deadline;
    private boolean done;

    public String getDeadline() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(deadline);
    }
}
