<%--
  Created by IntelliJ IDEA.
  User: Jacky Ryuk
  Date: 11/2/2021
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>product</title>
</head>
<body>
<h2>list product</h2>
<h3>Enter index:</h3>
<form action="/product">
  <input type="text" name="indexShow">
  <lable>
    <input type="submit">
  </lable>
</form>
<table>
  <tr>
    <th>ID</th>
    <th>Name</th>
  </tr>
  <c:forEach var="product" items="${productListServlet}" varStatus="loop">
    <tr>
      <td><c:out value="${loop.index +1}"/></td>
      <td><c:out value="${product.name}"/></td>
    </tr>
  </c:forEach>
</table>
<a href="/">Home</a>
</body>
</html>
