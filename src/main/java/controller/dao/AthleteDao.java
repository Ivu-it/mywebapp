package controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Athlete;
import utils.DbUtils;

public class AthleteDao {
	public ArrayList<Athlete> findAll() throws SQLException {
		String sql = "select * from athletes order by athlete_id;";

		ArrayList<Athlete> result = new ArrayList<Athlete>();

		try (Connection conn = DbUtils.open();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				Athlete a = new Athlete(rs.getInt("athlete_id"), rs.getString("name1"), rs.getString("name2"), rs.getInt("event_id"),
						rs.getString("gender"));
				result.add(a);
			}
		}

		return result;
	}

	public int create(Athlete a) throws SQLException {
		String sql = "insert into athletes (name1, name2, event_id, gender) values (?, ?, ?, ?);";

		try (Connection conn = DbUtils.open();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, a.getName1());
			pstmt.setString(2, a.getName2());
			pstmt.setInt(3, a.getEvent_id());
			pstmt.setString(4, a.getGender());

			return pstmt.executeUpdate();
		}
	}
}
