<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Janken" %>
<%
Janken jan = (Janken)session.getAttribute("janken");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="MainJanken" method="post">
<input type="radio" name="hand" value="グー">グー
<input type="radio" name="hand" value="チョキ">チョキ
<input type="radio" name="hand" value="パー">パー<br>
<input type="submit" value="送信">
</form>
<%if(jan != null){%>
<p><%=jan.getResult() %></p>
<%} %>
</body>
</html>