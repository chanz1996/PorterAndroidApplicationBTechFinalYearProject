package com.example.sg0302356.porterapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private TextView UserRegistration;
    private TextView ForgotPassword;
    private int counter =5;

    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView) findViewById(R.id.tvInfo);
        Login = (Button) findViewById(R.id.btnLogin);
        UserRegistration = (TextView)findViewById(R.id.tvRegister);
        ForgotPassword = (TextView)findViewById(R.id.tvForgotPassword);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user != null)
        {
            finish();
            startActivity(new Intent(MainActivity.this, HomeActivity.class));

        }

        Info.setText("No. of Attempts Left: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });

        UserRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });

        ForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PasswordActivity.class));
            }
        });


    }

    private void validate(String userName, String userPassword)
    {
        progressDialog.setMessage("Validation in Progres");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(userName,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    checkEmailVerification();

                }
                else
                {
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this, "Login Unsuccesful",Toast.LENGTH_SHORT).show();
                    counter--;
                    Info.setText("No. of Attempts Left: "+ counter);
                    if(counter == 0)
                    {
                        Login.setEnabled(false);
                    }

                }
            }
        });
    }


    private void checkEmailVerification()
    {
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        Boolean emailflag = firebaseUser.isEmailVerified();

        if(emailflag)
        {
            finish();
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
        }
        else
        {
            Toast.makeText(this,"Verify your email",Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();
        }
    }
}
