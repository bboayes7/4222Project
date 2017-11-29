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

/**
 * Servlet implementation class Addsong
 */
@WebServlet("/Addsong")
public class Addsong extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addsong() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int album_id = Integer.parseInt( request.getParameter("key"));
		String title = request.getParameter("title");
		String producer = request.getParameter("key2");

		Connection c = null;
	        try
	        {
				String url = "jdbc:postgresql://cs1.calstatela.edu/cs4222s04";
				String username = "cs4222s04";
				String password = "pU0ScEVQ";
				
				c = DriverManager.getConnection(url, username, password);

	            String sql = "insert into Song values (DEFAULT,?, ?,?)";
	            PreparedStatement pstmt = c.prepareStatement(sql);
	            
	            pstmt.setInt(1, album_id);
	            pstmt.setString(2, title);
	            pstmt.setString(3, producer);

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
	        response.sendRedirect( "test" );	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
