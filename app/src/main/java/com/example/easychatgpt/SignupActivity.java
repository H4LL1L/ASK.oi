package com.example.easychatgpt;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SignupActivity extends AppCompatActivity {

    EditText editTextEmail, editTextPassword;
    Button buttonReg;
    FirebaseAuth nAuth;
    TextView textView;
    ProgressBar progressBar;


    @Override
    public void onStart(){
        super.onStart();
        FirebaseUser currentUser = nAuth.getCurrentUser();
        if (currentUser !=null){

            Intent intent= new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();

        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        nAuth = FirebaseAuth.getInstance();
        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        buttonReg = findViewById(R.id.btn_register);
        progressBar = findViewById(R.id.progressBar3);
        textView = findViewById(R.id.loginNow);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                String email, password;
                email = String.valueOf(editTextEmail.getText());
                password = String.valueOf(editTextPassword.getText());
                
                if (TextUtils.isEmpty(email)) {
                Toast.makeText(SignupActivity.this, "Enter email", Toast.LENGTH_SHORT).show();
                return;
                 }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(SignupActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }


                nAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {

                                    Toast.makeText(
                                            SignupActivity.this, "Account created.",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                                    startActivity(intent);
                                    finish();


                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(
                                            SignupActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        }); {

                }
            }
        });


    }
}
