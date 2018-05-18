<%@ page import="uma.permission.endpoint.sample.model.ErrorResponse" %><%--
  Created by IntelliJ IDEA.
  User: dewni
  Date: 5/18/18
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>--%>

<%--<%@ page isErrorPage="true" %>

<h3>Sorry an exception occured!</h3>

Exception is: <%= exception %>--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Error</title>
</head>
<body>
<center>
    <h1>Error</h1>
    <h2><%=exception %><br/> </h2>
    <h2><%=exception.getMessage() %><br/> </h2>
</center>

<%--<%
    if (request.getAttribute("errorMessage") != null) {
        ErrorResponse errorResponse = (ErrorResponse) request.getAttribute("errorMessage");

%>
<h3>Error response</h3>
<div>Error: <%= errorResponse.getError()%></div>

<% } %>--%>

</body>
</html>