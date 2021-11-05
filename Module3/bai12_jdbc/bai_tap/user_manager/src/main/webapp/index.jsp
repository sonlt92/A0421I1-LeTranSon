<%--
  Created by IntelliJ IDEA.
  User: Jacky Ryuk
  Date: 11/3/2021
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>User Management Application</title>
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/mdb.min.css">
  <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container-fluid">
  <div class="row">
    <div class="col-xl-3"></div>
    <div class="col-xl-6">
      <h1 class="text-center">User Management</h1>
    </div>
    <div class="col-xl-3"></div>
  </div>
  <div class="row">
    <div class="col-xl-3"></div>
    <div class="col-xl-6 text-center">
      <button type="button"
              class="btn btn-outline-primary btn-rounded"
              data-mdb-ripple-color="dark">
        <a class="nav-link active"
           href="/users?action=create">Add New User</a>
      </button>
    </div>
    <div class="col-xl-3"></div>
  </div>
  <div class="row">
    <div class="col-xl-2">
      <br>
    </div>
  </div>
  <div class="row">
    <div class="col-xl-3"></div>
    <div class="col-xl-6 text-center">
      <button type="button"
              class="btn btn-outline-primary btn-rounded"
              data-mdb-ripple-color="dark">
        <a class="nav-link active"
           href="/users?action=user">List All Users</a>
      </button>
    </div>
    <div class="col-xl-3"></div>
  </div>
  <div class="row">
    <div class="col-xl-2">
      <br>
    </div>
  </div>
  <div class="row">
    <div class="col-xl-3"></div>
    <div class="col-xl-6">
      <form action="/users?action=search" method="post" class="text-center">
        <input name="countrySearch" class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <br>
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
    <div class="col-xl-3"></div>
  </div>
</div>
<!--js-->
<script src="js/jquery-3.6.0.min.js "></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/mdb.min.js"></script>
<!--js-->

</body>
</html>