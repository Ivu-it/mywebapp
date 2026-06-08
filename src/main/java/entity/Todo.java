package entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Todo {
	private int todo_id;
	private String title;
	private String detail;
	private String status;
	private Date due_date;

	public Todo(String title, String detail, String status, Date due_date) {
		this.title = title;
		this.detail = detail;
		this.status = status;
		this.due_date = due_date;
	}
}