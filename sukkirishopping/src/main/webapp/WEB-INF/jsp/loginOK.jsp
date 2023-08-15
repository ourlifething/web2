<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ商店</title>
</head>
<body>
<c:choose>
	<c:when test="${not empty errorMsg}">
	<p><c:out value="${errorMsg }"/></p>
	</c:when>
<c:otherwise>
<p>ようこそ<c:out value="${userId }"/>さん</p>
</c:otherwise>
</c:choose>
<a href="WelcomeServlet">トップへ</a>
</body>
</html>