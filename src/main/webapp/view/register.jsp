<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="jakarta.tags.core" %>
  <%@taglib prefix="fmt" uri="jakarta.tags.fmt" %>
  <%@taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register User</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/registerstyle.css">
</head>
<body>
  <form action="/laptrinhweb/register" method="post">
  	<c:if test="${alert !=null}">
	<h3 class="alert alert danger">${alert}</h3>
	</c:if>
    <div class="container">
     <h2>Đăng Ký Người Dùng</h2>
        <label for="email"><b>Email</b></label>
        <input type="email" placeholder="Nhập email" name="email" required>

        <label for="uname"><b>Tên Đăng Nhập</b></label>
        <input type="text" placeholder="Nhập tên đăng nhập" name="uname" required>

        <label for="psw"><b>Mật Khẩu</b></label>
        <input type="password" placeholder="Nhập mật khẩu" name="psw" required>

        <label for="fullname"><b>Họ và Tên</b></label>
        <input type="text" placeholder="Nhập họ và tên" name="fname" required>

        <button type="submit">Đăng Ký</button>
    </div>
    <div class="container" style="background-color:#f1f1f1">
        <button type="button" class="cancelbtn">Cancel</button>
        <span class="psw">Quên <a href="#">mật khẩu?</a></span>
    </div>
    </form>
</body>
</html>