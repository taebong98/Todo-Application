package com.taebong98.todo.Todo.App.respository;

import com.taebong98.todo.Todo.App.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface TodoRepository extends JpaRepository<Todo, Long> {
    Optional<Todo> findByTodoId(Long todoId);
}
