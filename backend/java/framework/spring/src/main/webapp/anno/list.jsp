<%--
  Created by IntelliJ IDEA.
  User: white
  Date: 17/7/14
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2> test</h2>
    <c:forEach items="${list}" var="user">
        ${user.name}: ${user.password}
        <br />
    </c:forEach>
</body>
</html>
