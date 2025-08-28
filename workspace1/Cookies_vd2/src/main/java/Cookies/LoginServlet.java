package Cookies;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");

		// lấy dữ liệu từ tham số của form
		String user = req.getParameter("username");
		String pass = req.getParameter("password");

		if (user.equals("nhu") && pass.equals("123")) {
			Cookie cookie = new Cookie("username", user); // khởi tạo cookie
			// thiết lập thời gian tồn tại 30s của cookie
			cookie.setMaxAge(20);
			// đặt path khớp context để đọc/xóa chắc chắn (ví dụ "/Cookies")
			cookie.setPath(req.getContextPath());
			// tăng an toàn (tùy chọn)
			cookie.setHttpOnly(true);
			// thêm cookie vào response
			resp.addCookie(cookie);
			// chuyển sang trang HelloServlet  (đổi sang context hiện tại)
			resp.sendRedirect(req.getContextPath() + "/hello");
		} else {
			// chuyển sang trang LoginServlet  (đổi sang context hiện tại)
			resp.sendRedirect(req.getContextPath() + "/login.html");
		}
	}
}
