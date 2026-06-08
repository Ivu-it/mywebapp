package Service;

import java.sql.SQLException;
import java.util.ArrayList;

import controller.dao.AthleteDao;
import entity.Athlete;

public class AthletesService {
public ArrayList<Athlete> getAthletes() {
		
		ArrayList<Athlete> result = null;
		
		try {
			result = (new AthleteDao()).findAll();			
		} catch(SQLException se) {
			se.printStackTrace();
		}
		
		return result;
	}

	public boolean createAthlete(String name1, String name2, int eventId, String gender) {
		Athlete a = new Athlete(0, name1, name2, eventId, gender);
		try {
			return (new AthleteDao()).create(a) > 0;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}
}
