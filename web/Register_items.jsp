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
    <h1> Register the items here </h1>

    <form name="registeritemform" action="RegItem" method="POST">
        <table border="0">
            <tbody>
            <tr>
                <td>Item Number</td>
                <td><input type="text" name="itemnumber" value="" required/></td>
            </tr>
            <tr>
                <td>Item Name</td>
                <td><input type="text" name="itemname" value="" required/></td>
            </tr>
            <tr>
                <td>Item Type</td>
                <td><input type="text" name="itemtype" value="" required/></td>
            </tr>
            <tr></tr>
            <tr></tr>

            <tr>
                <td><input type="button" name="home" style=" float: left" value="Back" onclick="location.href='index.jsp'"></td>
                <td><input type="submit" style=" float: right" value="Save" name="submit"/>
                    <input type="reset" style=" float: right" value="Clear" name="reset"/></td>

            </tr>
            </tbody>
        </table>

    </form>
</div>


</body>
</html>
