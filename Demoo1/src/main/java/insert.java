

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
 * Servlet implementation class insert
 */
@WebServlet("/insert")
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter p=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String role=request.getParameter("role");
		int pin=Integer.parseInt(request.getParameter("pin"));
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo","root","M1racle@123");
		
	PreparedStatement ps=con.prepareStatement("select role from hr where id=? ");
	ps.setInt(1, hropr.a);
	ResultSet rs=ps.executeQuery();
	rs.next();
	
	
	if(rs.getString(1).equals("hr"))
	{
		PreparedStatement pp=con.prepareStatement("insert into hr values(?,?,?,?)");
    pp.setInt(1, id);
	pp.setString(2,name);
	pp.setString(3,role);
	pp.setInt(4,pin);
	pp.executeUpdate();
	
	p.print("hr inserted sucessfully");
	//pp.close();
		}
	else if(rs.getString(1).equals("trainer"))
			{
				if(role.equals("trainer")||role.equals("trainee"))
			
		
			{
				PreparedStatement ps1=con.prepareStatement("insert into hr values(?,?,?,?) ");
		        ps1.setInt(1, id);
				ps1.setString(2,name);
				ps1.setString(3,role);
				ps1.setInt(4,pin);
				ps1.executeUpdate();
				p.print("trainer insert  details sucessfuly");
			}
			
			else
			{
				p.print("trainer can't insert hr details");
			}
	}else {
				p.print("invalid");			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	
	
	}

}
