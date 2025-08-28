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

@WebServlet("/createcookie")
public class CreateCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        String ten   = request.getParameter("ten");
        String holot = request.getParameter("holot");
        if (ten == null) ten = "";
        if (holot == null) holot = "";

        String vTen   = URLEncoder.encode(ten, "UTF-8");
        String vHolot = URLEncoder.encode(holot, "UTF-8");

        Cookie firstName = new Cookie("ten",   vTen);
        Cookie lastName  = new Cookie("holot", vHolot);

        String path = request.getContextPath();
        firstName.setPath(path);
        lastName.setPath(path);

        firstName.setMaxAge(60 * 60 * 24);
        lastName.setMaxAge(60 * 60 * 24);

        response.addCookie(firstName);
        response.addCookie(lastName);

        out.println("<b>First Name</b>: " + ten + " - <b>Last Name</b>: " + holot);
        out.close();
    }
}
