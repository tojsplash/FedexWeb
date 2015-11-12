<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign up</title>
</head>
<body bgcolor="green">
<center><h1>Welcome to the Registration Page !!!</h1></center>

<form action="Insertuser" method="post" name = "signup" >
<u><h3>Enter Your Details</h3></u>

<pre>First Name          <input type="text" name = "fname"/><br>
Last Name           <input type="text" name="lname" /><br>
Username            <input type="text" name="username" /><br>
Password            <input type="password" name="password1" /><br>
Confirm Password    <input type="password" name="password2" /><br>
email               <input type="text" name="emailid" /><br>
cell                <input type="text" name="mobno" /><br></pre>

<h4><font color="black">You have been successfully added to the Tracking system !!!</font></h4>

<input type="submit" value="Register"  />
<input type="reset" value="Reset" />
<input type="button" value="Back"onclick="window.location='home.jsp'"/>
</form>
</body>
</html>
