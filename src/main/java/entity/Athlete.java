package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Athlete {
	private int athlete_id;
	private String name1;
	private String name2;
	private int event_id;
	private String gender;
}
