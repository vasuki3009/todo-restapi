package in.pumo.todo.restapi.exception;

public class TodoNotFoundException extends RuntimeException {

	public TodoNotFoundException(String message) {
		super(message);
	}
}
