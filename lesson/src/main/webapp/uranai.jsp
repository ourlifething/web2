<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import= "java.util.*" %>
    <%@ page import= "java.text.*" %>
    
    <%
    String[] luckArray = {"超スッキリ", "スッキリ", "最悪"};
    int index =(int)(Math.random() * 3);
    String luck = luckArray[index];
    
    //実行した日の情報をもつインスタンス取得 -> Wed Jun 28 11:49:54 JST 2023
    Date date = new Date();
    //java.text.*;から取得
    SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日"); // yyyy/MM/ddとかもOK
    String today = sdf.format(date);
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ占い</title>
</head>
<body>
<%=date %>
<p><%= today %>の運勢は「<%= luck %>」です</p>
</body>
</html>