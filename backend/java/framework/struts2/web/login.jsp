<%--
  Created by IntelliJ IDEA.
  User: white
  Date: 17/6/16
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/login" method="post">
    <input type="text" name="name" />
    <input type="password" name="password" />
    <input type="submit" />
  </form>
  <a href="${pageContext.request.contextPath}/register" >注册</a>
  </body>
</html>
