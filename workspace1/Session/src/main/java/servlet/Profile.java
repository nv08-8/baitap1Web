package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/profile")
public class Profile extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");

    HttpSession session = request.getSession(false);
    PrintWriter out = response.getWriter();

    if (session != null) {
      String name = (String) session.getAttribute("name");
      out.print("Chào bạn, " + name + " đến với trang quản lý tài khoản");
    } else {
      out.print("Xin vui lòng đăng nhập");
      // Đổi "HelloServlet" thành context-path thật của em
      response.sendRedirect("/HelloServlet/Login.html");
    }
  }
}
