<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
    <form method="get" action="/user/login">
        用户名：<input type="text" name="name"/><br/>
        密码：<input type="text" name="password">
        <input type="submit" value="登录">
    </form>
</body>
</html>