package controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Todo;
import utils.DbUtils;

public class TodoDao {
	public ArrayList<Todo> findAll() throws SQLException {
		String sql = "select * from todos order by todo_id;";

		ArrayList<Todo> result = new ArrayList<Todo>();

		try (Connection conn = DbUtils.open();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				Todo a = new Todo(rs.getInt("todo_id"), rs.getString("title"), rs.getString("detail"),
						rs.getString("status"), rs.getDate("due_date"));
				result.add(a);
			}

		}
		return result;
	}

	public ArrayList<Todo> findByKeyword(String keyword) throws SQLException {
		String sql = "select * from todos where title like ? or detail like ? order by todo_id;";

		ArrayList<Todo> result = new ArrayList<Todo>();

		try (Connection conn = DbUtils.open();
				PreparedStatement ps = conn.prepareStatement(sql)) {

			String likeKeyword = "%" + keyword + "%";
			ps.setString(1, likeKeyword);
			ps.setString(2, likeKeyword);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Todo a = new Todo(
							rs.getInt("todo_id"),
							rs.getString("title"),
							rs.getString("detail"),
							rs.getString("status"),
							rs.getDate("due_date"));
					result.add(a);
				}
			}
		}
		return result;
	}

	public ArrayList<Todo> findByFilter(String keyword, String status) throws SQLException {
	    StringBuilder sql = new StringBuilder(
	        "select * from todos where 1=1");

	    if (keyword != null && !keyword.isEmpty()) {
	        sql.append(" and (title like ? or detail like ?)");
	    }
	    if (status != null && !status.isEmpty()) {
	        sql.append(" and status = ?");
	    }
	    sql.append(" order by todo_id");

	    ArrayList<Todo> result = new ArrayList<Todo>();

	    try (Connection conn = DbUtils.open();
	         PreparedStatement ps = conn.prepareStatement(sql.toString())) {

	        int i = 1;
	        if (keyword != null && !keyword.isEmpty()) {
	            String like = "%" + keyword + "%";
	            ps.setString(i++, like);
	            ps.setString(i++, like);
	        }
	        if (status != null && !status.isEmpty()) {
	            ps.setString(i++, status);
	        }

	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                Todo a = new Todo(
	                    rs.getInt("todo_id"),
	                    rs.getString("title"),
	                    rs.getString("detail"),
	                    rs.getString("status"),
	                    rs.getDate("due_date")
	                );
	                result.add(a);
	            }
	        }
	    }
	    return result;
	}

	public int create(Todo a) throws SQLException {
		String sql = "insert into todos(title, detail, status, due_date) values (?, ?, ?, ?);";
		try (Connection conn = DbUtils.open();
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, a.getTitle());
			ps.setString(2, a.getDetail());
			ps.setString(3, a.getStatus());
			ps.setDate(4, a.getDue_date());

			return ps.executeUpdate();
		}
	}
}
