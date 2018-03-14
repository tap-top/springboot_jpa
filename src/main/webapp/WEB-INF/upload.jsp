<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件</title>
</head>
<body>
    单个文件上传:<br/>
    <form action="/uploadFile" method="post" enctype="multipart/form-data">
        <input type="file" name="file"/>
        <input type="submit" value="上传"/>
    </form>
    <br/>
    多个文件上传:<br/>
    <form action="/uploadFileMore" method="post" enctype="multipart/form-data">
        1：<input type="file" name="file"/><br/>
        2：<input type="file" name="file"/><br/>
        3：<input type="file" name="file"/><br/>
        <input type="submit" value="上传"/>
    </form>
</body>
</html>