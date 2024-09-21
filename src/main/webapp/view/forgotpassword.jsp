<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
  <%@taglib prefix="fmt" uri="jakarta.tags.fmt" %>
  <%@taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quên mật khẩu</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/forgotcss.css">
</head>
<body>
    <h2>Quên mật khẩu</h2>
    <form action="${pageContext.request.contextPath}/forgotpassword" method="post">
        <div class="container">
            <label for="uname"><b>Tên đăng nhập</b></label>
            <input type="text" placeholder="Nhập tên đăng nhập của bạn" name="uname" required>

            <label for="email"><b>Email</b></label>
            <input type="email" placeholder="Nhập email của bạn" name="email" required>

            <label for="newPassword"><b>Mật khẩu mới</b></label>
            <input type="password" placeholder="Nhập mật khẩu mới" name="newPassword" required>

            <button type="submit">Cập nhật mật khẩu</button>
        </div>

        <c:if test="${alert != null}">
            <h3 style="color:red;">${alert}</h3>
        </c:if>
    </form>
</body>
</html>
