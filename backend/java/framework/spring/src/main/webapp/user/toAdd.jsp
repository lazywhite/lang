<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/add" method="post">
        <input type="text" name="name" />
        <input type="text" name="password" />
        <input type="submit" />
    </form>
</body>
</html>
