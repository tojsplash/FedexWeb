

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import javax.servlet.*;
/**
* Servlet implementation class Register
*/
@WebServlet("/register")
public class Login extends HttpServlet {
private static final long serialVersionUID = 1L;

/**
 * @see HttpServlet#HttpServlet()
 */
public Login() {
    super();
    // TODO Auto-generated constructor stub
}

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse  response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub


            response.setContentType("text/html");  
            PrintWriter pw = response.getWriter(); 
            //String connectionURL = "jdbc:mysql://127.0.0.1:3306/newData";// newData is the database  
            //Connection connection;  
            Connection conn=null;
            String url="jdbc:mysql://localhost:3306/";
            String dbName="userlogindb";
            String driver="com.mysql.jdbc.Driver";
        //String dbUserName="root";
        //String dbPassword="root";

        try{  
          String Fname = request.getParameter("fname");  
          String Mname = request.getParameter("mname");  
          String Lname = request.getParameter("lname");  
          String Uname = request.getParameter("username");  
          String Emailid = request.getParameter("emailid");  
          String Mobno = request.getParameter("mobno");  
          String Address = request.getParameter("address");  
          String Password1 = request.getParameter("password1");  
          String Password2 = request.getParameter("password2");  

          Class.forName(driver).newInstance();  
          conn = DriverManager.getConnection(url+dbName,"root", "root");
          PreparedStatement pst =(PreparedStatement) conn.prepareStatement("insert into 'userlogindb'.'registerutable'(fname,mname,lname,username,emailid,mobno,address,password1,password2) values(?,?,?,?,?,?,?,?,?)");//try2 is the name of the table  

          pst.setString(1,Fname);  
          pst.setString(2,Mname);        
          pst.setString(3,Lname);
          pst.setString(4,Uname);
          pst.setString(5,Emailid);
          pst.setString(6,Mobno);
          pst.setString(7,Address);
          pst.setString(8,Password1);
          pst.setString(9,Password2);


          int i = pst.executeUpdate();
          conn.commit(); 
          String msg=" ";
          if(i!=0){  
            msg="Record has been inserted";
            pw.println("<font size='6' color=blue>" + msg + "</font>");  


          }  
          else{  
            msg="failed to insert the data";
            pw.println("<font size='6' color=blue>" + msg + "</font>");
           }  
          pst.close();
        }  
        catch (Exception e){  
          pw.println(e);  
        }  

}

}