<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Product Management</title>
</head>
<body>
    <h1 style="text-align:left; float:left;">Product Management</h1>
    <c:choose>
        <c:when test="${username == null}">
            <p style="text-align:right; float:right;">Hello,</p>
        </c:when>
        <c:otherwise>
            <p style="text-align:right; float:right;">Hello, <b>${username}</b> - <a href="logout">Logout</a></p>
        </c:otherwise>
    </c:choose>
    <hr style="clear:both; border: none;"/>
</body>
</html>