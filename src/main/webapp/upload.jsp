<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhangge
  Date: 16-4-7
  Time: 上午10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件</title>
    <script type="text/javascript" src="jquery-1.5.1.js"/>
    <script type="text/javascript">

        $(document).ready(function() {
            <!--直接载入页面-->
            var comment = $('#comment');
            $('#refresh').click(function() {
                comment.children().remove();
                comment.load('comment.html #comment');//用法参考jQuery的load函数
            });

        });

    </script>
    <style type="text/css">
        table.gridtable {
            font-family: verdana,arial,sans-serif;
            font-size:11px;
            color:#333333;
            border-width: 1px;
            border-color: #666666;
            border-collapse: collapse;
        }
        table.gridtable th {
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #666666;
            background-color: #dedede;
        }
        table.gridtable td {
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #666666;
            background-color: #ffffff;
        }
    </style>

</head>
<body>
<form name="userForm2" action="/item/imageUpload" enctype="multipart/form-data" method="post">
    <div id="newUpload">
        源文件 <input type="file" name="file">
        <br/>
        目标文件 <input type="file" name="file">


    </div>
    <input type="submit" value="上传">

</form>

<form name="info" action="/item/itemUpload" method="post"/>

itemid <input type="text" name="bookId">
<br/>
bookname <input type="text" name="bookName">
<br/>
category<input type="text" name="categoryId">
<br/>
publish <input type="text" name="publish">
<br/>
<br/>
description <input type="text" name="description">
<br/>
author <input type="text" name="author">
<br/>
price <input type="text" name="price">
<br/>
discount <input type="text" name="discount">
<br/>
surplus <input type="text" name="surplus">
<input type="submit" value="上传">
</form>

</body>
</html>
