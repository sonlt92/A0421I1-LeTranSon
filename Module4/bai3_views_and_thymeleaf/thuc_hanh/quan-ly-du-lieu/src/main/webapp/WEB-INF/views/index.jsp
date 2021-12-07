<%--
  Created by IntelliJ IDEA.
  User: Jacky Ryuk
  Date: 11/28/2021
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Sandwich Condiments</title>
<%--  <style type="text/css">--%>
<%--    select {--%>
<%--      width: 200px;--%>
<%--      height: 20px;--%>
<%--    }--%>
<%--  </style>--%>
</head>
<body>
<h2>Sandwich Condiments</h2>
<form action="/save" method="post">
  <input type="checkbox" id="condiments1" name="condiments" value="Lettuce"><label for="condiments1">Lettuce</label><br>
  <input type="checkbox" id="condiments2" name="condiments" value="Tomato"><label for="condiments2">Tomato</label><br>
  <input type="checkbox" id="condiments3" name="condiments" value="Mustard"><label for="condiments3">Mustard</label><br>
  <input type="checkbox" id="condiments4" name="condiments" value="Sprouts"><label for="condiments4">Sprouts</label><br>
  <input type="submit" value="Submit">
</form>
<label>List spices chose: <span style="color: brown">
  <c:if test = "${listCondiment.isEmpty()}">
    <c:out value="Ban can chon 1 gia vi"/>
  </c:if>
  ${listCondiment}
</span> </label>
<label><c:out value="${messenger}"/></label>
</body>
</html>
