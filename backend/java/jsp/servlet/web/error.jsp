<%@ page contentType="text/html;Charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib prefix="" tagdir="/WEB-INF/tags"%>

<html lang="en">
<head>
	<meta charset="UTF-8">
	<title></title>
</head>
<body>
    异常类型: <%= exception.getClass() %>
    异常种类: <%= exception.getMessage() %>
    <h1>error page</h1>
</body>
</html>
