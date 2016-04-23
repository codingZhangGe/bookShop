<%--
  Created by IntelliJ IDEA.
  User: lingtong
  Date: 16-4-18
  Time: 上午10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>

</head>
<body>
首页
<div class="col-xs-12" ms-controller="form">
    <div class="form-group">
        <input type="text" ms-duplex="name">
        <button class="btn btn-info" ms-click="sayHello">
            say hi
        </button>
    </div>
</div>

<script src="/js/jquery.min.js"></script>
<script src="/js/avalon.js"></script>

<script>
    var vm = avalon.define({
        $id: 'form',
        name: 'q派',
        sayHello: function () {
            $.ajax({
                url: "/sayhi.json",
                type: "post",
                data: {
                    name: vm.name
                }
            }).success(function (ret) {
                //ret = JSON.parse(ret);

                console.log(ret);
                if (ret.status !== 0) {
                    console.info(ret.message);
                    return
                }
                alert(ret.data);
                console.info(ret.data);
            }).error(function (e) {
                console.info("错误信息");
                console.log(e);
            });
        }
    })
</script>
</body>
</html>

