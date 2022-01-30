package com.prathmeshadsod.thehindustanprime.Menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.prathmeshadsod.thehindustanprime.R;
import com.prathmeshadsod.thehindustanprime.UserData.ReadingDataHelper;
import com.prathmeshadsod.thehindustanprime.UserData.User_Login;

public class Profile extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseDatabase database;
    Button logout_btn;
    TextView name_plain;
    TextView email_plain;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null); // Becoz toolbar is getting title by default
        /* For Backpress */
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        auth = FirebaseAuth.getInstance();

        logout_btn = findViewById(R.id.logout_btn);
        name_plain = findViewById(R.id.name_plain);
        email_plain = findViewById(R.id.email_plain);

       database = FirebaseDatabase.getInstance();
        database.getReference().child("User SignUp").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                 if(snapshot.exists()) {

                     for(DataSnapshot data : snapshot.getChildren()) {
                         try {
                             String name = data.child("name").getValue().toString();
                             String email = data.child("emailId").getValue().toString();
                             name_plain.setText(name);
                             email_plain.setText(email);
                         }catch (Exception e) {
                             e.printStackTrace();
                         }
                     }

                 }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // just one line of code to signout
                auth.signOut();

                Intent intent = new Intent(Profile.this , User_Login.class);
                startActivity(intent);
                finish();
            }
        });


    }


}