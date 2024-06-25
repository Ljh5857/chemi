<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Login</title>
</head>
<body>
    <form action="/admin/login" method="post">
        <div>
            <label for="id">ID: </label>
            <input type="text" id="id" name="id">
        </div>
        <div>
            <label for="password">Password: </label>
            <input type="password" id="password" name="password">
        </div>
        <div>
            <button type="submit">Login</button>
        </div>
    </form>
</body>
</html>
