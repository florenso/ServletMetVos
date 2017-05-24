package beans;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.*;
import java.text.*;
import java.io.*;


public class LoginManager 
{
	String username;
	String password;
    boolean loginCorrect = false;
	
	class LoginData{
			public String username;
			public String password;
			public String lastLoginTime;
	}
	
	private List<LoginData> currentAllowedLogins;
	private String currentFilePath;
	

	public LoginManager(String filePath) {
		currentAllowedLogins = new ArrayList<LoginData>();
		currentFilePath = filePath;
		readFile(filePath);
    }
	
	private void readFile(String filePath){
		BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
				LoginData currentData = new LoginData();
				String[] dataSplitting = line.split(" ");
				currentData.username = dataSplitting[0];
				currentData.password = dataSplitting[1];
				currentData.lastLoginTime = dataSplitting[2];
				
				currentAllowedLogins.add(currentData);
				
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
	}
	
	public boolean checkLogin(String usr, String pass){
		for(LoginData ld : currentAllowedLogins){
			if(ld.username.equals(usr) && ld.password.equals(pass)){
		
				return true;
			}
		}
		return false;
	}
		
	public void writeLastTimeLogin(String usr){
		for(LoginData ld : currentAllowedLogins){
			if(ld.username.equals(usr)) {
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
				Date date = new Date();
				System.out.println(dateFormat.format(date));
				ld.lastLoginTime = dateFormat.format(date);
			}
		}
		 writeFile();
	}
	
	private void writeFile(){
		File fout = new File(currentFilePath);
		try{
			
			FileOutputStream fos = new FileOutputStream(fout);
		 
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		 
			for(LoginData ld : currentAllowedLogins){
				bw.write(ld.username + " " + ld.password + " " + ld.lastLoginTime);
				bw.newLine();
			}
		 
			bw.close();	
		}
		catch(IOException e){
			e.printStackTrace(); 
		}
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


