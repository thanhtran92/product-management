<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        <c:choose>
            <c:when test="${product == null}">
                <c:set var="formAction" value="add-product"/>
            </c:when>
            <c:otherwise>
                <c:set var="formAction" value="edit-product"/>
            </c:otherwise>
        </c:choose>

        <form action="${formAction}" method="post">
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
            </div>
        </form>

        <br>
        <form action="delete-product" method="post">
            <input type="hidden" name="id" value="${product.id}" />
            <input type="submit" value="Delete" />
        </form>
    </div>
    <br><br>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>