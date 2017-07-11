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
        <c:if test="${product == null}">
            <form action="/product-management/add-product.do" method="post">
        </c:if>
        <c:if test="${product != null}">
            <form action="/product-management/edit-product.do" method="post">
        </c:if>

        <input type="hidden" name="id" value="<c:out value='${product.id}' />" />

        <label>Name:</label>
        <input type="text" name="name" value="<c:out value='${product.name}' />">

        <label>Price:</label>
        <input type="text" name="price" value="<c:out value='${product.price}' />">

        <label>Category:</label>
        <select name="category">
            <option value="Category 1">Category 1</option>
            <option value="Category 2">Category 2</option>
            <option value="Category 3">Category 3</option>
        </select>

        <label>Description:</label>
        <input type="text" name="description" value="<c:out value='${product.description}' />">

        <input type="submit" value="Save"></input>
        </form>
    </div>
    <h2 align="center">
        <a href="/product-management/add-product.do">Add new product</a>
        <a href="/product-management/list-product.do">List all products</a>
    </h2>
</body>
</html>