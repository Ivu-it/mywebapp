package Service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.dao.TodoDao;
import entity.Todo;

public class TodoService {
	public ArrayList<Todo> getTodo() {
		ArrayList<Todo> result = null;

		try {
			result = (new TodoDao()).findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}
	public ArrayList<Todo> getTodoByKeyword(String keyword) {
	    ArrayList<Todo> result = null;

	    try {
	        result = (new TodoDao()).findByKeyword(keyword);
	        System.out.println("検索結果件数 = " + (result != null ? result.size() : "null"));
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	}
	public ArrayList<Todo> getFilteredTodo(String keyword, String status) {
	    ArrayList<Todo> result = null;
	    try {
	        result = (new TodoDao()).findByFilter(keyword, status);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	}

	public boolean createTodo(String title, String detail, String status, Date due_date) {
		Todo a = new Todo(0, title, detail, status, due_date);
		try {
			return (new TodoDao()).create(a) > 0;
			}catch(SQLException se) {
				se.printStackTrace();
				return false;
			}
	}

}
