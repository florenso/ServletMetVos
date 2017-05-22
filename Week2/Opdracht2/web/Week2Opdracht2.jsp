<%@ page import="java.util.Date" %>

<!doctype html public \"-//w3c//dtd html 4.0 Transitional//EN\">
<html>
 <head>
 <title>
 Opdracht 2 van Week 2
 </title>
 </head>
 <body>
 <h1>
 Hallo dit is de servlet van Opdracht 2 van Week 2
 <br>
 Dit is de LaatsteAanroep servlet omgebouwd tot JSP pagina.
 </h1>
 
 <%
       // Return the existing session if there is one. Create a new session otherwise.
      HttpSession sessie = request.getSession();
      Integer accessCount;
      synchronized(sessie) {
         accessCount = (Integer)sessie.getAttribute("accessCount");
         if (accessCount == null) {
            accessCount = 0;   // autobox int to Integer
         } else {
            accessCount = new Integer(accessCount + 1);
         }
         sessie.setAttribute("accessCount", accessCount);
      }
 
 %>
 
 <h2>You have access this site <%= accessCount%>  times in this session.</h2>
 <p>Session ID is <%= sessie.getId() %></p>
 <p>Session creation time is  <%= new Date(sessie.getCreationTime()) %> </p>
 <p>Session last access time is  <%= new Date(sessie.getLastAccessedTime()) %> </p>
 <p>Session max inactive interval  <%= new Date(sessie.getMaxInactiveInterval()) %> </p>
 
 <p><a  href='<%=request.getRequestURI()%>'>Refresh</a>
 <p><a  href='<%=response.encodeURL(request.getRequestURI())%>'>Refresh with  URL rewriting</a>
			   
 </body>
</html>