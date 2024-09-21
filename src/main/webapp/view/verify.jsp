<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xác Minh Tài Khoản</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/verifycss.css">
</head>
<body>
<form action="/laptrinhweb/verify" method="post">
  
    <div class="container">
    <h2>Hệ Thống Đã Gửi Mã Xác Minh Về Email! Yêu Cầu Xác Minh</h2>
        <label for="code"><b>Mã Xác Minh</b></label>
        <input type="text" placeholder="Nhập mã xác minh" name="code" required>

        <button type="submit">Xác Nhận</button>
    </div>

    <div class="container" style="background-color:#f1f1f1">
        <button type="button" class="cancelbtn">Hủy</button>
    </div>
</form>
</body>
</html>