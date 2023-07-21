<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
User user = (User)session.getAttribute("LoginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
<h1>ログイン</h1>
<%if(user != null){ %>
<p>ログイン成功しました</p>
<p>ようこそ<%=user.getName() %>さん</p>
<a href="Main">投稿・閲覧へ</a>
<%}else{ %>
<p>ログイン失敗</p>
<a href="index.jsp">TOPへ</a>
<%} %>
</body>
</html>