

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
import javax.servlet.http.HttpSession;


@WebServlet("/hropr")
public class hropr extends HttpServlet {
	public static int a=0;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 a=Integer.parseInt(request.getParameter("id"));
			int b=Integer.parseInt(request.getParameter("pin"));
			PrintWriter p=response .getWriter();
			HttpSession hs=request.getSession();
			response.setContentType("text/html");
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo","root","M1racle@123");
			PreparedStatement pp=con.prepareStatement("select * from hr where id=?");
			pp.setInt(1,a);
			ResultSet r=pp.executeQuery()	;
			if(r.next())
			{
				hs.setAttribute("name",r.getString(2));
			}
			PreparedStatement ps=con.prepareStatement("select role from hr where id=? and pin=?");
		ps.setInt(1, a);
		ps.setInt(2, b);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			if(rs.getString("role").equals("hr")||rs.getString("role").equals("trainer")||rs.getString("role").equals("trainee")) {
				p.print("<h2 style='text-align:right'>"+"welcome"+" "+hs.getAttribute("name")+"</h2>");
			
				RequestDispatcher rd=request.getRequestDispatcher("hr.html");
			rd.include(request, response);
//			p.print("welcome"+ " "+hs.getAttribute("name"));
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("hrdetail.html");
				
				rd.include(request, response);
			
				p.print("invalid");
			}
			
		}
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
}
		
			
			
			
			