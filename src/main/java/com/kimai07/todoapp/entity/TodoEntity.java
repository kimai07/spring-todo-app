package com.kimai07.todoapp.entity;

import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class TodoEntity {
    private Long id;
    private String title;
    private String description;
    private Date deadline;
    private boolean done;

    public void setDeadline(String deadline) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        this.deadline = format.parse(deadline);
    }

    public String getDeadline() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(this.deadline);
    }
}
