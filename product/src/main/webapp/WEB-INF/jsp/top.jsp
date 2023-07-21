<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>    
<%@ page import="java.util.*" %>
<%
//アプリケーションスコープより”data"をget
List<Product> data = (List<Product>)application.getAttribute("data");
//リクエストスコープから"msg"をget
String msg = (String)request.getAttribute("msg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%if(data.size() > 0){%>
<%if(msg != null){ %>
<p><%=msg %></p>
<%} %>
<p><%=data.size() %>件登録されました</p>
<%} %>
<form action="Register" method="post">
製品名:<input type="text" name="name"><br>
価格:<input type="text" name="price"><br>
<input type="submit" value="登録">
</form>
<%if(data.size() > 0){ %>
<table border="1">
	<tr>
		<th>製品名</th><th>価格</th><th>登録日</th>
	</tr>
	<%for(Product d : data){%>
	<tr>
		<td><%=d.getName()%></td><td><%=d.getPrice()%></td><td><%=d.getDateTime()%></td>
	</tr>
	<%} %>
</table>
<%} %>
</body>
</html>