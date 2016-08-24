package ru.lexpr.dbinsert;

import static java.lang.System.out;
import java.sql.*;
import java.util.Scanner;


public class Program {
	
	public static final String driverClass = "com.mysql.jdbc.Driver";
	public static final String connString = "jdbc:mysql://localhost:3306/web?user=root&password=admin";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName(driverClass);
		
		out.print("Курс: ");
		Scanner scanner = new Scanner(System.in);
		String title = scanner.nextLine();
		int length = scanner.nextInt();
		if (scanner.hasNextLine()) scanner.nextLine();
		String desc = scanner.nextLine();
		scanner.close();
		
		Connection con = DriverManager.getConnection(connString);
		//String sql = "SELECT title, length FROM Courses "
		//			+"WHERE title LIKE '%" + search + "%' "
		//			+"ORDER BY title";
		//INSERT INTO courses (title, length, description)
		//VALUES (?, ?, ?)
		
		//String sql = "SELECT title, length FROM Courses "
		//			+"WHERE title LIKE ? "
		//			+"ORDER BY title";
		
		String sql = "INSERT INTO courses (title, length, description) VALUES (?, ?, ?)";
		
		try {
		
			PreparedStatement cmd = con.prepareStatement(sql);
			cmd.setString(1, title);
			cmd.setInt(2, length);
			cmd.setString(3, desc);
			//ResultSet result = cmd.executeQuery();
			
			if (cmd.executeUpdate() == 1) out.println("Курс добавлен");
		
		} finally {
			con.close();
		}
		//Statement cmd = con.createStatement();
		//ResultSet result = cmd.executeQuery(sql);
		
	}
}
