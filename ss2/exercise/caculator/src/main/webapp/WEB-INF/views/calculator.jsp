<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 1/31/2023
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>calculator</title>

</head>
<body>

    <form  action="/calculate" >
        <div ><h1>Calculator</h1></div>
        <input  type="text"  value="${num1}"  name="num1" >
        <input  type="text"  value="${num2}"  name="num2" >
        <input  type="text"  value="${result}"  name="result" readonly>

        <input type="submit" name="operator" value="Addition(+)">
        <input type="submit" name="operator" value="Subtraction(-)">
        <input type="submit" name="operator" value="Multiplication(*)">
        <input type="submit" name="operator" value="Division(/)">

    </form>

</body>
</html>
