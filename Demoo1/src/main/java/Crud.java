

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

@WebServlet("/Crud")
public class Crud extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int a=Integer.parseInt(request.getParameter("idd"));
	PrintWriter p=response.getWriter();
	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo","root","M1racle@123");
//			
	PreparedStatement ps=con.prepareStatement("select * from hr where id=? ");
	ps.setInt(1,a);
	ResultSet rs=ps.executeQuery();
		if(rs.next()){
//		
//		if(rs.getString(1).equals("hr"))
//		{
//		
//		PreparedStatement ps1=con.prepareStatement("select * from hr ");
//		//ps.setInt(1,a);
//		ResultSet rs1=ps1.executeQuery();
//		while(rs1.next())
		
			RequestDispatcher rd=request.getRequestDispatcher("select.html");
			rd.include(request, response);
			p.print(rs.getString("name")+" "+rs.getString("role"));
		}
	}
	
	catch(Exception e)
	{
		System.out.println(e);
	}
	}
}
//			
//		}
//		}
//		else if(rs.getString(1).equals("traineer"))
//				{
//			PreparedStatement ps1=con.prepareStatement("select * from hr where role='traineer' or role='trainee' ");
//			//ps.setInt(1,a);
//			ResultSet rs1=ps1.executeQuery();
//			while(rs1.next())
//			{
//				RequestDispatcher rd=request.getRequestDispatcher("detail.html");
//				rd.forward(request, response);
//				p.print(rs1.getString("name")+" "+rs1.getString("role"));
//				
//			}
//				}
//		else {
//				PreparedStatement ps1=con.prepareStatement("select * from hr where role='trainee'");
//				//ps.setInt(1,a);
//				ResultSet rs1=ps1.executeQuery();
//				while(rs1.next())
//				{
//					RequestDispatcher rd=request.getRequestDispatcher("detail.html");
//					rd.forward(request, response);
//					p.print(rs1.getString("name")+" "+rs1.getString("role"));
//					
//				}
//			}
//				
//		}
//		catch(Exception e)
//		{
//			System.out.println(e);
//		}
//	}


