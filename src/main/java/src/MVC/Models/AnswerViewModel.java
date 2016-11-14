package main.java.src.MVC.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luke on 11/12/2016.
 */
public class AnswerViewModel {
    private String answer;
    private int id;
    private int questionId;

    public String getAnswer() {
        return answer;
    }

    public int getId() {
        return id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public AnswerViewModel(){

    }
    public AnswerViewModel(Answer answer){
        this.answer = answer.getAnswer();
        this.id = answer.getId();
        this.questionId = answer.getQuestionId();
    }
    public List<AnswerViewModel> getAnswers(int id){
        Answer answer = new Answer();
        List<AnswerViewModel> answerViewModels = new ArrayList<>();
        for(Answer a: answer.getSQLAnswer(id)){
            answerViewModels.add(makeAnswerView(a));
        }
        return answerViewModels;
    }
    public AnswerViewModel makeAnswerView(Answer answer){
        return new AnswerViewModel(answer);

    }
}
