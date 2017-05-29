package beans;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.*;
import java.text.*;
import java.io.*;
import java.sql.*;


public class DatabaseConnection 
{
	
	// JDBC driver name and database URL
    private String JDBC_DRIVER = "org.sqlite.JDBC";  
	private String DB_URL = "jdbc:sqlite:";
   

	private Connection conn = null;
    private Statement stmt = null;
	



	public DatabaseConnection(String filePath) {
		DB_URL += filePath;
    }
	
	public void executeSqlQueryWithoutResult(String query){
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
	
	public String executeSqlQueryWithResult(String sql){
		String finalResult = "";
			try{
				Class.forName("org.sqlite.JDBC");
				conn = DriverManager.getConnection(DB_URL);
				stmt = conn.createStatement();
				ResultSet resultSet = stmt.executeQuery(sql);
				ResultSetMetaData rsmd = resultSet.getMetaData();
				int columnsNumber = rsmd.getColumnCount();
				
				while (resultSet.next()) {
					for (int i = 1; i <= columnsNumber; i++) {
						if (i > 1) finalResult +=" ,  \n";
						String columnValue = resultSet.getString(i);
						finalResult += columnValue + " " + rsmd.getColumnName(i) + "\n";
					}
					finalResult += "\n";
				}
				resultSet.close();
				
				stmt.close();
				conn.close();
			}
			catch(SQLException se){
				//Handle errors for JDBC
				se.printStackTrace();
				finalResult = se.toString();
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
		
			return finalResult;

	}
	


}


