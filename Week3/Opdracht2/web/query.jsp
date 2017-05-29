<%@ page language="java" contentType="text/html"%>

<%! 
	public void jspInit()
	{
	    log("Query Pagina voor Database Queries.");
	}   
%>

<html>
<head>
<title>Database Query pagina</title>
<link href="mycss.css" rel="stylesheet" type="text/css">
</head>
<body>
		<h1>Voer hier alle database query's uit met resultaat. </h1>
		<form method="get" action="query">
            <table class = "center">
               <tr>
                  <td align="right">
                     Query :
                  </td>
                  <td>
				  <input name="query"  value="SELECT username, password, lastLoginTime, loginTimes FROM LoginData"  size="150">
                  </td>
               </tr>
               
               <tr>
                  <td colspan = "2" align= "right">
                      <input type="submit" value="Execute Query">
                  </td>
               </tr>   
            </table>
		</form>
		
		
		<%
		String query = (String) request.getAttribute("queryResult");


		if(query != null)
		{
			%>
			Query Result: <b> <%= query %> </b> <br>
			<%
		} 
		%>
	<br>
	<hr>
</body>
</html>