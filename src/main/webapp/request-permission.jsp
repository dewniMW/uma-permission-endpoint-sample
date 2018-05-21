<%@ page import="uma.permission.endpoint.sample.model.RequestPermission" %>
<%@ page import="uma.permission.endpoint.sample.model.PermissionTicketResponse" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="uma.permission.endpoint.sample.model.ErrorResponse" %>
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
            <td><input type="submit" value="Add more permissions" name="act"></td>
            <td><input type="submit" value="Send request" name="act"></td>
        </tr>
    </table>
</form>


<%
    if (request.getAttribute("permissionRequest") != null) {
        PermissionTicketResponse permissionTicketResponse = (PermissionTicketResponse) request.getAttribute("permissionRequest");

%>
<h4>Permission ticket created successfully.</h4>
<div>Permission ticket: <%= permissionTicketResponse.getTicket()%></div>

<% } %>
<br>
<%
    if (request.getAttribute("errorMessage") != null) {
        ErrorResponse permissionTicketResponse = (ErrorResponse) request.getAttribute("errorMessage");

%>
<h4>Error in the request.</h4>
<div>error: <%= permissionTicketResponse.getError()%></div>
<div>error_description: <%= permissionTicketResponse.getErrorDescription()%></div>
<% } %>


<a href="AdminHomePage.jsp"><input type="submit" value="Back" name=BackButton></a>
</body>
</html>
