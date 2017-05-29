package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.LoginManager;
import javax.servlet.ServletContext;

@SuppressWarnings("serial")

public class LoginPage extends HttpServlet
{
   public void init() throws ServletException
   {
      super.init();
      log("servlet init");
   }
   
   public void destroy()
   {

      log("servlet destroy");
      super.destroy();
   }
   
   public void doGet(HttpServletRequest request,HttpServletResponse response)
                                         throws ServletException, IOException
   {
	  String user = request.getParameter("username");
	  String pass = request.getParameter("passie");
	  String url = "";
	  
	  // Default constructor.
		
	  String relativeWebPath = "/WEB-INF/logins.sqlite";
		
	  String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
      System.out.println("LOGINS.txt path: " +absoluteDiskPath );
		
	  LoginManager cb = new LoginManager(absoluteDiskPath);
	 
	  
	  
	  
	  if(cb.checkLogin(user, pass))
	  {
		  request.setAttribute("lastTimeLogin", cb.lastTimeLoginForUser(user));
		  request.setAttribute("loginTimes", cb.loginTimesForUser(user));
		  url = "welcome.jsp";
		  cb.writeLastTimeLogin(user);
	  }
	  else {
		  request.setAttribute("login", cb);
		  System.out.println("Login Incorrect");
		  url = "loginpage.jsp";
	  }
		  
 
	  RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	  dispatcher.forward(request, response);
  }
}

