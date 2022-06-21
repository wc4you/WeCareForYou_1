package com.iabug.wecareforyou;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button login;
    Button signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (Button) findViewById(R.id.mainloginButton);
        signin = (Button) findViewById(R.id.mainsignupButton);

        login.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
        });
        signin.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);
        });
    }
}