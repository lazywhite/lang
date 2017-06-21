<%--
  Created by IntelliJ IDEA.
  User: white
  Date: 17/6/16
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <style type="text/css">
        table td.odd {
            color: red;
        }
        table td.even {
            color: green;
        }

    </style>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.2.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#img").click(function(){
                var id = Math.random();
                $(this).attr("src", "${pageContext.request.contextPath}/validcode?id=" + id);
            })
        })
        function valid(){
            var code = $("#userInput").val();
            $.ajax({
                url: "${pageContext.request.contextPath}/checkcode?code=" + code,
                method: "get",
                dataType: "json",
                success: function(data){
                    var flag = data.flag;
                    if(flag){
                        alert("you are right");
                    }else{
                        alert("you are wrong");
                    }
                    $("#img").click();
                }
            });
        }
    </script>
</head>
<body>
request:${requestKey}
<br />
session:${sessionKey}
<br />
application: ${appKey}
<br />

name: <s:property value="name" />
<br />
requestKey:<s:property value="#request.requestKey" />
<br />
sessionKey:<s:property value="#session.sessionKey" />
<br />
appKey:<s:property value="#application.appKey" />
<br />
age: <s:property value="age" />
<br />
date: <s:date name="birthDay" format="yyyy-MM-dd" />
<br />
<s:if test="age < 18">
    <span> 未成年</span>
</s:if>
<s:elseif test="age < 40">
    <span>成年人</span>
</s:elseif>
<s:else>
    <span>老年人</span>
</s:else>


<!--
    value 是ognl表达式
    var代表一个元素, 放在context区
    s封装了迭代的状态
-->
<table>
    <tr>
        <th>用户名</th>
        <th>密码</th>
    </tr>
    <!-- ognl表达式结合EL表达式一起使用 -->
    <s:iterator value="list" var="u" status="s">
        <tr>
            <td
                    <s:if test="#s.even">
                        class="even"
                    </s:if>

                    <s:if test="#s.odd">
                        class="odd"
                    </s:if>
            ><s:property value="#u.name" />, ${u.name}</td>
            <td >
                <s:property value="#u.password" />, ${u.password}
            </td>
        </tr>
    </s:iterator>
</table>
<s:debug></s:debug>
<s:set value="list.size()" var="listSize" scope="session">
</s:set>
listSize:  <s:property value="#session.listSize" /> <br/>
sessionSize:<s:property value="#session.size" /> <br/>  <!--注意var不要跟session等对象已有的属性重名-->
<s:iterator begin="1" end="10" step="2">
    good
</s:iterator>
<s:property value="sex" />
<s:a action="login" namespace="/" > 访问登录页面</s:a> <!--必须指定namespace -->

<!-- name 规定默认选定的option -->
<s:select  list="list"  listKey="password" listValue="name"
headerKey="----select---" headerValue="-1" name="selectedOptionValue"
 ></s:select>
<s:form action="register" namespace="/" theme="simple" id="ff" >
    <s:textfield label="用户名" name="test" class="test"></s:textfield>
    <s:textfield label="密码" name="password" ></s:textfield>
    <!-- showPassword true显示黑点, false不显示任何东西 -->
    <s:password showPassword="true" value="test"></s:password>
    <%--<s:checkboxlist list="intList" listKey="intId" listValue="intName"></s:checkboxlist>--%>
    <s:submit align="left" value="提交" ></s:submit>
    <s:reset></s:reset>
</s:form>

<a href="${pageContext.request.contextPath}/download?filename=<%=java.net.URLEncoder.encode("测试用的rar.rar", "utf-8").toString().replace("%", "_")%>">点击下载</a>
<input type="text" id="userInput" placeholder="请输入验证码" onblur="valid()"/>
<img src="${pageContext.request.contextPath}/validcode" id="img" />

</body>
</html>
