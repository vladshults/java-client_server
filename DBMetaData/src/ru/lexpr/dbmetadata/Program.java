package ru.lexpr.dbmetadata;

import static java.lang.System.out;
import java.sql.*;
//import java.util.Scanner;


public class Program {
	
	public static final String driverClass = "com.mysql.jdbc.Driver";
	public static final String connString = "jdbc:mysql://localhost:3306/web?user=root&password=admin";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName(driverClass);
		
		Connection conn = DriverManager.getConnection(connString);
		try {
			DatabaseMetaData meta = conn.getMetaData();
			out.println("\nDatabases: ");
			ResultSet cats = meta.getCatalogs();
			while(cats.next())
				out.println(cats.getString("TABLE_CAT"));
			out.println("\nTables: ");
			ResultSet tables = meta.getTables("web", null, null, null);
			while(tables.next())
				out.println(tables.getString("TABLE_NAME"));
			out.println("\nProcedures: ");
			ResultSet sps = meta.getProcedures("web", null, null);
			while(sps.next())
				out.println(sps.getString("PROCEDURE_NAME"));
		} finally {
			conn.close();
		}
	}
}
