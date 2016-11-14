package main.java.src.MVC.Models;

import main.java.src.MVC.SQLLayer;

import java.util.List;

/**
 * Created by luke on 11/6/2016.
 */
public class Question {

    private String question;
    private int id;
    private SQLLayer sqlLayer = null;
    public Question(){
        this.sqlLayer = initSQL();
    }
    public Question(String q, int id){
        this.question = q;
        this.id = id;
        this.sqlLayer = initSQL();
    }
    public Question(String q){
        this.question = q;
        this.sqlLayer = initSQL();

    }
    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private SQLLayer initSQL(){
        try {
            sqlLayer = new SQLLayer();

        }catch (Exception e){
            e.printStackTrace();
        }
        return sqlLayer;
    }
    public List<Question> getSQLQuestions(){
        sqlLayer = initSQL();
        return sqlLayer.getQuestions();
    }
    public void addQuestion(Question question){
        sqlLayer = initSQL();
        sqlLayer.addQuestion(question);
    }

}
