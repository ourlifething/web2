<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.LoginJB,model.FruitsJB"%>
    <%@page import="java.util.*" %>
    <%@page import="java.text.SimpleDateFormat" %>
<%
String errorMsg = (String)request.getAttribute("errorMsg");
LoginJB loginjb = (LoginJB)session.getAttribute("loginok");
List<FruitsJB> fruitsList = (List<FruitsJB>)request.getAttribute("fruitslist");
Date today = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("M");
String dateTime = sdf.format(today);
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
<div>
<p style="font-size:small;"><%=loginjb.getName() %>さん:ログイン中</p>
  <h1 class="display-5" style="font-family: 'Caveat Brush', cursive">Fruits Ranking</h1>
  <hr class="my-4">
  <%if(fruitsList == null){ %>
  <small><p class="lead">ようこそ<%=loginjb.getName() %>さん<%=dateTime %>月のおすすめフルーツを教えてください</p></small>
  <%} %>
  <%if(errorMsg != null){ %>
	  <p><%=errorMsg %></p>
  <%}else{%>
	  <%if(fruitsList != null){ %>
		  <%for(int i=0; i<fruitsList.size();i++){ %>
			  <%if(i == fruitsList.size()-1) {%>
			  <p class="lead"><%=fruitsList.get(i).getName() %>ですね。ご回答ありがとうございます。</p>
			  <%} %>
		  <%} %>
	  <%} %>
  <%} %>
  <hr class="my-4">
  <form action="Recommend" method="post">
	<div class="input-group mb-3">
	  <input type="text" name="recommend" class="form-control" placeholder="Recommend" aria-label="Recipient's username" aria-describedby="basic-addon2">
	  <div class="input-group-append">
	  
	    <button class="btn btn-outline-secondary" type="submit">入力する</button>
	  </div>
	</div>
  </form>
  
<%if(fruitsList != null){ %>
  <p class="lead">
    <a class="btn btn-primary btn-lg" href="SelectBest" role="button">更新する</a>
  </p>
<%} %>
<div style="margin-top:60px; text-align:center;">
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