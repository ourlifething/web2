<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*, java.util.*"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%-- JSTL式に書き換える --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EJWord</title>
<!-- Latest compiled and minified CSS   https://getbootstrap.com/docs/3.4/getting-started/  -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
<link rel="stylesheet" href="/ejword/css/style.css">
<body>
<div class="container">
	<form action="/ejword/main" method="get"class="form-inline"><!-- form-inline横並び -->
	  <input style="" type="text" name="searchWord" class="form-control" placeholder="検索語を入力" value="${ejw.searchWord}" required><!-- required:入力フィールドが必須項目であることを示します -->
	  <select class="form-control" name="mode">
		<option selected>Choose...</option>
		<!-- select属性の付け方 -->
		<option value="startsWith" ${ejw.mode eq "startsWith" ? "selected":"" }>で始まる</option>
		<option value="contains" ${ejw.mode eq "contains" ? "selected":"" }>含む</option>
		<option value="endsWith" ${ejw.mode eq "endsWith" ? "selected":"" }>で終わる</option>
		<option value="match" ${ejw.mode eq "match" ? "selected":"" }>一致する</option>
		</select>
		<button class="btn %>tn-primary" type="submit">検索</button>
		<!-- selected属性は、HTMLの<option>要素に対して使われる属性の一つであり、ドロップダウンメニュー（選択ボックス）の初期選択状態を指定するために使用 -->
	</form>
<c:if test="${not empty ejw.searchWord and empty ejw.list }">
	<%--件数表示部分作成 --%>
	<p>１件も一致しませんでした</p>
</c:if>
<c:if test="${not empty ejw.list }">
		<c:if test="${ejw.total le ejw.limit }">
			<p>全${ejw.total }件</p>
		</c:if>
		<%--ページ番号を利用して何件から何件を表示しているのかを表示する --%>
		<c:if test="${ejw.total gt ejw.limit}">
			<%-- <p>全<%=ejw.getTotal() %>件中 <%=(ejw.getPageNo()-1) * ejw.getLimit() + 1 %> ~ <%=ejw.getPageNo()*ejw.getLimit() > ejw.getTotal()? ejw.getTotal():ejw.getPageNo()*ejw.getLimit() %>件を表示</p>--%>
			<p>
			全${ejw.total }件中 ${(ejw.pageNo-1) * ejw.limit +1} ~ 
			${ejw.pageNo*ejw.limit gt ejw.total ? ejw.total:ejw.pageNo * ejw.limit}
			件を表示
			</p>
			<%--ページ番号が１より大きかったら前のリンクを表示 --%>
			<ul class="pager">
				<c:if test="${ejw.pageNo gt 1 }">
					<li><a href="/ejword/main?searchWord=${ejw.searchWord}&mode=${ejw.mode}&page=${ejw.pageNo -1 }">
					<span aria-hidden="true">	&lt;</span>前へ</a></li>
				</c:if>
					<%--件数が全件に届かない時は次へのリンクを表示（ &larr;は矢印）--%>
				<c:if test="${ejw.pageNo * ejw.limit lt ejw.total }">
					<li><a href="/ejword/main?searchWord=${ejw.searchWord}&mode=${ejw.mode}&page=${ejw.pageNo+1}">
					<span aria-hidden="true">&gt;</span>次へ</a></li>
				</c:if>
			</ul>
		</c:if>
		<table class="table table-bordered table-striped">
			<c:forEach var="w" items="${ejw.list}">
				<tr><th>${w.title}</th><td>${w.body}</td></tr>
			</c:forEach>
		</table>
	<c:if test="${not empty ejw.pager }">
		<div class='paginationBox'>
			<ul class='pagination'>
			<c:forEach var="row" items="${ejw.pager }">
				<li class="${row[0] }">
				<a href="/ejword/main?searchWord=${ejw.searchWord}&mode=${ejw.mode}&page=${row[1]}">${row[2]}</a>
				</li>
			</c:forEach>	
			</ul>
		</div>
	</c:if>
</c:if>
</div><!-- container -->
<footer>
&copy; 2017 Joytas.net
</footer>
</body>
</html>