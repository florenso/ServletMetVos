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


public class LoginManager 
{
	String username;
	String password;
    boolean loginCorrect = false;
	
	// JDBC driver name and database URL
    private String JDBC_DRIVER = "org.sqlite.JDBC";  
	private String DB_URL = "jdbc:sqlite:";
   
   	private List<LoginData> currentAllowedLogins;
	private String currentFilePath;
	private Connection conn = null;
    private Statement stmt = null;
	
	class LoginData{
			public String username;
			public String password;
			public String lastLoginTime;
			public int loginTimes;
	}
	


	public LoginManager(String filePath) {
		currentAllowedLogins = new ArrayList<LoginData>();
		currentFilePath = filePath;
		DB_URL += filePath;
		createDatabase();
		readFromDatabase();
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
		String sql;
		sql = "CREATE TABLE IF NOT EXISTS LoginData(id Integer,username varchar(255),password varchar(255),lastLoginTime varchar(255),loginTimes Integer,PRIMARY KEY (id));";
		executeSqlQueryWithoutResult(sql);
	}
	
	private void readFromDatabase(){
		   try{
				Class.forName("org.sqlite.JDBC");
				conn = DriverManager.getConnection(DB_URL);
				stmt = conn.createStatement();
				String sql;
				sql = "SELECT username, password, lastLoginTime, loginTimes FROM LoginData";
				ResultSet rs = stmt.executeQuery(sql);

				while(rs.next()){
					//Retrieve by column name
					LoginData currentData = new LoginData();

					currentData.username = rs.getString("username");
					currentData.password = rs.getString("password");
					currentData.lastLoginTime = rs.getString("lastLoginTime");
					currentData.loginTimes = rs.getInt("loginTimes");
				
					currentAllowedLogins.add(currentData);
				}
					rs.close();
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
				}//end try
	}
	
	public boolean checkLogin(String usr, String pass){
		for(LoginData ld : currentAllowedLogins){
			if(ld.username.equals(usr) && ld.password.equals(pass)){
		
				return true;
			}
		}
		//user doesn't exist yet.... So we will add him to the database
		addUserToDatabase(usr, pass);
		return false;
	}
		
	private void addUserToDatabase(String usr, String pass){
		String sql;
		String lastLoginTime = "NOT YET SET";
		sql = "INSERT INTO LoginData (username, password, lastLoginTime, loginTimes) VALUES ('"+usr+"', '"+pass+"', '"+lastLoginTime+"', 1);";
		executeSqlQueryWithoutResult(sql);
	}
		
	public void writeLastTimeLogin(String usr){
		for(LoginData ld : currentAllowedLogins){
			if(ld.username.equals(usr)) {
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
				java.util.Date date = new java.util.Date();
				System.out.println(dateFormat.format(date));
				ld.lastLoginTime = dateFormat.format(date);
				ld.loginTimes += 1;
				updateLastLoginTime(usr, ld.lastLoginTime, ld.loginTimes);
			}
		}
	 
	}
	
	private void updateLastLoginTime(String usr, String lastLoginTime, int loginTimes){
		String sql = "UPDATE LoginData SET lastLoginTime = '"+lastLoginTime+"', loginTimes='"+Integer.toString(loginTimes)+"' WHERE username='"+usr+"';";
		executeSqlQueryWithoutResult(sql);
	}
	
	public String loginTimesForUser(String usr){
		for(LoginData ld : currentAllowedLogins){
			if(ld.username.equals(usr)){
				return Integer.toString(ld.loginTimes);
			}
		}
		return "HACK DETECTED: USER NOT FOUND, IMPOSSIBLE LET'S CALL THE COPS";
	}
	
	public String lastTimeLoginForUser(String usr){
		for(LoginData ld : currentAllowedLogins){
			if(ld.username.equals(usr)){
				return ld.lastLoginTime;
			}
		}
		return "USER NOT FOUND, IMPOSSIBLE LET'S CALL THE COPS";
	}
	
	public boolean getLoginIncorrect(){
		return loginCorrect;
	}

}


