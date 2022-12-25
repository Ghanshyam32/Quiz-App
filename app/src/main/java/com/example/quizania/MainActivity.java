package com.example.quizania;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<ModelClass> listOfQ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listOfQ = new ArrayList<>();
        listOfQ.add(new ModelClass("what comes after 1", "2", "0", "2", "5", "2"));
        listOfQ.add(new ModelClass("what comes after 2", "2", "0", "3", "5", "3"));
        listOfQ.add(new ModelClass("what comes after 3", "2", "0", "4", "5", "4"));
        listOfQ.add(new ModelClass("what comes after 4", "2", "0", "5", "5", "5"));
        listOfQ.add(new ModelClass("what comes after 5", "2", "0", "6", "5", "6"));
        listOfQ.add(new ModelClass("what comes after 6", "2", "0", "7", "5", "7"));


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, DashboardActivity.class);
                startActivity(i);
                finish();
            }
        },5000);
    }
}