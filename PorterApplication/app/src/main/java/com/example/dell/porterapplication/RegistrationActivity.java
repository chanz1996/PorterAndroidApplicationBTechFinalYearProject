package com.example.dell.porterapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    private EditText FirstName;
    private EditText LastName;
    private EditText Email;
    private EditText Password;
    private Button RegisterButton;
    private TextView Login;

    private String first_name,last_name, email, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirstName = (EditText)findViewById(R.id.etFirstName);
        LastName = (EditText)findViewById(R.id.etLastName);
        Email = (EditText)findViewById(R.id.etEmail);
        Password = (EditText)findViewById(R.id.etPassword);
        RegisterButton = (Button)findViewById(R.id.btnRegister);
        Login = (TextView) findViewById(R.id.tvLogin);
        super.onCreate(savedInstanceState);

        first_name = FirstName.getText().toString().trim();
        last_name = LastName.getText().toString().trim();
        email = Email.getText().toString().trim();
        password = Password.getText().toString().trim();

        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(first_name.isEmpty() || last_name.isEmpty() || email.isEmpty() || password.isEmpty())
                {
                    Toast.makeText(RegistrationActivity.this, "Please fill all the Details", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(RegistrationActivity.this, "Start Registration", Toast.LENGTH_SHORT).show();
                }
            }
        });

        setContentView(R.layout.activity_registration);
    }
}
