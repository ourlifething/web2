<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.FruitsJB, java.util.*, model.LoginJB "%>
<%@page import="java.text.SimpleDateFormat" %>
    <%
    List<FruitsJB> list = (List<FruitsJB>)request.getAttribute("bestTen"); 
    LoginJB loginjb = (LoginJB)session.getAttribute("loginok");
   
    Date today = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("M");
    String dateTime = sdf.format(today);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/favFruits/css/signin.css">
<title>Insert title here</title>
</head>
<body>
<div class="jumbotron">

<p style="font-size:small;"><%=loginjb.getName() %>さん:ログイン中</p>
<div style="text-align:center;">

  <h1 class="display-5">Fruits Ranking</h1>
  
  <p class="lead"><%=dateTime %>月のおすすめランキング</p>
  <%int num = 1; %>
  <%for(FruitsJB f : list){ %>
  
  	<p><%=num%>:<%=f.getName() %></p>
  	<%num++;%>
  
  <%} %>

  
  <hr class="my-4">

<p>ご協力ありがとうございました</p>
<a style="font-size:small;" href="Logout" onclick="return confirm('[Fruits Ranking]をログアウトしてよろしいですか?');">ログアウトする</a>
</div>
  
</div>

</body>
<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>

</html>