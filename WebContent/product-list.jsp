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
    <jsp:include page="header.jsp"></jsp:include>
    <jsp:include page="menu.jsp"></jsp:include>
    <br><br>
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
                    <c:choose>
                        <c:when test="${username == null}">
                            <td>${product.name}</td>
                        </c:when>
                        <c:otherwise>
                            <td><a href="edit-product?id=${product.id}">${product.name}</a></td>
                        </c:otherwise>
                    </c:choose>
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
            <c:choose>
                <c:when test="${username == null}">
                    <input type="submit" value="Add New" disabled/>
                </c:when>
                <c:otherwise>
                    <input type="submit" value="Add New" />
                </c:otherwise>
            </c:choose>
        </form>
        <br>
        <p>Active sessions: <b><%= SessionListener.getActiveSessions() %></b></p>
    </div>
    <br><br>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>