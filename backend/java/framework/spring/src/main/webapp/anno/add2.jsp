<%--
  Created by IntelliJ IDEA.
  User: white
  Date: 17/7/14
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath}/anno/add">
    <input type="text" name="name" />
    <input type="radio" name="gender" value="0" />男
    <input type="radio" name="gender" value="1" />女

    extra: <input type="text" name="extra" />

    兴趣:
    <input type="checkbox" name="interest" value="1" />吃
    <input type="checkbox" name="interest" value="2" />喝
    <input type="checkbox" name="interest" value="3" />玩
    <input type="submit" />
</form>
</body>
</html>
