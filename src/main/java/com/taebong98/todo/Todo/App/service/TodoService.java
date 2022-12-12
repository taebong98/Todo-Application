package com.taebong98.todo.Todo.App.service;

import com.taebong98.todo.Todo.App.entity.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    public Todo createTodo(Todo todo) {
        // todo 객체는 나중에 DB 저장 후 되돌려 받는 것으로 변경 필요
        Todo createdTodo = todo;

        return createdTodo;
    }

    public Todo updateTodo(Todo todo) {
        // todo 객체는 나중에 DB 저장 후 되돌려 받는 것으로 변경 필요
        Todo updatedTodo = new Todo(1L, "운동하기", 1, false);
        return updatedTodo;
    }

    public Todo findTodo(long todoId) {
        Todo todo = new Todo(todoId, "운동하기", 1, false);
        return todo;
    }

    public List<Todo> findTodos() {
        List<Todo> todos = List.of(
                new Todo(1L, "운동하기", 1, false),
                new Todo(2L, "공부하기", 2, true)
        );
        return todos;
    }

    public void deleteTodo(long todoId) {
        // should business logic
    }

}
