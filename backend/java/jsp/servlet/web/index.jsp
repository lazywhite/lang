<%@ include file="header.jsp" %>
<body>
    <% if(request.getAttribute("username") != null){ %>
    welcome ${username}, your age: ${param.age}, your hobby: ${param.hobby}
    <% } else{%>
    <jsp:forward page="login.jsp">
        <jsp:param value="17" name="age" />
    </jsp:forward>
    <% } %>
    <br />
</body>
</html>

