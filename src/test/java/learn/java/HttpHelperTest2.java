/**
 * http://openhome.cc/Gossip/JUnit/EmbeddedResource.html
 */
package learn.java;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = JettyRunner.class)
public class HttpHelperTest2 {
	private static Server server;

	@BeforeClass
	public static void setUp() throws Exception {
		server = new Server(8080);
		server.setHandler(new AbstractHandler() {
			@Override
			public void handle(String target,
					Request baseRequest,
					HttpServletRequest request,
					HttpServletResponse response) throws IOException, ServletException {
				response.setContentType("text/html;charset=utf-8");
				response.setStatus(HttpServletResponse.SC_OK);
				baseRequest.setHandled(true);
				response.getWriter().print("success");
			}
		});
		server.start();
	}

	@AfterClass
	public static void tearDown() throws Exception {
		server.stop();
	}

	@Test
	public void testGetContent() throws Exception {
		HttpHelper helper = new HttpHelper();
		String expected = "success";
		String result = helper.getContent(new URL("http://localhost:8080"));
		assertEquals(expected, result);
	}

}