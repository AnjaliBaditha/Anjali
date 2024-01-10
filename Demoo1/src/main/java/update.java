

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

@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		int a1=	Integer.parseInt(request.getParameter("i"));
		String name=request.getParameter("n");
		PrintWriter p=response .getWriter();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo","root","M1racle@123");
			
		PreparedStatement ps=con.prepareStatement("select role from hr where id=? ");
		ps.setInt(1, hropr.a);
		ResultSet rs=ps.executeQuery();
		rs.next();
		if(rs.getString(1).equals("hr"))
		{
			PreparedStatement pp=con.prepareStatement("update hr set name=? where id=?");
	   
		pp.setString(1,name);
		 pp.setInt(2, a1);
		//pp.setString(3,role);
		//pp.setInt(4,pin);
		pp.executeUpdate();
		p.write("hr updated sucessfuly");
		pp.close();

		}
		else if(rs.getString(1).equals("trainer"))
			
		{
			PreparedStatement ps1=con.prepareStatement("update hr set name=? where id=? role='trainer' or role='trainee'");
			ps1.setString(1,name);
			ps1.setInt(2, a1);
			
			//ps1.setString(3,role);
			//ps1.setInt(4,pin);
			ps1.executeUpdate();
			p.write("trainer updated details sucessfully");
			ps1.close();
		}
		else
		{
			p.write("invalid");
		}
		
	}
		catch(Exception e)
		{
		System.out.println(e);
		}
	}


}
