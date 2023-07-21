<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User, model.Movie, java.util.List"  %>
<%
User loginUser = (User)session.getAttribute("LoginUser");

List<Movie> movie = (List<Movie>)application.getAttribute("movieComment");

String errorMsg =(String)request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movie Main</title>
</head>
<body>
<p>
<%=loginUser.getName() %>さん、ログイン中
	<a href="Logout">ログアウト</a>
</p>
<p><a href="Main">更新</a></p>
<form action="Main" method="post">
名前：<input type="text" name="userName"><br>
タイトル：<input type="text" name="title"><br>
コメント：<textarea name="comment"></textarea><br>
<input type="submit" value="コメントする">
</form>
<%if(errorMsg != null){ %>
<p><%=errorMsg %></p>
<%} %>
<table border="1">
<tr>
<th>名前</th><th>タイトル</th><th>コメント</th>
</tr>
<%for(Movie m : movie){ %>
<tr>
<td><%=m.getUserName() %></td><td><%=m.getTitle() %></td><td><%=m.getComment() %></td>
</tr>

<%} %>
</table>
</body>

</html>