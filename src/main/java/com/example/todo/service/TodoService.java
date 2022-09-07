package com.example.todo.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.todo.entity.Todo;

@Service
public class TodoService {

	private static final List<Todo> todos = new ArrayList<>();
	
	static {
		todos.add(new Todo(1, "Learn Java", new Date(System.currentTimeMillis()), false));
		todos.add(new Todo(2, "Learn Angular", new Date(System.currentTimeMillis()), false));
		todos.add(new Todo(3, "Learn Python", new Date(System.currentTimeMillis()), false));
	}
	
	public List<Todo> getAllTodos() {
		return todos;
	}
	
	public Todo getTodoById(int id) {
		for (Todo todoo : todos) {
			if (todoo.getId() == id) {
				return todoo;
			}
		}
		
		return null;
	}
	
	public Todo updateTodo(Todo todo) {
		Optional<Todo> optTodo = todos.stream().filter(todoo -> todoo.getId() == todo.getId()).findFirst();
		
		if (optTodo.isPresent()) {
			optTodo.get().setCompleted(todo.isCompleted());
			optTodo.get().setDescription(todo.getDescription());
			optTodo.get().setTargetDate(todo.getTargetDate());
			
			todos.set(optTodo.get().getId()-1, optTodo.get());
			return optTodo.get();
		}
		else {
			todo.setId(todos.size() + 1);
			todos.add(todo);
			return todo;
		}
		
		//URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todo.getId()).toUri();
	}
	
	public Todo deleteTodoById(int id) {
		Optional<Todo> todoOpt = todos.stream().filter(todo -> todo.getId() == id).findFirst();
		
		if (todoOpt.isPresent()) {
			todos.remove(todoOpt.get());
			return todoOpt.get();
		}
		
		return null;
	}
}
