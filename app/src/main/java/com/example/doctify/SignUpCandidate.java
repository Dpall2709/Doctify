package com.example.doctify;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.doctify.Models.Users;
import com.example.doctify.databinding.ActivitySignUpCandidateBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class SignUpCandidate extends AppCompatActivity {
    ActivitySignUpCandidateBinding binding;
    private FirebaseAuth auth;
    FirebaseDatabase database;
    ProgressDialog progressDialog;
    FirebaseStorage storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpCandidateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        storage = FirebaseStorage.getInstance();

      progressDialog = new ProgressDialog(SignUpCandidate.this);
      progressDialog.setTitle("Creating Account");
      progressDialog.setMessage("We are creating your account");

        binding.signIpCanArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpCandidate.this,MainActivity.class);
                startActivity(intent);
            }
        });
        binding.empl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpCandidate.this,SignUpEmployer.class);
                startActivity(intent);
            }
        });
        binding.signUpCanLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(SignUpCandidate.this,MainActivity.class);
              startActivity(intent);
            }
        });

        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                auth.createUserWithEmailAndPassword(binding.signUpCanEmail.getText().toString(),binding.signUpCanPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()){
                            Users users = new Users(binding.signUpCanUser.getText().toString(),binding.signUpCanEmail.getText().toString(),binding.signUpCanPassword.getText().toString(),
                                    binding.signUpCanPhone.getText().toString());
                            String id = task.getResult().getUser().getUid();
                            database.getReference().child("Users").child(id).setValue(users);
                            registerUser();
                            auth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Intent intent = new Intent(SignUpCandidate.this,MainActivity.class);
                                        startActivity(intent);

                                        Toast.makeText(SignUpCandidate.this,"User Created Successfully, and please verify email account",Toast.LENGTH_SHORT).show();
                                    }else {
                                        Toast.makeText(SignUpCandidate.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });



                        }else {
                            Toast.makeText(SignUpCandidate.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                        }
                    }
                });

            }
        });

        binding.signUpCanUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                startActivityForResult(intent,33);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data.getData()!= null){
            Uri sFile = data.getData();
            final StorageReference reference = storage.getReference().child("resume").child(FirebaseAuth.getInstance().getUid());
            reference.putFile(sFile).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                   reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                       @Override
                       public void onSuccess(Uri uri) {
                           database.getReference().child("Users").child(FirebaseAuth.getInstance().getUid()).child("resume").setValue(uri.toString());
                       }
                   });

                }
            });
        }

    }

    public  void registerUser(){

    }

}