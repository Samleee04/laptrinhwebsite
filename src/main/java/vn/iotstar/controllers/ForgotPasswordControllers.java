package vn.iotstar.controllers;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.UserServiceImpl;
@WebServlet(urlPatterns = {"/forgotpassword"})
public class ForgotPasswordControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;
    IUserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Hiển thị trang nhập username và email quên mật khẩu
        req.getRequestDispatcher("/view/forgotpassword.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        // Lấy tham số từ form
        String username = req.getParameter("uname");
        String email = req.getParameter("email");
        String newPassword = req.getParameter("newPassword");
        String alertMsg = "";

        // Kiểm tra xem username và email có tồn tại và khớp trong hệ thống không
        if (!service.checkExistUserNameAndEmail(username, email)) {
            alertMsg = "Tài khoản hoặc email không đúng!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/view/forgotpassword.jsp").forward(req, resp);
        } else {
            // Cập nhật mật khẩu mới trong cơ sở dữ liệu
            boolean isSuccess = service.updatePasswordByUsernameAndEmail(username, email, newPassword);

            if (isSuccess) {
                // Chuyển hướng đến trang thông báo thành công
                req.setAttribute("alert", "Mật khẩu của bạn đã được cập nhật thành công!");
                req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
            } else {
                // Báo lỗi nếu có vấn đề trong quá trình đặt lại mật khẩu
                alertMsg = "Lỗi hệ thống, vui lòng thử lại!";
                req.setAttribute("alert", alertMsg);
                req.getRequestDispatcher("/view/forgotpassword.jsp").forward(req, resp);
            }
        }
    }
}
