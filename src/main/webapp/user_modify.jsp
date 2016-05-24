<%@page import="com.design.dao.Dao_Method_admin"%>
<%@page import="com.design.vo.User_Type"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户信息</title>
</head>
<%
	int id=Integer.parseInt(request.getParameter("id"));
	List<User_Type> list=Dao_Method_admin.selectAdmin_Dao(id, "", -1);
	User_Type ut=new User_Type();
	for(int i=0;i<list.size();i++){
		ut.setId(list.get(i).getId());
		ut.setName(list.get(i).getName());
		ut.setPassword(list.get(i).getPassword());
		ut.setState(list.get(i).getState());
	}
%>
<body>

	<input type="hidden" name="na_id" id="id_id" value="<%=ut.getId() %>" />
	用户名:<input type="text" name="na_name" id="id_name" value="<%= ut.getName()%>"/><br><br>
	<!-- 用户密码:<input type="text" name="na_password" id="id_password"  /><br><br> -->
	新密码:<input type="text" name="na_pass" id="id_pass"  /><br><br>
	确认密码:<input type="text" name="na_password" id="id_password" /><br><br>
	类型:<input type="radio" name="na_type" value="1" <% if(ut.getState()==1){ %>checked="checked"<% } %> >管理员
		<input type="radio" name="na_type" value="2" <% if(ut.getState()==2){ %>checked="checked"<% } %> >客户<br><br>
	<input type="button" name="na_button" id="id_button" value="提交" onclick="isButton()"  />

</body>
<script type="text/javascript">
	function isButton(){
		//alert("提交修改后的信息");
		
		var id=document.getElementById("id_id").value;
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
		
		window.opener.setModify(id,name,password,type);
		window.close();
	}
</script>
</html>