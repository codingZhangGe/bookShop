<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询账单</title>
</head>
<body>
	用户id:<input type="text" name="na_uid" id="id_oid" /><br><br>
	地址:<input type="text" name="na_address" id="id_address" /> <br><br>
	电话:<input type="text" name="na_tel" id="id_tel" /> <br><br>
	时间:<input type="text" name="na_time" id="id_time" /> <br><br>
	状态:<select id="id_type">
			<option value="0"> 请选择 </option>
			<option value="1"> 未支付 </option>
			<option value="2"> 支付 </option>
			<option value="3"> 已取消 </option>
			<option value="4"> 过期 </option>
		</select><br><br>
	<input type="button" name="na_button" id="id_button" value="查询" onclick="isButton()" />
</body>
<script type="text/javascript">
	function isButton(){
		var id = document.getElementById("id_oid").value;
		var address = document.getElementById("id_address").value;
		var tel = document.getElementById("id_tel").value;
		var time = document.getElementById("id_time").value;
		var type = document.getElementById("id_type").value;
		
		var values = new Array();
		values[0] = id;
		values[1] = address;
		values[2] = tel;
		
		var date = new Date(time);
		values[3] = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
		
		values[4] = type;
	
		window.opener.setOrders("select",values);
		window.close();
	}
</script>
</html>