package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Album;
import models.Instrument;
import models.Musician;
import models.Performedby;
import models.Playedby;
import models.Song;

@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//Load mySql driver class
	public void init(ServletConfig config) throws ServletException{
		super.init( config );

		try{
			Class.forName( "org.postgresql.Driver" );
		}
		catch( ClassNotFoundException e ){
			throw new ServletException( e );
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Album> albums = new ArrayList<Album>();
		List<Song> songs = new ArrayList<Song>();
		List<Musician> musicians = new ArrayList<Musician>();
		List<Instrument> instruments = new ArrayList<Instrument>();
		List<Performedby> performedby = new ArrayList<Performedby>();
		List<Playedby> Playedby = new ArrayList<Playedby>();

		Connection c = null;
		try {
			String url = "jdbc:postgresql://cs1.calstatela.edu/cs4222s04";
			String username = "cs4222s04";
			String password = "pU0ScEVQ";
			c = DriverManager.getConnection(url, username, password);
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM album;");
			
			while(rs.next()) {
				Album entry = new Album(rs.getInt("id"), rs.getDate("copyrightDate"), rs.getString("title"), rs.getString("format"), rs.getInt("albumId"),rs.getInt("pSSN"));
				albums.add(entry);
			}
			
			rs = stmt.executeQuery("SELECT * FROM song;");
			
			while(rs.next()) {
				Song entry = new Song(rs.getString("title"), rs.getInt("album_id"), rs.getInt("song_id"));
				songs.add(entry);
			}
			
			rs = stmt.executeQuery("SELECT * FROM musician;");
			
			while(rs.next()) {
				Musician entry = new Musician(rs.getInt("ssn"), rs.getString("name"), rs.getInt("phone"), rs.getString("address"));
				musicians.add(entry);
			}
			
			rs = stmt.executeQuery("SELECT * FROM instrument;");
			
			while(rs.next()) {
				Instrument entry = new Instrument(rs.getInt("id"), rs.getString("name"), rs.getString("musicalKey"));
				instruments.add(entry);
			}
			
			rs = stmt.executeQuery("Select Musician.name,Song.title from performedby INNER join Musician on performedby.Mssn = Musician.ssn INNER join Song on performedby.song_id = Song.song_id ;");
			
			while(rs.next()) {
				Performedby entry = new Performedby(rs.getString("name"), rs.getString("title"));
				performedby.add(entry);
			}
			rs = stmt.executeQuery("Select Musician.name,Instrument.name as title from Playedby \r\n" + 
					"INNER join Musician on Playedby.Mssn = Musician.ssn \r\n" + 
					"INNER join Instrument on Playedby.Instrument_id = Instrument.id ;");
			
			while(rs.next()) {
				Playedby entry = new Playedby(rs.getString("name"), rs.getString("title"));
				Playedby.add(entry);
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		} finally {
			try {
				if(c != null)
					c.close();
			} catch(SQLException e) {
				throw new ServletException(e);
			}
		}
		
		request.setAttribute("albums", albums);
		request.setAttribute("songs", songs);
		request.setAttribute("musicians", musicians);
		request.setAttribute("instruments", instruments);
		request.setAttribute("performedby", performedby);
		request.setAttribute("Playedby", Playedby);

		request.getRequestDispatcher("/WEB-INF/helloo.jsp").forward(request, response);
	}



}
