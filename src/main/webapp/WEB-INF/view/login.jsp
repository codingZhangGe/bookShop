<%--
  Created by IntelliJ IDEA.
  User: lingtong
  Date: 16-4-18
  Time: 上午12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
登陆页面
<button id="qsso-login">qsso登录</button>

<!-- 引入qsso auth js库 -->
<script src="https://qsso.corp.qunar.com/lib/qsso-auth.js"></script>

<script>
    // 调用QSSO.attach进行登录参数的设置，如：设置绑定登录事件的HTML元素，接收token的登录接口URI。
    QSSO.attach('qsso-login', 'login.htm');
    // attach函数会将HTMLid为qsso-login的元素onclick时自动去qsso登录，当用户用户点击上面的button，会跳到qsso登录页面,用户在qsso登录后将会把token值post到http://xxx.qunar.com/login.php上。

</script>
<!-- 结束 -->
${message}
</body>
</html>
