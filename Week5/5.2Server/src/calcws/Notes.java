//Notes.java
package calcws;

import javax.jws.WebService;
import javax.jws.WebParam;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;

@WebService
public class Notes {
	// JDBC driver name and database URL
    private String JDBC_DRIVER = "org.sqlite.JDBC";  
	private String DB_URL = "jdbc:sqlite:";
		
    private Connection conn = null;
    private Statement stmt = null;
	
	
	private List<Note> allNotes;
	
	public Notes(){
		allNotes = new ArrayList<Note>();
		createDatabase();
		//readDatabase();
	}

	private void executeSqlQueryWithoutResult(String query){
			try{
				Class.forName("org.sqlite.JDBC");
				conn = DriverManager.getConnection(DB_URL);
				stmt = conn.createStatement();
				stmt.executeUpdate(query);
				stmt.close();
				conn.close();
			}
			catch(SQLException se){
				//Handle errors for JDBC
				se.printStackTrace();
			}catch(Exception e){
				//Handle errors for Class.forName
				e.printStackTrace();
			}finally{
				//finally block used to close resources
				try{
					if(stmt!=null)
						stmt.close();
					}catch(SQLException se2){
					}// nothing we can do
					try{
						if(conn!=null)
						conn.close();
					}catch(SQLException se){
						se.printStackTrace();
				}//end finally try
			}
	}

	private void createDatabase(){
		System.out.println("Database Created");
		String sql;
		sql = "CREATE TABLE IF NOT EXISTS Notes(id INTEGER,noteText TEXT,noteTimeStamp DATE, PRIMARY KEY (id));";
		executeSqlQueryWithoutResult(sql);
	}
	
	
	public boolean addNote(@WebParam(name="text") String tekst){
		String sql;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String date = sdf.format(new Date());
		sql = "INSERT INTO Notes (noteText, noteTimeStamp) VALUES ('"+tekst+"', '"+date+");";
		executeSqlQueryWithoutResult(sql);
		System.out.println("request addNote(" + tekst + ")");
		return false;
	}
	
	public boolean removeNote(@WebParam(name="id") int  noteId){
		String sql = "DELETE FROM Notes WHERE id='"+noteId+"';";
		executeSqlQueryWithoutResult(sql);
		System.out.println("request removeNote(" + noteId + ")");
		return false;
	}

	public List<Note> getNotes(){

		return allNotes;
	}
	

}