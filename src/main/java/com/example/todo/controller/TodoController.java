package com.example.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.entity.Todo;
import com.example.todo.service.TodoService;

@CrossOrigin("http://localhost:4200")
@RestController
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@GetMapping("/users/{username}/todos")
	public List<Todo> getAllTodos() {
		return todoService.getAllTodos();
	}
	
	@GetMapping("/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable int id) {
		return todoService.getTodoById(id);
	}
	
	@PutMapping("/users/{username}/todos")
	public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo, @PathVariable String username) {
		Todo updatedTodo = todoService.updateTodo(todo);
		return new ResponseEntity<Todo>(updatedTodo, HttpStatus.OK);
	}
	
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodoById(@PathVariable String username, @PathVariable int id) {
		Todo todo = todoService.deleteTodoById(id);
		
		if (todo == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.noContent().build();		
	}
	
	
}
