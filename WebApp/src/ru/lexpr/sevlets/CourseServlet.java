package ru.lexpr.sevlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/Course")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String driverClass = "com.mysql.jdbc.Driver";
	public static final String connString = "jdbc:mysql://localhost:3306/web?user=root&password=admin";
  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	doGet(request, response);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		String search = request.getParameter("search");
		if (search == null)
			search = "";
		
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName(driverClass);
			Connection con = DriverManager.getConnection(connString);
			String sql = "SELECT title, length, description FROM Courses "
						+"WHERE title LIKE ? "
						+"ORDER BY title";
				
			PreparedStatement cmd = con.prepareStatement(sql);
			cmd.setString(1, "%"+search.trim()+"%");
			ResultSet result = cmd.executeQuery();
			
			out.println("<table border=1>");
			while(result.next()) {
				out.println("<tr>");
				String title = result.getString("title");
				int length = result.getInt("length");
				String desc = result.getString("description");
				out.printf("<td>%s</td><td>%d</td><td>%s</td>", title, length, desc);
				out.println("</tr>");
			}
			out.println("</table>");
			result.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		} 
	}
}
