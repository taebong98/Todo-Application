package com.taebong98.todo.Todo.App.mapper;

import com.taebong98.todo.Todo.App.dto.TodoPatchDto;
import com.taebong98.todo.Todo.App.dto.TodoPostDto;
import com.taebong98.todo.Todo.App.dto.TodoResponseDto;
import com.taebong98.todo.Todo.App.entity.Todo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    Todo todoPostDtoToTodo(TodoPostDto todoPostDto);
    Todo todoPatchDtoToTodo(TodoPatchDto todoPatchDto);
    TodoResponseDto todoToTodoResponseDto(Todo todo);
}
