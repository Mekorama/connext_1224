<!DOCTYPE html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <meta charset="utf-8">
    <title>login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
<input id="basePath" type="hidden" value="<%=basePath%>"/>
<h1>登录</h1>
<table>
    <tr>
        <td>
            <input type="text" id="phone" name="phone" class="user_phone"
                   placeholder="请输入手机号" pattern="^1(3|4|5|7|8)\d{9}$" required/>
        </td>
    </tr>

    <tr>
        <td>
            <input type="password" id="password" name="password" class="user_pwd"
                   pattern="[A-Za-z0-9]{4,20}" required placeholder="请输入密码">
        </td>
    </tr>

    <tr>
        <td>
            <button type="submit" onclick="checklogin()">登录</button>
            <input type="button" value="注册" onclick="location.href='<%=basePath%>/user/doRegister'">
        </td>
    </tr>
</table>
</body>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
    function checklogin() {
        var user_phone = $('.user_phone').val();
        var user_pwd = $('.user_pwd').val();
        var phone_No = {
            "phone": user_phone,
            "password": user_pwd
        };
        if (user_phone == "" || user_phone == null) {
            alert("手机号码不能为空！");
            return false;
        } else if (user_pwd == "" || user_pwd == null) {
            alert("密码不能为空！");
            return false;
        } else {
            $.ajax({
                type: 'post',
                url: '<%=basePath%>/user/checkReg',
                dataType: "json",
                data: phone_No,
                success: function (data) {
                    if (data == 'success') {
                        alert("还未注册！");
                    } else {
                        alert("登录成功");
                        location.href = '${path}/messagelist/queryAll'
                    }
                },
                errer: function () {
                    alert("error");
                }
            });
        }
    }
</script>
</html>


