<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*;"%>
<%
//変数は同じページ内で使用可能
String name = "湊　雄介";
int age = 20;
//この中はjavaなので//コメントかける
%>
<%
int x = 10;
int y = 20;
%>
<%--JSPコメントはブラウザに残らない HTML出力が得意、、javaを入れ込む--%>
<!-- HTMLコメント ブラウザに残る -->
<%
int z = x + y;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--<%=  %>はSystem.out.print()の()のなかと同じ機能--%>
<p>私の名前は<%= name %>。年齢は<%= age %>です。</p>
<p><%= z %></p>
<%for(int i=0; i<5; i++){%>
<p><%= i %></p>
<%} %>
<table border= "1">
<% for(int i= 1; i<= 9; i++){ %>
<tr>
	<%for(int j= 1; j<= 9; j++){ %>
		<td><%= i*j %></td>
	<%} %>
</tr>	
<%} %>
</table>
</body>
</html>