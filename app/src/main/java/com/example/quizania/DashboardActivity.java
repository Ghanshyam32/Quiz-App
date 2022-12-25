package com.example.quizania;

import static com.example.quizania.MainActivity.listOfQ;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.CollapsibleActionView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DashboardActivity extends AppCompatActivity {

    CountDownTimer countDownTimer;
    int timerValue = 20;
    RoundedHorizontalProgressBar progressBar;
    List<ModelClass> allQuestions;
    ModelClass modelClass;
    int index = 0;
    TextView question, op1, op2, op3, op4;
    CardView card1, card2, card3, card4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Hooks();
        setContentView(R.layout.activity_dashboard);
        allQuestions = listOfQ;
        Collections.shuffle(allQuestions);
        modelClass = listOfQ.get(index);

        setAllData();

        countDownTimer = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerValue = timerValue - 1;
                progressBar.setProgress(timerValue);
            }

            @Override
            public void onFinish() {
                Dialog dialog = new Dialog(DashboardActivity.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.time_out);
                dialog.findViewById(R.id.tryAgain).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
                dialog.show();

            }
        }.start();
    }

    private void setAllData() {
        question.setText(modelClass.getQues());
        op1.setText(modelClass.getAns1());
        op2.setText(modelClass.getAns2());
        op3.setText(modelClass.getAns3());
        op4.setText(modelClass.getAns4());

    }

    private void Hooks() {
        progressBar = findViewById(R.id.progress_bar_1);
        question = findViewById(R.id.question);
        op1 = findViewById(R.id.ans1);
        op2 = findViewById(R.id.ans2);
        op3 = findViewById(R.id.ans3);
        op4 = findViewById(R.id.ans4);

        card1 = findViewById(R.id.ans1_card);
        card2 = findViewById(R.id.ans2_card);
        card2 = findViewById(R.id.ans3_card);
        card2 = findViewById(R.id.ans4_card);
    }
}