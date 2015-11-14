package testcases;
import junit.framework.TestCase;
import com.meterware.httpunit.*;
import junit.framework.*;

public class SignupTest extends TestCase {
	public void testBadSignup() throws Exception {
        WebConversation     conversation = new WebConversation();
        WebRequest  request = new GetMethodWebRequest( 
            "http://localhost:8080/FedexWeb/signup.jsp" );
        WebResponse response = conversation.getResponse( request );
        WebForm loginForm = response.getForms()[0];
        request = loginForm.getRequest();
        request.setParameter( "fname", "" );
        request.setParameter( "lname", "" );
        request.setParameter( "username", "" );
        request.setParameter( "password1", "" );
        request.setParameter( "password2", "" );
        request.setParameter( "emailid", "" );
        request.setParameter( "mobno" , "" );
        response = conversation.getResponse( request );
        assertTrue( "Signup Failed", 
                   response.getText().indexOf( "successfull" ) == -1 );
    } 
	
	public void testBadSignup1() throws Exception {
        WebConversation     conversation = new WebConversation();
        WebRequest  request = new GetMethodWebRequest( 
            "http://localhost:8080/FedexWeb/signup.jsp" );
        WebResponse response = conversation.getResponse( request );
        WebForm loginForm = response.getForms()[0];
        request = loginForm.getRequest();
        request.setParameter( "fname", "tojo" );
        request.setParameter( "lname", "joseph" );
        request.setParameter( "username", "tojsplash" );
        request.setParameter( "password1", "123456" );
        request.setParameter( "password2", "123897" );
        request.setParameter( "emailid", "tojsplash@yahoo.co.in" );
        request.setParameter( "mobno" , "9802678211" );
        response = conversation.getResponse( request );
        assertTrue( "Signup Failed", 
                   response.getText().indexOf( "successfull" ) == -1 );
    } 
	
	public void testBadSignup2() throws Exception {
        WebConversation     conversation = new WebConversation();
        WebRequest  request = new GetMethodWebRequest( 
            "http://localhost:8080/FedexWeb/signup.jsp" );
        WebResponse response = conversation.getResponse( request );
        WebForm loginForm = response.getForms()[0];
        request = loginForm.getRequest();
        request.setParameter( "fname", "tojo" );
        request.setParameter( "lname", "joseph" );
        request.setParameter( "username", "tojsplash" );
        request.setParameter( "password1", "12345" );
        request.setParameter( "password2", "12345" );
        request.setParameter( "emailid", "tojsplash@yahoo.co.in" );
        request.setParameter( "mobno" , "9802678211" );
        response = conversation.getResponse( request );
        assertTrue( "Signup Failed", 
                   response.getText().indexOf( "successfull" ) == -1 );
    } 
	
	public void testBadSignup3() throws Exception {
        WebConversation     conversation = new WebConversation();
        WebRequest  request = new GetMethodWebRequest( 
            "http://localhost:8080/FedexWeb/signup.jsp" );
        WebResponse response = conversation.getResponse( request );
        WebForm loginForm = response.getForms()[0];
        request = loginForm.getRequest();
        request.setParameter( "fname", "tojo" );
        request.setParameter( "lname", "joseph" );
        request.setParameter( "username", "tojsplash" );
        request.setParameter( "password1", "123456" );
        request.setParameter( "password2", "123456" );
        request.setParameter( "emailid", "tojsplashyahoo.com" );
        request.setParameter( "mobno" , "9802678211" );
        response = conversation.getResponse( request );
        assertTrue( "Signup Failed", 
                   response.getText().indexOf( "successfull" ) == -1 );
    } 
	
	public void testGoodLogin() throws Exception {
	       WebConversation     conversation = new WebConversation();
	        WebRequest  request = new GetMethodWebRequest( 
	            "http://localhost:8080/FedexWeb/signup.jsp" );
	        WebResponse response = conversation.getResponse( request );
	        WebForm loginForm = response.getForms()[0];
	        request = loginForm.getRequest();
	        request.setParameter( "fname", "Leonardo" );
	        request.setParameter( "lname", "Plato" );
	        request.setParameter( "username", "leoplato1" );
	        request.setParameter( "password1", "aaaaaaaa" );
	        request.setParameter( "password2", "aaaaaaaa" );
	        request.setParameter( "emailid", "aass@aass.com" );
	        request.setParameter( "mobno" , "199822733" );
	        response = conversation.getResponse( request );
	        assertTrue( "Signup Success", 
	                   response.getText().indexOf( "successfull" ) != -1 );
	     } 
	
}