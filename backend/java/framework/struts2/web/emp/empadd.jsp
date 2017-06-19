<%--
Created by IntelliJ IDEA.
User: white
Date: 17/6/16
Time: 15:17
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
    </head>
    <body>
        <form id="search" action="empAdd" method="post">
            名称:<input type="text" name="emp.ename" id="name" /><br/>
            职位:<input type="text" name="emp.job" /><br/>
            工资:<input type="text" name="emp.salary" /><br/>
            奖金:<input type="text" name="emp.bonus" /><br/>
            性别:<input type="radio" name="emp.sex" value="男"/>男
            <input type="radio" name="emp.sex" value="女" />女<br/>
            入职日期:<input type="text" name="emp.hiredate" /><br/>
            <select name="emp.dept.deptno">
                <c:forEach items="${depts}" var="dept">
                    <option value="${dept.deptno}">${dept.deptname}</option>
                </c:forEach>
            </select><br/>
            <input type="submit" value="提交" />
        </form>
    </body>
</html>
