<%@ page language="java" contentType="text/html"%>
<%! 
	public void jspInit()
	{
		System.out.println("LoginPage");
	}   
		
%>

<html>
   <head>
      <title>Login Page for secret </title>
      <link href="mycss.css" rel="stylesheet" type="text/css"> 
   </head>
   <body>
         User Login Page
         <hr>
         <br>
		 
		<%
		beans.LoginManager log = (beans.LoginManager) request.getAttribute("login");

		if(log != null)
		{
			%>
			Login status was: <b> <%= log.getLoginIncorrect() %> </b> 
			<br>
			<h1>User is added to database!! Please try again.</h1>
			<%
		}
		%>
		 
        <form method="get" action="welcome">
            <table class = "center">
               <tr>
                  <td align="right">
                     Username:
                  </td>
                  <td>
				  <input name="username"  value="Username"  size="15">
                  </td>
               </tr>
               <tr>
                  <td align="right">
                     Password:
                  </td>
                  <td>
                     <input type="password" name="passie"  value="Password"  size="15">
                  </td>
               </tr>
               <tr>
                  <td colspan = "2" align= "right">
                      <input type="submit" value="Inloggen">
                  </td>
               </tr>   
            </table>
		</form>
   </body>
</html>