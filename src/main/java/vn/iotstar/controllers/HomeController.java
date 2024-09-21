package vn.iotstar.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import vn.iotstar.utils.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.UserServiceImpl;
@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet{
	IUserService service = new UserServiceImpl();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/view/Home.jsp").forward(req, resp);
//		String url =req.getRequestURI().toString();
//		if(url.contains("register"))
//		{
//			req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
//		}
//		else if(url.contains("forgotpass"))
//		{
//			req.getRequestDispatcher("/view/forgotpassword.jsp").forward(req, resp);
//		}
//		else if(url.contains("login"))
//		{
//			req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
//		}
//		else if(url.contains("waiting"))
//		{
//			 resp.sendRedirect(req.getContextPath()+"/waiting");
//		}
//		else if(url.contains("verify"))
//		{
//			req.getRequestDispatcher("/view/verify.jsp").forward(req, resp);
//		}else
//		{
//			req.getRequestDispatcher("/view/Home.jsp").forward(req, resp);
//		}
//		
		//req.getRequestDispatcher("/view/Home.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String url =req.getRequestURI().toString();
//		if(url.contains("register"))
//		{
//			postRegister(req,resp);
//		}else if(url.contains("login"))
//		{
//			postLogin(req,resp);
//		}else if(url.contains("forgotpass"))
//		{
//			postForgotPassword(req,resp);
//		}else if(url.contains("verify"))
//		{
//			postVerifyCode(req,resp);
//		}
	}

	protected void postVerifyCode(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//		resp.setContentType("text/html");
//		resp.setCharacterEncoding("UTF-8");
//		req.setCharacterEncoding("UTF-8");
//		try(PrintWriter out = resp.getWriter())
//		{
//			 HttpSession session = req.getSession();
//			UserModel user =(UserModel) session.getAttribute("account");
//			String code =req.getParameter("authcode");
//			if(code.equals(user.getCode())) {
//				user.setEmail(user.getCode());
//				out.println("<br> Kích Hoạt Tài Khoản Thành Công <br/>");
//			}else
//			{
//				out.println("<br> Sai mã, vui lòng kiểm tra lại <br/>");
//			}
//			
//		}
		
	}

	protected void postForgotPassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		// TODO Auto-generated method stub
		
	}

	protected void postLogin(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	protected void postRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//		resp.setContentType("text/html");
//		resp.setCharacterEncoding("UTF-8");
//		req.setCharacterEncoding("UTF-8");
//		
//		 String username = req.getParameter("uname");
//		 String password = req.getParameter("psw");
//		 String email =req.getParameter("email");
//		 String fullname =req.getParameter("fname");
//		 String alertMsg="";
//		 if(service.checkExistEmail(email))
//		 {
//			 alertMsg ="Email Đã tồn tại!";
//			 req.setAttribute("alert", alertMsg);
//			 req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
//		 }else if(service.checkExistUserName(username))
//		 {
//			 alertMsg =" Tài khoản đã tồn tại!";
//			 req.setAttribute("alert", alertMsg);
//			 req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
//		 } else {
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
//			 }
		}
		
	
}
