<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.FruitsJB, java.util.*, model.LoginJB "%>
<%@page import="java.text.SimpleDateFormat" %>
    <%
    List<FruitsJB> list = (List<FruitsJB>)session.getAttribute("bestTen"); 
    List<FruitsJB> fruitsListMonth = (List<FruitsJB>)request.getAttribute("fruitsListMonth");
    LoginJB loginjb = (LoginJB)session.getAttribute("loginok");
   
    Date today = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("M");
    String dateTime = sdf.format(today);
    String month = (String)request.getAttribute("month");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Caveat+Brush&display=swap" rel="stylesheet">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/favFruits/css/signin.css">
<title>Fruits Ranking</title>
</head>
<body>
<!--div class="jumbotron"-->
<div class="">

<p style="font-size:small;"><%=loginjb.getName() %>さん:ログイン中</p>
<div style="text-align:center;">
  <h1 class="display-5" style="font-family: 'Caveat Brush', cursive">Fruits Ranking</h1>
</div>
  <hr class="my-4">
  <%if (month == null){%> 
<div style="text-align:center;">
	<p class="lead"><%=dateTime %>月フルーツランキング</p>
</div>

	<ol style="margin-left:50px;">
	   <%for(FruitsJB f : list){ %>
		  <li><%=f.getName() %></li>
	   <%} %>
 	</ol>
  <%}else{ %>
  <div style="text-align:center;">
	    <p class="lead"><%=month %>月フルーツランキング</p>
  </div>
	<ol style="margin-left:50px;">
	  <%for(FruitsJB fm : fruitsListMonth){ %>
		  <li><%=fm.getName() %></li>
	  <%} %>
	</ol> 
  <%} %> 
<hr class="my-4">

<div style="text-align:center;">
<p>月刊フルーツランキング</p>

<a style="font-size:small;" href="Logout" onclick="return confirm('[Fruits Ranking]をログアウトしてよろしいですか?');">ログアウトする</a>
</div>

<form action="Pager" method="get">

<nav aria-label="..." style="margin-top:20px;">
  <ul class="pagination pagination-sm">
  <%
  int currentPage;
  if(month == null){
	  currentPage = Integer.parseInt(dateTime);
  }else{
	  currentPage = Integer.parseInt(month);
  }
  int totalPage = 12;
  
  for(int i=1; i<=totalPage; i++){
  String pageClass = (i == currentPage)? "page-item disabled":"page-item";
  %>
  <li class="<%=pageClass %>"><a class="page-link" href="Pager?name=<%=i %>"><%=i %></a></li>
  <%
  	}
  %>
  	<!--  
    <li class="page-item disabled"><a class="page-link" href="Pager?name=1" tabindex="-1">1</a></li>
    <li class="page-item"><a class="page-link" href="Pager?name=2">2</a></li>
    <li class="page-item"><a class="page-link" href="Pager?name=3">3</a></li>
    <li class="page-item"><a class="page-link" href="Pager?name=4">4</a></li>
    <li class="page-item"><a class="page-link" href="Pager?name=5">5</a></li>
    <li class="page-item"><a class="page-link" href="Pager?name=6">6</a></li>
    <li class="page-item"><a class="page-link" href="Pager?name=7">7</a></li>
    <li class="page-item"><a class="page-link" href="Pager?name=8">8</a></li>
    <li class="page-item"><a class="page-link" href="Pager?name=9">9</a></li>
    <li class="page-item"><a class="page-link" href="Pager?name=10">10</a></li>
    <li class="page-item"><a class="page-link" href="Pager?name=11">11</a></li>
    <li class="page-item"><a class="page-link" href="Pager?name=12">12</a></li>
    -->
  </ul>
</nav>
</form>
<div style="margin-top:0 30px; text-align:center">
  <small><jsp:include page="footer.jsp"/></small>
</div>
</div>



<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>

</html>