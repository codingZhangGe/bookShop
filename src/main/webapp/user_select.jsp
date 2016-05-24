<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询用户信息</title>
</head>
<body>

	用户ID:<input type="text" name="na_id" id="id_id" /><br><br>
	用户名:<input type="text" name="na_name" id="id_name" /><br><br>
	用户类型:<input type="text" name="na_type" id="id_type" /><br><br>
	<input type="button" name="na_button" id="id_button" value="查询" onclick="isButton()" />
	
</body>
<script type="text/javascript">
	function isButton(){
		var id=document.getElementById("id_id").value;
		var name=document.getElementById("id_name").value;
		var type=document.getElementById("id_type").value;
		
		window.opener.setSelect(id,name,type);
		window.close();
	}
</script>
</html>