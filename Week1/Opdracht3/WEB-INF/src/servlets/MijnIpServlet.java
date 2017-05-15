package servlets;

//MijnIpServlet.java

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class MijnIpServlet extends HttpServlet
{
   public void doGet(HttpServletRequest request,HttpServletResponse response)
                                         throws ServletException, IOException
   {
      response.setContentType("text/html");
      String ipAddress =  request.getRemoteAddr();
      log("IP Address: "+ipAddress);
      
      PrintWriter out = response.getWriter();
      String s =
      "<!doctype html public \"-//w3c//dtd html 4.0 Transitional//EN\">\n" +
      "<html>\n" +
      "   <head>\n" +
      "       <title>\n" +
      "          MijnIpServlet page\n" +
      "       </title>\n" +
      "   </head>\n" +
      "   <body bgcolor=\"#8AAFED\">\n" +
      "      <center>\n" +
      "         <h1>\n" +
      "            IpAdress: " + ipAddress + 
      "         </h1>\n" +
      "      </center>\n" +
      "   </body>\n" +
      "</html>\n";

      out.print(s); 
   }
}
