<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
</head>
<body>
    <h1>Product List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>No</th>
                <th>Category No</th>
                <th>Name</th>
                <th>Price</th>
                <th>Description</th>
                <th>Stock</th>
                <th>Create Date</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${product}" var="product">
                <tr>
                    <td>${product.no}</td>
                    <td>${product.categoryNo}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.prodExplain}</td>
                    <td>${product.stock}</td>
                    <td>${product.createDate}</td>
                    <td>
                        <!-- Replace JavaScript function with a direct link -->
                        <a href="productUpdate?no=${product.no}">Edit</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
