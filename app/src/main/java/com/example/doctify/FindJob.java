package com.example.doctify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doctify.Adapters.LatestAdapter;
import com.example.doctify.Adapters.MainAdapter;
import com.example.doctify.Models.LatestModel;
import com.example.doctify.Models.MainModel;
import com.example.doctify.Models.Users;
import com.example.doctify.databinding.ActivityFindJobBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import im.crisp.client.ChatActivity;
import im.crisp.client.Crisp;

public class FindJob extends AppCompatActivity {
    ActivityFindJobBinding binding;
    ImageView image;
    TextView nameGet;
    FirebaseDatabase database;
    FirebaseAuth auth;
    FirebaseUser user;
    CharSequence search ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFindJobBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
//        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
//         image = findViewById(R.id.ivImage);
         nameGet = (TextView)findViewById(R.id.getName);

        user = FirebaseAuth.getInstance().getCurrentUser();
        nameGet.setText(user.getDisplayName());

        binding.chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Crisp.configure(getApplicationContext(), "f27fdec0-75a9-4f4d-97d8-a6c2f96c937d");
                Intent crispIntent = new Intent(FindJob.this, ChatActivity.class);
                startActivity(crispIntent);

            }
        });

//         image.setOnLongClickListener(new View.OnLongClickListener() {
//             @Override
//             public boolean onLongClick(View v) {
//
//                 PopupMenu popupMenu = new PopupMenu(getApplicationContext(),image);
//                 popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
//                 popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                     @Override
//                     public boolean onMenuItemClick(MenuItem item) {
//                         switch (item.getItemId()){
//                             case R.id.menu_home:
//                                 Toast.makeText(getApplicationContext(),"This is Home Menu",Toast.LENGTH_SHORT).show();
//                                 return true;
//                             case R.id.menu_call:
//                                 Toast.makeText(getApplicationContext(),"This is call Menu",Toast.LENGTH_SHORT).show();
//                                 return true;
//                             case R.id.menu_setting:
//                                 Toast.makeText(getApplicationContext(),"This is setting Menu",Toast.LENGTH_SHORT).show();
//                                 return true;
//
//                         }
//                         return false;
//                     }
//                 });
//                 popupMenu.show();
//                 return false;
//             }
//         });




        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.ganaecologist,"Gynaecology"));
        list.add(new MainModel(R.drawable.neurology,"Neurology"));
        list.add(new MainModel(R.drawable.cardiology,"Cardiology"));
        list.add(new MainModel(R.drawable.radiolodgy,"Radiology"));
        list.add(new MainModel(R.drawable.neonatology,"Neonatology"));
        list.add(new MainModel(R.drawable.nurse,"Nursing"));
        list.add(new MainModel(R.drawable.nephorology,"Nephrology"));
        list.add(new MainModel(R.drawable.cirtical_care,"Critical Care"));
        list.add(new MainModel(R.drawable.urology,"Urology"));
        list.add(new MainModel(R.drawable.pharmacy,"MD medicine"));
        list.add(new MainModel(R.drawable.ophthalmology,"Ophthalmology"));
        list.add(new MainModel(R.drawable.oncology,"Oncology"));
        list.add(new MainModel(R.drawable.physician,"General Surgery"));








        MainAdapter adapter = new MainAdapter(list,list,this);
        binding.rv1.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false);
        binding.rv1.setLayoutManager(layoutManager);



//        binding.searchBar.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                adapter.getFilter().filter(s);
//                search = s;
//
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });

        ArrayList<LatestModel> list1 = new ArrayList<>();
        list1.add(new LatestModel(R.drawable.apollo));
        list1.add(new LatestModel(R.drawable.max));
        list1.add(new LatestModel(R.drawable.aster));
        list1.add(new LatestModel(R.drawable.fortis));
        list1.add(new LatestModel(R.drawable.sarvoiday));
        list1.add(new LatestModel(R.drawable.parkhos));
        list1.add(new LatestModel(R.drawable.cribs));
        list1.add(new LatestModel(R.drawable.manipal));
        list1.add(new LatestModel(R.drawable.columbia));
        list1.add(new LatestModel(R.drawable.harinandani));




        LatestAdapter adapter1 = new LatestAdapter(list1,this);
        binding.rv2.setAdapter(adapter1);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        binding.rv2.setLayoutManager(layoutManager1);
    }

}