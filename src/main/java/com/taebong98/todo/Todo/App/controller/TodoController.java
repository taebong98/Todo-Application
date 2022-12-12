package com.taebong98.todo.Todo.App.controller;

import com.taebong98.todo.Todo.App.dto.TodoPatchDto;
import com.taebong98.todo.Todo.App.dto.TodoPostDto;
import com.taebong98.todo.Todo.App.dto.TodoResponseDto;
import com.taebong98.todo.Todo.App.entity.Todo;
import com.taebong98.todo.Todo.App.mapper.TodoMapper;
import com.taebong98.todo.Todo.App.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("v1/todos")
public class TodoController {
    private final TodoService todoService;
    private final TodoMapper mapper;

    @PostMapping
    public ResponseEntity postTodo(@Valid @RequestBody TodoPostDto todoPostDto) {
        Todo response = todoService.createTodo(mapper.todoPostDtoToTodo(todoPostDto));
        return new ResponseEntity(mapper.todoToTodoResponseDto(response), HttpStatus.CREATED);
    }

    @PatchMapping("{todos-id}")
    public ResponseEntity patchTodo(@Positive @PathVariable("todos-id") long todoId,
                                    @Valid @RequestBody TodoPatchDto todoPatchDto) {

        Todo response = todoService.updateTodo(mapper.todoPatchDtoToTodo(todoPatchDto), todoId);
        return new ResponseEntity(mapper.todoToTodoResponseDto(response), HttpStatus.OK);
    }

    @GetMapping("{todos-id}")
    public ResponseEntity getTodo(@Positive @PathVariable("todos-id") long todoId) {
        Todo response = todoService.findTodo(todoId);
        return new ResponseEntity(mapper.todoToTodoResponseDto(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getTodos() {
        List<Todo> todos = todoService.findTodos();

        List<TodoResponseDto> response =
                todos.stream()
                        .map(mapper::todoToTodoResponseDto)
                        .collect(Collectors.toList());

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping("{todos-id}")
    public ResponseEntity deleteTodo(@Positive @PathVariable("todos-id") long todoId) {
        todoService.deleteTodo(todoId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
