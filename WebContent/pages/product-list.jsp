<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.thanh.listener.SessionListener"%>
<!DOCTYPE html>
<html>
<head>
<title>Product Management</title>
</head>
<body>
    <h1 align="center">Product Management</h1>
    <div align="center">
        <form action="search-product">
            Name: <input type="text" name="name">
            Category: <select name="category">
                <option disabled selected> -- select a category -- </option>
                <option value="Category 1">Category 1</option>
                <option value="Category 2">Category 2</option>
                <option value="Category 3">Category 3</option>
                <option value="Category 4">Category 4</option>
            </select>
            Price from: <input type="number" name="minPrice"> to <input type="number" name="maxPrice">
            <input type="submit" value="Search">
        </form>
    </div>
    <br><br><br><br><br>
    <div align="center">
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Category</th>
                <th>Description</th>
            </tr>
            <c:forEach var="product" items="${productList}">
                <tr>
                    <td>${product.id}</td>
                    <td><a href="edit-product?id=${product.id}">${product.name}</a></td>
                    <td>${product.price}</td>
                    <td>${product.category}</td>
                    <td>${product.description}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <br><br>
    <div align="center">
        <form action="add-product">
            <input type="submit" value="Add New" />
        </form>
        <br><br>
        <p>Active sessions: <b><%= SessionListener.getActiveSessions() %></b></p>
    </div>
</body>
</html>