package testcases;

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import junit.framework.TestCase;
import com.meterware.httpunit.*;
import junit.framework.*;


public class PendingRequestsTest extends TestCase{
	public void testBadSignup() throws Exception {
        WebConversation     conversation = new WebConversation();
        WebRequest  request = new GetMethodWebRequest( 
            "http://localhost:8080/FedexWeb/pending_requests.jsp" );
        WebResponse response = conversation.getResponse( request );
        WebForm loginForm = response.getForms()[0];
        request = loginForm.getRequest();
        response = conversation.getResponse( request );
        assertTrue( "approval Failed", 
                   response.getText().indexOf( "TrackingID" ) != -1 );
    } 

	public void testBadSignup1() throws Exception {
        WebConversation     conversation = new WebConversation();
        WebRequest  request = new GetMethodWebRequest( 
            "http://localhost:8080/FedexWeb/pending_requests.jsp" );
        WebResponse response = conversation.getResponse( request );
        WebForm loginForm = response.getForms()[0];
        request = loginForm.getRequest();
        response = conversation.getResponse( request );
        assertTrue( "approval Failed", 
                   response.getText().indexOf( "successfull" ) == -1 );
    } 
}
