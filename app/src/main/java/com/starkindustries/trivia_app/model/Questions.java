package com.starkindustries.trivia_app.model;

import androidx.annotation.NonNull;

public class Questions {
    public String question;
    public boolean answer;
    public Questions(String question,boolean answer)
    {
        this.question=question;
        this.answer=answer;
    }
    public Questions()
    {}

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Questions{" +
                "question='" + question + '\'' +
                ", answer=" + answer +
                '}';
    }
}
