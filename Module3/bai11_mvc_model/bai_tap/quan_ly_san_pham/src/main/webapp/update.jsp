<%--
  Created by IntelliJ IDEA.
  User: Jacky Ryuk
  Date: 11/2/2021
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
  <title>Product</title>
</head>
<body>
<h2>Update</h2>
<form action="/product">
  <input type="text" name="index">
  <lable>
    <input type="submit" value="submit">
  </lable>
</form>
<div id="table">
  <table border="1px">
    <tr>
      <th>Index</th>
      <th>ID</th>
      <th>Name</th>
      <th>Price</th>
      <th>Product description</th>
      <th>Manufacturer</th>
    </tr>
    <c:forEach var="product" items="${productListServlet}" varStatus="loop">
      <tr>
        <td><c:out value="${loop.index + 1}"/></td>
        <td><c:out value="${product.id}"/></td>
        <td><c:out value="${product.name}"/></td>
        <td><c:out value="${product.price}"/></td>
        <td><c:out value="${product.productDescription}"/></td>
        <td><c:out value="${product.manufacturer}"/></td>
      </tr>
    </c:forEach>
  </table>
</div>
<a href="/">Home</a>
</body>
</html>
