<%@ page import="main.java.src.MVC.Models.QuestionViewModel" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: luke
  Date: 11/12/2016
  Time: 5:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<QuestionViewModel> questionViewModel = (List<QuestionViewModel>)request.getAttribute("viewModel");
    String json = "{\"questions\": [,";
    for(QuestionViewModel q: questionViewModel){
        json += "{\"question\":"+"'"+ q.getQuestion()+ "'"+"},";
    }
    json += "]}";
    out.println(json);
%>
</body>
</html>
