<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>A0421I1- Le Tran Son</title>
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css" />
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css" />
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/mdb.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css"
          integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">
</head>
<body>
<!--Main Layout-->
<div class="container-fluid">
    <div class="row m-3">
        <div class="col-lg-12 text-center">
            <h3>Display</h3>
        </div>
    </div>
    <div class="row m-3">
        <div class="text-primary col-lg-12 text-center">
            <h5>${msg}</h5>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <table id="tableCus" class="table table-striped table-bordered" style="width: 100%">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">Index</th>
                    <th scope="col">Product Name</th>
                    <th scope="col">Price</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Color</th>
                    <th scope="col">Catagory</th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="product" items="${}" varStatus="loop">
                    <tr>
                        <td scope="row"><c:out value="${loop.index}"/></td>
                        <td><c:out value="${product.name}"/></td>
                        <td><c:out value="${product.price}"/></td>
                        <td><c:out value="${product.Quantity}"/></td>
                        <td><c:out value="${product.Color}"/></td>
                        <td><c:out value="${product.Catagory}"/></td>
                        <td>
                            <a href="/customer?actionUser=edit&idCus=${product.id}">
                                <button type="submit" class="btn btn-outline-primary">Edit</button>
                            </a>
                        </td>
                        <td>
                            <a href="/customer?actionUser=delete&idCus=${product.id}">
                                <button type="submit" class="btn btn-outline-primary">Delete</button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>


<!--js-->
<script src="js/jquery-3.6.0.min.js "></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/mdb.min.js"></script>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function() {
        $('#tableCus').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        } );
    } );
</script>
<!--js-->
</body>
</html>
