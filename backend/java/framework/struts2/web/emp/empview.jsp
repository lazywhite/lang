<%--
Created by IntelliJ IDEA.
User: white
Date: 17/6/16
Time: 15:17
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="path"></c:set>
<html>
<head>
    <script type="text/javascript">
        function jump(page){
            if(page > ${totalPage}){
                return;
            }else {
                document.getElementById("curPage").value = page;
                document.getElementById("search").submit();
            }
        }
        function delEmp(id){
            if(id == null || id == undefined){
                return;
            }
            var rt = confirm("确认删除?");
            if(rt == true){
                location.href="${path}/emp/empDel?id=" + id;
            }
        }
        function checkAll(){
            var cks = document.getElementsByClassName("ck");
            for(var i=0;i<cks.length;i++){
                console.log(cks[i]);
            }
            var checkAllbtn = document.getElementById("checkAllbtn");
            console.log(checkAllbtn.checked)
            if(checkAllbtn.checked == true){
                for(var i=0;i<cks.length;i++){
                    cks[i].checked = true;
                }

            }else{
                for(var i=0;i<cks.length;i++){
                    cks[i].checked = false;
                }
            }
        }
    </script>
</head>
<body>
<a href="${path}/emp/empToAdd" >新增</a>
<hr />
<form id="search" action="empView" method="post">
    <fieldset>
        <caption>搜索</caption>
        姓名: <input type="text" name="name" id="name" value="${name}"/>
        <input type="hidden" id="curPage" name="curPage" />
        性别<select name="sex" id="sex">
        <option value="-1">-------</option>
        <option value="男" <c:if test="${sex == '男'}">selected="selected"</c:if>>男</option>
        <option value="女" <c:if test="${sex == '女'}">selected="selected"</c:if>>女</option>
    </select>
    <input type="submit" value="搜索" /> <input type="reset" value="重置" />
    </fieldset>
</form>

<form action="${path}/emp/empBatchDel" method="post" onsubmit="return confirm()">
    <table cellspacing="0px" cellpadding="10px" border="1px">
        <thead>
        <th><label><input type="checkbox" id="checkAllbtn" onclick="checkAll()" />全选</label></th>
        <th>编号</th>
        <th>姓名</th>
        <th>工作</th>
        <th>薪资</th>
        <th>奖金</th>
        <th>性别</th>
        <th>入职日期</th>
        <th>部门</th>
        <th>操作</th>

        </thead>
        <tbody>
        <c:forEach items="${emps}" var="emp">
            <tr>
                <td><input type="checkbox" class="ck" name="empids" value="${emp.empno}" /></td>
                <td>${emp.empno}</td>
                <td>${emp.ename}</td>
                <td>${emp.job}</td>
                <td>${emp.salary}</td>
                <td>${emp.bonus}</td>
                <td>${emp.sex}</td>
                <td>${emp.hiredate}</td>
                <td>${emp.deptName}</td>
                <td><a href="${path}/emp/empToUpd?id=${emp.empno}">编辑</a>&nbsp;&nbsp;<a href="javascript:;" onclick="delEmp(${emp.empno})">删除</a></td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
    <input type="submit" value="删除所选"/>
</form>
<hr />
<c:if test="${curPage > 1}">
    <a href="javascript:;" onclick="jump(1)">首页</a>
    <a href="javascript:;" onclick="jump(${curPage -1})">上一页</a>
</c:if>
第${curPage}页/共${totalPage}页
<input type="number" id="ipt" min="1" max="${totalPage}" onchange="jump(this.value)" />
<c:if test="${curPage < totalPage}">
    <a href="javascript:;" onclick="jump(${curPage +1})">下一页</a>
    <a href="javascript:;" onclick="jump(${totalPage})">尾页</a>
</c:if>
</body>
</html>
