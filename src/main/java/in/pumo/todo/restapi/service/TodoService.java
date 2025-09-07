package in.pumo.todo.restapi.service;

import java.util.List;

import in.pumo.todo.restapi.dto.TodoDto;

public interface TodoService {

	public TodoDto addTodo(TodoDto todoDto);

	public List<TodoDto> getAllTodos();

	public TodoDto getTodoById(Long id);

	public void deleteTodo(Long id);

	public TodoDto updateTodo(Long id, TodoDto tododto);
}
