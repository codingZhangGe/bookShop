<%@page import="com.design.vo.Order_type"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.design.dao.Dao_Method_order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改账单</title>
<%
	String id = request.getParameter("id");
	List<Order_type> list = Dao_Method_order.idSelect(id, "modify");
	
	for(int i=0; i<list.size(); i++){
		%>
		<input type="hidden" name="na_hidden" id="id_hidden" value="<%=list.get(i).getOrderID() %>" />
		用户id:<input type="text" name="na_uid" id="id_uid" value="<%=list.get(i).getUID() %>" /><br><br>
		地址:<input type="text" name="na_address" id="id_address" value="<%=list.get(i).getAddress() %>"/> <br><br>
		电话:<input type="text" name="na_tel" id="id_tel" value="<%=list.get(i).getTelephone() %>" /> <br><br>
		状态:<select id="id_type">
			<option value="1" <%if(list.get(i).getStatus().equals("未支付")){ %>selected="selected"<% } %>> 未支付 </option>
			<option value="2" <%if(list.get(i).getStatus().equals("支付")){ %>selected="selected"<% } %>> 支付 </option>
			<option value="3" <%if(list.get(i).getStatus().equals("已取消")){ %>selected="selected"<% } %>> 已取消 </option>
			<option value="4" <%if(list.get(i).getStatus().equals("过期")){ %>selected="selected"<% } %>> 过期 </option>
		</select><br><br>
		<%
	}
%>
</head>
<body>
	
	<input type="button" name="na_button" id="id_button" value="修改" onclick="isButton()" />
</body>
	<script type="text/javascript">
		function isButton(){
			var values = new Array();
			values[0] = document.getElementById("id_uid").value;
			values[1] = document.getElementById("id_address").value;
			values[2] = document.getElementById("id_tel").value;
			values[3] = document.getElementById("id_type").value;
			values[4] = document.getElementById("id_hidden").value;
			
			window.opener.setOrders("modify",values);
			window.close();
		}
	</script>
</html>