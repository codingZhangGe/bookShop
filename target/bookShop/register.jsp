<%--
  Created by IntelliJ IDEA.
  User: zhangge
  Date: 16-5-12
  Time: 上午11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/xupt/register" method="post">
    <table border="0">
        <tr><td>姓名</td><td><input name="name" value=" "></td></tr>
        <tr><td>密码</td><td><input name="password" value=" "></td></tr>
        <tr><td>邮箱</td><td><input name="email" value=" "></td></tr>
        <tr><td>电话</td><td><input name="tel" value=" "></td></tr>
    </table>
    <input type="submit" value="注册">
</form>
</body>
</html>
