<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Track</title>

</head>

<body bgcolor="blue">
<input type="button" value="logout" style="float:right"onclick="window.location='home.jsp'">

<script>  
function validateform(){  
var ids=document.home.ids.value;  
  
if (ids==null || ids==""){  
  alert("Please enter a tracking ID");  
  return false;
    
}
}

</script> 

<%

String id = session.getAttribute("name").toString();
session.setAttribute("name", id);

%>



<center><h1>Track Your Packages in a single click !!!</h1></center>

<center><h4>Enter Tracking IDs Separated by Commas</h4></center>

<form name="home" action="track" onsubmit="return validateform()" method="post">

           <center><input type="text" name="ids" style="width: 150px;"/> <br></center> 

             <p style="text-indent:36.8em;"><input type="reset" value="Reset"/>

             <input type="Submit" value="Track"/></p>

        </form>

</body>

</html>