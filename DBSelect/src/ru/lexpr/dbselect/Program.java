package ru.lexpr.dbselect;

import static java.lang.System.out;
import java.sql.*;


public class Program {
	
	public static final String driverClass = "com.mysql.jdbc.Driver";
	public static final String connString = "jdbc:mysql://localhost:3306/web?user=root&password=admin";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName(driverClass);
		
		Connection con = DriverManager.getConnection(connString);
		String sql = "SELECT title, length FROM Courses ORDER BY title";
		Statement cmd = con.createStatement();
		ResultSet result = cmd.executeQuery(sql);
		while(result.next()) {
			String title = result.getString("title");
			int length = result.getInt("length");
			
			out.printf("%-30s %d\n ", title, length);
		}
		result.close();
	}

}
