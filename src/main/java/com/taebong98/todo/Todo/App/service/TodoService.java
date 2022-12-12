package com.taebong98.todo.Todo.App.service;

import com.taebong98.todo.Todo.App.entity.Todo;
import com.taebong98.todo.Todo.App.respository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Todo todo, long todoId) {
        // 존재하는 todo 리스트인지 검증한다
        Todo verifiedTodo = findVerifiedTodo(todoId);
        // title, todoOrder, completed 정보 업데이트
        Optional.ofNullable(todo.getTitle()).ifPresent(title -> verifiedTodo.setTitle(title));
        Optional.ofNullable(todo.getTodoOrder()).ifPresent(todoOrder -> verifiedTodo.setTodoOrder(todoOrder));
        Optional.ofNullable(todo.isCompleted()).ifPresent(completed -> verifiedTodo.setCompleted(completed));
        return todoRepository.save(verifiedTodo);
    }

    public Todo findTodo(long todoId) {
        return findVerifiedTodo(todoId);
    }

    public List<Todo> findTodos() {
        return (List<Todo>) todoRepository.findAll();
    }

    public void deleteTodo(long todoId) {
        Todo findTodo = findVerifiedTodo(todoId);
        todoRepository.delete(findTodo);
    }

    public void deleteTodos() {
        todoRepository.deleteAll();
    }

    private Todo findVerifiedTodo(long todoId) {
        Optional<Todo> optionalTodo = todoRepository.findById(todoId);
        Todo findTodo = optionalTodo.orElseThrow(() -> new RuntimeException("존재하지 않는 회원입니다."));
        return findTodo;
    }
}
