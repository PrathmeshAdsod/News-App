package com.prathmeshadsod.thehindustanprime.UserData;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.google.firebase.database.FirebaseDatabase;
import com.prathmeshadsod.thehindustanprime.MainActivity;
import com.prathmeshadsod.thehindustanprime.R;

import java.util.HashMap;

public class SignUp extends AppCompatActivity {

    private FirebaseAuth auth;
    private FirebaseDatabase database;
    EditText user_email;
    EditText user_password;
    EditText user_name;
    Button signup;
    TextView login_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();

        user_email = findViewById(R.id.user_email);
        user_password = findViewById(R.id.user_password);
        signup = findViewById(R.id.signup);
        user_name = findViewById(R.id.user_name);
        login_account = findViewById(R.id.login_account);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String email =  user_email.getText().toString();
                 String password = user_password.getText().toString();
                 String name = user_name.getText().toString();

                 if(name.isEmpty() || email.isEmpty()) {
                     Toast.makeText(SignUp.this, "Please fill name and email correctly", Toast.LENGTH_SHORT).show();
                 }
                 else if(password.isEmpty() || password.length() < 6) {
                     Toast.makeText(SignUp.this, "Password must be more than 8 characters", Toast.LENGTH_SHORT).show();
                 }
                 // Sign Up of user and sending his/her data on Firebase Realtime database
                 else {

                     // Adding Data to Firebase of User Using Realtime Database

                     HashMap<String , Object> map = new HashMap<>();
                     map.put("name" , user_name.getText().toString());
                     map.put("emailId" , user_email.getText().toString());

                     database = FirebaseDatabase.getInstance();
                     database.getReference().child("User SignUp").push().setValue(map);

                     Register(email, password);

                 }
            }
        });



        login_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this , User_Login.class);
                startActivity(intent);
            }
        });




    }

    private void Register(String email , String password) {
         auth.createUserWithEmailAndPassword(email , password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
             @Override
             public void onComplete(@NonNull Task<AuthResult> task) {

                 if(task.isSuccessful()) {
                     Toast.makeText(SignUp.this, "Registration Successfull", Toast.LENGTH_SHORT).show();

                     Intent intent = new Intent(SignUp.this , MainActivity.class);
                     startActivity(intent);

                     finish();  // Finishing the activity
                 }
                 else {
                     Toast.makeText(SignUp.this, "Something Went Wrong here !", Toast.LENGTH_SHORT).show();
                 }

             }
         });
    }

}