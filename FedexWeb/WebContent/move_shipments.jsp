<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Move Shipments</title>

</head>

<body bgcolor="blue">
<input type="button" value="logout" style="float:right"onclick="window.location='home.jsp'">

<script>  
function validateform(){  
var count=document.home.count.value;  
  
if (count==null || count==""){  
  alert("Please enter number of packets to be shipped");  
  return false;
    
}
}

</script> 

<%

String id = session.getAttribute("name").toString();
session.setAttribute("name", id);

%>



<center><h1>Start shipping the Packages !!!</h1></center>

<center><h4>Enter Number of packets to be shipped</h4></center>

<form name="home" action=move_shipment onsubmit="return validateform()" method="post">

           <center><input type="text" name="count" style="width: 150px;"/> <br></center> 

             <p style="text-indent:36.8em;"><input type="reset" value="Reset"/>

             <input type="Submit" value="Ship"/></p>

        </form>

</body>

</html>