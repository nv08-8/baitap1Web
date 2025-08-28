package Cookies;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deletecookie") // URL: /<context-path>/deletecookie
public class DeleteCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie cookie = null;
		Cookie[] cookies = null;
		// Get an array of Cookies associated with this domain
		cookies = request.getCookies();
		// Set response content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if (cookies != null) {
			out.println("<h2> Cookies Name and Value</h2>");
			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				if ((cookie.getName()).compareTo("ten") == 0) {
					// delete cookie
					cookie.setMaxAge(0);
					response.addCookie(cookie);
					out.print("Deleted cookie : " + cookie.getName() + "<br/>");
				}
				out.print("Name : " + cookie.getName() + ", ");
				out.print("Value: " + cookie.getValue() + " <br/>");
			}
		}
		out.close();
	}
}
