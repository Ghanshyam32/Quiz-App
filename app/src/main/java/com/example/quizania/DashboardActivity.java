package com.example.quizania;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class DashboardActivity extends AppCompatActivity {

    ProgressBar progressBar;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


    }

    public void prog() {
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        final Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                counter++;
                progressBar.setProgress(counter);

                if (counter == 100)
                    t.cancel();
            }
        };
        t.schedule(tt, 0, 1000);

    }
}