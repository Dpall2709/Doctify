package com.example.doctify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.doctify.Models.Users;
import com.example.doctify.databinding.ActivitySignUpEmployerBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpEmployer extends AppCompatActivity {
    ActivitySignUpEmployerBinding binding;
    ProgressDialog progressDialog;
    FirebaseAuth auth;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpEmployerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        progressDialog = new ProgressDialog(SignUpEmployer.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("We are creating your account");
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();


        binding.signUpEmpArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpEmployer.this, MainActivity.class);
                startActivity(intent);
            }
        });
        binding.signUpEmpLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpEmployer.this,MainActivity.class);
                startActivity(intent);
            }
        });

        binding.signUpEmpCand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpEmployer.this,SignUpCandidate.class);
                startActivity(intent);
            }
        });
        binding.btnEmpSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                auth.createUserWithEmailAndPassword(binding.signUpEmpEmail.getText().toString(),binding.signUpEmpPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                            Users users = new Users(binding.signUpEmpUser.getText().toString(),binding.signUpEmpEmail.getText().toString(),binding.signUpEmpPassword.getText().toString(),
                                    binding.signUpEmpNumber.getText().toString(),binding.signUpEmpOrName.getText().toString(),binding.signUpEmpReq.getText().toString());
                            String id = task.getResult().getUser().getUid();
                            database.getReference().child("Emp").child(id).setValue(users);
                            if (task.isSuccessful()){
                                auth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()){

                                            Intent intent = new Intent(SignUpEmployer.this,MainActivity.class);
                                            startActivity(intent);
                                            Toast.makeText(SignUpEmployer.this,"User Created Successfully, plz verify email account",Toast.LENGTH_SHORT).show();

                                        }else{
                                            Toast.makeText(SignUpEmployer.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                                        }

                                    }
                                });
                            }


                        }else {
                            Toast.makeText(SignUpEmployer.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });
    }
}