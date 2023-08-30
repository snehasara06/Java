<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html>
        <head>
            <title>CARS</title>
        </head>
        <body>
            <center><h1>Cars</h1>
                <h2><a href="/new">Add New Book</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="/list">List All Books</a>
                </h2>
            </center>
            <div align="center">
                <c:if test="${car != null}">
                    <form action="update" method="post">
                </c:if>
                <c:if test="${car == null}">
                    <form action="insert" method="post">
                </c:if>
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            <c:if test="${car != null}">
                                Edit
                            </c:if>
                            <c:if test="${car == null}">
                                Add New
                            </c:if>
                        </h2>
                    </caption>
                    <c:if test="${car != null}">
                        <input type="hidden" name="id" value="${car.id}" />
                    </c:if>
                    <tr>
                        <th>Name: </th>
                        <td>
                            <input type="text" name="name" size="45" value="${car.name} "/>
                        </td>
                    </tr>
                    <tr>
                        <th>Type: </th>
                        <td>
                            <input type="text" name="type" size="45" value="${car.type}" />
                        </td>
                    </tr>
                    <tr>
                        <th>Fuel: </th>
                        <td>
                            <input type="text" name="fuel" size="45" value="${car.fuel}" />
                        </td>
                    </tr>
                    <tr>
                        <th>Price: </th>
                        <td>
                            <input type="text" name="price" size="45" value="${car.price}" />
                        </td>
                    </tr>
                    <tr>
                        <th>Seater: </th>
                        <td>
                            <input type="text" name="seater" size="45" value="${car.seater}" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Save" />
                        </td>
                    </tr>
                </table>
                </form>
            </div>
        </body>

        </html>