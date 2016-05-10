<%--
  Created by IntelliJ IDEA.
  User: ge.zhang
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

<br>

<form action="/bookshop/details" method="post">
    图书详情
    <table border="0">
        <tr>
            <td>bookId</td>
            <td><input name="bookId" value="073d80ff029c46e399dab60f1e2d9088"/></td>
        </tr>
        <tr>
            <td>state</td>
            <td><input name="state" value="1"/></td>
        </tr>

    </table>
    <input type="submit">
</form>
</body>

<br>

<form action="/bookshop/cart" method="post">
    加入购物车
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
        下单
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
