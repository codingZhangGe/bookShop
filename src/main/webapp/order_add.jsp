<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加账单</title>
</head>
<body>
	用户id:<input type="text" name="na_uid" id="id_oid" /><br><br>
	地址:<input type="text" name="na_address" id="id_address" /> <br><br>
	电话:<input type="text" name="na_tel" id="id_tel" /> <br><br>
	<input type="button" name="na_button" id="id_button" value="添加" onclick="isButton()" />
</body>
	<script type="text/javascript">
		function isButton(){
			
			
			var id = document.getElementById("id_oid").value;
			var address = document.getElementById("id_address").value;
			var tel = document.getElementById("id_tel").value;
			var values = new Array();
			values[0] = id;
			values[1] = address;
			values[2] = tel;
			window.opener.setOrders("add",values);
			window.close();
		}
	</script>
</html>