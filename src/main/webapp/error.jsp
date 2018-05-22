<%@ page import="uma.permission.endpoint.sample.client.impl.PermissionClientImpl" %><%--
  Created by IntelliJ IDEA.
  User: dewni
  Date: 5/18/18
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Error</title>
</head>
<body>
    <h1>Error</h1>
    <%--<h2>Internal Server Error</h2>--%>
    <h2>Http status code: <%= PermissionClientImpl.httpStatusCode %></h2>
    <%--<h2><%=exception %><br/> </h2>
    <h2><%=exception.getMessage() %><br/> </h2>--%>
</body>
</html>