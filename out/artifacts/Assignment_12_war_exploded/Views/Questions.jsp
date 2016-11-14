<%@ page import="main.java.src.MVC.Models.QuestionViewModel" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: luke
  Date: 11/12/2016
  Time: 11:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Questions</title>
</head>
<body>
<h1>Questions</h1>
<%
    List<QuestionViewModel> questionViewModel = (List<QuestionViewModel>)request.getAttribute("viewModel");
    int count = 0;

    for (QuestionViewModel q : questionViewModel) {
        count++;
        out.print("<p>" + count + ". <a href=\"ShowAnswers?id="+q.getID()+"\">" + q.getQuestion() + "</a></p>");
    }
%>
<form method="POST" action="ShowQuestions">
    <p><input type="text" name="theQuestion" size="50"> <input type="submit" value="Add Question"></p>
</form>
<p><a href ="GetQuestionsAPI">JSON</a><p>
</body>
</html>
