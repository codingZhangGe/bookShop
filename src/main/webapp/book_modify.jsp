<%@page import="com.design.vo.Book_type"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.design.dao.Dao_Method_book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改书籍页面</title>
</head>

<body>
<%
	String id=request.getParameter("id");
	Map<String,String> map=new HashMap<String,String>();
	map.put("BookID", id);
	List list=Dao_Method_book.selectBook_Dao(map);
	for(int i=0;i<list.size();i++){
		Book_type bt=(Book_type)list.get(i);
		%>
		<input type="hidden" name="na_id" id="id_id" value="<%=bt.getId() %>" />
		书名：<input type="text" name="na_name" id="id_name" value="<%=bt.getName() %>" /><br><br>
		原价：<input type="text" name="na_price" id="id_price" value="<%=bt.getPrice() %>" /><br><br>
		现价：<input type="text" name="na_currentprice" id="id_currentprice" value="<%=bt.getCurrentprice() %>" /><br><br>
		折扣：<input type="text" name="na_discount" id="id_discount" value="<%=bt.getDiscount() %>" /><br><br>
		作者：<input type="text" name="na_author" id="id_author" value="<%=bt.getAuthor() %>" /><br><br>
		出版社：<input type="text" name="na_publish" id="id_publish" value="<%=bt.getPublish() %>" /><br><br>
		类型：<select id="id_cid" name="na_cid">
				<option value="-1" >请选择</option>
				<option value="1" <%if(bt.getCid()==1){ %>selected="selected"<% } %> >文学</option>
				<option value="2" <%if(bt.getCid()==2){ %>selected="selected"<% } %>>外文</option>
				<option value="3" <%if(bt.getCid()==3){ %>selected="selected"<% } %>>神话</option>
				<option value="4" <%if(bt.getCid()==4){ %>selected="selected"<% } %>>言情</option>
				<option value="5" <%if(bt.getCid()==5){ %>selected="selected"<% } %>>武侠</option>
				<option value="6" <%if(bt.getCid()==6){ %>selected="selected"<% } %>>地理</option>
				<option value="7" <%if(bt.getCid()==7){ %>selected="selected"<% } %>>音乐</option>
				<option value="8" <%if(bt.getCid()==8){ %>selected="selected"<% } %>>美术</option>
			</select><br><br>
		介绍：<input type="text" name="na_introduce" id="id_introduce" value="<%=bt.getIntroduce() %>" /><br><br>
		店铺ID：<input type="text" name="na_shopid" id="id_shopid" value="<%=bt.getShopid() %>" /><br><br>
		小图：<input type="text" name="na_image_s" id="id_image_s" value="<%=bt.getImage_s() %>" /><br><br>
		大图：<input type="text" name="na_image_b" id="id_image_b" value="<%=bt.getImage_b() %>" /><br><br>
		状态：<select name="na_state" id="id_state">
				<option value="1" <%if(bt.getStatus()==1){ %>selected="selected"<% } %> >待销</option>
				<option value="2" <%if(bt.getStatus()==2){ %>selected="selected"<% } %> >售空</option>
			</select>
		数量：<input type="text" name="na_count" id="id_count" value="<%=bt.getCount() %>" /><br><br>
		已售:<input type="text" name="na_sale" id="id_sale" value="<%=bt.getSale() %>" /><br><br>
		版本：<input type="text" name="na_version" id="id_version" value="<%=bt.getVersion() %>" /><br><br>
		<%
	}
%>
<input type="button" name="na_button" id="id_button" value="修改" onclick="isButton()" >
</body>
<script type="text/javascript">
function isButton(){
	var id=document.getElementById("id_id").value;
	var name=document.getElementById("id_name").value;
	var price=document.getElementById("id_price").value;
	var currentprice=document.getElementById("id_currentprice").value;
	var discount=document.getElementById("id_discount").value;
	var author=document.getElementById("id_author").value;
	var publish=document.getElementById("id_publish").value;
	var cid=document.getElementById("id_cid").value;
	var introduce=document.getElementById("id_introduce").value;
	var shopid=document.getElementById("id_shopid").value;
	var image_s=document.getElementById("id_image_s").value;
	var image_b=document.getElementById("id_image_b").value;
	var count=document.getElementById("id_count").value;
	var sale=document.getElementById("id_sale").value;
	var state=document.getElementById("id_state").value;
	var version=document.getElementById("id_version").value;
	var valueList="";
	
	
	if(id.length!=0){
		valueList+=";BookID="+id;
	}
	if(name.length!=0){
		valueList+=";BName="+name;
	}
	if(price.length!=0){
		valueList+=";Price="+price;
	}
	if(currentprice.length!=0){
		valueList+=";Currentprice="+currentprice;
	}
	if(discount.length!=0){
		valueList+=";Discount="+discount;
	}
	if(author.length!=0){
		valueList+=";Author="+author;
	}
	if(publish.length!=0){
		valueList+=";Publish="+publish;
	}
	if(cid.length!=0){
		valueList+=";CID="+cid;
	}
	if(introduce.length!=0){
		valueList+=";Introduce="+introduce;
	}
	if(shopid.length!=0){
		valueList+=";ShopID="+shopid;
	}
	if(image_s.length!=0){
		valueList+=";Image_s="+image_s;
	}
	if(image_b.length!=0){
		valueList+=";Image_b="+image_b;
	}
	if(count.length!=0){
		valueList+=";BCount="+count;
	}
	if(state.length!=0){
		valueList+=";Status="+state;
	}
	if(sale.length!=0){
		valueList+=";Bsale="+sale;
	}
	if(version.length!=0){
		valueList += ";Version="+version; 
	}
	
	window.opener.setBook("modify",valueList);
	window.close();
}
</script>
</html>