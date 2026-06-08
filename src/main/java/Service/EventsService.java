package Service;

import java.sql.SQLException;
import java.util.ArrayList;

import controller.dao.eventDao;
import entity.Event;

public class EventsService {
	public ArrayList<Event> getEvents(){
		ArrayList<Event> res = null;
		
		try {
			res = (new eventDao()).findAll();			
		} catch(SQLException se) {
			
		}
		
		return res;
		
	}
	
	public int addEvent(String name) {
		
		Event e = new Event(name);
		try {
			(new eventDao()).create(e);	
		} catch(SQLException se) {
			
		}
		
		return 0;
	}
}
