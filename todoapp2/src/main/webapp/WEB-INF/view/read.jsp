<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.Todo,java.util.*"%>
    <%
    List<Todo> list = (List<Todo>)request.getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<title>TodoApp</title>
</head>
<body>
<a href="/todoapp2/Create" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true"style="width:200px; margin:10px;">新規</a>

<p></p>

<% if(list !=null && list.size() >0){ %>
<table class="table table-striped table-dark"style="width:600px; margin:10px;">
  <thead>
    <tr>
      <td scope="col"></td>
      <td scope="col">TO DO LIST</td>
      <td scope="col">★重要度★</td>
      <td scope="col">更新・削除</td>
    </tr>
  </thead>
<%for(Todo t:list){ %>
  <tbody>
    <tr>
      <th scope="row">⚫︎</th>
      <td><%=t.getTitle() %></td>
      <td><%=t.getStar() %></td>
	  <td><a href="/todoapp2/Update?id=<%=t.getId()%> "style="color:#fff;">更新</a>
	  <a href="/todoapp2/Delete?id=<%=t.getId()%>" onclick="return confirm('[<%=t.getTitle()%>]を削除してよろしいですか？');"style="color:#fff;">/ 削除</a>
	  </td>
	 </tr>
<%} %>
</table>
<%}else{ %>
<p>Todoはまだありません</p>
<%} %>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>