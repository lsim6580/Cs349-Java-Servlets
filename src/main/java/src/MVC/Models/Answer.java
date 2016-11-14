package main.java.src.MVC.Models;

import main.java.src.MVC.SQLLayer;

import java.util.List;

/**
 * Created by luke on 11/6/2016.
 */
public class Answer {
    private String answer;
    private int id;
    private int questionId;
    private SQLLayer sqlLayer = null;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionId() {
        return questionId;
    }
    public List<Answer> getSQLAnswer(int id){
        sqlLayer = initSQL();
        return sqlLayer.getAnswer(id);
    }

    public void addSQLAnswer(Answer a){
        sqlLayer = initSQL();
        sqlLayer.addAnswer(a);
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
    private SQLLayer initSQL(){
        try {
            sqlLayer = new SQLLayer();

        }catch (Exception e){
            e.printStackTrace();
        }
        return sqlLayer;
    }
}
