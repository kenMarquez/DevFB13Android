package com.ken.quizapp.models;

/**
 * Created by Ken on 14/02/17.
 */

public class Question {


    private String title;
    private int answer;


    public Question(String title, int answer) {
        this.title = title;
        this.answer = answer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }



}
