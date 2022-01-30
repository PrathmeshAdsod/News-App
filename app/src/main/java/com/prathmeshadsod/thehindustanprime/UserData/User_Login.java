package com.prathmeshadsod.thehindustanprime.UserData;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.prathmeshadsod.thehindustanprime.FlashScreen;
import com.prathmeshadsod.thehindustanprime.MainActivity;
import com.prathmeshadsod.thehindustanprime.R;

public class User_Login extends AppCompatActivity {

    FirebaseAuth auth;
    EditText login_email;
    EditText login_password;
    Button login_btn;
    TextView create_account;

    LottieAnimationView load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__login);

        login_email = findViewById(R.id.login_email);
        login_password = findViewById(R.id.login_password);
        login_btn = findViewById(R.id.login_btn);
        create_account = findViewById(R.id.create_account);
        load = findViewById(R.id.load);

        auth = FirebaseAuth.getInstance();

        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User_Login.this , SignUp.class);
                startActivity(intent);
            }
        });


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = login_email.getText().toString();
                String password = login_password.getText().toString();

                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    Toast.makeText(User_Login.this, "Please fill email and password", Toast.LENGTH_SHORT).show();
                }
                else {
              /*      */
                    load.setVisibility(View.VISIBLE);
                    load.playAnimation();

                    login(email , password);
                }

            }
        });




    }

    private void login(String email , String password) {
            auth.signInWithEmailAndPassword(email,password).addOnSuccessListener(User_Login.this, new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {

                    Thread thread = new Thread() {

                        public void run() {
                            try{
                                sleep(1000);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            finally {
                                Intent intent = new Intent(User_Login.this, MainActivity.class);
                                startActivity(intent);
                                finish();

                            }
                        }

                    };
                    thread.start();

                }
            });

            auth.signInWithEmailAndPassword(email,password).addOnFailureListener(User_Login.this, new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(User_Login.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });
    }
}