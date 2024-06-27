<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Login</title>
</head>
<body>
    <form action="/admin/productInsert" method="post">

        <div>


<!--          <label for="prodCategoryNo">카테고리 번호 : </label>
            <select id = "prodCategoryNo" name = "categoryNo" required>
            <c:forEach items="${prodCategories}" var="prodCategory">
           <option value="${prodCategory.no}">${prodCategory.name}</option>
            </c:forEach>
            </select>
-->

            <label for="prodCategoryNo">카테고리 번호 : </label>
            <select id = "prodCategoryNo" name = "categoryNo" required>
           <option value="1">카테고리1</option>
           <option value="2">카테고리2</option>
           <option value="3">카테고리3</option>

            </select>


        </div>

        <div>
            <label for="name">상품이름 : </label>
            <input type="text" id="name" name="name">
        </div>

        <div>
            <label for="price">가격 : </label>
            <input type="text" id="price" name="price">
        </div>

        <div>
            <label for="prodExplain">상품설명 : </label>
            <input type="text" id="prodExplain" name="prodExplain">
        </div>

        <div>
            <label for="stock">재고 : </label>
            <input type="text" id="stock" name="stock">
        </div>

        <div>
            <label for="photo">상품 사진 : </label>
            <input type="file" id="photo" name="photo">
        </div>

        <div>
          <button type="submit">제출</button>
        </div>

    </form>
</body>
</html>
