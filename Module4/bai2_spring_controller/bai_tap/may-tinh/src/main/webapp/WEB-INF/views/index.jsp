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
  <title>Calculator</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<h2>My Calculator</h2>
<form id="locale" action="/calculator" method="get">
  <input type="number" name="number1" placeholder="Number 1">
  <input type="number" name="number2" placeholder="Number 2"><br><br>
  <button type="submit" name="operator" value="+" class="btn btn-primary">Addition +</button>
  <button type="submit" name="operator" value="-" class="btn btn-primary">Subtraction -</button>
  <button type="submit" name="operator" value="*" class="btn btn-primary">Multiplication *</button>
  <button type="submit" name="operator" value="/" class="btn btn-primary">Division /</button>
</form>
<span>KQ: ${kq}</span><br><br>
<c:if test="${msg!=null}">
  <span style="color: red">Warning: ${msg}</span>
</c:if>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
