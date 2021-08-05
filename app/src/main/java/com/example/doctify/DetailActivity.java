package com.example.doctify;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.doctify.databinding.ActivityDetailBinding;

import im.crisp.client.ChatActivity;
import im.crisp.client.Crisp;

public class  DetailActivity extends AppCompatActivity {
    ActivityDetailBinding binding;
    ProgressDialog progressDialog;
 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();





//        int image = getIntent().getIntExtra("image",0);
//        String name = getIntent().getStringExtra("name");
//
//
//        binding.imgHos.setImageResource(image);
//        binding.nameHos.setText(name);
//
        String place = getIntent().getStringExtra("place");
        String degree = getIntent().getStringExtra("degree");
        String name = getIntent().getStringExtra("name");
        int image = getIntent().getIntExtra("image",0);
        binding.detaildegree.setText(place);
        binding.detailPlace.setText(degree);
        binding.imgHos.setImageResource(image);
       binding.nameHos.setText(name);
       binding.chat.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Crisp.configure(getApplicationContext(), "f27fdec0-75a9-4f4d-97d8-a6c2f96c937d");
               Intent crispIntent = new Intent(DetailActivity.this, ChatActivity.class);
               startActivity(crispIntent);
           }
       });
       binding.btnApply.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(DetailActivity.this,ContactFormActivity.class);
               intent.putExtra("Specli",name);
               startActivity(intent);
           }
       });
//        binding.btnApply.setOnClickListener(new View.OnClickListener() {
//
//
//
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder a = new AlertDialog.Builder(DetailActivity.this);
//                a.setMessage("Are you sure to send email")
//                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//
//                                String[] TO_EMAILS = {"deepak9771119@gmail.com"};
//                                Intent intent = new Intent(Intent.ACTION_SENDTO);
//                                intent.setData(Uri.parse("mailto:"));
//                                intent.putExtra(Intent.EXTRA_EMAIL,TO_EMAILS);
//
//                                intent.putExtra(Intent.EXTRA_SUBJECT,"Apply for: "+name);
//                                intent.putExtra(Intent.EXTRA_TEXT,"This is text");
//
//                                startActivity(Intent.createChooser(intent,"choose one application"));
////                                startActivityForResult(Intent.createChooser(intent, "Serhildan"),1);
//                            }
//                        })
//                        .setNegativeButton("No",null);
//                AlertDialog  c = a.create();
//                c.show();
//
////                Toast.makeText(DetailActivity.this,"Successfully send email.",Toast.LENGTH_SHORT).show();
//            }
//        });
        binding.leftArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this,ResultActivity.class);
                startActivity(intent);
            }
        });
    }
}