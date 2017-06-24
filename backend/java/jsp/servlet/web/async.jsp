<%@ page session="false" isErrorPage="false" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
${message}<br />
<% out.println("业务调用结束时间" + new java.util.Date());
request.getAsyncContext().complete();
 %>
