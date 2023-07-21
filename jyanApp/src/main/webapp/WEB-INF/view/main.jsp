<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Jyan" %>
<%
Jyan jyan = (Jyan)session.getAttribute("jyan");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Main" method="post">
<label><input type="radio" name="hand" value="グー">グー</label>
<label><input type="radio" name="hand" value="チョキ">チョキ</label>
<label><input type="radio" name="hand" value="パー">パー</label>
<input type="submit" value="送信">
</form>
<%if(jyan != null){ %>
<p>あなたは<%=jyan.getUserHand() %></p>
<p>PCは<%=jyan.getPcHand() %></p>
<p>あなたは<%=jyan.getResult() %></p>
<p><%=jyan.getWin() %>勝<%=jyan.getLose() %>敗</p>
<%} %>
</body>
</html>