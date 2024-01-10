

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
 * Servlet implementation class ins
 */
@WebServlet("/ins")
public class ins extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public ins() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
		String s1=request.getParameter("f1");
		String s2=request.getParameter("f2");
		String s3=request.getParameter("f3");
	
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo","root","M1racle@123");
		//PreparedStatement p=con.prepareStatement("insert into simple values(?,?,?)");
		//	PreparedStatement p=con.prepareStatement("delete from simple where id=2");
			//PreparedStatement p=con.prepareStatement("update  simple set name=?,branch=? where id=1");
			PreparedStatement p=con.prepareStatement("select * from simple ");
			ResultSet rs=p.executeQuery();
			PrintWriter pw=response.getWriter();
			while(rs.next())
			{
			pw.print(rs.getString(1));
			}
			
//			p.setString(1, s1);
//			p.setString(2,s2);
//			p.setString(3, s3);
			p.executeUpdate();
			p.close();
			
		}
			catch(Exception e) {
		System.out.println(e);}
		
		
	

}
}