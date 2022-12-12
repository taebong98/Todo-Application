package com.taebong98.todo.Todo.App.controller;

import com.taebong98.todo.Todo.App.dto.TodoPatchDto;
import com.taebong98.todo.Todo.App.dto.TodoPostDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("v1/todos")
public class TodoController {
    @PostMapping
    public ResponseEntity postTodo(@Valid @RequestBody TodoPostDto todoPostDto) {
        // TODO should Business logic

        return new ResponseEntity(todoPostDto, HttpStatus.CREATED);
    }

    @PatchMapping("{todos-id}")
    public ResponseEntity patchTodo(@Positive @PathVariable("todos-id") long todosId,
                                    @Valid @RequestBody TodoPatchDto todoPatchDto) {
        // TODO should Business logic

        return new ResponseEntity(todoPatchDto, HttpStatus.OK);
    }

    @GetMapping("{todos-id}")
    public ResponseEntity getTodo(@Positive @PathVariable("todos-id") long todosId) {
        // TODO should Business logic

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getTodos() {
        // TODO should Business logic

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("{todos-id}")
    public ResponseEntity deleteTodo(@Positive @PathVariable("todos-id") long todosId) {
        // TODO should Business logic

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
