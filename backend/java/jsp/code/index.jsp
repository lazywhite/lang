<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.*" %>
<%@ page session="true" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;Charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="" tagdir="/WEB-INF/tags"%>

<%! Float PI = 3.14f;%>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <%--
        <%@ include file="header.jsp" %>
        --%>
        <%
        String uri = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getRequestURI();
        out.println("current uri: "  + uri);
        out.println("<br />");
        Date now = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        out.println("current time: "  + sf.format(now));
        %>
        <h1> 一、 Request Object</h1>
        <h2> 1. request parameter</h2>

        <table border=1>
            <tr>
            <th>param</th>
            <th>value</th>
            </tr>
            <%
            Map<String, String[]> paraMap = request.getParameterMap();
            for(String key: paraMap.keySet()){  %>
            <tr>
            <td>
            <%= key%>
            </td>
            <td>
            <%
            for(String v: paraMap.get(key)){
            out.println(v);
            }
            %>
            </td></tr>
            <% } %>
        </table>

        <h2> 2. request header</h2>
        <table border=1>
            <tr>
            <th width="300px">header</th>
            <th>value</th>
            </tr>
            <%
            Enumeration<String> headerNames = request.getHeaderNames();
            while(headerNames.hasMoreElements()){
            String key = headerNames.nextElement();
            out.println("<tr><td>" + key + "</td><td>" + request.getHeader(key) + "</td></tr>");
            }
            %>
        </table>
        <h2> 3. request cookie</h2>
        <table border=1>
            <tr>
            <th width="300px">cookie-key</th>
            <th>value</th>
            </tr>
            <%
            Cookie[] cs = request.getCookies();
            for(Cookie c: cs){
            out.println("<tr><td>" + c.getName() + "</td><td>" + c.getValue() + "</td></tr>");
            }
            %>
        </table>
        <h2> 4. International</h2>
        <table border=1>
            <%
            Locale l = request.getLocale();
            out.println("<tr><td width='100px'>Country</td><td>" + l.getCountry()+ "</td></tr>");
            out.println("<tr><td>Language</td><td>" + l.getLanguage()+ "</td></tr>");
            %>
        </table>

        <h1> 二、 Response Object</h1>
        <h2> 1. response headeres</h2>
        <table border=1>
            <tr>
            <th width="300px">cookie-key</th>
            <th>value</th>
            </tr>
            <%
            Cookie c = new Cookie("cookie-key", "cookie-value"); //set cookie
            c.setMaxAge(60 * 60 * 5); //setMaxAge(0) --> clear cookie
            response.addCookie(c);
            Collection<String> rhs = response.getHeaderNames();
            for(String rh: rhs){
            out.println("<tr><td width='100px'>" + rh +  "</td>" + "<td>" + response.getHeader(rh) + "</td></tr>");
            }

            //    response.setStatus(200);
            //    response.sendError(503, "Service unavailable");
            //    response.sendRedirect("http://www.baidu.com");
            %>
        </table>
        <h1> 三、 Session Object</h1>
        <%
        if(session.isNew()){
        out.println("welcome to my site");
        }else{
        out.println("welcome back to my site");
        }

        session.setAttribute("session-attr", "session-value");
        %>

        <table border=1>
            <tr>
            <th width="300px">cookie-key</th>
            <th>value</th>
            </tr>
            <%
            out.println("<td>session-id</td><td>" + session.getId() + "</td></tr>");
            Enumeration<String> sas = session.getAttributeNames();
            while(sas.hasMoreElements()){
            String s = sas.nextElement();
            out.println("<td>" + s + "</td><td>" + session.getAttribute(s) + "</td></tr>");
            }
            %>
        </table>
        <h1> 四、Application Object</h1>
        <%
        out.println("server info: " + application.getServerInfo() + "<br/>");
        out.println("<br/>");
        out.println("context path: " + application.getContextPath());
        out.println("<br/>");
        out.println("absolute path: " + application.getRealPath("."));
        out.println("<br/>");
        SessionCookieConfig  scc = application.getSessionCookieConfig();
        out.println(scc.getName());
        out.println("is secure: " + scc.isSecure());

        out.println("<br/>");
        out.println("virtual server name: " + application.getVirtualServerName());
        out.println("<br/>");
        %>
        <h1>五、pageContext Object</h1>
        <%
            pageContext.setAttribute("session-attr", "session-val", pageContext.SESSION_SCOPE);
            pageContext.setAttribute("application-attr", "app-val", pageContext.APPLICATION_SCOPE);
            pageContext.setAttribute("request-attr", "req-val", pageContext.REQUEST_SCOPE);
            out.println(pageContext.getAttribute("session-attr", pageContext.SESSION_SCOPE));
            out.println(pageContext.getAttribute("application-attr", pageContext.APPLICATION_SCOPE));
            out.println(pageContext.getAttribute("request-attr", pageContext.REQUEST_SCOPE));
            ServletConfig sc  = pageContext.getServletConfig();
//            Enumeration<String> params = sc.getInitParameterNames();
//            while(params.hasMoreElements()){
//            String s = params.nextElement();
//            out.println("<tr><td>" + s + "</td><td>" + sc.getInitParameter(s) + "</td></tr>");
//            }
            %>
        </table>
        <h1>六、Config Object</h1>
        <table border=1>
            <tr>
                <th width="300px">servlet-init-param</th>
                <th>value</th>
            </tr>
        <%
        out.println("servlet name: " + config.getServletName());
        Enumeration<String> ips = config.getInitParameterNames();
        while(ips.hasMoreElements()){
            String s = ips.nextElement();
            out.println("<tr><td>" + s + "</td><td>" + config.getInitParameter(s) + "</td></tr>");
        }
        %>
        </table>


   <h1>七、 JSP with Bean</h1>
        <jsp:useBean id="user" class="com.local.User" scope="session">
            <jsp:setProperty name="user" property="name" value="bob" />
        </jsp:useBean>
        <p>get User name from bean: <jsp:getProperty name="user" property="name" /></p>
   <h1> 八、Expression Language </h1>
   <pre>
   implicitly object
        1. pageScope
        2. requestScope
        3. sessionScope
        4. applicationScope
        5. param
        6. paramValues
        7. header
        8. headerValues
        9. initParam
        10. cookie
        11. pageContext
    
   </pre>
        <p>get request param: ${param["key"]} </p>
        <p>get request header content-type: ${header["user-agent"]} </p>
        <p>get cookie : ${cookie["cookie-key"]} </p>
    </body>
</html>
