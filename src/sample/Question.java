package sample;

import java.util.Arrays;

public class Question {

    private String question;
    private String[] answers;
    private String correctAnswer;

    public Question(String question, String[] answers) {
        this.question = question;
        this.answers = answers;
    }

    public Question(String question, String[] answers, String correctAnswer) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public String correctAnswer() {
        return this.correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }
    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answers=" + Arrays.toString(answers) +
                ", correctAnswer='" + correctAnswer + '\'' +
                '}';
    }
}
