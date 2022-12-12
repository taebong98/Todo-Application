package com.taebong98.todo.Todo.App.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class TodoResponseDto {
    private String title;
    private int todoOrder;
    private boolean completed;
}
