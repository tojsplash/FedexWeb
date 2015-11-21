<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"                                                    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<input type="button" value="logout" style="float:right"onclick="window.location='home.jsp'">
<center><h1>     Tracking Summary  </h1></center>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tracking Details</title>
</head>
<body bgcolor="">
<body>
<center>
<form >
<%



String TrackingIDs = request.getAttribute("ids").toString();


String[] str_array = TrackingIDs.split(",");
int length = str_array.length;
for(int i = 0;i<length;i++){
	%>


<%
Class.forName("com.mysql.jdbc.Driver");
String url="jdbc:mysql://localhost/world";
String username="root";
String password="1415";
String query="select TrackingID,Item,No_of_Packages,Packaging_type,SCity,DCity from shipment_creation  WHERE TrackingID = " + str_array[i] + "";
//query="select TrackingID,Item,from_Contact,SCity,to_Contact,DCity,status from shipment_creation";
Connection conn=DriverManager.getConnection(url,username,password);
Statement stmt=conn.createStatement();
String[] ckarray=new String[100];
ResultSet rs=stmt.executeQuery(query);
while(rs.next())
{
%>
	<h3>   Shipment Details  </h3>
	<table border="2">
<tr>
<td><center>TrackingID</center></td>
<td><center>Item</center></td>
<td><center>No of Items</center></td>
<td><center>Packaging</center></td>
<td><center>Source City</center></td>
<td><center>Destination City</center></td>

</tr>
    <tr><td><center><%=rs.getInt("TrackingID")%></center></td>
    <td><center><%=rs.getString("Item")%></center></td>
    <td><center><%=rs.getString("No_of_Packages")%></center></td>
    <td><center><%=rs.getString("Packaging_type")%></center></td>
    <td><center><%=rs.getString("SCity")%></center></td>
    <td><center><%=rs.getString("DCity")%></center></td>
</tr>
<%
}
%>

    <%
    rs.close();
    stmt.close();   
%>

 </table>
 
<table border="2">
<%
String status ="";
String query1="select * from nodes  WHERE TrackingID = " + str_array[i] + "";
Connection conn1=DriverManager.getConnection(url,username,password);
Statement stmt1=conn1.createStatement();
ResultSet rs1=stmt1.executeQuery(query1);
while(rs1.next())
{
	for (int m = 1; m <= 12;  m++) {
		
		if (rs1.getString("Node" + m) == null) {
			
			break;
		}	

		if (rs1.getString("Node" + m) != null) {
			 status = rs1.getString("Node" + m);

		}
%>
    
    
    <tr><td><center><%=status%></center></td>
    </tr>

<%
	}
	%>
	 <h3>   Tracking Details  </h3>	
    </table>
 
 <%
}
conn1.close();
%>

<%
}

%>
  
<input type = "Button" value ="Back"onclick="window.location='track.jsp'"/>
</form>
</center>
</body>
</html> 