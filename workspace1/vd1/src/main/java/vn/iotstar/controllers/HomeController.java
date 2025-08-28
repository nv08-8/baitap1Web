package vn.iotstar.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/home", "/trangchu"})
public class HomeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        // Bước 1: Nhận tham số request
        String name = req.getParameter("name"); // ví dụ

        // Bước 2: Xử lý tham số
        // (logic xử lý dữ liệu ở đây)

        // Bước 3: Phản hồi kết quả
        resp.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = resp.getWriter();
        out.println("<h1>Hello</h1>");
        out.close();
        
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Có thể gọi lại doGet để xử lý chung
        doGet(req, resp);
    }
}
