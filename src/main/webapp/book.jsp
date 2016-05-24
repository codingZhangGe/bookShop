<%@page import="com.design.dao.Dao_Method_book"%>
<%@page import="com.design.vo.Book_type"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书籍的增删改查</title>
</head>
<%
	List<Book_type> list=Dao_Method_book.allBook_Dao();
%>
<body>
<table cellspacing="1" cellpadding="4" border="1" valign="bottom" id="id_table" >
	<tr>
		<th>选择</th>
		<th>编号</th>
		<th>书名</th>
		<th>原价</th>
		<th>现价</th>
		<th>折扣</th>
		<th>作者</th>
		<th>出版社</th>
		<th>类型</th>
		<th>介绍</th>
		<th>店铺</th>
		<th>评论</th>
		<th>小图地址</th>
		<th>大图地址</th>
		<th>状态</th>
		<th>版本</th>
	</tr>
	<tbody id="id_tbody">
		<%
			if(list.size()>0){
				for(int i=0;i<list.size();i++){
					%>
					<tr>
						<td>
							<input type="checkbox" id="id_checkbox" name="na_checkbox" />
							<input type="hidden" name="na_hidden" id="id_hidden" value="<%=list.get(i).getId() %>" />
						</td>
						<td> <%=i+1 %> </td>
						<td> <%=list.get(i).getName() %> </td>
						<td> <%=list.get(i).getPrice() %> </td>
						<td> <%=list.get(i).getCurrentprice() %> </td>
						<td> <%=list.get(i).getDiscount() %> </td>
						<td> <%=list.get(i).getAuthor()%> </td>
						<td> <%=list.get(i).getPublish() %> </td>
						<td> <%=list.get(i).getCid() %> </td>
						<td> <%=list.get(i).getIntroduce() %> </td>
						<td> <%=list.get(i).getShopid() %> </td>
						<td> <%=list.get(i).getCommentID() %> </td>
						<td> <%=list.get(i).getImage_s() %> </td>
						<td> <%=list.get(i).getImage_b() %> </td>
						<td> <%=list.get(i).getStatus() %> </td>
						<td> <%=list.get(i).getVersion() %> </td>
					</tr>
					<%
				}
			}
		%>
		<tr id="id_tr">
			<td colspan="16" align="right">
				<input type="button" name="na_add" id="id_add" value="增加" onclick="addBook()" />
				<input type="button" name="na_modify" id="id_modify" value="修改" onclick="modifyBook()" />
				<input type="button" name="na_delete" id="id_delete" value="删除" onclick="deleteBook()" />
				<input type="button" name="na_select" id="id_select" value="查询" onclick="selectBook()"/>
			</td>
		</tr>
	</tbody>
</table>
</body>

<script type="text/javascript">
	//var str=name+";"+price+";"+currentprice+";"+discount+";"+author+";"+publish+";"+cid+";"+introduce+";"+shopid+";"+commentid+";"+image_s+";"+image_b+";"+status;

	function setBook(zh,valueList){
		var add_modify_select=zh;
		var url="";
		
		if(zh=="add"){
			url="book_add.do?valueList="+valueList;
		}else if(zh=="modify"){
			url="book_modify.do?valueList="+valueList;
		}else if(zh=="select"){
			url="book_select.do?valueList="+valueList;
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
		//alert(url);
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				
				var msg=xhr.responseText;
				/* alert("msg="+msg); */
				msg = eval("("+msg+")");
				/* alert("new_msg="+msg); */
				var c=1;
				//alert("页面显示");
				for(var attr in msg){
					var bt=msg[attr];
					
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
					hidden.setAttribute("value", bt.id)
					
					for(var i=0;i<16;i++){
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
								td.innerText=bt.name;
								break;
							case 3:
								td.innerText=bt.price;
								break;
							case 4:
								td.innerText=bt.currentprice;
								break;
							case 5:
								td.innerText=bt.discount;
								break;
							case 6:
								td.innerText=bt.author;
								break;
							case 7:
								td.innerText=bt.Publish;
								break;
							case 8:
								td.innerText=bt.cid;
								break;
							case 9:
								td.innerText=bt.introduce;
								break;
							case 10:
								td.innerText=bt.shopid;
								break;
							case 11:
								td.innerText=bt.commentID;
								break;
							case 12:
								td.innerText=bt.image_s;
								break;
							case 13:
								td.innerText=bt.image_b;
								break;
							case 14:
								td.innerText=bt.status;
								break;
							case 15:
								td.innerText=bt.version;
								break;
						}
						tr.appendChild(td);
					}
				}
			}
		}
	}

	function addBook(){
		alert("添加书籍");
		window.open("http://localhost:8080/Graduation_design/book_add.jsp?",null,
		 "width=600px,height=700px,screenX=400px,screenY=100px,toolbar=no,menubar=no,location=no,alwaysRaised=yes,directories=no");
	
	}
	
	function modifyBook(){
		alert("修改书籍");
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
			window.open("http://localhost:8080/Graduation_design/book_modify.jsp?id="+id,null,
			 "width=600px,height=700px,screenX=300px,screenY=50px,toolbar=no,menubar=no,location=no,alwaysRaised=yes,directories=no");
		}else{
			alert("一次只能修改一个");
		}
	}
	
	function selectBook(){
		alert("查询书籍");
		window.open("http://localhost:8080/Graduation_design/book_select.jsp?",null,
		 "width=600px,height=700px,screenX=300px,screenY=50px,toolbar=no,menubar=no,location=no,alwaysRaised=yes,directories=no");
	}
	
	function deleteBook(){
		alert("删除书籍");
		
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
		var url="book_delete.do?idList="+idList;
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