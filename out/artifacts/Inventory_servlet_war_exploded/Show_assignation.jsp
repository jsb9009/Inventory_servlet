<%--
  Created by IntelliJ IDEA.
  User: jaliya
  Date: 7/12/17
  Time: 11:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

  <table border="3">
    <tr>
      <td>Item</td>
      <td>Item Type</td>
      <td>Employee</td>

</tr>
<%
  try
  {
    Class.forName("com.mysql.jdbc.Driver");
    String url="jdbc:mysql://localhost:3306/inventory_servlet";
    String username="root";
    String password="";
    String query="select item_no,item_type,employee_no from items,employees where items.assignation=employees.index_no";
    Connection conn=DriverManager.getConnection(url, username, password);
    Statement stmt=conn.createStatement();
    ResultSet rs=stmt.executeQuery(query);

    while(rs.next())
    {
%>

    <tr><td><%out.println(rs.getString(1)); %></td><td><%out.println(rs.getString(2)); %></td><td><%out.println(rs.getString(3)); %></td></tr>

<%
  }
%>
</table>
<%
    rs.close();
    stmt.close();
    conn.close();
  }
  catch(Exception e)
  {
    e.printStackTrace();
  }
%>

  <td><input type="button" name="home" value="Back"  onclick="location.href='index.jsp'">
</form>


</body>
</html>
