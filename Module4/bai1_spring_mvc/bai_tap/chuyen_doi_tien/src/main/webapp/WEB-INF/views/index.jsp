<%--
  Created by IntelliJ IDEA.
  User: Jacky Ryuk
  Date: 11/28/2021
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Chuyen doi tien te</title>
  </head>
  <body>
  <form action="/convert" method="get">
    <label for="input">Nhap so tien:</label>
    <input type="number" id="input" name="money"><br><br>
    <input type="submit" value="Chuyen doi">
  </form>
  <label>Ket qua: ${result}</label>
  </body>
</html>
