<%--
  Created by IntelliJ IDEA.
  User: white
  Date: 17/6/16
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
  <title>$Title$</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/register" method="post" enctype="multipart/form-data">
  <fieldset>
    <caption>注册信息</caption>
    <br/>
    <label>
      用户名：<input type="text" name="user.name" />
    </label>
    <br/>
    <label>
      密码：<input type="password" name="user.password" />
    </label>
    <br/>
    爱好：
    <label>
      吃：<input type="checkbox" name="user.hobby" value="1"/>
    </label>
    <label>
      喝：<input type="checkbox" name="user.hobby" value="2"/>
    </label>
    <label>
      玩：<input type="checkbox" name="user.hobby" value="3"/>
    </label>
    <br/>
    <label>
      生日：<input type="text" name="user.birthDay" />
    </label>
    <br/>
    <label>
      头像: <s:file name="portrait"></s:file>
    </label>
    <input type="submit" />
  </fieldset>
</form>

</body>
</html>
