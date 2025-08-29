package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");

    String username = request.getParameter("username");
    String password = request.getParameter("password");

    if (username != null && password != null
        && username.equals("nhuvo") && password.equals("123")) {
      PrintWriter out = response.getWriter();
      out.print("Chào mừng bạn, " + username);

      HttpSession session = request.getSession();
      session.setAttribute("name", username);
    } else {
      PrintWriter out = response.getWriter();
      out.print("Tài khoản hoặc mật khẩu không chính xác");
      request.getRequestDispatcher("Login.html").include(request, response);
    }
  }
}
