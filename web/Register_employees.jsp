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
  <title>Register_employees</title>
</head>
<body>

<div>
  <h1> Register the employees here </h1>
  <form name="registeremployeeform" action="Register_employees.jsp" method="POST">
    <table border="0">
      <tbody>
      <tr>
        <td>Employee Number</td>
        <td><input type="text" name="employeenumber" value="" required/></td>
      </tr>
      <tr>
        <td>Employee Name</td>
        <td><input type="text" name="employeename" value="" required/></td>
      </tr>
      <tr>
        <td>Position</td>
        <td><input type="text" name="position" value="" required/></td>
      </tr>

      <%

          if(request.getParameter("registeritemform")!=null) {
              String employeeNumber = request.getParameter("employeenumber");
              String employeeName = request.getParameter("employeename");
              String position = request.getParameter("position");

              Connection con = new DBConnector().getConnection();
              try {
                  Statement stmt = con.createStatement();
                  stmt.executeUpdate("INSERT INTO employees(employee_no,employee_name,position) VALUES ('" + employeeNumber + "','" + employeeName + "','" + position + "')");
                  JOptionPane.showMessageDialog(null, "Employee successfully registered");
                  stmt.close();
                  con.close();

              } catch (Exception e) {

                  throw new ServletException("Error in registration", e);

              }
          }
      %>
      <td></td>
      <td></td>
      </tr>
      <tr>
        <td align="right"><input type="reset" value="Clear" name="reset" /></td>
        <td><input type="submit" value="Save" name="submit" /></td>
          <td><input type="button" name="home" value="Back"  onclick="location.href='index.jsp'">
      </tr>
      </tbody>
    </table>

  </form>
</div>


</body>
</html>