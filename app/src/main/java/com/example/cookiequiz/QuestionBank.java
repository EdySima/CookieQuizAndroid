package com.example.cookiequiz;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {

    private static List<QuestionList> set1_questions(){
        final List<QuestionList> questionsList = new ArrayList<>();

        final QuestionList question1 = new QuestionList("Question 1", "Answer 1", "Answer 2", "Answer 3", "Answer 4", "Answer 1");
        final QuestionList question2 = new QuestionList("Question 2", "Answer 1", "Answer 2", "Answer 3", "Answer 4", "Answer 2");
        final QuestionList question3 = new QuestionList("Question 3", "Answer 1", "Answer 2", "Answer 3", "Answer 4", "Answer 3");
        final QuestionList question4 = new QuestionList("Question 4", "Answer 1", "Answer 2", "Answer 3", "Answer 4", "Answer 4");
        final QuestionList question5 = new QuestionList("Question 5", "Answer 1", "Answer 2", "Answer 3", "Answer 4", "Answer 1");

        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);

        return questionsList;
    }

    public static List<QuestionList> getQuestions(){
        return set1_questions();
    }
}
