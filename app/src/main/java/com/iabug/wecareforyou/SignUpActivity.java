package com.iabug.wecareforyou;

import static com.iabug.wecareforyou.ResultActivity.result;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import io.grpc.CallCredentials;


public class SignUpActivity extends AppCompatActivity {
    private TextView passwordTV, emailTV;
    private FirebaseAuth auth;
    public static FirebaseFirestore db;
    public static String userid;
    public static Map<String,Object> user=new HashMap<>();
//    Map<String,Object> user=new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        db =FirebaseFirestore.getInstance();
        Button details_submit = findViewById(R.id.signupButton);
        passwordTV = findViewById(R.id.signinpasswordInput);
        emailTV = findViewById(R.id.signinemailInput);
        auth = FirebaseAuth.getInstance();
        //Button
        details_submit.setOnClickListener(v -> {

            String email = emailTV.getText().toString().trim();
            String password = passwordTV.getText().toString().trim();


            if (TextUtils.isEmpty(email)) {
                Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(password)) {
                Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (password.length() < 6) {
                Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                return;
            }

            //create user
            auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(SignUpActivity.this, task -> {

                        Toast.makeText(SignUpActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(SignUpActivity.this, "Authentication failed." + task.getException(),
                                    Toast.LENGTH_SHORT).show();
                        } else {
//                            userid=auth.getCurrentUser().getUid();
                            userid=FirebaseAuth.getInstance().getCurrentUser().getUid();
                            DocumentReference documentReference=db.collection(userid).document("Result");
                            user.put("Email",email);
                            documentReference.set(user);
                            startActivity(new Intent(SignUpActivity.this, HomeActivity.class));

                            finish();
                        }
                    });
        });
    }
}
