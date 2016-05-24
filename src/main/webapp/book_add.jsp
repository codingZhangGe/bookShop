<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加书籍页面</title>
</head>
<body>
	书名：<input type="text" name="na_name" id="id_name" /><br><br>
	原价：<input type="text" name="na_price" id="id_price" /><br><br>
	现价：<input type="text" name="na_currentprice" id="id_currentprice" /><br><br>
	折扣：<input type="text" name="na_discount" id="id_discount" /><br><br>
	作者：<input type="text" name="na_author" id="id_author" /><br><br>
	出版社：<input type="text" name="na_publish" id="id_publish" /><br><br>
	类型：<select id="id_cid" name="na_cid">
			<option value="1">历史</option>
			<option value="2">外文</option>
			<option value="3">神话</option>
			<option value="4">言情</option>
			<option value="5">武侠</option>
			<option value="6">地理</option>
			<option value="7">音乐</option>
			<option value="8">美术</option>
		</select>
	介绍：<input type="text" name="na_introduce" id="id_introduce" /><br><br>
	店铺ID：<input type="text" name="na_shopid" id="id_shopid" /><br><br>
	小图：<input type="text" name="na_image_s" id="id_image_s" /><br><br>
	大图：<input type="text" name="na_image_b" id="id_image_b" /><br><br>
	<!-- 状态：<select name="na_state" id="id_state">
			<option value="1">售空</option>
			<option value="2">待销</option>
		</select> -->
	数量：<input type="text" name="na_count" id="id_count" /><br><br>
	版本：<input type="text" name="na_version" id="id_version" /><br><br>
	<center><input type="button" name="na_button" id="id_button" value="增加" onclick="isButton()" ></center>
</body>
<script type="text/javascript">
	function isButton(){
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
		var version=document.getElementById("id_version").value;
		
		var valueList="BName="+name+";Price="+price+";Currentprice="+currentprice+";Discount="+discount+
		";Author="+author+";Publish="+publish+";CID="+cid+";Introduce="+introduce+";ShopID="+shopid+";Image_s="+image_s+
		";Image_b="+image_b+";BCount="+count+";Version="+version;
		window.opener.setBook("add",valueList);
		window.close();
	}
</script>
</html>