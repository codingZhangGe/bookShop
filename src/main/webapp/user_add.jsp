<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
</head>

<body>
	<table border="0" align="left" cellpadding="5" cellspacing="5">
		<tr>
			<td align="right">用&nbsp;户&nbsp;名:</td>
			<td align="left"><input type="text" name="na_name" id="id_name" onBlur="blurName()"/></td>
			<td align="left" id="td_name">&nbsp;</td>
		</tr>
		<tr>
			<td align="right">用户密码:</td>
			<td align="left"><input type="text" name="na_pass" id="id_pass" onBlur="blurPass()"/></td>
			<td align="left" id="td_pass">&nbsp;</td>
		</tr>
		<tr>
			<td align="right">确认密码:</td>
			<td align="left"><input type="text" name="na_password" id="id_password" onBlur="blurPassword()"/></td>
			<td align="left" id="td_password">&nbsp;</td>
		</tr>
		<tr>
			<td align="right">用户类型:</td>
			<td align="left"><input type="radio" name="na_type" value="1">管理员
				<input type="radio" name="na_type" value="2" checked="checked">客户</td>
			<td align="left" id="td_type">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="3" align="center"><input type="button" name="na_button" id="id_button" value="添加" onclick="isButton()" /></td>
		</tr>
	</table>
	<!-- 用户名：<input type="text" name="na_name" id="id_name" /><br><br> 
	用户密码：<input type="text" name="na_pass" id="id_pass" /><br><br> 
	确认密码：<input type="text" name="na_password" id="id_password" /> <br><br> 
	用户类型：<input type="radio" name="na_type" value="1">管理员
				<input type="radio" name="na_type" value="2">客户<br><br> 
	<input type="button" name="na_button" id="id_button" value="添加" onclick="isButton()" /> -->
	
</body>

<script type="text/javascript">
	function blurName(){
		var name=document.getElementById("id_name").value;
		if(name.length==""){
			document.getElementById("td_name").innerHTML = "&nbsp;用户名不能为空";
			return false;
		}else{
			document.getElementById("td_name").innerHTML = "";
			return true;
		}
	}

	function blurPass(){
		var pass = document.getElementById("id_pass").value;
		var sign = /^[\dA-Za-z\0-9]{5,16}$/;
		var result = pass.match(sign);
		
		if(pass==""){
			document.getElementById("td_pass").innerHTML = "&nbsp;密码不能为空";
			return false;
		}else if(result==null){
			document.getElementById("td_pass").innerHTML = "&nbsp;密码输入有误；数字和字母不小于5位且不大于16位";
			return false;
		}else{
			document.getElementById("td_pass").innerHTML = "";
			return true;
		}
	}
	
	function blurPassword(){
		var pass=document.getElementById("id_pass").value;
		var password=document.getElementById("id_password").value;
		
		if(pass==password){
			return true;
		}else{
			return false;
		}
	}
	
	function isButton(){
		var name=document.getElementById("id_name").value;
		var pass=document.getElementById("id_pass").value;
		var password=document.getElementById("id_password").value;
		var state=document.getElementsByName("na_type");
		var type=0;
		for(var i=0;i<state.length;i++){
			if(state[i].checked){
				type=state[i].value;
			}
		}
		
		var values=name+";"+password+";"+type;
		
		if(blurPass() && blurPassword() && blurName()){
			window.opener.setAdd(name,password,type);
			window.close();
		}
		
	}

	/* function isButton(){
		var name=document.getElementById("id_name").value;
		var pass=document.getElementById("id_pass").value;
		var password=document.getElementById("id_password").value;
		var state=document.getElementsByName("na_type");
		var type=0;
		for(var i=0;i<state.length;i++){
			if(state[i].checked){
				type=state[i].value;
			}
		}
		
		var flag=0;
		if(name.length==0){
			alert("用户名不能为空");
			flag+=1;
		}
		
		if(pass.length==0){
			alert("密码不能为空");
			flag+=1;
		}
		if(password.length==0){
			alert("确认密码不能为空");
			flag+=1;
		}
		alert("相等");
		if(pass!=password){
			alert("输入的两次密码不一样");
			flag+=1;
		}
		if(flag==0){
			alert("进来啦");
			window.opener.setAdd(name,password,type);
			alert("NAME="+name+";PASSWORD="+password+";TYPE="+type);
			document.getElementById("id_form").submit();
			window.close();
		}
	} */

	
	/* function isSubmit(){
		var name=document.getElementById("id_name").value;
		var pass=document.getElementById("id_pass").value;
		var password=document.getElementById("id_password").value;
		var state=document.getElementsByName("na_type");
		var type=0;
		for(var i=0;i<state.length;i++){
			if(state[i].checked){
				type=state[i].value;
			}
		}
		
		if(name.length==0){
			alert("用户名不能为空");
			return false;
		}
		
		if(pass.length==0){
			alert("密码不能为空");
			return false;
		}
		if(password.length==0){
			alert("确认密码不能为空");
			return false;
		}
		alert("相等");
		if(pass!=password){
			alert("输入的两次密码不一样");
			return false;
		}
		alert("到底了");
		window.opener.setAdd(name,password,type);
		return true;
		window.close();
	} */
</script>
</html>