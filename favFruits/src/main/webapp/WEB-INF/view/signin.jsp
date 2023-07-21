<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String errorMsg = (String)request.getAttribute("false");
%>

<!doctype html>
<html lang="ja">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" href="/favFruits/css/signin.css">
    <title>Fruits Ranking</title>
  </head>
  <body>
	  <form action="Login" method="post">
		<div style="text-align:center" class="text-cenr mb-4">
		  <img src="/favFruits/images/FRTS.jpg" class="rounded mb-4" alt="logo" width="72" height="72" style="">
		  <h3 style="">Fruits Ranking</h3>
		</div>
		
		  <div class="mx-auto" style="" >
			 <div class="form-group">
				<label for="exampleInputName">名前</label>
				<input type="text" class="form-control" id="exampleInputName" name="name" placeholder="name">
				<small id="nameHelp" class="form-text text-muted">We'll never share your info with anyone else.</small>
			 </div>
			
			 <div class="form-group">
				<label for="exampleInputPassword1">パスワード</label>
				<input type="password" class="form-control" name="password" placeholder="Password">
			 </div>
			 <%if(errorMsg != null){ %>
			 <p><%=errorMsg %></p>
			 <%} %>
			 <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		  </div>
		</form>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>