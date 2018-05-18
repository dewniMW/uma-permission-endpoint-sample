<%@ page import="uma.permission.endpoint.sample.model.RequestPermission" %>
<%@ page import="uma.permission.endpoint.sample.model.PermissionTicketResponse" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: isuri
  Date: 5/3/18
  Time: 8:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Request Permission</title>
</head>
<body>
<h1>----- Request Permission -----</h1>
<br>
<form id="form-requestPermission" action="/permission" method="post">
    <table>
        <tr>
            <td>Add resource id :</td>
            <td> <input type="text" name="resource_id" id="resource_id"></td>
        </tr>
        <tr>
            <td>Add resource scopes :</td>
            <td> <input type="text" name="resource_scopes" id="resource_scopes"></td>
        </tr>
        <tr>
            <td><%--<input type="submit" value="Add more permissions" name="add_permission">--%></td>
            <td><input type="submit" value="Send request" name="send_request"></td>
        </tr>
    </table>
</form>


<%
    if (request.getAttribute("permissionRequest") != null) {
        PermissionTicketResponse permissionTicketResponse = (PermissionTicketResponse) request.getAttribute("permissionRequest");

%>
<h3>Permission Endpoint response</h3>
<div>Permission ticket: <%= permissionTicketResponse.getTicket()%></div>

<% } %>


<a href="AdminHomePage.jsp"><input type="submit" value="Back" name=BackButton></a>
</body>
</html>
