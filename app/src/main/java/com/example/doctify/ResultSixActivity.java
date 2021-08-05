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

public class ResultSixActivity extends AppCompatActivity {
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
                Intent crispIntent = new Intent(ResultSixActivity.this, ChatActivity.class);
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
        list.add(new ResultTwoModel("We are looking for Auxiliary nurse-midwifery (ANM), which take care of patients, take clinical rounds to each patient, diagnose and treat patients."," Mumbai, Maharashtra","B Sc. Nursing/","0.6","2","ANM Nursing Job",R.drawable.nurse));
        list.add(new ResultTwoModel("We are looking to employ a Staff Nurse, which provide proper diet plan and primary healthcare and take care of patients, take pro per round to each patients twice a week.","Ahmedabad, Gujrat","B.Sc. and M.Sc","0.6","2","Vacancy for fresher Staff Nurse\n",R.drawable.nurse));
        list.add(new ResultTwoModel("We are looking for Nurse supervisor/staff nurse, which take care of patients, provide primary treatment, take clinical round to each patients, to diagnose and treat patients."," Ahmedabad, Gujrat","B.Sc. Nursing/GNM","0.7","2","Staff Nurse Supervisor Job",R.drawable.nurse));
        list.add(new ResultTwoModel("We are looking for General nurse and midwifery(GNM), which take care of patients, take clinical rounds to each patient, diagnose and treat patients, provide information to the patien.","Chennai, Tamil Nadu","B.Sc. Nursing/GNM","0.6","2","GNM Nurse Job",R.drawable.nurse));
        list.add(new ResultTwoModel("We are looking for staff nurse, which take care of patients, take clinical round to each patients, to diagnose and treat patients.","Ghaziabad, Uttar Pradesh","B.Sc.Nursing/GNM","0.6","2","Staff Nurse Job",R.drawable.nurse));
        list.add(new ResultTwoModel("We are looking to employ Occupational Therapist, which provide primary healthcare and take care of patients as need, take pro per round to each patient twice a week.","Jaipur, Rajasthan","B.Sc. Nursing/GNM","0.6","2","Occupational Therapist Job",R.drawable.nurse));
        list.add(new ResultTwoModel("We are looking for a Casualty staff nurse, which takes care of patients, takes clinical rounds to each patient, diagnoses and treats patients.","Patna, Bihar","B.Sc.Nursing/GNM","0.6","2","Casualty Staff Nurse Jobs",R.drawable.nurse));
        ResultTwoAdapter adapter = new ResultTwoAdapter(list,this);
        binding.rv4.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.rv4.setLayoutManager(layoutManager);


    }}