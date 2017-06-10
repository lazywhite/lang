<%@ page contentType="text/html;Charset=UTF-8" pageEncoding="UTF-8"  %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div id="login">

    <h1>登录页面<span style="color:red; font-size:12px;">${message}</span></h1>
    <form method="post" action="<%=request.getContextPath()%>/login.do">
        <input type="text" name="username" />
        <input type="text" name="password" />
        <input type="submit" value="submit" />
    </form>
</div>

<h3> get from index ${param.age}</h3>
</body>
</html>

