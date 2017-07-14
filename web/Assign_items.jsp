
<%--
  Created by IntelliJ IDEA.
  User: jaliya
  Date: 7/12/17
  Time: 11:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%--TODO JSP file names contains lowercase undescore for separte words--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Assign_items</title>
</head>
<body>

<div>
  <h1> Assign the items here </h1>
  <form name="assignitemform" action="AssignItem" method="POST">
    <table border="0">
      <tbody>
      <tr>
        <td>Employee Number</td>
        <td><input type="text" name="employeenumber" value="" required/></td>
      </tr>
      <tr>
        <td>Item Number</td>
        <td><input type="text" name="itemnumber" value="" required/></td>
      </tr>
      <td></td>
      <td></td>
      </tr>

      <tr>
        <td align="right"><input type="reset" value="Clear" name="reset" /></td>
        <td><input type="submit" value="Assign" name="submit" /></td>
        <td><input type="button" name="home" value="Back"  onclick="location.href='index.jsp'">
      </tr>
      </tbody>
    </table>

  </form>
</div>


</body>
</html>
