package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddMusician")
public class AddMusician extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ssn = Integer.parseInt(request.getParameter("ssn"));
		String name = request.getParameter("name");
		long phone = Long.parseLong(request.getParameter("phone")); //set sql column as a BIGINT because phonenumbers are looong
		String address = request.getParameter("address");
	//Still need to implement empty fields check and if true then redirect
		 Connection c = null;
	        try
	        {
				String url = "jdbc:postgresql://cs1.calstatela.edu/cs4222s04";
				String username = "cs4222s04";
				String password = "pU0ScEVQ";
				
				c = DriverManager.getConnection(url, username, password);

	            String sql = "insert into musician values (?, ?, ?, ?)";
	            PreparedStatement pstmt = c.prepareStatement(sql);
	            pstmt.setInt(1, ssn);
	            pstmt.setString(2, name);
	            pstmt.setLong(3, phone);
	            pstmt.setString(4, address);
	            pstmt.executeUpdate();
	            
	           }
	        catch( SQLException e )
	        {
	            throw new ServletException( e );
	        }
	        finally
	        {
	            try
	            {
	                if( c != null ) c.close();
	            }
	            catch( SQLException e )
	            {
	                throw new ServletException( e );
	            }
	        }
	        response.sendRedirect( "test" );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
