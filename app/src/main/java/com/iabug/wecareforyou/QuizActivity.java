package com.iabug.wecareforyou;

import static com.iabug.wecareforyou.ResultActivity.result;
import static com.iabug.wecareforyou.HomeActivity.List;
import static com.iabug.wecareforyou.SignUpActivity.db;
import static com.iabug.wecareforyou.SignUpActivity.userid;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collections;

public class QuizActivity extends AppCompatActivity {

//    ArrayList<ModelClass> List;
    ModelClass modelClass;
//    ResultActivity result;
    public static int index=0;
    public static int res=0;
    public static int resa=0;
    public static int resd=0;
    int score=0;
    int ct=0;
    public static int arsize=0;

    public static int count=1;
    TextView question;
    RadioButton choice1,choice2,choice3,choice4;//,choice5;
    Button nxtBtn;
    RadioGroup radioGroup;
    FirebaseFirestore db;
    String userid;
    Map<String,Object> user=new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        question=findViewById(R.id.question);
        choice1=findViewById(R.id.choice1);
        choice2=findViewById(R.id.choice2);
        choice3=findViewById(R.id.choice3);
        choice4=findViewById(R.id.choice4);
//        choice5=findViewById(R.id.choice5);
        nxtBtn=findViewById(R.id.nextButton);
        radioGroup=findViewById(R.id.radiogroup);

                modelClass=List.get(index);
        db = FirebaseFirestore.getInstance();
        userid=FirebaseAuth.getInstance().getCurrentUser().getUid();
                setdata();
//                count++;
        System.out.println("user is logged in quiz ------"+ FirebaseAuth.getInstance().getCurrentUser());
        System.out.println("count----------"+ct);
            nxtBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                        int selectedId = radioGroup.getCheckedRadioButtonId();
                        if (selectedId == -1) {
                            Toast.makeText(QuizActivity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                        } else {
                            RadioButton radioButton = (RadioButton) radioGroup.findViewById(selectedId);
                            updatescore(selectedId);
                            radioGroup.clearCheck();
                            updateTextView();
                            modelClass = List.get(index);
                            setdata();
//                            senddata();
                        }
                }
            });

    }

//    private void senddata() {
//        if (index >= arsize-1) {
//            userid = FirebaseAuth.getInstance().getCurrentUser().getUid();
//            DocumentReference documentReference = db.collection("Users").document(userid);
//            Map<String, Object> user = new HashMap<>();
//            user.put("Result", res);
//            documentReference.set(user);
//        }
//    }


    private void updatescore(int selectedId) {
        if(index>-1 &&index<7){
        switch (selectedId){
            case R.id.choice1:score=0;
                res+=score;break;
            case R.id.choice2:score=1;
                res+=score;break;
            case R.id.choice3:score=2;
                res+=score;break;
            case R.id.choice4:score=3;
                res+=score;break;
//            case R.id.choice5:score=4;
//                res+=score;break;
        }
        System.out.println("res is --------------"+res);
        }
        if (index>=7 && index<14){
            switch (selectedId){
                case R.id.choice1:score=0;
                    resa+=score;break;
                case R.id.choice2:score=1;
                    resa+=score;break;
                case R.id.choice3:score=2;
                    resa+=score;break;
                case R.id.choice4:score=3;
                    resa+=score;break;
//            case R.id.choice5:score=4;
//                res+=score;break;

            }
            System.out.println("resa-------"+resa);
        }

        if(index>=14 && index<22) {
            switch (selectedId){
                case R.id.choice1:score=0;
                    resd+=score;break;
                case R.id.choice2:score=1;
                    resd+=score;break;
                case R.id.choice3:score=2;
                    resd+=score;break;
                case R.id.choice4:score=3;
                    resd+=score;break;
//            case R.id.choice5:score=4;
//                res+=score;break;

            }
            System.out.println("resd-------"+resd);
        }



    }
    private void updateTextView() {
        if(index<arsize-1) {
            System.out.println("index-is-------------"+index+"arzise-----"+arsize);
            index++;
        }
        else{
            System.out.println("updateTextView else------------------"+index);
                db.collection(userid).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        count=task.getResult().size();
                        System.out.println("quiz count is 990009090------------"+count);
                    }
                });
                    Intent intent=new Intent(QuizActivity.this,ResultActivity.class);
                    startActivity(intent);
                    finish();
                }
        }


    private void setdata() {
        question.setText(modelClass.getQuestion());
        choice1.setText(modelClass.getChoice1());
        choice2.setText(modelClass.getChoice2());
        choice3.setText(modelClass.getChoice3());
        choice4.setText(modelClass.getChoice4());
//        choice5.setText(modelClass.getChoice5());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }


}