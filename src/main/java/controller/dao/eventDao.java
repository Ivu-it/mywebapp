package controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Event;
import utils.DbUtils;

public class eventDao {
	public ArrayList<Event> findAll() throws SQLException {
		String sql = "select * from events order by event_id;";

		ArrayList<Event> result = new ArrayList<Event>();

		try (Connection conn = DbUtils.open();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				Event a = new Event(rs.getInt("event_id"), rs.getString("name"));
				result.add(a);
			}
		}

		return result;
	}
	
	public int create(Event event) throws SQLException {
		String sql = "insert into events(name) values(?);";
 
		int id = 0;
 
		try (Connection conn = DbUtils.open();
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			stmt.setString(1, event.getName());
			int affectedRows = stmt.executeUpdate();
 
			if (affectedRows > 0) {
				try (ResultSet rs = stmt.getGeneratedKeys()) {
					if (rs.next()) {
						id = rs.getInt(1); // Retrieves the inserted ID
					}
				}
			}
		}
		return id;
	}
}
