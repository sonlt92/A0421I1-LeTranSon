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
    <title>Tu dien</title>
  </head>
  <body>
  <form action="/dictionary" method="get">
    <label for="input">Nhap tu can tim:</label>
    <input type="text" id="input" name="word"><br><br>
    <input type="submit" value="Tim kiem">
  </form>
  <h1>Ket qua: ${result}</h1>
  </body>
</html>
