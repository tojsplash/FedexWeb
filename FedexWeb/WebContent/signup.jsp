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

<script>  

function validateform(){  
	
var fname=document.signup.fname.value; 
var lname=document.signup.lname.value;
var username=document.signup.username.value;
var password=document.signup.password1.value; 
var firstpassword=document.signup.password1.value;  
var secondpassword=document.signup.password2.value;
var Email=document.signup.emailid.value;

var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

if (!filter.test(Email)) {
alert('Please provide a valid email address');
return false;
}


if (fname==null || fname=="" || lname==null || lname==""){  
	  alert("Name can't be blank");  
	  return false;  
	}
	
if(username==null || username==""){
	
	alert("Userame can't be blank");  
	  return false;
}
if(password.length<6){  
	  alert("Password must be at least 6 characters long.");  
	  return false;  
	  }  
	  
	if(firstpassword==secondpassword){  
		return true;  
		}  
		else{  
		alert("password must be same!");  
		return false;  
		}   
	
}

</script> 


<form action = "Insertuser" method="post"name = "signup" onsubmit="return validateform()">

<u><h3>Enter Your Details</h3></u>

<pre>First Name          <input type="text" name = "fname"/><br>
Last Name           <input type="text" name="lname" /><br>
Username            <input type="text" name="username" /><br>
Password            <input type="password" name="password1" /><br>
Confirm Password    <input type="password" name="password2" /><br>
email               <input type="text" name="emailid" /><br>
cell                <input type="number" name="mobno"> <br/></pre>

<input type="submit" value="Register"  />
<input type="reset" value="Reset" />
<input type="button" value="Back"onclick="window.location='home.jsp'"/>
</form>
</body>
</html>
