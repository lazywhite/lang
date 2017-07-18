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

<form method="post" action="${pageContext.request.contextPath}/anno/test02">

<c:forEach begin="0" end="1" varStatus="idx">
    <input type="text" name="List[${idx.index}].name" />
</c:forEach>
<input type="submit" />
</form>
</body>
</html>
