<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Product Management</title>
</head>
<body>
    <h1 align="center">Product Management</h1>
    <h2 align="center">Login</h2>
    <div align="center">
        <form action="login" method="post">
            <p><font color="red">${errorMessage}</font></p>
            User name: <input type="text" name="username">
            Password: <input type="password" name="password">
            <input type="submit" value="Login">
        </form>
    </div>
</body>
</html>