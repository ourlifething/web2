<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶメイン</h1>
<p>
<c:out value="${loginUser.name}"/>さんログイン中
<!--  <a href="Logout">ログアウト</a>-->
<a href="Logout" onclick="return confirm('[どこつぶ]をログアウトしてよろしいですか?');">ログアウト</a>

</p>
<p><a href="Main">更新</a></p>
<form action="Main" method="post">
<a href="Delete?action=delete"onclick="return confirm('[コメント]を全て削除してよろしいですか?');">/コメントを全て削除</a><br>
<input type="text" name="text">
<input type="submit" value="つぶやく">
</form>
<c:if test="${not empty errorMsg }">

<p><c:out value="${errorMsg}"/></p>
</c:if>

<c:forEach var="mutter" items="${mutterList }">
<p><c:out value="${mutter.userName} "/>: <c:out value="${ mutter.userText} "/></p>
<c:if test="${mutter.userName eq  loginUser.name }">
<a href="/dokoTsubuDB/Delete?id=${ mutter.id}" onclick="return confirm('[${mutter.userText}]を削除してよろしいですか?');">削除</a>
</c:if>
</c:forEach>
<jsp:include page="footer.jsp"/>
</body>
</html>
