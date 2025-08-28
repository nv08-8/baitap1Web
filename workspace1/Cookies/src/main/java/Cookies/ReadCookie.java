package Cookies;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadCookie
 */
@WebServlet("/readcookie")
public class ReadCookie extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			out.println("<h2>Found Cookies Name and Value</h2>");
			for (Cookie cookie : cookies) {
				out.println("Name: " + cookie.getName() + ", Value: " + cookie.getValue() + "<br>");
			}
		} else {
			out.println("<h2>No cookies founds</h2>");
		}
		out.close();
	}
}