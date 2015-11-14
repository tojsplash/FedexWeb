package testcases;
import junit.framework.TestCase;
import com.meterware.httpunit.*;
import junit.framework.*;

public class LoginTestCases extends TestCase {
	public void testBadLogin() throws Exception {
        WebConversation     conversation = new WebConversation();
        WebRequest  request = new GetMethodWebRequest( 
            "http://localhost:8080/FedexWeb/home.jsp" );
        WebResponse response = conversation.getResponse( request );
        WebForm loginForm = response.getForms()[0];
        request = loginForm.getRequest();
        request.setParameter( "userid", "master" );
        response = conversation.getResponse( request );
        assertTrue( "Login not accepted", 
                   response.getText().indexOf( "Welcome to Home" ) == -1 );
    } 
	public void testGoodLogin() throws Exception {
        WebConversation     conversation = new WebConversation();
        WebRequest  request = new GetMethodWebRequest( 
            "http://localhost:8080/FedexWeb/home.jsp" );
        WebResponse response = conversation.getResponse( request );
        WebForm loginForm = response.getForms()[0];
        request = loginForm.getRequest();
        request.setParameter( "userid", "master" );
        request.setParameter( "pswrd", "master" );
        response = conversation.getResponse( request );
        assertTrue( "Login not accepted", 
                   response.getText().indexOf( "Welcome to Home" ) == -1 );
    } 

	public void testGoodLogin1() throws Exception {
        WebConversation     conversation = new WebConversation();
        WebRequest  request = new GetMethodWebRequest( 
            "http://localhost:8080/FedexWeb/home.jsp" );
        WebResponse response = conversation.getResponse( request );
        WebForm loginForm = response.getForms()[0];
        request = loginForm.getRequest();
        request.setParameter( "userid", "tojsplash" );
        request.setParameter( "pswrd", "123456" );
        response = conversation.getResponse( request );
        assertTrue( "Login accepted", 
                   response.getText().indexOf( "Welcome to Home" ) !=-1 );
    } 


}
