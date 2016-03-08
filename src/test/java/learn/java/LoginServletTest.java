/**
 * http://openhome.cc/Gossip/JUnit/EasyMock.html
 */
package learn.java;

import static org.easymock.EasyMock.createControl;
import static org.easymock.EasyMock.expect;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easymock.IMocksControl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

class TestForLoginServlet extends LoginServlet {
    public void doTest(HttpServletRequest req,
                       HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}

public class LoginServletTest {
    private TestForLoginServlet loginServlet;
    private IMocksControl control;
    private HttpServletRequest request;
    private RequestDispatcher dispatcher;

    @Before
    public void setUp() {
        loginServlet = new TestForLoginServlet();
        control = createControl();
        request = control.createMock(HttpServletRequest.class);
        dispatcher = control.createMock(RequestDispatcher.class);
    }

    @Test
    public void testLoginSuccess() throws Throwable {
        expect(request.getParameter("user")).andReturn("justin");
        expect(request.getParameter("passwd")).andReturn("1234");
        expect(request.getRequestDispatcher("success.html"))
             .andReturn(dispatcher);
        dispatcher.forward(request, null);
        control.replay();

        loginServlet.doTest(request, null);
    }

    @Test
    public void testLoginFail() throws Throwable {
        expect(request.getParameter("user")).andReturn("someone");
        expect(request.getParameter("passwd")).andReturn("1234");
        expect(request.getRequestDispatcher("login.html"))
             .andReturn(dispatcher);
        dispatcher.forward(request, null);
        control.replay();

        loginServlet.doTest(request, null);
    }

    @After
    public void tearDown() {
        control.verify();
    }
}

