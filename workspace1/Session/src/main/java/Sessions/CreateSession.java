package Sessions;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/createsession")
public class CreateSession extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    HttpSession s = req.getSession();               // khởi tạo session
    s.setAttribute("ten", "Võ Nguyễn Quỳnh Như");    
    s.setAttribute("tuoi", Integer.valueOf(20));    
    s.setMaxInactiveInterval(30);                

    resp.setContentType("text/html; charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.println("Xin chào bạn session đã được tạo");
    out.close();
  }
}
