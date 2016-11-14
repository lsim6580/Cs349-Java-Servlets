package main.java.src.MVC.Controller;

import main.java.src.MVC.Models.Answer;
import main.java.src.MVC.Models.AnswerViewModel;
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
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by luke on 11/6/2016.
 */
@WebServlet(name = "GetQuestionsAPI")
public class GetQuestionsAPI extends HttpServlet {
    SQLLayer sqlLayer;
    public GetQuestionsAPI()throws Exception{
        super();
        sqlLayer = new SQLLayer();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Question question = new Question();
        QuestionViewModel questionViewModel = new QuestionViewModel();
        List<QuestionViewModel> questionViewModels = questionViewModel.getQuestions();
        RequestDispatcher rd = null;
        rd = request.getRequestDispatcher("/Views/QuestionsAPI.jsp");
        request.setAttribute("viewModel", questionViewModels);
        rd.forward(request, response);


    }
}
