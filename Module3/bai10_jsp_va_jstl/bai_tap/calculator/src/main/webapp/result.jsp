<%--
  Created by IntelliJ IDEA.
  User: Jacky Ryuk
  Date: 10/31/2021
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h2>
    Result:
</h2>
<p>
    <c:out value="${firstOperand}"/>
    <lable><c:out value="${operator}"/></lable>
    <lable><c:out value="${secondOperand}"/></lable>
    =
    <lable><c:out value="${result}"/></lable>
</p>
<form action="index.jsp">
    <button type="submit">Home</button>
</form>
</body>
</html>
