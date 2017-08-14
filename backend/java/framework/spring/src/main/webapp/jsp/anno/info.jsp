<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>使用 JSTL 函数</title>
</head>
<body>

${extra}
${sessionScope.attr1}
<br />
<fmt:formatDate value="${birthday}" pattern="yyyy-MM-dd" />

<c:set var="string1" value="www runoob com"/>
<c:set var="string2" value="${fn:split(string1, ' ')}" />
<c:set var="string3" value="${fn:join(string2, '-')}" />

<p>string3 字符串 : ${string3}</p>

<c:set var="string4" value="${fn:split(string3, '-')}" />
<c:set var="string5" value="${fn:join(string4, ' ')}" />

<p>string5 字符串: ${string5}</p>

</body>
</html>
