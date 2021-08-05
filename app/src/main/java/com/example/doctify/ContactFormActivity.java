package com.example.doctify;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Toast;

import com.example.doctify.databinding.ActivityContactFormBinding;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ContactFormActivity extends AppCompatActivity {
    ActivityContactFormBinding binding;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContactFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
     progressDialog = new ProgressDialog(ContactFormActivity.this);
    progressDialog.setTitle("Wait");
        progressDialog.setMessage("We are sending your detail");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);



        binding.sendEmailContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ContactFormActivity.this,"Please wait while we sending your Data",Toast.LENGTH_SHORT).show();
                final String username = "deepak9771119@gmail.com";
                final String password = "Deepak@2709";
                String Specility = getIntent().getStringExtra("Specli");
                String subject = "Apply for " + Specility;
                String firstName = binding.firstNameContact.getText().toString();
                String lastName = binding.lstNameContact.getText().toString();
                String phone = binding.phoneContact.getText().toString();
                String emailU = binding .emailContact.getText().toString();
                String messageToSend = "Name-: " + firstName + " "+ lastName + "\nEmail id-: " + emailU + "\nPhone Number-: "+ phone;
                String ToEmail = "dk416148@gmail.com";

                Properties props = new Properties();
                props.put("mail.smtp.auth","true");
                props.put("mail.smtp.starttls.enable","true");
                props.put("mail.smtp.host","smtp.gmail.com");
                props.put("mail.smtp.port","587");
                Session session = Session.getInstance(props,new javax.mail.Authenticator(){
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {

                        return new PasswordAuthentication(username,password);
                    }
                });


                try {

                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(username));
                    message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(ToEmail));
                
                    message.setSubject(subject);
                    message.setText(messageToSend);

                    Transport.send(message);


                    Toast.makeText(getApplicationContext(),"Detail Sent",Toast.LENGTH_SHORT).show();


                }catch (MessagingException e){

                    throw new RuntimeException(e);
                }
                binding.emailContact.setText("");
                binding.phoneContact.setText("");
                binding.firstNameContact.setText("");
                binding.lstNameContact.setText("");

            }
        });


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


    }
}