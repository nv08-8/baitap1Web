package Sessions;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/showsession")
public class ShowSession extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    resp.setContentType("text/html; charset=UTF-8");
    PrintWriter out = resp.getWriter();

    String ten = "";
    HttpSession s = req.getSession();                 // khởi tạo/nhận session
    Object obj = s.getAttribute("ten");               
    if (obj != null) {
      ten = String.valueOf(obj);                      // ép kiểu về String
    } else {
      resp.sendRedirect("/Session/creatsession");
      return;
    }

    int tuoi = (Integer) s.getAttribute("tuoi");      // ép kiểu Integer
    out.println("Xin chào bạn: " + ten + " tuổi: " + tuoi);
    out.close();
  }
}
