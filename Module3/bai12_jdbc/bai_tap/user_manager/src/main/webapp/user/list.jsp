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
        <div class="col-xl-3"></div>
        <div class="col-xl-6">
            <h1 class="text-center">List of Users</h1>
        </div>
        <div class="col-xl-3">
            <button type="button"
                    class="btn btn-outline-primary btn-rounded"
                    data-mdb-ripple-color="dark">
                <a class="nav-link active"
                   href="/users?action=sort">Sort name</a>
            </button>
        </div>
    </div>
    <div class="row">
        <div class="col-xl-3"></div>
        <div class="col-xl-6 align-content-xl-center">
            <table class="table table-striped table-hover">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">Index</th>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Country</th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${listUser}" varStatus="loop">
                    <tr>
                        <td scope="row"><c:out value="${loop.index +1}"/></td>
                        <td><c:out value="${user.id}"/></td>
                        <td><c:out value="${user.name}"/></td>
                        <td><c:out value="${user.email}"/></td>
                        <td><c:out value="${user.country}"/></td>
                        <td>
                            <a href="/users?action=edit&id=${user.id}">Edit</a>
                        </td>
                        <td>
                            <a href="/users?action=delete&id=${user.id}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                <c:if test="${action == 'search'}">
                    <c:if test="${size == '0'}">
                        <tr>
                            <td class="text-center" colspan="7"><h3>Not found</h3></td>
                        </tr>
                    </c:if>
                </c:if>
                </tbody>
            </table>
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