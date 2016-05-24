<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除用户</title>
</head>
<body>
<form action="user_delete.do" method="post" onsubmit="return isSubmit();">
	用户ID:<input type="text" name="na_id" id="id_id" /><br><br>
	用户名：<input type="text" name="na_name" id="id_name" /><br><br>
	密码：<input type="text" name="na_password" id="id_password" /><br><br>
	类型：<input type="text" name="na_type" id="id_type" />
	 <input type="submit" value="提交" />
</form>
</body>
<script type="text/javascript">
	function isSubmit(){
		var id=document.getElementById("id_id").value;
		var name=document.getElementById("id_name").value;
		var password=document.getElementById("id_password").value;
		var type=document.getElementById("id_type").value;
		
		if(id<1){
			return false;
			alert("id不正确");
		}
		if(name==null && name.length==0){
			alert("name不能为空");
			return false;
		}
		
		if(type!=1 && type!=2){
			alert("type不能为空");
			return false;
		}
		
		return true;
		window.close();
	}
</script>
</html>