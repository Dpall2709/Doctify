package com.example.doctify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.doctify.Adapters.ResultTwoAdapter;
import com.example.doctify.Models.ResultTwoModel;
import com.example.doctify.databinding.ActivityResultTwoBinding;

import java.util.ArrayList;

import im.crisp.client.ChatActivity;
import im.crisp.client.Crisp;

public class ResultElevenActivity extends AppCompatActivity {
    ActivityResultTwoBinding binding;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultTwoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

//        image = findViewById(R.id.iv2);
        binding.chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Crisp.configure(getApplicationContext(), "f27fdec0-75a9-4f4d-97d8-a6c2f96c937d");
                Intent crispIntent = new Intent(ResultElevenActivity.this, ChatActivity.class);
                startActivity(crispIntent);
            }
        });

//
//        image.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//
//                PopupMenu popupMenu = new PopupMenu(getApplicationContext(),image);
//                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
//                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem item) {
//                        switch (item.getItemId()){
//                            case R.id.menu_home:
//                                Toast.makeText(getApplicationContext(),"This is Home Menu",Toast.LENGTH_SHORT).show();
//                                return true;
//                            case R.id.menu_call:
//                                Toast.makeText(getApplicationContext(),"This is call Menu",Toast.LENGTH_SHORT).show();
//                                return true;
//                            case R.id.menu_setting:
//                                Toast.makeText(getApplicationContext(),"This is setting Menu",Toast.LENGTH_SHORT).show();
//                                return true;
//
//                        }
//                        return false;
//                    }
//                });
//                popupMenu.show();
//                return false;
//            }
//        });
        String name = getIntent().getStringExtra("name");

        binding.resulthead.setText(name);

        ArrayList<ResultTwoModel> list = new ArrayList<>();
        list.add(new ResultTwoModel("We look to appoint a dedicated and experienced Ophthalmology to care the conditions in patients.","Buxar","Master Degree","1","2","Ophthalmology Senior Resident Job",R.drawable.ophthalmology));
        list.add(new ResultTwoModel("We look to appoint a dedicated and experienced Ophthalmology to care the conditions in patients.","Agra","Master Degree","3","2","Senior Consultant Ophthalmologist Doctor",R.drawable.ophthalmology));
        list.add(new ResultTwoModel("We look to appoint a dedicated and experienced Ophthalmology to care the conditions in patients.","Patna","Master Degree","3","2","Retina Surgeon Ophthalmologist Doctor",R.drawable.ophthalmology));
        list.add(new ResultTwoModel("We look to appoint a dedicated and experienced Ophthalmology to care the conditions in patients.","Delhi","Master Degree","2","2","General Ophthalmologist Jobs",R.drawable.ophthalmology));
        list.add(new ResultTwoModel("We look to appoint a dedicated and experienced Ophthalmology to care the conditions in patients.","Indore","Master Degree","1","2","Female Ophthalmologist Doctor",R.drawable.ophthalmology));
        list.add(new ResultTwoModel("We look to appoint a dedicated and experienced Ophthalmology to care the conditions in patients.","Indore","Master Degree","1","2","Ophthalmologist Job Vacancy In Multispecialty Hospital",R.drawable.ophthalmology));
        list.add(new ResultTwoModel("We look to appoint a dedicated and experienced Ophthalmology to care the conditions in patients.","Noida","Master Degree","1","2","Hiring of Ophthalmologist Doctor",R.drawable.ophthalmology));
        ResultTwoAdapter adapter = new ResultTwoAdapter(list,this);
        binding.rv4.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.rv4.setLayoutManager(layoutManager);


    }}