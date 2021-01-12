package com.example.sg0302356.porterapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
   // private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        firebaseAuth = FirebaseAuth.getInstance();
       /* logout = (Button)findViewById(R.id.btnLogout);
         logout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
               Logout();
             }
         });*/

    }

    private void Logout()
    {
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(HomeActivity.this, MainActivity.class));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.logoutMenu: Logout();
        }
        return super.onOptionsItemSelected(item);
    }
}
