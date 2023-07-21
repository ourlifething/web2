<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*, java.util.*"%>
    
<%
EJWord ejw = (EJWord)request.getAttribute("ejw");
%>
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
	  <input style="" type="text" name="searchWord" class="form-control" placeholder="検索語を入力" value="<%=ejw.getSearchWord()%>" required><!-- required:入力フィールドが必須項目であることを示します -->
	  <select class="form-control" name="mode">
		<option selected>Choose...</option>
		<!-- select属性の付け方 -->
		<option value="startsWith" <%=ejw.getMode().equals("startsWith")?"selected":"" %>>で始まる</option>
		<option value="contains" <%=ejw.getMode().equals("contains")?"selected":"" %>>含む</option>
		<option value="endsWith" <%=ejw.getMode().equals("endsWith")?"selected":"" %>>で終わる</option>
		<option value="match" <%=ejw.getMode().equals("match")?"selected":"" %>>一致する</option>
	  </select>
		<button class="btn btn-primary" type="submit">検索</button>
	<!-- selected属性は、HTMLの<option>要素に対して使われる属性の一つであり、ドロップダウンメニュー（選択ボックス）の初期選択状態を指定するために使用 -->
	</form>
	<%if(ejw.getList() != null && ejw.getList().size() > 0){ %>
		<%--件数表示部分作成 --%>
		<%if(ejw.getTotal() <= ejw.getLimit()){ %>
			<p>全<%=ejw.getTotal() %>件</p>
		<%}else{ %>
			<%--ページ番号を利用して何件から何件を表示しているのかを表示する --%>
			<p>全<%=ejw.getTotal() %>件中 <%=(ejw.getPageNo()-1) * ejw.getLimit() + 1 %> ~ <%=ejw.getPageNo()*ejw.getLimit() > ejw.getTotal()? ejw.getTotal():ejw.getPageNo()*ejw.getLimit() %>件を表示</p>
			<%--ページ番号が１より大きかったら前のリンクを表示 --%>
			<ul class="pager">
				<%if(ejw.getPageNo() > 1) {%>
					<li><a href="/ejword/main?searchWord=<%=ejw.getSearchWord() %>&mode=<%=ejw.getMode() %>&page=<%=ejw.getPageNo()-1 %>"><span aria-hidden="true">	&lt;</span>前へ</a></li>
				<%} %>
					<%--件数が全件に届かない時は次へのリンクを表示（ &larr;は矢印）--%>
				<%if(ejw.getPageNo() * ejw.getLimit() < ejw.getTotal()){ %>
					<li><a href="/ejword/main?searchWord=<%=ejw.getSearchWord() %>&mode=<%=ejw.getMode() %>&page=<%=ejw.getPageNo()+1 %>"><span aria-hidden="true">&gt;</span>次へ</a></li>
				<%} %>
			</ul>
		<%} %>
		<table class="table table-bordered table-striped">
			<%for(Word w : ejw.getList()){%>
				<tr><th><%=w.getTitle() %></th><td><%=w.getBody() %></td></tr>
			<%}%>
		</table>
	<%} %>
	<%if(ejw.getPager() != null){ %>
	<div class='paginationBox'>
		<ul class='pagination'>
		<% for(String[] row : ejw.getPager()){ %>
			<li class="<%=row[0] %>">
			<a href="/ejword/main?searchWord=<%=ejw.getSearchWord() %>&mode=<%=ejw.getMode() %>&page=<%=row[1] %>"><%=row[2] %></a>
			</li>
		<%} %>
		</ul>
	</div>
	<%} %>
</div><!-- container -->
<footer>
&copy; 2017 Joytas.net
</footer>
</body>
</html>