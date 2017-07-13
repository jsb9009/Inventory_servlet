<%@ page import="java.sql.Connection" %>
<%@ page import="sample.DBConnector" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="javax.swing.*" %>
<%--
  Created by IntelliJ IDEA.
  User: jaliya
  Date: 7/12/17
  Time: 11:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Assign_items</title>
</head>
<body>

<div>
  <h1> Assign the items here </h1>
  <form name="assignitemform" action="Assign_items.jsp" method="POST">
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
      <%

        if(request.getParameter("registeritemform")!=null) {


          String employeeNumber = request.getParameter("employeenumber");
          String itemNumber = request.getParameter("itemnumber");


          Connection con = new DBConnector().getConnection();
          try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("update items set assignation=(select index_no from employees where employee_no='" + employeeNumber + "') where item_no='" + itemNumber + "'");
            JOptionPane.showMessageDialog(null, "Item successfully assigned");
            stmt.close();
            con.close();

          } catch (Exception e) {

            throw new ServletException("Error in assignation", e);

          }
        }
      %>

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
