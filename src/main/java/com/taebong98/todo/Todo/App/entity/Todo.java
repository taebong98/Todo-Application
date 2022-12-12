package com.taebong98.todo.Todo.App.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@AllArgsConstructor
@Entity
public class Todo {
    @GeneratedValue @Id
    private Long todoId;

    private String title;

    private int todoOrder;

    private boolean completed;
}
