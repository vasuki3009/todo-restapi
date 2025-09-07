package in.pumo.todo.restapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pumo.todo.restapi.dto.TodoDto;
import in.pumo.todo.restapi.service.TodoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

// https://localhost:9000/api/todos
@RestController
@AllArgsConstructor
@RequestMapping("api/todos")
public class TodoController {

	private TodoService todoService;

	// Adds a new Todo
	// POST REQUEST
	// http://localhost:9090/api/todos
	@PostMapping("")
	public ResponseEntity<TodoDto> addtodo(@RequestBody @Valid TodoDto todoDto) {
		TodoDto savedTodoDto = todoService.addTodo(todoDto);
		return new ResponseEntity<>(savedTodoDto, HttpStatus.CREATED);
	}

	// Get all Todos
	// GET REQUEST
	// http://localhost:9090/api/todos
	@GetMapping("")
	public ResponseEntity<List<TodoDto>> getAllTodos() {
		List<TodoDto> todoDtoList = todoService.getAllTodos();
		return new ResponseEntity<>(todoDtoList, HttpStatus.OK);
	}

	// Get Todo by id
	// GET REQUEST
	// http://localhost:9090/api/todos/id/{id}
	@GetMapping("/id/{id}")
	public ResponseEntity<TodoDto> getTodoById(@PathVariable("id") Long todoId) {
		TodoDto todoDto = todoService.getTodoById(todoId);
		return new ResponseEntity<>(todoDto, HttpStatus.OK);
	}

	// http://localhost:9090/api/todos/{id}
	@DeleteMapping("/{id}")
	public void deleteTodo(@PathVariable("id") Long id) {
		todoService.deleteTodo(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<TodoDto> updateTodoDto(@PathVariable("id") Long id, @RequestBody @Valid TodoDto tododto) {
		TodoDto updatedtododto = todoService.updateTodo(id, tododto);
		return new ResponseEntity<>(updatedtododto, HttpStatus.CREATED);
	}
}
