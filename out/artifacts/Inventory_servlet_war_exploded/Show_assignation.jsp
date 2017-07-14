<%--
  Created by IntelliJ IDEA.
  User: jaliya
  Date: 7/12/17
  Time: 11:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.DriverManager" %>


<form method="post">

  <td><input type="button" name="home" value="Back"  onclick="location.href='index.jsp'">
</form>

<table border="3">
  <tr>
    <td>Item</td>
    <td>Item Type</td>
    <td>Employee</td>

  </tr>

  <c:forEach items="${accountList}" var="item">
    <tr>
      <td>${item.itemNumber}</td>
      <td>${item.itemName}</td>
      <td>${item.itemType}</td>
    </tr>

  </c:forEach>

</table>


</body>
</html>


