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
        <form id="search" action="empUpd" method="post">
            <input type="hidden" value="${emp.empno}" name="emp.empno" />
            名称:<input type="text" name="emp.ename"  value="${emp.ename}"/><br/>
            职位:<input type="text" name="emp.job" value="${emp.job}" /><br/>
            工资:<input type="text" name="emp.salary" value="${emp.salary}" /><br/>
            奖金:<input type="text" name="emp.bonus"  value="${emp.bonus}" /><br/>
            性别:<input type="radio" name="emp.sex" value="男"  <c:if test="${emp.sex == '男'}">checked="checked"</c:if> />男
            <input type="radio" name="emp.sex" value="女" <c:if test="${emp.sex == '女'}">checked="checked"</c:if>/>女<br/>
            入职日期:<input type="text" name="emp.hiredate" value="${emp.hiredate}"/><br/>
            <select name="emp.dept.deptno">
                <c:forEach items="${depts}" var="dept">
                    <option value="${dept.deptno}"
                    <c:if test="${emp.dept.deptno == dept.deptno}">
                        selected="selected"
                    </c:if>
                    >${dept.deptname}</option>
                </c:forEach>
            </select><br/>
            <input type="submit" value="提交" />
        </form>
    </body>
</html>
