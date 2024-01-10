

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class disp
 */
@WebServlet("/disp")
public class disp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stu
		
		
		try
		{
			PrintWriter a=response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo","root","M1racle@123");
			String s=request.getParameter("id");
			PreparedStatement p=con.prepareStatement("select * from hr where name=?");
			p.setString(1, s);
			ResultSet rs=p.executeQuery();
			if(rs.next())
			{
				RequestDispatcher rd=request.getRequestDispatcher("disp2.java");
						rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("forward.html");
				rd.include(request, response);
				a.print("invalid");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}}


