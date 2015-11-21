<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Login</title>

</head>

<body bgcolor="blue">


<script>  
function validateform(){  
var userid=document.home.userid.value;  
var pswrd=document.home.pswrd.value;


  
if (userid==null || userid=="" || pswrd==null || pswrd==""){  
  alert("Username/Password can't be blank");  
  return false;  
}
}

</script> 



<center><h1>Welcome to Package Creation and Tracking System</h1></center>

<center><h4>Enter Username and Password to proceed</h4></center>

<form name="home" action="Validateuser" onsubmit="return validateform()" method="post">

           <center>Username<input type="text" name="userid" style="width: 150px;"/> <br></center> 

            <center>Password<input type="password" name="pswrd" style="width: 150px;"/><br></center>
           <center><h4>*Invalid Username/Password</h4></center>
             

             <p style="text-indent:39em;"><input type="reset" value="Reset"/>

             <input type="submit" value="Login"></p>

             <p style="text-indent:40em;"><input type="button" value="Signup" onclick="window.location='signup.jsp'"/>

            <sub>Click Signup if you are a new user </sub></p>

            <p style="text-indent:40em;"><input type="reset" value="Cancel"/></p>  
           

        </form>

</body>

</html>