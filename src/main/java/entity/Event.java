package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Event {
	private int event_id;
	private String name;

	public Event(String name) {
		this.name = name;
	}
}