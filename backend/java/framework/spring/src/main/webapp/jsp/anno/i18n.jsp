<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>JSTL fmt:message 标签</title>
</head>
<body>

<fmt:setLocale value="en_US"/>

<fmt:message key="anno.name.empty" /><br/>
<fmt:message key="password.length.error" /><br/>

</body>
</html>