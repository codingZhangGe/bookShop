
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
        图片1 <input type="file" name="file">
        <br/>
        图片2<input type="file" name="file">
        <br/>
        图片3<input type="file" name="file">
        <br/>
        图片4<input type="file" name="file">
        <br/>
        图片5<input type="file" name="file">
        <br/>

    </div>
    <input type="submit" value="上传">

</form>
</body>
<body>
<form name="info" action="/item/itemUpload" enctype="application/x-www-form-urlencoded" method="post">

    <table>
        <tr>
            <td>
itemid
            </td>
            <td><input name="bookId"></td>
        </tr>

        <tr>

<td>bookname </td>
            <td><input  name="bookName"></td>
        </tr>
        <tr>
            <td>
category</td> <td><input  name="categoryName"></td>
        </tr>
        <tr>
            <td>
publish </td><td><input  name="publish"></td>
        </tr>
        <tr>
            <td>
description </td><td><input  name="description"></td>
        </tr>
        <tr>
            <td>
author </td><td><input  name="author"></td>
</tr>
        <tr>
            <td>
price</td><td> <input name="price"></td>
        </tr>
        <tr>
            <td>
discount </td><td><input  name="discount"></td>
        </tr>
        <tr>
            <td>
surplus </td><td><input type="text" name="surplus"></td>
        </tr>
<input type="submit" value="上传">
    </table>
</form>



<form name="info" action="/item/category" enctype="application/x-www-form-urlencoded" method="post">

    <table>


        <tr>
            <td>parentName </td>
            <td><input  name="parentName"></td>
            <td>categoryname </td>
            <td><input  name="category"></td>
        </tr>


        <input type="submit" value="上传">
    </table>
</form>



</body>
</html>
