<%@ page language="java" contentType="text/html"%>
<!-- 
 <jsp:useBean id="calculator" class="beans.CalculatorBean" />


<jsp:setProperty name = "calculator" property = "*" />
<jsp:getProperty name = "calculator" property = "xstatus" /> 
<jsp:getProperty name = "calculator" property = "ystatus" />
-->

<%! 
	public void jspInit()
	{
		System.out.println("FORMDEMO.JSP IS LOADED");
	}   
		
%>

<html>
   <head>
      <title>calculate form page</title>
      <link href="mycss.css" rel="stylesheet" type="text/css"> 
   </head>
   <body>
         calculate form page
         <hr>
         <br>
        <form method="get" action="calculate">
            <table class = "center">
               <tr>
                  <td align="right">
                     x:
                  </td>
                  <td>
				 
				  <%
				  beans.CalculatorBean cb = (beans.CalculatorBean) request.getAttribute("calc");
				  
					if(cb != null)
					{
						if(cb.getXstatus() == 0){
							%>
							<input name="xvalue"  style="background-color:#DC143C;" value="0"  size="15">
							<%
						} else{
							%>
							<input name="xvalue"  value="0"  size="15">
							<%
						}
					}
					else{
						%>
						<input name="xvalue"  value="0"  size="15">
						<%
					}
				  %>
                  </td>
               </tr>
               <tr>
                  <td align="right">
                     y:
                  </td>
                  <td>
				  <%
					if(cb != null)
					{
						if(cb.getYstatus() == 0){
							%>
							<input name="yvalue"  style="background-color:#DC143C;" value="0"  size="15">
							<%
						} else{
							%>
							<input name="yvalue"  value="0"  size="15">
							<%
						}
					}
					else{
						%>
						<input name="yvalue"  value="0"  size="15">
						<%
					}
				  %>
                     
                  </td>
               </tr>
               <tr>
                  <td colspan = "2" align= "right">
                      <input type="submit" value=" tel op ">
                  </td>
               </tr>   
            </table>
		</form>
   </body>
</html>