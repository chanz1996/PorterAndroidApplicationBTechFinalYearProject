package com.example.dell.porterapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisteringActivity extends AppCompatActivity {

    private EditText FirstName;
    private EditText LastName;
    private EditText Email;
    private EditText Password;
    private Button RegisterButton;
    private TextView Login;

    DatabaseHelper dbHelper;
    SQLiteDatabase db;


    private String first_name,last_name, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registering);

        dbHelper = new DatabaseHelper(this);
        db = dbHelper.getWritableDatabase();

        FirstName = (EditText)findViewById(R.id.etFirstName);
        LastName = (EditText)findViewById(R.id.etLastName);
        Email = (EditText)findViewById(R.id.etEmail);
        Password = (EditText)findViewById(R.id.etPassword);
        RegisterButton = (Button)findViewById(R.id.btnRegister);
        Login = (TextView) findViewById(R.id.tvLogin);


        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                first_name = FirstName.getText().toString().trim();
                last_name = LastName.getText().toString().trim();
                email = Email.getText().toString().trim();
                password = Password.getText().toString().trim();

                if(first_name.isEmpty() || last_name.isEmpty() || email.isEmpty() || password.isEmpty())
                {
                    Toast.makeText(RegisteringActivity.this, "Please Fill all the Details", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    populateDatabase();
                }

            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisteringActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });
    }

    public void populateDatabase()
    {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.User_First_Name,first_name);
        values.put(DatabaseHelper.User_Last_Name,last_name);
        values.put(DatabaseHelper.User_Email,email);
        values.put(DatabaseHelper.User_Password,password);
        long id = db.insert(DatabaseHelper.User_Table,null,values);
        if(id != -1)
        {
            Toast.makeText(this, "Succesfully Registered", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegisteringActivity.this, LoginActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Registration Failed", Toast.LENGTH_SHORT).show();
        }
    }
}
