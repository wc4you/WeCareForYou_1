package com.iabug.wecareforyou;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {


//    private Button reset_password;

    private Button sign_in_details_button;//,reset_password_button;
    private TextView signuptext,forgottext;
    private EditText email_TV, password_TV;
    private FirebaseAuth auth;
    SharedPreferences savelogin;

    @Override


    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();
        email_TV = (EditText) findViewById(R.id.loginemailidInput);
        password_TV = (EditText) findViewById(R.id.logininpasswordInput);
        signuptext = (TextView) findViewById(R.id.loginbottomtext);
        sign_in_details_button = (Button) findViewById(R.id.LoginButton);
        forgottext = (TextView) findViewById(R.id .forgotpasswordtext) ;
//        reset_password = (Button) findViewById(R.id.reset_password);


        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();
        savelogin = getSharedPreferences("login", MODE_PRIVATE);
        if(savelogin.getBoolean("logged",false)){
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
        }

        signuptext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });
        forgottext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ResetpasswordActivity.class));
            }
        });
//
//        reset_password.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(SignInActivity.this, ResetPasswordActivity.class));
//            }
//        });

        sign_in_details_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email_TV.getText().toString();
                final String password = password_TV.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                //authenticate user

                    auth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    // If sign in fails, display a message to the user. If sign in succeeds
                                    // the auth state listener will be notified and logic to handle the
                                    // signed in user can be handled in the listener.
                                    if (!task.isSuccessful()) {
                                        // there was an error
                                        if (password.length() < 6) {
                                            password_TV.setError(getString(R.string.minimum_password));
                                        } else {
                                            Toast.makeText(LoginActivity.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                                        }
                                    } else {
                                        System.out.println("user is logged in -------"+auth.getCurrentUser());
                                        savelogin.edit().putBoolean("logged",true).apply();
                                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });
                }

        });
    }
}