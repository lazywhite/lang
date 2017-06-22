<%--
  Created by IntelliJ IDEA.
  User: white
  Date: 17/6/16
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
  <title>Login Page</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
  <s:textfield name="name"  label="用户名"></s:textfield>${errors.name[0]}
  <br />
  <s:textfield name="password" label="密码"></s:textfield>${errors.password[0]}
  <br />
  <s:submit value="提交"></s:submit>
</form>
<a href="${pageContext.request.contextPath}/regPage" >注册</a>
</body>
</html>
