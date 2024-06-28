<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Product</title>
</head>
<body>
    <h1>Update Product</h1>
    <form action="/admin/productUpdate" method="post">
        <label for="productNo">Product No:</label>
        <select id="productNo" name="no">
            <option value="1" name = "1" id = "1">Product 1</option>
            <option value="2" name = "2" id = "1">Product 2</option>
        </select>
        <br><br>
        <label for="categoryNo">Category No:</label>
        <input type="text" id="categoryNo" name="categoryNo">
        <br><br>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name">
        <br><br>
        <label for="price">Price:</label>
        <input type="text" id="price" name="price">
        <br><br>
        <label for="prodExplain">Description:</label>
        <input type="text" id="prodExplain" name="prodExplain">
        <br><br>
        <label for="stock">Stock:</label>
        <input type="text" id="stock" name="stock">
        <br><br>
        <button type="submit">Update</button>
        <button type="button" onclick="deleteProduct()">Delete</button>

    </form>
</body>
<script>
        function deleteProduct() {
            const productNo = document.getElementById("productNo").value;
            if (confirm(`Are you sure you want to delete product ${productNo}?`)) {
                fetch(`/admin/productDelete?no=${productNo}`, {
                    method: 'DELETE'
                }).then(response => {
                    if (response.ok) {
                        alert('Product deleted successfully');
                        window.location.reload();
                    } else {
                        alert('Failed to delete product');
                    }
                });
            }
        }
    </script>
</html>
