<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员页面</title>
</head>
<body>

<form action="user.do" method="post">
	<input type="submit" name="na_user" id="id_user" value="用户管理" />
</form><br><br>


	<input type="submit" name="na_bill" id="id_bill" value="账单管理" onclick="window.location.href='order.jsp'; " /><br><br><br>


<!-- <form action="book.do"> -->
	<input type="submit" name="na_user" id="id_user" value="书籍管理" onclick="window.location.href='book.jsp'; " /><br><br><br>
<!-- </form><br><br> -->


<!-- <form action="">
	<input type="submit" name="na_user" id="id_user" value="店铺管理" />
</form> -->
		
</body>
</html>