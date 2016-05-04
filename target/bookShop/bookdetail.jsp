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

<form action="/bookshop/category" method="post">
    <table border="0">
        <tr>
            <td>itemid</td>
            <td><input name="itemId" /></td>
        </tr>
        <tr>
            <td>state</td>
            <td><input name="state" /></td>
        </tr>
        <tr>
            <td>buycount</td>
            <td><input name="buyNumber" /></td>
        </tr>
    </table>
    <input type="submit">
</form>

<br>

<form action="/Order/doOrder" method="post">
    <table border="0">
        <tr>
            <td>cartId</td>
            <td><input name="cartId" value="item_id4"/></td>
        </tr>

        <tr>
            <td>linkman</td>
            <td><input name="linkman" /></td>
        </tr>

        <tr>
            <td>address</td>
            <td><input name="address" /></td>
        </tr>

        <tr>
            <td>telphone</td>
            <td><input name="telphone" /></td>
        </tr>



    </table>
    <input type="submit">
</form>


</body>

</html>
