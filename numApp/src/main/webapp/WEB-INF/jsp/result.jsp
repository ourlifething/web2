<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
<%
Num num = (Num)request.getAttribute("num");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result</title>
</head>
<body>
入力値:<%=num.getNums() %><br>
要素数:<%=num.getSize() %><br>
最大値:<%=num.getMax() %><br>
最小値:<%=num.getMin() %><br>
合計:<%=num.getTotal() %><br>

<a href="NumMain">戻る</a>

</body>
</html>