package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.DatabaseConnection;
import javax.servlet.ServletContext;

@SuppressWarnings("serial")

public class ExecuteQueryInDatabase extends HttpServlet
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
	  String query = request.getParameter("query");
	  String result = request.getParameter("result");
	  // Default constructor.
		
	  String relativeWebPath = "/WEB-INF/database_test.sqlite";
		
	  String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
      System.out.println("DatabaseFilePath: " +absoluteDiskPath );
	  
	  DatabaseConnection cb = new DatabaseConnection(absoluteDiskPath);

      request.setAttribute("queryResult", cb.executeSqlQueryWithResult(query));  

	  
	  
	  String url = "query.jsp";
		 
		  
 
	  RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	  dispatcher.forward(request, response);
  }
}

