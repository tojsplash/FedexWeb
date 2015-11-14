
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create shipment</title>
</head>
<body bgcolor="green">

<script>  
function validateform(){  
	var Item=document.Createpackage.Item.value;  
	var No_of_Packages=document.Createpackage.NoofPackages.value;
	var Packaging_type=document.Createpackage.Packagingtype.value;
	var Package_Declared_Value=document.Createpackage.PackageDeclaredValue .value; 
	var Company_or_name=document.Createpackage.CompanyorName.value;   
	var Contact=document.Createpackage.Contact.value;
	var Address_line1=document.Createpackage.Addressline1.value;
	var Address_line2=document.Createpackage.Addressline2.value;
	var zipcode=document.Createpackage.Zipcode.value;
	var Email=document.Createpackage.Email.value;
	var Country=document.Createpackage.Country.value;
	var from_Company_or_name=document.Createpackage.from_CompanyorName.value;
	var from_Contact=document.Createpackage.from_Contact.value;
	var from_Address_line1=document.Createpackage.from_Addressline1.value;
	var from_Address_line2=document.Createpackage.from_Addressline2.value;
	var from_zipcode=document.Createpackage.from_Zipcode.value;
	var from_Email=document.Createpackage.from_Email.value;
	var from_Country=document.Createpackage.from_Country.value;
	var Scity=document.Createpackage.Scity.value;
	var Dcity=document.Createpackage.Dcity.value;
	var service=document.Createpackage.radio.value;
	

	if (Item == "" || Item == null || No_of_Packages =="" ||  No_of_Packages ==null || Packaging_type =="" || Packaging_type == null ||
			Package_Declared_Value == "" || Package_Declared_Value== null || Company_or_name == "" || Company_or_name == null || Contact =="" ||  
			Contact ==null || Address_line1 =="" || Address_line1 == null || Address_line2 == "" || Address_line2== null
	|| zipcode == "" || zipcode == null || Email =="" ||  Email ==null || Country =="" || Country == null ||
	from_Company_or_name == "" || from_Company_or_name == null || from_Contact =="" ||  from_Contact ==null || from_Address_line1 =="" || from_Address_line1 == null || Address_line2 == "" || 
	from_Address_line2== null|| from_zipcode == "" || from_zipcode == null || from_Email =="" ||  from_Email ==null || from_Country =="" || from_Country == null ||
	service =="" || service ==null || Scity =="" || Scity ==null || Dcity =="" || Dcity ==null){

		alert("Please fill all fields"); 
		return false;

		}	
	var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

    if ((!filter.test(Email)) || (!filter.test(from_Email))) {
    alert('Please provide a valid email address');
    //email.focus;
    return false;
 }



	}  
	  
</script> 





<form   action="Package_Creation" method="post" name = "Createpackage" onsubmit="return validateform()">

<%

String id = session.getAttribute("name").toString();


%>

<input type="hidden" name="name" value="<%=id%>" />

<input type="button" value="logout" style="float:right"onclick="window.location='home.jsp'">

<u><h3>Begin Your Shipment</h3></u>
<u><h4>What are you Shipping?</h4></u>
<pre>Item                     <input type="text" name="Item"/><br>
No of Packages        	 <input type="text" name="NoofPackages" min="0"/><br>
Packaging type        	 <select name="Packagingtype">
<option>package</option>
<option>Express Freight</option>
<option>Envelope</option>
</select><br>
Package Declared Value   <input type="number" name="PackageDeclaredValue" min="0"/>in $<br></pre>


<u><h4>Where is this shipment going?</h4></u>
<pre>Company or Name 	 <input type="text" name="CompanyorName"/><br>
Contact 		 <input type="number" name="Contact" min="0"/><br>
Country 		 <select name="Country">
<option value="">Country...</option>
<option value="United States">United states</option></select><br>
D.City 	                 <select name="Dcity"/><br>

<option value="">City</option>

<option value="Northborough MA">Northborough MA</option>

<option value="Edison NJ">Edison NJ</option>

<option value="Allentown PA">Allentown PA</option>

<option value="Martinsburg WV">Martinsburg WV</option>

<option value="Charlotte NC">Charlotte NC</option>

<option value="Atlanta GA">Atlanta GA</option>

<option value="Orlando FL">Orlando FL</option>

<option value="Memphis TN">Memphis TN</option>

<option value="Grove City OH">Grove City OH</option>

<option value="Baltimore MD">Baltimore MD</option>

<option value="Indianapolis IN">Indianapolis IN</option>

<option value="Detroit MI">Detroit MI</option>

<option value="New Berlin WI">New Berlin WI</option>

<option value="Minneapolis MN">Minneapolis MN</option>

<option value="St. Louis MO">St. Louis MO</option>

<option value="Kansas KS">Kansas KS</option>

<option value="Dallas TX">Dallas TX</option>

<option value="Houston TX">Houston TX</option>

<option value="Denver CO">Denver CO</option>

<option value="Salt Lake City U">Salt Lake City U</option>

<option value="Phoenix AZ">Phoenix AZ</option>

<option value="Los Angeles CA">Los Angeles CA</option>

<option value="Chino CA">Chino CA</option>

<option value="Sacramento CA">Sacramento CA</option>

<option value="Seattle WA">Seattle WA</option></select>

Address line1 	         <input type="text" name="Addressline1"/><br>
Address line2 	         <input type="text" name="Addressline2" /><br>
Zip code 		 <input type="number" name="Zipcode" min="0"/><br>
Email 			 <input type="text" name="Email"/><br></pre>


<u><h4>Where is this shipment coming from?</h4></u>
<pre>Company or Name 	 <input type="text" name="from_CompanyorName"/><br>
Contact 		 <input type="number" name="from_Contact" min="0"/><br>
Country 		 <select name="from_Country">
<option value="">Country...</option>
<option value="United States">United states</option></select><br>
S.City 	                 <select name="Scity" /><br>
<option value="">City</option>

<option value="Northborough MA">Northborough MA</option>

<option value="Edison NJ">Edison NJ</option>

<option value="Allentown PA">Allentown PA</option>

<option value="Martinsburg WV">Martinsburg WV</option>

<option value="Charlotte NC">Charlotte NC</option>

<option value="Atlanta GA">Atlanta GA</option>

<option value="Orlando FL">Orlando FL</option>

<option value="Memphis TN">Memphis TN</option>

<option value="Grove City OH">Grove City OH</option>

<option value="Baltimore MD">Baltimore MD</option>

<option value="Indianapolis IN">Indianapolis IN</option>

<option value="Detroit MI">Detroit MI</option>

<option value="New Berlin WI">New Berlin WI</option>

<option value="Minneapolis MN">Minneapolis MN</option>

<option value="St. Louis MO">St. Louis MO</option>

<option value="Kansas KS">Kansas KS</option>

<option value="Dallas TX">Dallas TX</option>

<option value="Houston TX">Houston TX</option>

<option value="Denver CO">Denver CO</option>

<option value="Salt Lake City U">Salt Lake City U</option>

<option value="Phoenix AZ">Phoenix AZ</option>

<option value="Los Angeles CA">Los Angeles CA</option>

<option value="Chino CA">Chino CA</option>

<option value="Sacramento CA">Sacramento CA</option>

<option value="Seattle WA">Seattle WA</option></select>

Address line1 	         <input type="text" name="from_Addressline1"/><br>
Address line2 	         <input type="text" name="from_Addressline2"/><br>
Zip code 		 <input type="number" name="from_Zipcode" min="0"/><br>
Email 			 <input type="text" name="from_Email"/><br></pre>

<u><h4>How do you want us to collect your shipment?</h4></u>
<input type="radio" name="radio" value="Pickup"/>Pick up from your above address
<input type="radio" name="radio" value="DropOff"/>Drop off at nearest location
<br><br>
<input type="submit" value="submit"/>
<input type="button" value="Cancel" onclick="window.location='userhome.jsp'"/>
<input type="reset" value="Reset"/>
</form>
</body>
</html>
