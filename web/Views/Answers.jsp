<%@ page import="main.java.src.MVC.Models.AnswerViewModel" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: luke
  Date: 11/12/2016
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Answers</title>

</head>
<body>
<%
    List<AnswerViewModel> answerViewModels = (List<AnswerViewModel>)request.getAttribute("viewModel");
    int count = 0;
    out.println("<p>Answers for question " + Integer.parseInt(request.getParameter("id")) + "</p>");
    for(AnswerViewModel a: answerViewModels){
        out.print("<p>" + a.getAnswer()+"<p>");
    }
%>
<form method="POST" action="ShowAnswers">
<p><input type="text" name="theAnswer" size="50"> <input type="submit" value="Add Answer"></p>
  </form>
</body>
</html>
