<%@page import="com.design.vo.User_Type"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
</head>
<body>

<%	
	int id=-1;
	String name="";
	String password="";
	int state=-1;
	List<User_Type> list=(List<User_Type>)request.getAttribute("list");
%>

<table cellspacing="1"  cellpadding="4" border="1" valign="bottom" id="user_list_table">
	<thead>
		<tr>
			<th>用户id</th>
			<th>用户名称</th>
			<th>用户密码</th>
			<th>用户类别</th>
			<th>选择</th>
		</tr>
	</thead>
	<tbody id="id_tbody">
		<%
			if(list.size()!=0 && list!=null){
				for(int i=0;i<list.size();i++){
					id=list.get(i).getId();
					name=list.get(i).getName();
					password=list.get(i).getPassword();
					state=list.get(i).getState();
					%>
						<tr>
							<td> <%=id %> </td>
							<td> <%=name %> </td>
							<td> <%=password %> </td>
							<td> <%=state %> </td>
							<td>
								<input type="checkbox" id="id_checkbox" name="na_checkbox" />
								<input type="hidden" name="na_hidden" id="id_hidden" value="<%=id %>" />
							</td>
						</tr>
					<%
				}
			}
		%>
		<tr id="id_tr">
			<td colspan="5" align="right">
				<input type="button" name="na_add" id="id_add" value="增加" onclick="addUser()" />
				<input type="button" name="na_modify" id="id_modify" value="修改" onclick="modifyUser()" />
				<input type="button" name="na_delete" id="id_delete" value="删除" onclick="deleteUser()" />
				<input type="button" name="na_select" id="id_select" value="查询" onclick="selectUser()"/>
			</td>
		</tr>
	</tbody>
</table><br><br> 

</body>

<script type="text/javascript">

	//添加
	function setAdd(name_child,password_child,type_child){
		alert(name_child+"  "+password_child+"  "+type_child);
		/* var tb = document.getElementById('user_list_table');
	    var rowNum=tb.rows.length;
	    for (var i = 1; i < rowNum - 1;i++){
	    	tb.deleteRow(i);
	        rowNum=rowNum-1;
	        i=i-1;
	    }
		
		//alert("这是父页面的 NAME="+name_child+";PASSWORD="+password_child+";TYPE="+type_child);
		var valueList=name_child+";"+password_child+";"+type_child;
		var hidden_front=document.getElementsByName("na_hidden");
		
		var xhr=null;
		if(window.XMLHttpRequest){
			xhr=new XMLHttpRequest();
		}else{
			xhr= new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		xhr.open("POST", "user_add.do?valueList="+valueList, true);
		
		xhr.send();
		
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				
				var msg=xhr.responseText;
				msg = eval("("+msg+")");
				for(var attr in msg){
					var ut=msg[attr];
					
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
					hidden.setAttribute("value", ut.id)
					
					for(var i=0;i<5;i++){
						var td=document.createElement("td");
						switch(i){
							case 0:
								td.innerText=ut.id;
								break;
							case 1:
								td.innerText=ut.name;
								break;
							case 2:
								td.innerText=ut.password;
								break;
							case 3:
								td.innerText=ut.state;
								break;
							case 4:
								td.appendChild(hidden);
								td.insertBefore(checkbox, hidden);
								break;
						}
						tr.appendChild(td);
					}
					//alert("遍历的一次结束");
				}
				
				//window.location.reload();
			}
		}	 */
	}
	
	function setSelect(id_child,name_child,type_child){
		var valueList=id_child+";"+name_child+";"+type_child;
		//var valueList="id="+id_child+";name="+name_child+";state="+type_child;
		//alert("这是ID="+id_child+";NAME="+name_child+";TYPE="+type_child);
		var tb = document.getElementById('user_list_table');
	    var rowNum=tb.rows.length;
	    for (var i = 1; i < rowNum - 1;i++){
	    	tb.deleteRow(i);
	        rowNum=rowNum-1;
	        i=i-1;
	    }
		
		var xhr=null;
		if(window.XMLHttpRequest){
			xhr=new XMLHttpRequest();
		}else{
			xhr=new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		xhr.open("POST", "user_select.do?valueList="+valueList, true);
		xhr.send();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status){
				var msg=xhr.responseText;
				msg = eval("("+msg+")");
				for(var attr in msg){
					var ut=msg[attr];
					
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
					hidden.setAttribute("value", ut.id)
					
					for(var i=0;i<5;i++){
						var td=document.createElement("td");
						switch(i){
							case 0:
								td.innerText=ut.id;
								break;
							case 1:
								td.innerText=ut.name;
								break;
							case 2:
								td.innerText=ut.password;
								break;
							case 3:
								td.innerText=ut.state;
								break;
							case 4:
								td.appendChild(hidden);
								td.insertBefore(checkbox, hidden);
								break;
						}
						tr.appendChild(td);
					}
					//alert("遍历的一次结束");
				}
			}
		}
	}
	
	function setModify(id_child,name_child,password_child,type_child){
		var valueList=id_child+";"+name_child+";"+password_child+";"+type_child;
		var tb = document.getElementById('user_list_table');
	    var rowNum=tb.rows.length;
	    for (var i = 1; i < rowNum - 1;i++){
	    	tb.deleteRow(i);
	        rowNum=rowNum-1;
	        i=i-1;
	    }
		
		//alert("valueList"+valueList);
		var xhr=null;
		if(window.XMLHttpRequest){
			var xhr=new XMLHttpRequest();
		}else{
			xhr=new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		xhr.open("POST", "user_modify.do?valueList="+valueList, true);
		xhr.send();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				var msg=xhr.responseText;
				msg=eval("("+msg+")");
				for(var attr in msg){
					var ut=msg[attr];
					
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
					hidden.setAttribute("value", ut.id)
					
					for(var i=0;i<5;i++){
						var td=document.createElement("td");
						switch(i){
							case 0:
								td.innerText=ut.id;
								break;
							case 1:
								td.innerText=ut.name;
								break;
							case 2:
								td.innerText=ut.password;
								break;
							case 3:
								td.innerText=ut.state;
								break;
							case 4:
								td.appendChild(hidden);
								td.insertBefore(checkbox, hidden);
								break;
						}
						tr.appendChild(td);
					}
				}
			}
		}
	}
	
	//添加
	function addUser(){
		alert("要添加喽");
		var childWindow=window.open("http://localhost:8080/Graduation_design/user_add.jsp",null,
		 "width=800px,height=300px,screenX=400px,screenY=200px,toolbar=no,menubar=no,location=no,alwaysRaised=yes,directories=no");

	}
	
	//修改
	function modifyUser(){
		alert("修改开始喽");
		
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
		//alert("这是我的修改ID="+id);
		if(c==0){
			alert("请选择一个用户！");
		}else if(c==1){
			window.open("http://localhost:8080/Graduation_design/user_modify.jsp?id="+id,null,
			 "width=400px,height=300px,screenX=400px,screenY=200px,toolbar=no,menubar=no,location=no,alwaysRaised=yes,directories=no");
		}else{
			alert("一次只能修改一个");
		}
		//alert("修改结束啦");
	}
	
	//查询
	function selectUser(){
		alert("查询喽");
		window.open("http://localhost:8080/Graduation_design/user_select.jsp",null,"width=400px,height=300px,screenX=400px,screenY=200px,toolbar=no,menubar=no,location=no,alwaysRaised=yes,directories=no");
		//alert("查询结束啦");
	}
	
	//删除
	function deleteUser(){
		alert("删除用户");
		
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
					//alert("第"+j+"个"+hidden[j].value);
				}
				c++;
			}
		}
		
		//1.创建对象
		var xhr=null;
		if(window.XMLHttpRequest){
			xhr = new XMLHttpRequest();
		}else{
			xhr = new ActiveXObject("Microsoft.XMLHTTP");
		}
		//2.连接服务器
		var url="user_delete.do?idList="+idList;
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