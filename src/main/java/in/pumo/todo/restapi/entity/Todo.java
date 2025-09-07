package in.pumo.todo.restapi.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "tbl_todo")
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "todo_username", nullable = false)
	private String username;

	@Column(name = "todo_description", nullable = false)
	private String description;

	@Column(name = "todo_target_date", nullable = false)
	private LocalDate targetDate;

	@Column(name = "todo_completed", nullable = false)
	private Boolean completed;

}
