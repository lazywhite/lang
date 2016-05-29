ajp: apache jserv protocol
jre: java runtime environment
jdk: java development kit
jndi: java namespace and directory interface
jdbc: java database connectivity
jpa: java persistence api
jmx: java management extensions
javabean: special class in java, serial multiple class into one "Bean" 
apr: apache portable runtime(support for openssl, epoll, sendfile)


## Tomcat server architecture
Server
    Listener(security, apr, memory leak prevent)
    GlobalNamingResources
    Service(name)
        Connector(port, protocol)
        Engine(name, defaultHost)
            Realm
            Host(name, appBase)
                Valve(logging config)

## Server startup
https://tomcat.apache.org/tomcat-8.0-doc/architecture/startup/serverStartup.pdf

## Request process flow

## Log files
error_log
access_log

## components of tomcat
catalina: tomcat servlet container
coyote: http connector
jasper: jsp engine


## jsp processing
1. web server forward http request to jsp engine
2. jsp engine load jsp files and convert to servlet content
3. jsp engine compile servlet into class and forward original request 
    to servlet engine
4. a part of web server call the servlet engine loads servlet class and 
    execute it, get html output
5. web server response html content

jsp engine compare the mtime of jsp and servlet to decide whether to recompile 

## jsp life cycle
A JSP life cycle can be defined as the entire process from its creation till the destruction which is similar to a servlet life cycle with an additional step which is required to compile a JSP into servlet.

jspInit()
_jspService(HttpServletRequest request,
            HttpServletResponse response)
jspDestroy()

# Language 

## scriptlet
<% code fragment %> or <jsp:scriptlet> code fragment </jsp:scriptlet>
any text, HTML tags, JSP elements must be outside the scriptlet
## declarations
<%! declaration; [declaration;] ... %>
<jsp:declaration> code fragment </jsp:declaration>

## expression
<%= expression %>
<jsp:expression> expression </jsp:expression>

## comments
<%-- comment --%> (jsp comment, ignored by the jsp engine)
<!-- comment --> (html comment, ignored by browser)
<\% (represent static <% literal)
%\> (represent static %> literal)

## directive
<%@ page %> (define page-dependent attributes)
<%@ include ... %> (include a file during the translate phase)
<%@ taglib ... %> (declare a tag library, containing custom actions)

## actions
There are two attributes that are common to all Action elements: the id attribute and the scope attribute.
<jsp: action_name  attribute="value" />
<jsp:useBean id="name" class="package.class" />
<jsp:useBean id="myName" ... >
...
   <jsp:setProperty name="myName" property="someProperty" .../>
</jsp:useBean>

## implicit objects
request
response
out
session
application
config
pageContext
page
Exception
