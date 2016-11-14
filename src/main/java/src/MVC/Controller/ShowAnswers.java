package main.java.src.MVC.Controller;

import main.java.src.MVC.Models.Answer;
import main.java.src.MVC.Models.AnswerViewModel;
import main.java.src.MVC.Models.Question;
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
@WebServlet(name = "ShowAnswers")
public class ShowAnswers extends HttpServlet {
    SQLLayer sqlLayer;
    AnswerViewModel answerViewModel;
    int questionID;
    public ShowAnswers() throws Exception{
        super();

        answerViewModel = new AnswerViewModel();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String theAnswer = request.getParameter("theAnswer");
        System.out.println(theAnswer);
        Answer answer = new Answer();
        answer.setQuestionId(questionID);
        answer.setAnswer(theAnswer);
        answer.addSQLAnswer(answer);

        response.sendRedirect("ShowAnswers?id="+ questionID);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            questionID = Integer.parseInt(request.getParameter("id"));
            RequestDispatcher rd = null;
            List<AnswerViewModel> answerViewModels = answerViewModel
                    .getAnswers(questionID);

            rd = request.getRequestDispatcher("/Views/Answers.jsp");
            request.setAttribute("viewModel", answerViewModels);

            rd.forward(request, response);
//            out.println("<html>");
//            out.println("<body>");
//

//        out.println("<form method=\"POST\" action=\"ShowAnswers\">");
//        out.println("<p><input type=\"text\" name=\"theAnswer\" size=\"50\"> <input type=\"submit\" value=\"Add Answer\"></p>");
//        out.println("</form>");
//        out.println("</body></html>");
        }
    }
