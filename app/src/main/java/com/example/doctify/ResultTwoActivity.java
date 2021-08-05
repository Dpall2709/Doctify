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

public class ResultTwoActivity extends AppCompatActivity {
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
                Intent crispIntent = new Intent(ResultTwoActivity.this, ChatActivity.class);
                startActivity(crispIntent);
            }
        });


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
        list.add(new ResultTwoModel("We are hiring a neurologist doctor who can communicate with lenses and other medical staff to ensure patients receive best possible care"," Mumbai, Maharashtra","MBBS/MD/DM/DNB","5","2","Vacancy For Neurologist Doctors",R.drawable.neurology));
        list.add(new ResultTwoModel("We are hiring a neurologist for the treatment of disorders of the nervous system.Also needed to work in hospitals to treat patients or for conducting records."," New Delhi, Delhi","MBBS/MD/DM/DNB","5","2","Hiring A Specialist Neurologist Doctors",R.drawable.neurology));
        list.add(new ResultTwoModel("We are hiring a neurologist who specializes in illness and dysfunction of the nervous system.hould also be able to treat disorders of the other sense organs such as skin, eyes, ears, etc.","Kolkata, West Bengal","MBBS/MD/DM/DNB","5","2","Requirement of MD Neurology Doctor",R.drawable.neurology));
        list.add(new ResultTwoModel("We are hiring a neurologist doctor who can develop treatment plans and manage to adapt treatment of patients depending on progress.","Agra, Uttar Pradesh","MBBS/MD/DM/DNB","5","2","Urgent Hiring For Neurologist Doctor",R.drawable.neurology));
        list.add(new ResultTwoModel("We are hiring a neurologist who can perform physical and neurological examinations of patients who are suffering from neurological disorders"," Ahmedabad, Gujrat","MBBS/MD/DM/DNB","5","2","Neurologist Jobs In Hospital & Clinics",R.drawable.neurology));
        list.add(new ResultTwoModel("We are hiring a neurologist who can diagnose complex medical problems by recognizing the patient’s history and performing various tests","Meerut, Uttar Pradesh","MBBS/MD/DM/DNB","6","2","Vacancy For Female Neurologist Doctor",R.drawable.neurology));
        list.add(new ResultTwoModel("We are looking to hire a neurologist who can perform specialized treatment such as sleep disorders, neuro immunology, neuro oncology, behavioral neurology and neuro genetics","Ghaziabad, Uttar Pradesh","MBBS/MD/DM/DNB","6","2","Vacancy For Neurologist Physician Doctor",R.drawable.neurology));
        ResultTwoAdapter adapter = new ResultTwoAdapter(list,this);
        binding.rv4.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.rv4.setLayoutManager(layoutManager);


    }}
