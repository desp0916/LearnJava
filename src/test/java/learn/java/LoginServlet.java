/**
 * http://openhome.cc/Gossip/JUnit/InContainerTest.html
 */
package learn.java;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String user = req.getParameter("user").trim();
		String passwd = req.getParameter("passwd").trim();
		String page = "login.html";
		if ("justin".equals(user) && "1234".equals(passwd)) {
			page = "success.html";
		}
		req.getRequestDispatcher(page).forward(req, resp);
	}
}