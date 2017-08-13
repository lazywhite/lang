<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath %>" />
</head>
<body>

<form action="anno/test03" method="post">
    <input type="text" name="birthday" />
    <input type="text" name="extra" />
    <input type="submit" />
</form>


</body>
</html>
