<%--
  Created by IntelliJ IDEA.
  User: Jacky Ryuk
  Date: 10/29/2021
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product Discount Calculator</title>
  </head>
  <body>
  <form action="/discount" method="post">
    <p>
      Product Description :
      <label>
        <input type="text" name="productDescription">
      </label>
    </p>
    <p>
      List Price:
      <label>
        <input type="text" name="listPrice">
      </label>
    </p>
    <p>
      Discount Percent:
      <label>
        <input type="text" name="discountPercent">
      </label>
    </p>
    <input type="submit" value="discount">
  </form>

  <h2>
    Discount Amount:
    <%=request.getAttribute("discountAmount")%>
  </h2>
  <h2>
    Discount Price:
    <%=request.getAttribute("discountPrice")%>
  </h2>
  </body>
</html>
