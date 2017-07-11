<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Product Management</title>
</head>
<body>
    <h1 align="center">Product Management</h1>
    <div align="center">
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Category</th>
                <th>Description</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="product" items="${productList}">
                <tr>
                    <td><c:out value="${product.id}" /></td>
                    <td><c:out value="${product.name}" /></td>
                    <td><c:out value="${product.price}" /></td>
                    <td><c:out value="${product.category}" /></td>
                    <td><c:out value="${product.description}" /></td>
                    <td>
                        <a href="/product-management/edit-product.do?id=<c:out value='${product.id}' />">Edit</a>
                        <a href="/product-management/delete-product.do?id=<c:out value='${product.id}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <h2 align="center">
        <a href="/product-management/add-product.do">Add new product</a>
        <a href="/product-management/list-product.do">List all products</a>
    </h2>
</body>
</html>