package main.java.src.MVC.Controller;

import main.java.src.MVC.Models.Question;
import main.java.src.MVC.Models.QuestionViewModel;
import main.java.src.MVC.SQLLayer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by luke on 11/6/2016.
 */
@WebServlet(name = "ShowQuestions")
public class ShowQuestions extends HttpServlet {
    Question question;
    public ShowQuestions(){
        super();
        question = new Question();
    }
    /**add question to db*/
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String theQuestion = request.getParameter("theQuestion");
        question.addQuestion(new Question(theQuestion));
        response.sendRedirect("ShowQuestions");
    }
    /**get all questions and display them*/
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        QuestionViewModel questionViewModel = new QuestionViewModel();
        List<QuestionViewModel> questionViewModels = questionViewModel.getQuestions();
        RequestDispatcher rd = null;
        rd = request.getRequestDispatcher("/Views/Questions.jsp");
        request.setAttribute("viewModel", questionViewModels);
        rd.forward(request, response);

    }
}
