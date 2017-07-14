<%--
  Created by IntelliJ IDEA.
  User: jaliya
  Date: 7/14/17
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>

<h2> Free items are </h2>

<table border="2">
  <tr>
    <th>Item</th>
    <th>Item Type</th>
    <th>Index Number</th>

  </tr>

  <c:forEach items="${accountListFree}" var="item1">
    <tr>
      <td>${item1.itemNumber}</td>
      <td>${item1.itemName}</td>
      <td>${item1.itemType}</td>

    </tr>

  </c:forEach>

</table>

<form method="post">

  <td><input type="button" name="home" value="Back"  onclick="location.href='index.jsp'">
</form>

</body>
</html>
