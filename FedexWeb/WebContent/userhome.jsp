<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>UserHome</title>

</head>

<body bgcolor="green">
 

<input type="button" value="logout" style="float:right"onclick="window.location='home.jsp'">

<%

String id = request.getAttribute("name").toString();
response.setHeader("name", id);

%>

<center><h1>Welcome to Home Mr. <%= id %> !!!  </h1></center>

        <form name="userhome">
        
           
<p style="text-indent:3em;"><input type="button" value="Create Shipment" style = "width: 25em" onclick="window.location='Createpackage.jsp'"
/>
 <img src="packaging.jpg" width="850" height="600" style="float: right"><br>
<p style="text-indent:3em;"> <input type="button" value="Track Shipment" style = "width: 25em"  onclick="window.location='track.jsp'"/><br>
<p style="text-indent:3em;"><input type="button" value="Shipment History" style = "width: 25em" onclick="window.location='history.jsp'"/><br>
		
         
             

        </form>

</body>

</html>