package com.taebong98.todo.Todo.App.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class TodoPostDto {
    @NotBlank(message = "제목은 필수입니다")
    private String title;
    private int todoOrder;
    private boolean completed;
}
