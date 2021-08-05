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

public class ResultThreeActivity extends AppCompatActivity {
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
                Intent crispIntent = new Intent(ResultThreeActivity.this, ChatActivity.class);
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
        list.add(new ResultTwoModel("We are hiring a Non Invasive cardiologist who can carry out a variety of tests to check the performance of a patient’s heart from pulmonary hypertension tests to biopsies.","Faridabad, Haryana"," MBBS/MD/DM/DNB","5","2","Non Invasive Cardiologist\n",R.drawable.cardiology));
        list.add(new ResultTwoModel("We are hiring a cardiologist specialist doctor who can treat patients with heart and cardiovascular problems.","Meerut, Uttar Pradesh"," MBBS/MD/DM/DNB","6","2","Urgent Hiring For Cardiologist Specialist Doctor",R.drawable.cardiology));
        list.add(new ResultTwoModel("We are hiring a Interventional cardiology doctor who works to determine the exact roles and responsibilities they take on."," Chennai, Tamil Nadu","MBBS/MD/DM/DNB","6","","Requirement Interventional Cardiology Doctor",R.drawable.cardiology));
        list.add(new ResultTwoModel("We are hiring a MD cardiology doctor who can maintain in-depth notes of every appointment with a patient so that a current record of every patient’s data can be consulted when necessary.","Meerut, Uttar Pradesh"," MBBS/MD/DM/DNB","5","","MD Cardiology Doctor",R.drawable.cardiology));
        list.add(new ResultTwoModel("We are hiring a cardiovascular technician doctor who can provide excellent inpatient and outpatient cardiovascular care as well as care coordination"," Dehradun, Uttarakhand"," MBBS/MD/DM/DNB","5","","Cardiovascular Technicianr",R.drawable.cardiology));
        list.add(new ResultTwoModel("We are looking for experienced cardiologist doctors who can perform various tests, make diagnosis, provide treatment, plans and options and work with other physicians and surgeons"," Darbhanga, Bihar"," MBBS/MD/DM/DNB","5","","Experienced Cardiologist Doctors",R.drawable.cardiology));

        ResultTwoAdapter adapter = new ResultTwoAdapter(list,this);
        binding.rv4.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.rv4.setLayoutManager(layoutManager);


    }}
