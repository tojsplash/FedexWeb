<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"                                                    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<input type="button" value="logout" style="float:right"onclick="window.location='home.jsp'">
<center><h1>   Pending Requests  </h1></center>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Authorize Requests</title>
</head>
<body bgcolor="">
<body background="http://www.wallpaperup.com/uploads/wallpapers/2013/11/14/175148/big_thumb_7d1e5024866338a55c886a955d2213f2.jpg">
<body>
<center>
<form method="post" action="RequestAuthorise">
<table border="2">
<tr>
<td><center>TrackingID</center></td>
<td><center>Item</center></td>
<td><center>From</center></td>
<td><center>City</center></td>
<td><center>To</center></td>
<td><center>City</center></td>
<td><center>Status</center></td>
<td><center>Action</center></td>
</tr>
<%
Class.forName("com.mysql.jdbc.Driver");
String url="jdbc:mysql://localhost/world";
String username="root";
String password="1415";
String query="select TrackingID,Item,from_Contact,SCity,to_Contact,DCity,status from shipment_creation where status='pending_approval'";
//query="select TrackingID,Item,from_Contact,SCity,to_Contact,DCity,status from shipment_creation";
Connection conn=DriverManager.getConnection(url,username,password);
Statement stmt=conn.createStatement();
String[] ckarray=new String[100];
ResultSet rs=stmt.executeQuery(query);
while(rs.next())
{
%>
    <tr><td><center><%=rs.getInt("TrackingID")%></center></td>
    <td><center><%=rs.getString("Item")%></center></td>
    <td><center><%=rs.getString("from_Contact")%></center></td>
    <td><center><%=rs.getString("SCity")%></center></td>
    <td><center><%=rs.getString("to_Contact")%></center></td>
    <td><center><%=rs.getString("DCity")%></center></td>
    <td><center><%=rs.getString("status")%></center></td>
    <td><center><select name="<%= rs.getInt("TrackingID")%>">
  <option value="pending_approval">N/A</option>
  <option value="Approved">Approve</option>
  <option value="Rejected">Reject</option>
</select>></center></td>
    </tr>
        <%
}
%>
    </table>
    <%
    rs.close();
    stmt.close();
    conn.close();
%>

<input type="submit" value ="Submit">
<input type="reset" value ="Reset">
</form>
</center>
</body>
</html> 