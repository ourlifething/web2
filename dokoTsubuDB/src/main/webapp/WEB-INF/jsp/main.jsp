<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User, model.Mutter, java.util.List" %>
<%
//セッションスコープに保存されたユーザー情報を取得

User loginUser = (User)session.getAttribute("loginUser");
//アプリケーションスコープに保存されたつぶやきリストを取得

List<Mutter> mutterList = (List<Mutter>)request.getAttribute("mutterList");

//リクエストスコープに保存されたエラーメッセージを取得
String errorMsg = (String)request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶメイン</h1>
<p>
<%=loginUser.getName() %>さん、ログイン中
<!--  <a href="Logout">ログアウト</a>-->
<a href="Logout" onclick="return confirm('[どこつぶ]をログアウトしてよろしいですか?');">ログアウト</a>

</p>
<p><a href="Main">更新</a></p>
<form action="Main" method="post">
<a href="Delete?action=delete"onclick="return confirm('[コメント]を全て削除してよろしいですか?');">/コメントを全て削除</a><br>
<input type="text" name="text">
<input type="submit" value="つぶやく">
</form>
<% if (errorMsg != null){ %>
<p><%=errorMsg %></p>
<%}else{ %>
<% for(Mutter mutter : mutterList){%>
<p><%=mutter.getUserName() %>: <%=mutter.getUserText() %></p>
<%if(mutter.getUserName().equals(loginUser.getName())){ %>
<a href="/dokoTsubuDB/Delete?id=<%=mutter.getId() %>" onclick="return confirm('[<%=mutter.getUserText() %>]を削除してよろしいですか?');">削除</a>
<%} %>
<%} %>
<%} %>
</body>
</html>