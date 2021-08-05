package com.example.doctify;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.doctify.databinding.ActivityRequrimentFormBinding;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class RequriementFormActivity extends AppCompatActivity {
    ActivityRequrimentFormBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRequrimentFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        Spinner mySpinner = (Spinner)findViewById(R.id.spinner);
        String[] items = {"Doctors Hiring","Nurses Hiring","Staff Hiring","Custom Hiring request"};
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,items);
        mySpinner.setAdapter(arrayAdapter);



        binding.signUpEmpArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RequriementFormActivity.this,EmpActivity.class);
                startActivity(intent);
            }
        });

        binding.reqSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(RequriementFormActivity.this,"Please wait while we sending your Data",Toast.LENGTH_SHORT).show();
                final String username1 = "deepak9771119@gmail.com";
                final String password1 = "Deepak@2709";
                String sub = getIntent().getStringExtra("drSpec");
                String subject = "Apply for " + sub;
                String categories = binding.spinner.getSelectedItem().toString();
                String org = binding.orgName.getText().toString();
                String loc = binding.locationName.getText().toString();
//                String pos = binding.postionName.getText().toString();
                String sal = binding.salary.getText().toString();
                String other = binding.otherReq.getText().toString();
                String conatct = binding.orgContact.getText().toString();
                String emailid = binding.orgEmail.getText().toString();
                String all = "Categories: "+(categories)+"\n"+"Organization: "+(org)+"\n"+"Contact Number: "+(conatct)+"\n"+"Email id: "+(emailid)+"\n"+"Location: "+(loc)+"\n"+"\n"+"Salary: "+(sal)+"\n"+"Other Requirement: "+(other);
                String ToEmail = "dk416148@gmail.com";
                Properties properties = new Properties();
                properties.put("mail.smtp.auth","true");
                properties.put("mail.smtp.starttls.enable","true");
                properties.put("mail.smtp.host","smtp.gmail.com");
                properties.put("mail.smtp.port","587");

                Session session1 = Session.getInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username1,password1);
                    }
                });
                try {
                    Message message = new MimeMessage(session1);
                    message.setFrom(new InternetAddress(username1));
                    message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(ToEmail));

                    message.setSubject(subject);
                    message.setText(all);

                    Transport.send(message);


                    Toast.makeText(getApplicationContext(),"Detail Sent",Toast.LENGTH_SHORT).show();

                }catch (MessagingException e){

                    throw new RuntimeException(e);
                }
                binding.orgName.setText("");
                binding.locationName.setText("");
                binding.locationName.setText("");
//                binding.postionName.setText("");
                binding.salary.setText("");
                binding.otherReq.setText("");
                binding.orgContact.setText("");
                binding.orgEmail.setText("");


            }
        });
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
}