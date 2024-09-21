package vn.iotstar.controllers;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.UserServiceImpl;
//import vn.iotstar.utils.Constant;
import vn.iotstar.utils.Email;
@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	IUserService service = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		 String username = req.getParameter("uname");
		 String password = req.getParameter("psw");
		 String email =req.getParameter("email");
		 String fullname =req.getParameter("fname");
		 String alertMsg="";
		 if(service.checkExistEmail(email))
		 {
			 alertMsg ="Email Đã tồn tại!";
			 req.setAttribute("alert", alertMsg);
			 req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
		 }else if(service.checkExistUserName(username))
		 {
			 alertMsg =" Tài khoản đã tồn tại!";
			 req.setAttribute("alert", alertMsg);
			 req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
		 } else {
//			 Email sm = new Email();
//			 String code = sm.getRandom();
//			 UserModel user = new UserModel(username, email, fullname, code);
//			 boolean test =sm.sendEmail(user);
//			 if(test)
//			 {
//				 HttpSession session = req.getSession(true);
//				 session.setAttribute("account", user);
//				 
//				 boolean isSucces = service.register(email, password, username, fullname, code);
//				 if(isSucces)
//				 {
//					 resp.sendRedirect(req.getContextPath()+"/verify");
//				 }
//			 }else{
//				 alertMsg = "Lỗi hệ thống";
//				 req.setAttribute("alert", alertMsg);
//				 req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
//				}
			 UserModel user = new UserModel(username, email, fullname);
			 boolean isSucces = service.register(email, password, username, fullname);
		        if (isSucces) {
		            // Đăng ký thành công, chuyển hướng tới trang đăng nhập
		            resp.sendRedirect(req.getContextPath() + "/login");
		        } else {
		            // Đăng ký thất bại, báo lỗi
		            alertMsg = "Lỗi hệ thống, vui lòng thử lại!";
		            req.setAttribute("alert", alertMsg);
		            req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
		        }
		 }
	}
}
