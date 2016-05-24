<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=gb2312">
<title>供应商管理</title>

	<link href="../resources/css/hottest.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
		.bt_01{
   		 	width:71px;
			height:25px;
			border:0px;
    		background: url(../resources/images/htdl.gif) no-repeat;
			color:#fff;
			font-size:12px;
			}
		.worn {
			font-size: 10px;
			color: #FF0000;
    	}
	</style>
</head>

<body onLoad="document.form1.vendorName.focus();">
	<form action="ok.html" method="post" name="form1" onSubmit="return isOk()">
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  			<tr>
    			<td height="30">
    				<table width="100%" border="0" cellspacing="0" cellpadding="0">
      					<tr>
        					<td width="15" height="30"><img src="../resources/images/tab_03.gif" width="15" height="30" /></td>
        					<td background="../resources/images/tab_05.gif" align="left"><img src="../resources/images/311.gif" width="16" height="16" /> <span class="STYLE4">供应商添加/修改</span></td>
        					<td width="14"><img src="../resources/images/tab_07.gif" width="14" height="30" /></td>
      					</tr>
    				</table>
    			</td>
  			</tr>
  			<tr>
    			<td>
    				<table width="100%" border="0" cellspacing="0" cellpadding="0">
      					<tr>
        					<td width="15" style="background:url(../resources/images/tab_12.gif) repeat-y left #d3e7fc; ">&nbsp;</td>
        					<td width="97%" bgcolor="#FFFFFF"  valign="top" align="center" height="500" style=" padding-top:20px;">
								<table width="505px" border="0" cellspacing="0" cellpadding="0" >
									<tr style="width:100%;height:20px;background:url(../resources/images/htbg1.gif);">
										<td></td>
									</tr>
									<tr style="width:100%; height:250px; background: url(../resources/images/htbg3.gif) repeat-y; text-align:center;">
										<td>
                    						<table width="89%" border="0" cellspacing="0" cellpadding="0">
                      							<tr>
                        							<td width="20%" height="30" align="right" class="STYLE4">供应商名：</td>
                        							<td width="37%" align="left"><input type="text"  onBlur="checkName()" name="vendorName" msg="供应商名称必填"/></td>
                        							<td width="43%" align="left" id="id1" class="worn">&nbsp;</td>
                      							</tr>
                      							<tr>
                        							<td width="20%" height="30" align="right" class="STYLE4">城市编号：</td>
                        							<td align="left"><input type="text" name="cityId"/ onBlur="checkCityId()"></td>
                        							<td align="left" id="id2" class="worn">&nbsp;</td>
                      							</tr>
                      							<tr>
                        							<td width="20%" height="30" align="right" class="STYLE4">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：</td>
                        							<td align="left"><input type="text" name="address" onBlur="checkAddress()"/></td>
                        							<td align="left" id="id3" class="worn">&nbsp;</td>
                      							</tr>
                      							<tr>
                        							<td width="20%" height="30" align="right" class="STYLE4">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;编：</td>
                        							<td align="left"><input type="text" name="postcode" onBlur="checkPost()" msg="邮编格式(6位数字)"/></td>
                        							<td align="left" id="id4" class="worn">&nbsp;</td>
                      							</tr>
                      							<tr>
                        							<td width="20%" height="30" align="right" class="STYLE4">固定电话：</td>
                        							<td align="left"><input type="text" name="telphone" onBlur="checkTel()" msg="电话格式：区号-电话" /></td>
                        							<td align="left" id="id5" class="worn">&nbsp;</td>
                      							</tr>
                      							<tr>
                        							<td width="20%" height="30" align="right" class="STYLE4">联&nbsp;&nbsp;系&nbsp;&nbsp;人：</td>
                        							<td align="left"><input type="text" name="contact" onBlur="checkP()" msg="输入中文名字"/></td>
                        							<td align="left" id="id6" class="worn">&nbsp;</td>
                      							</tr>
                      							<tr>
                        							<td width="20%" height="30" align="right" class="STYLE4">状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态：</td>
                        							<td align="left">
                            							<select name="status">
                                							<option value="1">激活</option>
                                							<option value="0">冻结</option>
                            							</select>
                        							</td>
                        							<td align="left">&nbsp;</td>
                      							</tr>
                      							<tr>
                        							<td height="40" colspan="3" align="center">
                        							<input type="submit" name="" value="确定" class="bt_01"/>&nbsp; 
                        							<input type="reset" name="" value="取消"  class="bt_01"/></td>
                      							</tr>
                      							<tr>
                      								<td height="40" colspan="3" align="center" class="STYLE4"></td>
                      							</tr>
                    							</table>
											</td>
										</tr>
										<tr style="width:100%; height:17px; background: url(../resources/images/htbg2.gif) no-repeat;">
											<td>&nbsp;</td>
										</tr>
									</table>
								</td>
        <td width="14"  style="background:url(../resources/images/tab_16.gif) repeat-y right #d3e7fc; ">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="29"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="29"><img src="../resources/images/tab_20.gif" width="15" height="29" /></td>
        <td background="../resources/images/tab_21.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="21%" height="14">&nbsp;</td>
            <td width="79%" class="worn" align="right">&nbsp;</td>
          </tr>
        </table></td>
        <td width="14"><img src="../resources/images/tab_22.gif" width="14" height="29"/></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>

</body>

<script language="javascript">
 	//中文汉字通过
	function checkName(){
		var input_name = document.form1.vendorName.value;
		var name = /^[\u4e00-\u9fa5]+$/
                var result=input_name.match(name);
		
		if(input_name== ""){
			document.getElementById("id1").innerHTML = "<img src='../resources/images/no.gif' width='12' height='12'/>&nbsp;用户名不能为空";
			return false;
		}else if(result==null){
			document.getElementById("id1").innerHTML = "<img src='../resources/images/no.gif' width='12' height='12'/>&nbsp;请输入中文名称";
		}else{
		 	document.getElementById("id1").innerHTML = "<img src='../resources/images/yes.gif' width='15' height='15'/>";
			return true;
		}
	}
	//验证城市编号(4-8位数字)
	function checkCityId(){
		var input_cityid = document.form1.cityId.value;
		var cityid = /^[0-9]{4,8}$/
		var result=input_cityid.match(cityid);

		if(input_cityid== ""){
			document.getElementById("id2").innerHTML = "<img src='../resources/images/no.gif' width='12' height='12'/>&nbsp;城市编号不能为空";
			return false;
		}else if(result==null){
			document.getElementById("id2").innerHTML = "<img src='../resources/images/no.gif' width='12' height='12'/>&nbsp;城市编号输入有误";
		}else{
		 	document.getElementById("id2").innerHTML = "<img src='../resources/images/yes.gif' width='15' height='15'/>";
			return true;
		}	
	}
	//验证地址（数字字母和汉字组成）
	function checkAddress(){
		var input_addr = document.form1.address.value;
		var adrr = /[\dA-Za-z\u4E00-\u9FA5]+/
		var result=input_addr.match(adrr);
		if(input_adrr == ""){
			document.getElementById("id3").innerHTML = "<img src='../resources/images/no.gif' width='12' height='12'/>&nbsp;地址不能为空";
			return false;
		}else if(result==null){
			document.getElementById("id3").innerHTML = "<img src='../resources/images/no.gif' width='12' height='12'/>&nbsp;请输入正确地址(数字,字母,汉字)";
		}else{
		 	document.getElementById("id3").innerHTML = "<img src='../resources/images/yes.gif' width='15' height='15'/>";
			return true;
		}	
	}
	//验证邮编（六位数字且不以0开始）
	function checkPost(){
		var input_zip_code = document.form1.postcode.value;
		var zip_code = /^[1-9][0-9]{5}$/;
		var result=input_zip_code.match(zip_code);
		if(input_zip_code == ""){
			document.getElementById("id4").innerHTML = "<img src='../resources/images/no.gif' width='12' height='12'/>&nbsp;邮编不能为空";
			return false;
		}else if(result==null){
			document.getElementById("id4").innerHTML = "<img src='../resources/images/no.gif' width='12' height='12'/>&nbsp;请输入正确的邮编";
		}else{
		 	document.getElementById("id4").innerHTML = "<img src='../resources/images/yes.gif' width='15' height='15'/>";
			return true;
		}	
	}
	//验证电话xxxx-xxxx xxx/xxx-xxxx xxxx
	function checkTel(){
		var input_tel = document.form1.telphone.value;
		var tel = /[0-9]{3}-[0-9]{8}|[0-9]{7}-[0-9]{4}/
		var result=input_tel.match(tel);
		if(input_tel == ""){
			document.getElementById("id5").innerHTML = "<img src='../resources/images/no.gif' width='12' height='12'/>&nbsp;电话不能为空";
			return false;
		}else if(result==null){
			document.getElementById("id5").innerHTML = "<img src='../resources/images/no.gif' width='12' height='12'/>&nbsp;请输入正确格式(xxx-xxxxxxx/xxxx-xxxxxx)";
		}else{
		 	document.getElementById("id5").innerHTML = "<img src='../resources/images/yes.gif' width='15' height='15'/>";
			return true;
		}	
	}
	//验证联系人（中文名称）
	function checkP(){
		var input_person = document.form1.contact.value;
		var person = /^[\u4e00-\u9fa5]{2,10}$/
		var result=input_person.match(person);
		if(input_person==""){
		 document.getElementById("id6").innerHTML = "<img src='../resources/images/no.gif' width='12' height='12'/>&nbsp;联系人不能为空";

			}
		else if(result==null){
			document.getElementById("id6").innerHTML = "<img src='../resources/images/no.gif' width='12' height='12'/>&nbsp;请输入中文名称";
		}else{
		 	document.getElementById("id6").innerHTML = "<img src='../resources/images/yes.gif' width='15' height='15'/>";
			return true;
		}
	}
	//提交
	function checkSubmit(){
		if(!checkName()){
			return false;
		}
		if(!checkCityId()){
			return false;
		}
		if(!checkAddress()){
			return false;
		}
		if(!checkPost()){
			return false;
		}
		if(!checkTel()){
			return false;
		}
		if(!checkP()){
			return false;
		}
		return true;
	}
	function isOk(){
		if(!checkSubmit()){
			alert("信息填写有误！");
			return false;
		}
		return true;
	}
 </script>

</html>
