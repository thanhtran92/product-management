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
            <form action="add-product.do" method="post">
        </c:if>
        <c:if test="${product != null}">
            <form action="edit-product.do" method="post">
        </c:if>

        <input type="hidden" name="id" value="${product.id}" />

        <label>Name:</label>
        <input type="text" name="name" value="${product.name}" />

        <label>Price:</label>
        <input type="text" name="price" value="${product.price}" />

        <jsp:useBean id="categories" class="java.util.ArrayList"> 
            <%
            categories.add("Category 1");
            categories.add("Category 2");
            categories.add("Category 3");
            categories.add("Category 4");
            %>
        </jsp:useBean>

        <label>Category:</label>
        <select name="category">
            <c:forEach var="item" items="${categories}">
                <option value="${item}" ${item == product.category ? 'selected="selected"' : ''}>${item}</option>
            </c:forEach>
        </select>

        <label>Description:</label>
        <input type="text" name="description" value="${product.description}" />

        <br><br>
        <div align="center">
            <input type="submit" value="Update / Add New" />
            <a href="delete-product.do?id=${product.id}">Delete</a>
            <br><br>
            <a href="logout.do">Logout</a>
        </div>
        </form>
    </div>
</body>
</html>