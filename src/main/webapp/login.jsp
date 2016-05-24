<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>登陆界面</title>
</head>

<body>
	<form action="login.do" method="post" onsubmit="return isUp();">
		用户名*：<input type="text" name="na_user" id="id_user" /><br><br>
		密码*：<input type="password" name="na_password" id="id_password" /><br><br>
		
		类别*：<input type="radio" name="na_type" value="1" />管理者
		<input type="radio" name="na_type" value="2" checked="checked" />客户<br><br>
		
		<input type="submit" value="登陆" />
	</form>
</body>

<script type="text/javascript">
	function isUp(){
		var user=document.getElementById("id_user").value;
		var password=document.getElementById("id_password").value;
	
		if(user.length==0){
			alert("用户名不能为空");
			return false;
		}
		if(password.length==0){
			alert("密码不能为空");
			return false;
		}
		return true;
	}
</script>

</html>