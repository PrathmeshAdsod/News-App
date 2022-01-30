package com.prathmeshadsod.thehindustanprime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.prathmeshadsod.thehindustanprime.UserData.User_Login;

public class FlashScreen extends AppCompatActivity {

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_screen);

        /*
         We are doing to check if user is already logged in
         If he is already logged in user will have value
         If not log in then user will have value null
         So we will give them intent accordingly
        */

        auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();


     //   getSupportActionBar().hide();         /* Hide the Toolbar */

        Thread thread = new Thread() {

            public void run() {
                try{
                    sleep(3000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                finally {

                    // Checking if user is already logged in

                    if(user != null) {
                        startActivity(new Intent(FlashScreen.this , MainActivity.class));
                        finish();
                    }else {
                        startActivity(new Intent(FlashScreen.this , User_Login.class));
                        finish();
                    }

                }
            }

        };
        thread.start();

    }
}