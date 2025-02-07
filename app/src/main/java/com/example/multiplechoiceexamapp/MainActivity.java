package com.example.multiplechoiceexamapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private QuestionsGenerator generator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Create a generator
        generator = new QuestionsGenerator();

        //Initialize
        initialize(generator);



    }

    public void initialize(QuestionsGenerator generator)
    {
        //- generate
//        generator.generate();

        //- get question, four answers
        String question = generator.getQuestions();
        String answer1 = generator.getAnswer1();
        String answer2 = generator.getAnswer2();
        String answer3 = generator.getAnswer3();
        String answer4 = generator.getAnswer4();

        //- display question, four answers in radio

        //Getting hold on the question text view and display the question
        TextView questionOutPut = findViewById(R.id.txtViewQuestion);
        questionOutPut.setText(question);

        //getting hold of the radio button to display the answer
        RadioButton answer1Btn = findViewById(R.id.answer1);
        RadioButton answer2Btn = findViewById(R.id.answer2);
        RadioButton answer3Btn = findViewById(R.id.answer3);
        RadioButton answer4Btn = findViewById(R.id.answer4);

        //displaying the answers to the radio buttons
        answer1Btn.setText(answer1);
        answer2Btn.setText(answer2);
        answer3Btn.setText(answer3);
        answer4Btn.setText(answer4);

        //- display 0/0
        TextView scoreView = findViewById(R.id.txtViewResult);
        scoreView.setText("0/0");

        //- enable submit button, disable next button
        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setEnabled(true);

        //disable next button
        Button btnNext = findViewById(R.id.btnNext);
        btnNext.setEnabled(false);

    }

    public void submit(View v)
    {
        //find out which button is clicked
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        int answeredBtn = radioGroup.getCheckedRadioButtonId();

        //get key
        int key = generator.getKey();

        //- if answer equals key
        //- increase correct

        int selectedAnswerIndex = 0;
        if(answeredBtn == R.id.answer1)
            selectedAnswerIndex = 1;
        else if(answeredBtn == R.id.answer2)
            selectedAnswerIndex = 2;
        else if(answeredBtn == R.id.answer3)
            selectedAnswerIndex = 3;
        else if(answeredBtn == R.id.answer4)
            selectedAnswerIndex = 4;


        if(selectedAnswerIndex!=0)
        {
            if(selectedAnswerIndex == key)
                generator.increaseCorrect();


            //- deal with the case where user does not click any button

            //increase total
            generator.increaseTotal();

            //get correct , get total
            int correct = generator.getCorrect();
            int total = generator.getTotal();

            //display correct and total
            TextView resultView = findViewById(R.id.txtViewResult);
            resultView.setText(correct+"/"+total);

            //get the index of the current question to know if it arrives to the last question
            int index = generator.getIndex();

            //the size is the number of questions available
            int size = generator.getSize();

            //- enable submit button, disable next button
            Button btnSubmit = findViewById(R.id.btnSubmit);
            btnSubmit.setEnabled(false);

            //disable next button
            if(index != size-1)
            {
                Button btnNext = findViewById(R.id.btnNext);
                btnNext.setEnabled(true);
            }

        }


    }

    public void next(View v)
    {
        //- generate
        generator.generate();
        //- get question, four answers
        String question = generator.getQuestions();
        String answer1 = generator.getAnswer1();
        String answer2 = generator.getAnswer2();
        String answer3 = generator.getAnswer3();
        String answer4 = generator.getAnswer4();

        //- display question, four answers in radio
        //Getting hold on the question text view and display the question
        TextView questionOutPut = findViewById(R.id.txtViewQuestion);
        questionOutPut.setText(question);

        //getting hold of the radio button to display the answer
        RadioButton answer1Btn = findViewById(R.id.answer1);
        RadioButton answer2Btn = findViewById(R.id.answer2);
        RadioButton answer3Btn = findViewById(R.id.answer3);
        RadioButton answer4Btn = findViewById(R.id.answer4);

        //displaying the answers to the radio buttons
        answer1Btn.setText(answer1);
        answer2Btn.setText(answer2);
        answer3Btn.setText(answer3);
        answer4Btn.setText(answer4);
        //- uncheck all buttons
        answer1Btn.setChecked(false);
        answer2Btn.setChecked(false);
        answer3Btn.setChecked(false);
        answer4Btn.setChecked(false);

        //- get correct, total
        int correct = generator.getCorrect();
        int total = generator.getTotal();





            //- display correct/total
            TextView resultView = findViewById(R.id.txtViewResult);
            resultView.setText(correct+"/"+total);

            //- enable submit button, disable next button
            Button btnSubmit = findViewById(R.id.btnSubmit);
            btnSubmit.setEnabled(true);

            //disable next button
            Button btnNext = findViewById(R.id.btnNext);
            btnNext.setEnabled(false);
    }


}