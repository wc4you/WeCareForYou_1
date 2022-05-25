package com.iabug.wecareforyou;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    TextView Question1,question1_A,question1_B,question1_C,question1_D,question1_E;
    Button btn;
    FirebaseDatabase database;
    DatabaseReference myRef;
    FirebaseUser CurrentUser;
    String uid;
    private List<McqModel> list;
    private int count =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        CurrentUser = FirebaseAuth.getInstance().getCurrentUser();
        assert CurrentUser != null;
        list = new ArrayList<>();
        uid = CurrentUser.getUid();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference().child("UserQuestion");

        Question1 = findViewById(R.id.question);
        question1_A = findViewById(R.id.optionA);
        question1_B = findViewById(R.id.optionB);
        question1_C = findViewById(R.id.optionC);
        question1_D = findViewById(R.id.optionD);
        question1_E = findViewById(R.id.optionE);
        btn = findViewById(R.id.nextButton);
        /*UpcomingPeriodDate = findViewById(R.id.upcomingPeriodDateCardView);
        OvulationDate = findViewById(R.id.OvulationDate);*/
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                {
                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                        String questionlist = snapshot.child("Question").getValue(String.class);
                        String optionA = snapshot.child("OptionA").getValue(String.class);
                        String optionB = snapshot.child("OptionB").getValue(String.class);
                        String optionC = snapshot.child("OptionC").getValue(String.class);
                        String optionD = snapshot.child("OptionD").getValue(String.class);
                        String optionE = snapshot.child("OptionE").getValue(String.class);
                        list.add(new McqModel(optionA,optionB,optionC,optionD,optionE,questionlist));
                        Question1.setText(questionlist);
                        question1_A.setText(optionA);
                        question1_B.setText(optionB);
                        question1_C.setText(optionC);
                        question1_D.setText(optionD);
                        question1_E.setText(optionE);
                    }
                }
            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(QuizActivity.this,"",Toast.LENGTH_SHORT).show();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}