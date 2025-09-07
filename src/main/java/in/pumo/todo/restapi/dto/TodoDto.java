package in.pumo.todo.restapi.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TodoDto {

	private Long id;

	private String username;

	@Size(min = 10, message = "Description should be atleast 10 characters")
	private String description;

	@Future(message = "Target Date should be future date")
	private LocalDate targetDate;

	private Boolean completed;

}
