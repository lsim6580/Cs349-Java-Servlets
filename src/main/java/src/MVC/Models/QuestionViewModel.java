package main.java.src.MVC.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luke on 11/12/2016.
 */
public class QuestionViewModel {
    
    //private List<QuestionViewModel> questions;
    private String question;
    private int id;


    public QuestionViewModel(Question question){
        this.question = question.getQuestion();
        this.id = question.getId();
    }
    public QuestionViewModel(){};
    public List<QuestionViewModel> getQuestions(){
        List<QuestionViewModel> questionViewModels = new ArrayList<>();
        Question question = new Question();
        for(Question q: question.getSQLQuestions()){
            questionViewModels.add(makeQuestionView(q));
        }
        return questionViewModels;
    }
    public String getQuestion(){
        return this.question;
    }
    public int getID(){
        return this.id;
    }
    public QuestionViewModel makeQuestionView(Question question){
        return new QuestionViewModel(question);

    }
}
