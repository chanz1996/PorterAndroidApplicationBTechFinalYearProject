/*
package com.example.dell.porterapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    Integer UserId;
    Intent intent;
    private TextView WelcomeInfo;
    private Button Logout;
    String Email;
    Cursor cursor;

    DatabaseHelper dbHelper;
    SQLiteDatabase db;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        dbHelper = new DatabaseHelper(this);
        db = dbHelper.getWritableDatabase();

        intent = getIntent();
        UserId = intent.getIntExtra("User_Id",-1);
        WelcomeInfo = (TextView)findViewById(R.id.tvWelcome);

        setContent();

        Logout = (Button)findViewById(R.id.btnLogout);

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(HomeActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;

            case R.id.logoutMenu: {
                finish();
                Intent intent = new Intent(HomeActivity.this,MainActivity.class);
                startActivity(intent);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public void setContent()
    {
        cursor = db.rawQuery("SELECT "+DatabaseHelper.User_Email+" FROM "+DatabaseHelper.User_Table+" WHERE "+DatabaseHelper.User_Id+" = "+UserId,null);
        if(cursor != null)
        {
            if(cursor.getCount()>0)
            {
                cursor.moveToFirst();
                String Email = cursor.getString(0);
                WelcomeInfo.setText("Welcome "+Email);
            }
            else
            {
                Toast.makeText(HomeActivity.this, "Email Fetch Failed", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(HomeActivity.this, "Cursor is Null", Toast.LENGTH_SHORT).show();
        }

    }

}
*/