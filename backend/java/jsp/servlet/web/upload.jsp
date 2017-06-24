<%@ page contentType="text/html;Charset=UTF-8" pageEncoding="UTF-8"  %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>文件上传</title>
</head>
<body>

<form method="post" action="<%=request.getContextPath()%>/upload" enctype="multipart/form-data">
    <input type="text" name="name" />
    <input type="file" name="portrait" />
    <input type="submit" value="submit" />
</form>

</body>
</html>

