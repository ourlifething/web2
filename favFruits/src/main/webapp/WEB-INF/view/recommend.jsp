<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.FruitsJB, java.util.*, model.LoginJB "%>
    <%@page import="java.text.SimpleDateFormat" %>
    <%
    String bestFruitname = (String)request.getAttribute("bestFruitname");
    
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

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Caveat+Brush&display=swap" rel="stylesheet">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/favFruits/css/signin.css">
<title>Fruits Ranking</title>
</head>

<body>
<div class="">
	<p style="font-size:small;"><%=loginjb.getName() %>さん:ログイン中</p>
	  <h1 class="display-5" style="font-family: 'Caveat Brush', cursive">Fruits Ranking</h1>
	  <hr class="my-4">
	  <p class="">現在<%=dateTime %>月第１位は<%=bestFruitname %>です。</p>
	  <p><%=bestFruitname %>は好きですか？</p>
	<form action="Result" method="post">
	  <div class="form-check form-check-inline">
		  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="<%=bestFruitname%>">
		  <label class="form-check-label" for="inlineRadio1">はい</label>
	  </div>
	  <div class="form-check form-check-inline">
		  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="いいえ">
		  <label class="form-check-label" for="inlineRadio2">いいえ</label>
	  </div>
	  
	  <hr class="my-4">
	  <p><%=dateTime %>月ランキングを確認しますか？</p>
	 
	  <button class="btn btn-primary" type="submit">確認する</button><br>
	  <div style="margin-top:10px;">
		  <a style="font-size:small; margin-top:20px;" href="Logout" onclick="return confirm('[Fruits Ranking]をログアウトしてよろしいですか?');">ログアウトする</a>
	  </div>
	</form>
	 
	<div style="margin-top:20px;">
		 <small style="text-align:center;"><jsp:include page="footer.jsp"/></small>
	</div>
</div>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>

</html>