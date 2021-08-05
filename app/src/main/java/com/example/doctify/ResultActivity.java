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

import com.example.doctify.Adapters.searchAdapter;
import com.example.doctify.Models.SearchModel;
import com.example.doctify.databinding.ActivityResultBinding;

import java.util.ArrayList;

import im.crisp.client.ChatActivity;
import im.crisp.client.Crisp;

public class ResultActivity extends AppCompatActivity {
    ActivityResultBinding binding;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

//        image = findViewById(R.id.iv2);
        binding.chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Crisp.configure(getApplicationContext(), "f27fdec0-75a9-4f4d-97d8-a6c2f96c937d");
                Intent crispIntent = new Intent(ResultActivity.this, ChatActivity.class);
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


        ArrayList<SearchModel> list = new ArrayList<>();
        list.add(new SearchModel("We look to appoint a dedicated and experienced gynecologist to diagnose and treat gynecological conditions in patients.","Chennai, Tamil Nadu","MBBS/DGO/DNB/MS/MD","3","","Recruitment IVF Gynaecologist Doctor",R.drawable.ganaecologist));
        list.add(new SearchModel("We are looking for an experienced gynaecologist to treat and diagnose patients. We need a full-time gynaecologist need to attend all emergencies.","Darbhanga, Bihar","MBBS/DGO/DNB/MS/MD","4","1","Consultant Gynaecologist – IVF Doctor",R.drawable.ganaecologist));
        list.add(new SearchModel("We are hiring gynaecologists who should demonstrate excellent problem-solving skills and ensure that doctor-patient confidentiality is maintained."," Buxar, Bihar","MBBS/DGO/DNB/MS/MD","4","5","Urgent New Opening For Gynaecologist",R.drawable.ganaecologist));
        list.add(new SearchModel("OB Gynaecologist has a job opening 100-bed multi-speciality hospital. The candidate should be well versed in all aspects of Gynaecologist work.","Samastipur, Bihar","MBBS/DGO/DNB/MS/MD","1.5","2","OBS Gynaecologist Job for Super Speciality Hospita",R.drawable.ganaecologist));
        list.add(new SearchModel("gynaecologist who can help and provide a calm presence for patients in distress and should be able to discuss sensitive information with the patient and family."," Patna, Bihar","MBBS/DGO/DNB/MS/MD","3","2","Required Female Gynaecologist Doctor",R.drawable.ganaecologist));
        list.add(new SearchModel("We are looking for  gynecologist who can help and improve patients’ health by providing excellent care and advice and having excellent verbal and written communication","Noida, Uttar Pradesh","MBBS/DGO/DNB/MS/MD","3","2","Requirement of Gynaecologist Doctor For Multi-Speciality Hospital",R.drawable.ganaecologist));
        list.add(new SearchModel("Need a good gynecologist who can take care and treat gynecological patients with proper guidance and supervision","Bangalore, Karnataka","MBBS/DGO/DNB/MS/MD","4","2","Gynaecologist Consultant",R.drawable.ganaecologist));


       searchAdapter adapter = new searchAdapter(list,this);
        binding.rv4.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.rv4.setLayoutManager(layoutManager);



    }
}