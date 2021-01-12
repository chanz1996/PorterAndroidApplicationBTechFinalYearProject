package com.example.dell.porterapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class UserProfileActivity extends AppCompatActivity {

    private Button GoHome;
    @Override
    public void  onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tripsmenu);
        GoHome = findViewById(R.id.GoHome);
        GoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserProfileActivity.this,PorterHomeActivity.class);
                startActivity(intent);
            }
        });


    }

}
