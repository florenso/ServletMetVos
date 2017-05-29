<%@ page language="java" contentType="text/html"%>

<%! 
	public void jspInit()
	{
	    log("WelkomPagina bereikt");
	}   
%>

<html>
<head>
<title>Welkom pagina</title>
<link href="mycss.css" rel="stylesheet" type="text/css">
</head>
<body>
		<h1>Welkom in het geheime gedeelte van die alleen toegankelijk is voor echt bijzondere mensen.</h1>
		<%
		String lastTimeLogin = (String) request.getAttribute("lastTimeLogin");
		String loginTimes = (String) request.getAttribute("loginTimes");

		if(lastTimeLogin != null && loginTimes != null)
		{
			%>
			Last time you logged in: <b> <%= lastTimeLogin %> </b> <br>
			You logged <%= loginTimes %> time(s) in.
			<%
		} 
		else{
			%>
			Something went terribly wrong, please contact your creator...
			<%
		}
		%>
	<br>
	<hr>
</body>
</html>