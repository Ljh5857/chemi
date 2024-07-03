<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Product</title>
</head>
<body>
    <h1>Edit Product</h1>
    <form action="/admin/productUpdate" method="post" onsubmit="return confirm('Are you sure you want to update this product?');">
        <input type="hidden" name="no" value="${product.no}" />
        <div>
            <label>Category No:</label>
            <input type="text" name="categoryNo" value="${product.categoryNo}" />
        </div>
        <div>
            <label>Name:</label>
            <input type="text" name="name" value="${product.name}" />
        </div>
        <div>
            <label>Price:</label>
            <input type="text" name="price" value="${product.price}" />
        </div>
        <div>
            <label>Description:</label>
            <input type="text" name="prodExplain" value="${product.prodExplain}" />
        </div>
        <div>
            <label>Stock:</label>
            <input type="text" name="stock" value="${product.stock}" />
        </div>
        <div>
            <button type="submit">Update</button>
        </div>
    </form>
    <form action="/admin/productDelete" method="post" onsubmit="return confirm('Are you sure you want to delete this product?');">
        <input type="hidden" name="no" value="${product.no}" />
        <button type="submit">Delete</button>
    </form>
    <a href="/admin/productList">Back to Product List</a>
</body>
</html>
