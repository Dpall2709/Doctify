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

public class ResultFourActivity extends AppCompatActivity {
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
                Intent crispIntent = new Intent(ResultFourActivity.this, ChatActivity.class);
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
        list.add(new ResultTwoModel("A radiologist able to use medical imaging technologies such as x-ray, CT-scan, and MRI and successfully execute and interpret the medical images in order to aid the diagnostic and treatment process.","Farrukhabad, Uttar Pradesh","MBBS/MD/MDRD/DNB","5","2","Consultant/Senior Consultant- Radiologist",R.drawable.radiolodgy));
        list.add(new ResultTwoModel("We are hiring radiologists who can perform a variety of diagnostic procedures that as x – rays, MRIs, CT – scanners, and ultrasounds to diagnose illnesses and injuries."," Madhubani, Bihar","MBBS/MD/MDRD/DNB","5","2","Vacancy for Female Radiologist Doctor",R.drawable.radiolodgy));
        list.add(new ResultTwoModel("We are hiring radiologists who can use medical imaging technology to diagnose and treat illnesses and injuries, should have to perform many tasks of diagnosing and treating illness"," Chennai, Tamil Nadu","MBBS/MD/MDRD/DNB","6","2","Vacancy for Male Radiologist Doctor",R.drawable.radiolodgy));
        list.add(new ResultTwoModel("We are looking for an experienced radiologist to join our team. As a radiologist, at our clinic, you will work with other talented physicians at a radiology department.","Lucknow, Uttar Pradesh","MBBS/MD/MDRD/DNB","5","2","New Radiology Physicians job",R.drawable.radiolodgy));
        list.add(new ResultTwoModel(" We are hiring radiologists who can perform and interpret the outcomes of diagnostic imaging procedures and coordinate radio-logical service with other medical activities."," Greater Noida, Uttar Pradesh","MBBS/MD/MDRD/DNB","6","2","New Opening of MD Radiologist Doctor",R.drawable.radiolodgy));
        list.add(new ResultTwoModel("We are hiring experienced radiologists who are specialized in executing and interpreting medical images such as x-ray, CT-Scan, ultrasounds, and MRIs.","Patna, Bihar","MBBS/MD/MDRD/DNB","6","2","Required Specialist Radiologist Doctor",R.drawable.radiolodgy));
        list.add(new ResultTwoModel("Looking for a radiologist doctor who can perform diagnostic procedures on patients. Should also be able to evaluate the medical history to ensure tests will not cause harm.","Meerut, Uttar Pradesh","MBBS/MD/MDRD/DNB","5","2","Vacancy for Radiologist Technician Doctor",R.drawable.radiolodgy));
        ResultTwoAdapter adapter = new ResultTwoAdapter(list,this);
        binding.rv4.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.rv4.setLayoutManager(layoutManager);


    }}