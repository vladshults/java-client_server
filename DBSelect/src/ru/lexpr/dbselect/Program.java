package ru.lexpr.dbselect;

import static java.lang.System.out;
import java.sql.*;
import java.util.Scanner;


public class Program {
	
	public static final String driverClass = "com.mysql.jdbc.Driver";
	public static final String connString = "jdbc:mysql://localhost:3306/web?user=root&password=admin";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName(driverClass);
		
		out.print("Поиск: ");
		Scanner scanner = new Scanner(System.in);
		String search = scanner.nextLine().trim();
		scanner.close();
		
		Connection con = DriverManager.getConnection(connString);
		//String sql = "SELECT title, length FROM Courses "
		//			+"WHERE title LIKE '%" + search + "%' "
		//			+"ORDER BY title";
		//INSERT INTO courses (title, length, description)
		//VALUES (?, ?, ?)
		
		String sql = "SELECT title, length FROM Courses "
					+"WHERE title LIKE ? "
					+"ORDER BY title";
		
		PreparedStatement cmd = con.prepareStatement(sql);
		cmd.setString(1, "%" + search + "%");
		ResultSet result = cmd.executeQuery();
		
		//Statement cmd = con.createStatement();
		//ResultSet result = cmd.executeQuery(sql);
		while(result.next()) {
			String title = result.getString("title");
			int length = result.getInt("length");
			
			out.printf("%-30s %d\n ", title, length);
		}
		result.close();
	}

}
