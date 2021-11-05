<%--
  Created by IntelliJ IDEA.
  User: Jacky Ryuk
  Date: 11/2/2021
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<h2>Update product</h2>
<form action="/product?actionUser=update" method="post">
    <input type="text" name="id" value="${productUpdate.id}" style="display: none">
    <h3>
        Name of product:
        <lable>
            <input type="text" name="name" value="${productUpdate.name}">
        </lable>
    </h3>
    <h3>
        Price:
        <lable>
            <input type="text" name="price" value="${productUpdate.price}">
        </lable>
    </h3>
    <h3>
        Product Description:
        <lable>
            <input type="text" name="productDescription" value="${productUpdate.productDescription}">
        </lable>
    </h3>
    <h3>
        Manufacturer:
        <lable>
            <input type="text" name="manufacturer" value="${productUpdate.manufacturer}">
        </lable>
    </h3>
    <input type="submit" value="submit">
</form>
<a href="/">Home</a>
</body>
</html>