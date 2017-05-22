<!doctype html public \"-//w3c//dtd html 4.0 Transitional//EN\">
<html>
 <head>
 <title>
 Opdracht 1 van Week 2
 </title>
 </head>
 <body>
 <h1>
 Hallo dit is de servlet van Opdracht 1 van Week 2
 </h1>
<h2>Je bezoekt deze pagina met het volgende ip-address:
</h2>
<h3>
<%
    String ipAddress =  request.getRemoteAddr();
  %>
Ip-Address: <%= ipAddress %>
</h3>
 </body>
</html>