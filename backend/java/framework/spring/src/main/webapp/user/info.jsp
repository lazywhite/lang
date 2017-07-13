<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
</head>
<body>
<c:forEach items="${list}" var="user">
    ${user.name}:  ${user.password}
    <br />
</c:forEach>
${hello}
</body>
</html>
