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
                   href="/users?action=users">List All Users</a>
            </button>
        </div>
        <div class="col-xl-3"></div>
    </div>
    <div class="row">
        <div class="col-xl-3"></div>
        <div class="col-xl-6">
            <h3 class="text-center">Add New User</h3>
        </div>
        <div class="col-xl-3"></div>
    </div>
    <div class="row">
        <div class="col-xl-2"></div>
        <div class="col-xl-8">
            <form action="/users?action=edit" method="post">
                <!-- Text input -->
                <input style="display: block;" type="hidden" name="id" value="<c:out value='${user.id}' />"/>
                <div class="form-group">
                    <label for="inputNameEmployee">User Name:</label>
                    <input value="${user.name}" type="text" class="form-control" id="inputNameEmployee" name="name">
                </div>
                <!-- Text input -->
                <div class="form-group">
                    <label for="form6Example4">Country:</label>
                    <input value="${user.country}" type="text" class="form-control" id="form6Example4" name="country">
                </div>
                <!-- Email input -->
                <div class="form-group">
                    <label for="form6Example5">Email address:</label>
                    <input value="${user.email}" type="email" class="form-control" id="form6Example5"
                           aria-describedby="emailHelpEmployee" name="email">
                    <small id="form6Example" class="form-text text-muted">We'll never share your email with anyone
                        else.</small>
                </div>

                <!-- Checkbox -->
                <div class="form-check d-flex justify-content-center mb-4">
                    <input
                            class="form-check-input me-2"
                            type="checkbox"
                            value=""
                            id="form6Example8"
                            checked
                    />
                    <label class="form-check-label" for="form6Example8"> Add new user? </label>
                </div>

                <!-- Submit button -->
                <button type="submit" class="btn btn-primary btn-block mb-4">Submit</button>
            </form>
        </div>
    </div>
</div>
<!--js-->
<script src="js/jquery-3.6.0.min.js "></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/mdb.min.js"></script>
<!--js-->

</body>
</html>