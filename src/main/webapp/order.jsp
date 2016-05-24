<%@page import="com.design.vo.Order_type"%>
<%@page import="com.design.dao.Dao_Method_order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账单管理</title>
<%
	List<Order_type> list = Dao_Method_order.allOrder_Dao();
%>
</head>
<body>
<table cellspacing="1" cellpadding="4" border="1" valign="bottom" id="id_table" >
	<tr>
		<th>选择</th>
		<th>编号</th>
		<th>用户id</th>
		<th>地址</th>
		<th>时间</th>
		<th>电话</th>
		<th>状态</th>
	</tr>
	<tbody id="id_tbody">
	
		<%
			int number = 1;
			for(int i=1; i<list.size(); i++){
				%>
				<tr>
					<td>
						<input type="checkbox" id="id_checkbox" name="na_checkbox" />
						<input type="hidden" name="na_hidden" id="id_hidden" value="<%=list.get(i).getOrderID() %>" />
					</td>
					<td><%=number++ %></td>
					<td><%=list.get(i).getUID() %></td>
					<td><%=list.get(i).getAddress() %></td>
					<td><%=list.get(i).getOrderTime() %></td>
					<td><%=list.get(i).getTelephone() %></td>
					<td><%=list.get(i).getStatus() %></td>
				</tr>	
				<% 
			}
		%>
		
		<tr id="id_tr">
			<td colspan="15" align="right">
				<input type="button" name="na_add" id="id_add" value="增加" onclick="addOrders()" />
				<input type="button" name="na_modify" id="id_modify" value="修改" onclick="modifyOrders()" />
				<input type="button" name="na_delete" id="id_delete" value="删除" onclick="deleteOrders()" />
				<input type="button" name="na_select" id="id_select" value="查询" onclick="selectOrders()"/>
			</td>
		</tr>
	</tbody>
</table>
</body>
<script type="text/javascript">
	function whetherPower(){
		alert("此账单暂时不能修改");
	}
	
	function setOrders(zh, values){
		var url = "";
		if(zh=="add"){
			url = "orders_add.do?UID="+values[0]+"&Address="+values[1]+"&Telephone="+values[2];
		}else if(zh=="modify"){
			url = "orders_modify.do?UID="+values[0]+"&Address="+values[1]+"&Telephone="+values[2]+"&Status="+values[3]+"&OrderID="+values[4];
		}else if(zh=="select"){
			url = "orders_select.do?UID="+values[0]+"&Address="+values[1]+"&Telephone="+values[2]+"&OrderTime="+values[3]+"&Status="+values[4];
		}
		
		var table = document.getElementById("id_table");
	    var rowNum=table.rows.length;
	    for (var i = 1; i < rowNum - 1;i++){
	    	table.deleteRow(i);
	        rowNum=rowNum-1;
	        i=i-1;
	    }
	    
	    xhr=null;
		var xhr=null;
		if(window.XMLHttpRequest){
			xhr=new XMLHttpRequest();
		}else{
			xhr= new ActiveXObject("Microsoft.XMLHTTP");
		}
		xhr.open("POST", url, true);
		xhr.send();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				var msg=xhr.responseText;
				alert("msg= "+msg);
				msg = eval("("+msg+")");
				var c=1;
				for(var attr in msg){
					var ot=msg[attr];
				
					var tr=document.createElement("tr");
					var tbody=document.getElementById("id_tbody");
					var	lastTr=document.getElementById("id_tr");
					tbody.insertBefore(tr, lastTr);
					
					var checkbox=document.createElement("input");
					checkbox.setAttribute("type", "checkbox");
					checkbox.setAttribute("id", "id_checkbox");
					checkbox.setAttribute("name", "na_checkbox");
					
					var hidden=document.createElement("input");
					hidden.setAttribute("type", "hidden");
					hidden.setAttribute("id", "id_hidden");
					hidden.setAttribute("name", "na_hiddeen");
					hidden.setAttribute("value", ot.OrderID);
					
					for(var i=0; i<7; i++){
						var td=document.createElement("td");
						switch(i){
							case 0:
								td.appendChild(hidden);
								td.insertBefore(checkbox, hidden);
								break;
							case 1:
								td.innerText=c++;
								break;
							case 2:
								td.innerText=ot.UID;
								break;
							case 3:
								td.innerText=ot.Address;
								break;
							case 4:
								td.innerText=ot.Telephone;
								break;
							case 5:
								td.innerText=ot.OrderTime;
								break;
							case 6:
								td.innerText=ot.Status;
								break;
						}
						tr.appendChild(td);
					}
				}
			}
		}
	}
	
	function addOrders(){
		/* alert("添加账单"); */
		window.open("http://localhost:8080/Graduation_design/order_add.jsp?",null,
		 "width=600px,height=500px,screenX=400px,screenY=100px,toolbar=no,menubar=no,location=no,alwaysRaised=yes,directories=no");
	}
	
	function modifyOrders(){
		alert("修改账单");
		var id=0;
		var c=0;
		var selectList=document.getElementsByName("na_checkbox");
		
		for(var i=0;i<selectList.length;i++){
			//alert("进来判断选中的是谁");
			if(selectList[i].checked){
				var hidden=selectList[i].parentNode.childNodes;
				//alert("j");
				for(var j=0;j<hidden.length;j++){
					//alert("j="+j);
					//alert("第"+j+"个"+hidden[j].value);
					if(hidden[j].value>0){
						id=hidden[j].value;
					}
				}
				c++;
			}
		}
		if(c==0){
			alert("请选择一个用户！");
		}else if(c==1){
			xhr=null;
			var xhr=null;
			if(window.XMLHttpRequest){
				xhr=new XMLHttpRequest();
			}else{
				xhr= new ActiveXObject("Microsoft.XMLHTTP");
			}
			xhr.open("POST", "order_judge.jsp?id="+id, true);
			xhr.send();
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4 && xhr.status==200){
					var judge = xhr.responseText;
					if(judge>2){
						alert("此账单暂时不能修改");
					}else{
						window.open("http://localhost:8080/Graduation_design/order_modify.jsp?id="+id,null,
						 "width=600px,height=500px,screenX=300px,screenY=700px,toolbar=no,menubar=no,location=no,alwaysRaised=yes,directories=no");
					}
				}
			}
			
		 }else{
			alert("一次只能修改一个");
		}
	}
	
	function selectOrders(){
		window.open("http://localhost:8080/Graduation_design/order_select.jsp?",null,
		 "width=600px,height=500px,screenX=400px,screenY=100px,toolbar=no,menubar=no,location=no,alwaysRaised=yes,directories=no");
	
	}
	
	function deleteOrders(){
		alert("删除账单");
		
		var selectList=document.getElementsByName("na_checkbox");
		var tbody=document.getElementById("id_tbody");
		var idList="";
		var c=0;
		
		for(var i=0;i<selectList.length;i++){
			if(selectList[i].checked){
				var hidden=selectList[i].parentNode.childNodes;
				for(var j=0;j<hidden.length;j++){
					if(hidden[j].value>0){
						idList+=hidden[j].value+";";
					}
				}
				c++;
			}
		}
		
		var xhr=null;
		if(window.XMLHttpRequest){
			xhr = new XMLHttpRequest();
		}else{
			xhr = new ActiveXObject("Microsoft.XMLHTTP");
		}
		//2.连接服务器
		var url="orders_delete.do?idList="+idList;
		xhr.open("POST",url, true);
		//3.发送请求  
		xhr.send();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				if(c==0){
					alert("没有选中的用户");
				}else{
					for(var i=selectList.length-1;i>-1;i--){
						if(selectList[i].checked){
							tbody.removeChild(selectList[i].parentNode.parentNode);
						}
					}
				}
			}
		}	
	}
</script>
</html>