<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>CARS</title>
</head>
<body>
    <center>
        <h1>Cars</h1>
        <h2>
            <a href="/new">Add New </a>
            &nbsp;&nbsp;&nbsp;
            <!-- <a href="/list">List All Cars</a> -->
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Cars</h2></caption>
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>TYPE</th>
                <th>FUEL</th>
                <th>PRICE</th>
                <th>SEATER</th>
                <th>ACTIONS</th>
            </tr>
            <c:forEach var="car" items="${listCars}">
                <tr>
                    <td><c:out value="${car.id}" /></td>
                    <td><c:out value="${car.name}" /></td>
                    <td><c:out value="${car.type}" /></td>
                    <td><c:out value="${car.fuel}" /></td>
                    <td><c:out value="${car.price}" /></td>
                    <td><c:out value="${car.seater}" /></td>

                    <td>
                        <a href="/edit?id=${car.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=${car.id}">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>