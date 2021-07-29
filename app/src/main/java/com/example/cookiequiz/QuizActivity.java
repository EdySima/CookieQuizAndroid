package com.example.cookiequiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QuizActivity extends AppCompatActivity {

    private TextView actualQuestion, question;
    private AppCompatButton answer1, answer2, answer3, answer4;

    private AppCompatButton nextBtn;

    private List<QuestionList> questionsList;

    private int currentQuestion = 0;

    private String selectedAnswerByUser = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();

        setContentView(R.layout.activity_quiz);


        actualQuestion = findViewById(R.id.actQuiz_noQuestion_ActualQuestion);
        question = findViewById(R.id.actQuiz_QuestionText);

        answer1 = findViewById(R.id.actQuiz_Answer1);
        answer2 = findViewById(R.id.actQuiz_Answer2);
        answer3 = findViewById(R.id.actQuiz_Answer3);
        answer4 = findViewById(R.id.actQuiz_Answer4);

        nextBtn = findViewById(R.id.actQuiz_nextBtn);

        questionsList = QuestionBank.getQuestions();

        String actualQuestionString = (currentQuestion+1) + "/" + questionsList.size();
        actualQuestion.setText(actualQuestionString);
        question.setText(questionsList.get(0).getQuestion());
        answer1.setText(questionsList.get(0).getAnswer1());
        answer2.setText(questionsList.get(0).getAnswer2());
        answer3.setText(questionsList.get(0).getAnswer3());
        answer4.setText(questionsList.get(0).getAnswer4());

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedAnswerByUser.isEmpty()){
                    selectedAnswerByUser = answer1.getText().toString();

                    answer1.setBackgroundResource(R.drawable.incorrect_answer_button);
                    answer1.setTextColor(ResourcesCompat.getColor(getResources(), R.color.light_yellow, null));

                    revealAnswer();

                    questionsList.get(currentQuestion).setUserSelectedAnswer(selectedAnswerByUser);
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedAnswerByUser.isEmpty()){
                    selectedAnswerByUser = answer2.getText().toString();

                    answer2.setBackgroundResource(R.drawable.incorrect_answer_button);
                    answer2.setTextColor(ResourcesCompat.getColor(getResources(), R.color.light_yellow, null));

                    revealAnswer();

                    questionsList.get(currentQuestion).setUserSelectedAnswer(selectedAnswerByUser);
                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedAnswerByUser.isEmpty()){
                    selectedAnswerByUser = answer3.getText().toString();

                    answer3.setBackgroundResource(R.drawable.incorrect_answer_button);
                    answer3.setTextColor(ResourcesCompat.getColor(getResources(), R.color.light_yellow, null));

                    revealAnswer();

                    questionsList.get(currentQuestion).setUserSelectedAnswer(selectedAnswerByUser);
                }
            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedAnswerByUser.isEmpty()){
                    selectedAnswerByUser = answer4.getText().toString();

                    answer4.setBackgroundResource(R.drawable.incorrect_answer_button);
                    answer4.setTextColor(ResourcesCompat.getColor(getResources(), R.color.light_yellow, null));

                    revealAnswer();

                    questionsList.get(currentQuestion).setUserSelectedAnswer(selectedAnswerByUser);
                }
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedAnswerByUser.isEmpty()) {
                    Toast.makeText(QuizActivity.this, "Please select an answer!", Toast.LENGTH_SHORT).show();
                }
                else{
                    changeNextQuestion();
                }
            }
        });

    }


    private void resetAnswerButton(AppCompatButton answer){
        answer.setBackgroundResource(R.drawable.answer_button);
        answer.setTextColor(ResourcesCompat.getColor(getResources(), R.color.brown, null));
    }

    private void changeNextQuestion(){
        currentQuestion++;

        if((currentQuestion + 1) == questionsList.size()){
            nextBtn.setText("Submit Quiz");
        }

        if(currentQuestion < questionsList.size()){
            selectedAnswerByUser = "";
            resetAnswerButton(answer1);
            resetAnswerButton(answer2);
            resetAnswerButton(answer3);
            resetAnswerButton(answer4);

            String actualQuestionString = (currentQuestion+1) + "/" + questionsList.size();
            actualQuestion.setText(actualQuestionString);
            question.setText(questionsList.get(currentQuestion).getQuestion());
            answer1.setText(questionsList.get(currentQuestion).getAnswer1());
            answer2.setText(questionsList.get(currentQuestion).getAnswer2());
            answer3.setText(questionsList.get(currentQuestion).getAnswer3());
            answer4.setText(questionsList.get(currentQuestion).getAnswer4());
        }
        else{
            Intent intent = new Intent(QuizActivity.this, QuizResults.class);
            intent.putExtra("correct", getCorrectAnswers());
            startActivity(intent);

            finish();
        }
    }

    private int getCorrectAnswers(){
        int nr_correctAnswers = 0;

        for(int i = 0; i < questionsList.size(); i++){
            final String getUserSelectedAnswer = questionsList.get(i).getUserSelectedAnswer();
            final String getCorrectAnswer = questionsList.get(i).getCorrectAnswer();

            if(getUserSelectedAnswer.equals(getCorrectAnswer)){
                nr_correctAnswers++;
            }
        }

        return nr_correctAnswers;
    }

    private void revealAnswer(){
        final String getCorrectAnswer = questionsList.get(currentQuestion).getCorrectAnswer();

        if(answer1.getText().toString().equals(getCorrectAnswer)){
            answer1.setBackgroundResource(R.drawable.correct_answer_button);
            answer1.setTextColor(ResourcesCompat.getColor(getResources(), R.color.light_yellow, null));
        }
        else if(answer2.getText().toString().equals(getCorrectAnswer)){
            answer2.setBackgroundResource(R.drawable.correct_answer_button);
            answer2.setTextColor(ResourcesCompat.getColor(getResources(), R.color.light_yellow, null));
        }
        else if(answer3.getText().toString().equals(getCorrectAnswer)){
            answer3.setBackgroundResource(R.drawable.correct_answer_button);
            answer3.setTextColor(ResourcesCompat.getColor(getResources(), R.color.light_yellow, null));
        }
        else{
            answer4.setBackgroundResource(R.drawable.correct_answer_button);
            answer4.setTextColor(ResourcesCompat.getColor(getResources(), R.color.light_yellow, null));
        }
    }

}