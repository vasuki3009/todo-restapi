package in.pumo.todo.restapi.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import in.pumo.todo.restapi.dto.TodoDto;
import in.pumo.todo.restapi.entity.Todo;
import in.pumo.todo.restapi.exception.TodoNotFoundException;
import in.pumo.todo.restapi.repository.TodoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TodoServiceImplementation implements TodoService {

	private TodoRepository todoRepository;

	private ModelMapper modelMapper;

	@Override
	public TodoDto addTodo(TodoDto todoDto) {

		// converting TodoDto => Todo JPA Entity
//		Todo todo = new Todo();
//		todo.setUsername(todoDto.getUsername());
//		todo.setDescription(todoDto.getDescription());
//		todo.setTargetDate(todoDto.getTargetDate());
//		todo.setCompleted(todoDto.getCompleted());

		Todo todo = modelMapper.map(todoDto, Todo.class);

		// saving Todo in database
		Todo savedTodo = todoRepository.save(todo);

		// converting Todo JPA Entity => TodoDto
//		TodoDto savedTodoDto = new TodoDto();
//		savedTodoDto.setId(savedTodo.getId());
//		savedTodoDto.setUsername(savedTodo.getUsername());
//		savedTodoDto.setDescription(savedTodo.getDescription());
//		savedTodoDto.setTargetDate(savedTodo.getTargetDate());
//		savedTodoDto.setCompleted(savedTodo.getCompleted());

		TodoDto savedTodoDto = modelMapper.map(savedTodo, TodoDto.class);

		return savedTodoDto;
	}

	@Override
	public List<TodoDto> getAllTodos() {
		List<Todo> todoList = todoRepository.findAll();

		List<TodoDto> todoDtoList = todoList.stream()

				.map(todo -> modelMapper.map(todo, TodoDto.class))

				.toList();

		return todoDtoList;
	}

	@Override
	public TodoDto getTodoById(Long id) {
		Todo todo = todoRepository.findById(id)
				.orElseThrow(() -> new TodoNotFoundException("Todo not found with id: " + id));
		TodoDto todoDto = modelMapper.map(todo, TodoDto.class);
		return todoDto;
	}

	@Override
	public void deleteTodo(Long id) {
		todoRepository.deleteById(id);
	}

	@Override
	public TodoDto updateTodo(Long id, TodoDto tododto) {
		Todo todo = todoRepository.findById(id).orElseThrow(() -> new TodoNotFoundException("Id is not Found:" + id));
		todo.setUsername(tododto.getUsername());
		todo.setDescription(tododto.getDescription());
		todo.setTargetDate(tododto.getTargetDate());
		todo.setCompleted(tododto.getCompleted());

		Todo updatedtodo = todoRepository.save(todo);

		TodoDto updatedtododto = modelMapper.map(updatedtodo, TodoDto.class);
		return updatedtododto;
	}

}
