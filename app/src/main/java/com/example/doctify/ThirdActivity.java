package com.example.doctify;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.doctify.databinding.ActivityThirdBinding;

import im.crisp.client.ChatActivity;
import im.crisp.client.Crisp;

public class ThirdActivity extends AppCompatActivity {
    ActivityThirdBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityThirdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        binding.chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Crisp.configure(getApplicationContext(), "f27fdec0-75a9-4f4d-97d8-a6c2f96c937d");
                Intent crispIntent = new Intent(ThirdActivity.this, ChatActivity.class);
                startActivity(crispIntent);
            }
        });


        binding.btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this,FindJob.class);
                startActivity(intent);
            }
        });
//        binding.arrowLeft.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ThirdActivity.this,SecondActivity.class);
//                startActivity(intent);
//            }
//        });

        binding.hireEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this,EmpActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder a = new AlertDialog.Builder(ThirdActivity.this);
        a.setMessage("Are u sure to exist")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                     finish();

                    }
                }).setNegativeButton("No",null);
        AlertDialog c = a.create();
        c.show();

    }
}