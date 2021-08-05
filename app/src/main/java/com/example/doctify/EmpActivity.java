package com.example.doctify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.doctify.Adapters.EmpAdapter;
import com.example.doctify.Adapters.EmpAdapterTwo;
import com.example.doctify.Models.EmpModel;
import com.example.doctify.Models.EmpModelTwo;
import com.example.doctify.databinding.ActivityEmpBinding;

import java.util.ArrayList;

import im.crisp.client.ChatActivity;
import im.crisp.client.Crisp;

public class EmpActivity extends AppCompatActivity {
    ActivityEmpBinding binding;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
//        image = findViewById(R.id.ivImage);


        ArrayList<EmpModel> list = new ArrayList<>();
        list.add(new EmpModel(R.drawable.ganaecologist,"Gynaecology"));
        list.add(new EmpModel(R.drawable.ganaecologist,"Gynaecology"));
        list.add(new EmpModel(R.drawable.ganaecologist,"Gynaecology"));
        list.add(new EmpModel(R.drawable.ganaecologist,"Gynaecology"));
        list.add(new EmpModel(R.drawable.ganaecologist,"Gynaecology"));
        list.add(new EmpModel(R.drawable.ganaecologist,"Gynaecology"));
        list.add(new EmpModel(R.drawable.ganaecologist,"Gynaecology"));
        list.add(new EmpModel(R.drawable.ganaecologist,"Gynaecology"));
        list.add(new EmpModel(R.drawable.ganaecologist,"Gynaecology"));
        list.add(new EmpModel(R.drawable.ganaecologist,"Gynaecology"));
        list.add(new EmpModel(R.drawable.ganaecologist,"Gynaecology"));
        list.add(new EmpModel(R.drawable.ganaecologist,"Gynaecology"));
        list.add(new EmpModel(R.drawable.ganaecologist,"Gynaecology"));
        list.add(new EmpModel(R.drawable.ganaecologist,"Gynaecology"));


//        EmpAdapter adapter = new EmpAdapter(list,this);
//        binding.rvEmp.setAdapter(adapter);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false);
//        binding.rvEmp.setLayoutManager(layoutManager);


        ArrayList<EmpModelTwo> list1 = new ArrayList<>();
        list1.add(new EmpModelTwo(R.drawable.ganaecologist,"Deepak Kumar","Gynaecology","Patna","Full Time","2 Year","4.2"));
        list1.add(new EmpModelTwo(R.drawable.neurology,"Rajeev Kumar","Neurology","Lakhisarai","Half Time","1 Year","4.6"));
        list1.add(new EmpModelTwo(R.drawable.cardiology,"Deepak Kumar","Cardiology","Patna","Full Time","2 Year","4.6"));
        list1.add(new EmpModelTwo(R.drawable.radiolodgy,"Deepak Kumar","Radiology","Patna","Full Time","2 Year","4.6"));
        list1.add(new EmpModelTwo(R.drawable.neonatology,"Deepak Kumar","Neonatology","Patna","Full Time","2 Year","4.6"));
        list1.add(new EmpModelTwo(R.drawable.nurse,"Deepak Kumar","Nursing","Patna","Full Time","2 Year","4.6"));
        list1.add(new EmpModelTwo(R.drawable.urology,"Deepak Kumar","Urology","Patna","Full Time","2 Year","4.6"));
        list1.add(new EmpModelTwo(R.drawable.pharmacy,"Deepak Kumar","MD Medicine","Patna","Full Time","2 Year","4.6"));
        list1.add(new EmpModelTwo(R.drawable.ophthalmology,"Deepak Kumar","Ophthalmology","Patna","Full Time","2 Year","4.6"));
        list1.add(new EmpModelTwo(R.drawable.oncology,"Deepak Kumar","Oncology","Patna","Full Time","2 Year","4.6"));
        list1.add(new EmpModelTwo(R.drawable.physician,"Deepak Kumar","General","Patna","Full Time","2 Year","4.6"));


        EmpAdapterTwo adapterTwo = new EmpAdapterTwo(list1,this);
        binding.empResRv.setAdapter(adapterTwo);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);
        binding.empResRv.setLayoutManager(layoutManager1);

        binding.chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Crisp.configure(getApplicationContext(), "f27fdec0-75a9-4f4d-97d8-a6c2f96c937d");
                Intent crispIntent = new Intent(EmpActivity.this, ChatActivity.class);
                startActivity(crispIntent);
            }
        });


//       image.setOnLongClickListener(new View.OnLongClickListener() {
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

    }
}