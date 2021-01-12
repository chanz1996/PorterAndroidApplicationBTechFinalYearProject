package com.example.dell.porterapplication;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    DatabaseHelper dbHelper;

    private EditText Email;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private TextView UserRegistration;
    private TextView ForgotPassword;
    private int counter =5;

    Cursor cursor;
    private ProgressDialog progressDialog;

    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbHelper = new DatabaseHelper(this);
        db = dbHelper.getWritableDatabase();

        Email = (EditText)findViewById(R.id.etEmail);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView) findViewById(R.id.tvInfo);
        Login = (Button) findViewById(R.id.btnLogin);
        UserRegistration = (TextView)findViewById(R.id.tvRegister);
        ForgotPassword = (TextView)findViewById(R.id.tvForgotPassword);

        progressDialog = new ProgressDialog(this);

        Info.setText("No. of Attempts Left: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String EmailText = Email.getText().toString().trim();
                String PasswordText = Password.getText().toString().trim();

                if(EmailText.isEmpty() || PasswordText.isEmpty())
                {
                    Toast.makeText(LoginActivity.this, "Please Enter all the Details", Toast.LENGTH_SHORT).show();
                }
                else {
                    validate(EmailText, PasswordText);
                }
            }
        });

        UserRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisteringActivity.class);
                startActivity(intent);
            }
        });
    }

    private void validate(String userEmail, String userPassword)
    {
        progressDialog.setMessage("Validation in Progres");
        progressDialog.show();

        cursor = db.rawQuery("SELECT *FROM "+DatabaseHelper.User_Table+" WHERE "+DatabaseHelper.User_Email+"=? AND "+DatabaseHelper.User_Password+"=?",new String[] {userEmail,userPassword});

        if (cursor != null) {
            if (cursor.getCount() > 0) {

                cursor.moveToFirst();
                progressDialog.dismiss();
                Integer User_Id = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.User_Id));
                Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, PorterHomeActivity.class);
                intent.putExtra("User_Id", User_Id);
                startActivity(intent);

                //Removing LoginActivity[Login Screen] from the stack for preventing back button press.
                finish();
            } else {
                progressDialog.dismiss();
                Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                counter--;
                Info.setText("No. of Attempts Left: " + counter);
                if (counter == 0) {
                    Login.setEnabled(false);
                }

            }
        }
        else
        {
            Toast.makeText(LoginActivity.this, "Dammit", Toast.LENGTH_SHORT).show();
        }

    }
}

