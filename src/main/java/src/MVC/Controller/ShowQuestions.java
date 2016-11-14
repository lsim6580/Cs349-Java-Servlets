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
    SQLLayer sqlLayer;
    Question question;
    public ShowQuestions(){
        super();
        question = new Question();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String theQuestion = request.getParameter("theQuestion");
        System.out.println(theQuestion);
        question.addQuestion(new Question(theQuestion));

        response.sendRedirect("ShowQuestions");



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        QuestionViewModel questionViewModel = new QuestionViewModel();
        List<QuestionViewModel> questionViewModels = questionViewModel.getQuestions();
        RequestDispatcher rd = null;
        //QuestionViewModel questionViewModel = new QuestionViewModel(question.getSQLQuestions());
        rd = request.getRequestDispatcher("/Views/Questions.jsp");
        request.setAttribute("viewModel", questionViewModels);
        rd.forward(request, response);

    }
}
