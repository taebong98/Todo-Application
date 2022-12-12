package com.taebong98.todo.Todo.App.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Todo {
    private Long todoId;
    private String title;
    private int todoOrder;
    private boolean completed;
}
