package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddAlbum
 */
@WebServlet("/AddAlbum")
public class AddAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAlbum() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String title = request.getParameter("title");
				String format = request.getParameter("format");
				String userdate = request.getParameter("date");
				int producer = Integer.parseInt( request.getParameter("key"));
				DateFormat dateformat = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
				Date date;
				


			



				Connection c = null;
			        try
			        {
						date = dateformat.parse(userdate);

				        java.sql.Date d = new java.sql.Date(date.getTime()); 

						String url = "jdbc:postgresql://cs1.calstatela.edu/cs4222s04";
						String username = "cs4222s04";
						String password = "pU0ScEVQ";
						
						c = DriverManager.getConnection(url, username, password);

			            String sql = "insert into Album values (DEFAULT,DEFAULT,?,?,?,?)";
			            PreparedStatement pstmt = c.prepareStatement(sql);
			            pstmt.setInt(1,producer );
			            pstmt.setDate(2,d);
			            pstmt.setString(3, title);
			            pstmt.setString(4, format);

			            pstmt.executeUpdate();
			            
			           }
			        catch( SQLException | ParseException e )
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
