<%--
  Created by IntelliJ IDEA.
  User: Jacky Ryuk
  Date: 11/2/2021
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>product</title>
</head>
<body>
<h2>Show product details</h2>
<h3>ID:</h3>
<span>
        <c:out value="${productShowDetails.id}"/>
    </span>
<h3>Name:</h3>
<span>
        <c:out value="${productShowDetails.name}"/>
    </span>
<h3>price:</h3>
<span>
        <c:out value="${productShowDetails.price}"/>
    </span>
<h3>Product Description:</h3>
<span>
        <c:out value="${productShowDetails.productDescription}"/>
    </span>
<h3>manufacturer:</h3>
<span>
        <c:out value="${productShowDetails.manufacturer}"/>
    </span>
<a href="/">Home</a>
</body>
</html>
