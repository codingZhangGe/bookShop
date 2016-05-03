<%--
  Created by IntelliJ IDEA.
  User: yunfeng.yang
  Date: 16-4-21
  Time: 下午2:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/auction/doAuction" method="post">
    <table border="0">
        <tr>
            <td>姓名</td>
            <td><input name="itemId" value="item_id1"/></td>
            <td><input name="state" value="2"/></td>
            <td><input name="auctionPrice" value="12"/></td>
        </tr>
    </table>
    <input type="submit">
</form>

<br>

<form action="/bookshop/details" method="post">
    <table border="0">
        <tr>
            <td>itemId</td>
            <td><input name="itemId" value="item_id1"/></td>
        </tr>
        <tr>
            <td>state</td>
            <td><input name="state" value="2"/></td>
        </tr>

    </table>
    <input type="submit">
</form>
</body>

<br>

<form action="/administrator/takeOffItem" method="post">
    <table border="0">
        <tr>
            <td>姓名</td>
            <td><input name="itemId" value="item_id5"/></td>
        </tr>
    </table>
    <input type="submit">
</form>

<br>

<form action="/administrator/putOnItems" method="post">
    <table border="0">
        <tr>
            <td>姓名</td>
            <td><input name="itemId" value="item_id4"/></td>
        </tr>
    </table>
    <input type="submit">
</form>


</body>

</html>
