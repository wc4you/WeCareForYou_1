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

import android.os.Bundle;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        result = findViewById(R.id.textView);
        result2 = findViewById(R.id.textView2);
        result3 = findViewById(R.id.textView5);
        res = res * 2;
        resa = resa * 2;
        resd = resd * 2;
        auth = FirebaseAuth.getInstance();
        userif=FirebaseAuth.getInstance().getCurrentUser().getUid();


        FirebaseFirestore db = FirebaseFirestore.getInstance();

        if (index >= arsize - 1) {
            System.out.println("----------------------------IN update result-------------------------------------");
            if (res >= 0 && res <= 13) {
                System.out.println(res + "/40 " + " Low stress");
                result.setText("Low Stress");
//                res=0;
            }
            if (res >= 14 && res <= 26) {
                System.out.println(res + "/40 " + " Moderate stress");
                result.setText(" Moderate stress");
//                res=0;
            }
            if (res >= 27 && res <= 100) {
                System.out.println(res + "/40 " + "  High perceived stress");
                result.setText(" High perceived stress");
//                res=0;
            }
            if (resa >= 0 && resa <= 13) {
                System.out.println(resa + "/40 " + " Low stress");
                result2.setText("Low Anxiety");
//                resa=0;
            }
            if (resa >= 14 && resa <= 26) {
                System.out.println(resa + "/40 " + " Moderate stress");
                result2.setText(" Moderate Anxiety");
//                resa=0;
            }
            if (resa >= 27 && resa <= 100) {
                System.out.println(resa + "/40 " + "  High perceived anxiety");
                result2.setText(" High  Anxiety");
//                resa=0;
            }
            if (resd >= 0 && resd <= 13) {
                System.out.println(resd + "/40 " + " Low stress");
                result3.setText("Low depression");
//                resd=0;
            }
            if (resd >= 14 && resd <= 26) {
                System.out.println(resd + "/40 " + " Moderate stress");
                result3.setText(" Moderate depression");
//                resd=0;
            }
            if (resd >= 27 && resd <= 100) {
                System.out.println(resd + "/40 " + "  High perceived depression");
                result3.setText(" High depression");
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

        }

}