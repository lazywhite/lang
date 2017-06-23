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
  <style type="text/css">
    ul.errorMessage {color: #FF3300;}
    ul.errorMessage {list-style-type: none;display: inline;margin: 0px;padding: 3px;}
    ul.errorMessage li {list-style-type: none;display: inline;}
  </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
  <s:textfield name="name"  label="用户名"></s:textfield>
<s:fielderror>

</s:fielderror>
  <br />
  <s:textfield name="password" label="密码"></s:textfield>
  <br />
  <s:submit value="提交"></s:submit>
</form>
<a href="${pageContext.request.contextPath}/regPage" >注册</a>
</body>
</html>
