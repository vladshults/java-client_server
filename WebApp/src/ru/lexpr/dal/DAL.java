package ru.lexpr.dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import ru.lexpr.model.Course;

public class DAL implements AutoCloseable {
	
	private Connection conn;
	private String driverName;
	private String connString;
	
	public DAL (String driverName, String connString) throws ClassNotFoundException, SQLException {
		 this.driverName = driverName;
		 this.connString = connString;
		 
		 Class.forName(this.driverName);
		 conn = DriverManager.getConnection(this.connString);
	}
	
	
	public List<Course> getCourses(String search) {
		return getCourses(null);
	}
	
	public List<Course> getCourse(String search) throws SQLException {
		String sql = "SELECT id, title, length, description FROM Courses "
				+"WHERE title LIKE ? "
				+"ORDER BY title";
		
	PreparedStatement cmd = conn.prepareStatement(sql);
	if (search == null) search = "";
	cmd.setString(1, "%"+search.trim()+"%");
	ResultSet result = cmd.executeQuery();
	List<Course> r = new ArrayList<Course>();
	while(result.next()) {
		String title = result.getString("title");
		int id = result.getInt("id");
		String desc = result.getString("description");
		int length = result.getInt("length");
		r.add(new Course(id, title, length, desc));
		}
	result.close();
	return r;
	}
	
	
	@Override
	public void close() throws Exception {
		conn.close();
	}

}
