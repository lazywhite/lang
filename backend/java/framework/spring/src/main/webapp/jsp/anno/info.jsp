<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
</head>
<body>
${extra}
${sessionScope.attr1}
<br />
<fmt:formatDate value="${birthday}" pattern="yyyy-MM-dd" />
</body>
</html>
