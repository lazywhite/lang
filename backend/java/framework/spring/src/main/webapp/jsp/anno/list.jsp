<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
</head>
<body>
<c:forEach items="${list}" var="anno">
    ${anno.name}: ${anno.password}
    <br />
</c:forEach>

${share.name}: ${share.password}
<br />
${sessionScope.attr1}

</body>
</html>
