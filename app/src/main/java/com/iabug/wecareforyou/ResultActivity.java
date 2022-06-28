package com.iabug.wecareforyou;

import static com.iabug.wecareforyou.QuizActivity.count;
import static com.iabug.wecareforyou.QuizActivity.res;
import static com.iabug.wecareforyou.QuizActivity.index;
import static com.iabug.wecareforyou.QuizActivity.arsize;
import static com.iabug.wecareforyou.QuizActivity.resa;
import static com.iabug.wecareforyou.QuizActivity.resd;
//import static com.iabug.wecareforyou.SignUpActivity.userid;
import static com.iabug.wecareforyou.SignUpActivity.user;
import static com.iabug.wecareforyou.SignUpActivity.userid;
//import static com.iabug.wecareforyou.SignUpActivity.db;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class ResultActivity extends AppCompatActivity {
    public static TextView result;
    public static TextView result2;
    public static TextView result3;
    private FirebaseAuth auth;
    String userif;
    String resstore;
    Button rethom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        result = findViewById(R.id.textView);
        result2 = findViewById(R.id.textView2);
        result3 = findViewById(R.id.textView5);
        rethom=(Button)findViewById(R.id.button2);
        res = res * 2;
        resa = resa * 2;
        resd = resd * 2;
        auth = FirebaseAuth.getInstance();
        userif=FirebaseAuth.getInstance().getCurrentUser().getUid();


        FirebaseFirestore db = FirebaseFirestore.getInstance();

        if (index >= arsize - 1) {
            System.out.println("----------------------------IN update result-------------------------------------");
            if (res >= 0 && res <= 14) {
                System.out.println(res +  " Normal/ Not Stressed");
                result.setText("Normal/ Not Stressed");
//                res=0;
            }
            if (res >= 15 && res <= 18) {
                System.out.println(res +  " Mild Stress");
                result.setText("Mild Stress");
//                res=0;
            }
            if (res >= 19 && res <= 25) {
                System.out.println(res +  " Moderate stress");
                result.setText("Moderate Stress");
//                res=0;
            }
            if (res >= 26 && res <= 33) {
                System.out.println(res +  " Severe stress");
                result.setText(" Severe stress");
//                res=0;
            }
            if (res >= 34){// && res <= 100) {
                System.out.println(res +  "  Extremely Severe stress");
                result.setText(" Extremely Severe stress");
//                res=0;
            }
            if (resa >= 0 && resa <= 7) {
                System.out.println(resa +  " Normal / No anxiety");
                result2.setText("Normal / No anxiety");
//                resa=0;
            }
            if (resa >= 8 && resa <= 9) {
                System.out.println(resa +  " Mild Anxiety");
                result2.setText("Mild Anxiety");
//                resa=0;
            }
            if (resa >= 10 && resa <= 14) {
                System.out.println(resa +  " Moderate Anxiety");
                result2.setText("Moderate Anxiety");
//                resa=0;
            }
            if (resa >= 15 && resa <= 19) {
                System.out.println(resa +  " Severe Anxiety");
                result2.setText(" Severe Anxiety");
//                resa=0;
            }
            if (resa >= 20){// && resa <= 100) {
                System.out.println(resa +  "  Extremely Severe Anxiety");
                result2.setText(" Extremely Severe Anxiety");
//                resa=0;
            }
            if (resd >= 0 && resd <= 9) {
                System.out.println(resd +  " Normal / Not Depressed");
                result3.setText("Normal / Not Depressed");
//                resd=0;
            }
            if (resd >= 10 && resd <= 13) {
                System.out.println(resd +  " Mild depression");
                result3.setText("Mild depression");
//                resd=0;
            }
            if (resd >= 14 && resd <= 20) {
                System.out.println(resd +  " Moderate depression");
                result3.setText("Moderate depression");
//                resd=0;
            }
            if (resd >=21 && resd <= 27) {
                System.out.println(resd +  " Severe depression");
                result3.setText(" Severe depression");
//                resd=0;
            }
            if (resd >= 28){// && resd <= 100) {
                System.out.println(resd +  "  Extremely Severe depression");
                result3.setText(" Extremely Severe depression");
//                resd=0;
            }
            index = 0;
        }
        System.out.println("user is count is  ------"+ count);
        resstore="Result"+count;
        System.out.println("user is -----"+userif);
        System.out.println("resstore-----"+resstore);
//        userid=FirebaseAuth.getInstance().getCurrentUser();
            DocumentReference documentReference = db.collection(userif).document(resstore);
            Map<String, Object> user = new HashMap<>();
//            user.put("Results", res);
            user.put("Stress", res);
            user.put("Anxiety", resa);
            user.put("Depression", resd);
            documentReference.set(user);
        res=0;
        resa=0;
        resd=0;
        rethom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ResultActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });

        }

}