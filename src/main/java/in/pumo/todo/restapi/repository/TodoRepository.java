package in.pumo.todo.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pumo.todo.restapi.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>  {

}
