package com.example.doctify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Timer;
import java.util.TimerTask;

public class FirstPage extends AppCompatActivity {
    Timer timer;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        getSupportActionBar().hide();
        auth = FirebaseAuth.getInstance();
        timer = new Timer();


        if (auth.getCurrentUser()!= null){
            Intent intent = new Intent(FirstPage.this,ThirdActivity.class);
            startActivity(intent);
        }else {
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Intent intent = new Intent(FirstPage.this,SecondActivity.class);
                    startActivity(intent);
                    finish();

                }
            },5000);

        }
    }
}