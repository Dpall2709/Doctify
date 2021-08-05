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

public class ResultTenActivity extends AppCompatActivity {
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
                Intent crispIntent = new Intent(ResultTenActivity.this, ChatActivity.class);
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
        list.add(new ResultTwoModel("We are hiring a doctor in MD in medicine who can evaluate patients and provide appropriate medical treatment for various illnesses and injuries."," Meerut, Uttar Pradesh","MBBS/MD Medicine","1.5","2","MD Community Medicine Job",R.drawable.pharmacy));
        list.add(new ResultTwoModel("We are hiring Doctors of MD in medicines, who can see patients who are not ill or injured but who are seeking to maintain their current level of health","Pune, Maharashtra","MBBS/MD Medicine","3","2","Requirement of MD Medicine Doctor",R.drawable.pharmacy));
        list.add(new ResultTwoModel("We are hiring a doctor in MD in medicine who can prescribe, administer and dispense medication in accordance with state and federal statutes.","Patna, Bihar","MBBS/MD Medicine","4","2","Hiring of MD Medicine Doctor",R.drawable.pharmacy));
        list.add(new ResultTwoModel("We are hiring M.D. in medical doctors to treat those admitted or referred to the hospital.","Kolkata, West Bengal","MBBS/MD Medicine","4","2","MD General Medicine Specialist Job",R.drawable.pharmacy));
        list.add(new ResultTwoModel("We are hiring a MD required doctor, who has a current state medical licence as well as board certification in emergency medicine or family medicine assets.", "Mumbai, Maharashtra","MBBS/MD Medicine","4","2","Specialists Doctor of MD Medicine",R.drawable.pharmacy));
        list.add(new ResultTwoModel("We are hiring MD in medical hospital doctors who can diagnose and treat medical conditions, disorders and diseases through the application of specialist medical skills and knowledge.","Chennai, Tamil Nadu","MBBS/MD Medicine","5","2","MD Physician",R.drawable.pharmacy));
        list.add(new ResultTwoModel("We are looking to hire a doctor with outstanding medical and excellent skills. Doctors need to be very passionate, have attentive listening skills","Meerut, Uttar Pradesh","MBBS/MD Medicine","3.5","2","Internal Medicine MD",R.drawable.pharmacy));
        ResultTwoAdapter adapter = new ResultTwoAdapter(list,this);
        binding.rv4.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.rv4.setLayoutManager(layoutManager);


    }}