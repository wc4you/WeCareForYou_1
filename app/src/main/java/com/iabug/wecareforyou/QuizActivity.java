package com.iabug.wecareforyou;

import static com.iabug.wecareforyou.ResultActivity.result;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class QuizActivity extends AppCompatActivity {

    ArrayList<ModelClass> List;
    ModelClass modelClass;
//    ResultActivity result;
    public static int index=0;
    public static int res=0;
    int score=0;
    public static int arsize=0;
    TextView question;
    RadioButton choice1,choice2,choice3,choice4,choice5;
    Button nxtBtn;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        question=findViewById(R.id.question);
        choice1=findViewById(R.id.choice1);
        choice2=findViewById(R.id.choice2);
        choice3=findViewById(R.id.choice3);
        choice4=findViewById(R.id.choice4);
        choice5=findViewById(R.id.choice5);
        nxtBtn=findViewById(R.id.nextButton);
        radioGroup=findViewById(R.id.radiogroup);



        List =new ArrayList<>();
        List.add(new ModelClass("In the last week, how often have you been upset because of something that happened unexpectedly?.","Never","Almost Never","Sometimes","Fairly Often","Very Often"));
        List.add(new ModelClass("In the last week, how often have you felt that you were unable to control the important things in your life? .","Never","Almost Never","Sometimes","Fairly Often","Very Often"));
        List.add(new ModelClass("In the last week, how often have you felt nervous and “stressed”?","Never","Almost Never","Sometimes","Fairly Often","Very Often"));
        List.add(new ModelClass("In the last week, how often have you felt confident about your ability to handle your personal problems?", "Never","Almost Never","Sometimes","Fairly Often","Very Often"));
        List.add(new ModelClass("In the last week, how often have you felt that things were going your way?","Never","Almost Never","Sometimes","Fairly Often","Very Often"));
        List.add(new ModelClass("In the last week, how often have you found that you could not cope with all the things that you had to do?","Never","Almost Never","Sometimes","Fairly Often","Very Often"));
        List.add(new ModelClass("In the last week, how often have you been able to control irritations in your life?","Never","Almost Never","Sometimes","Fairly Often","Very Often"));
        List.add(new ModelClass("In the last week, how often have you felt that you were on top of things?","Never","Almost Never","Sometimes","Fairly Often","Very Often"));
        List.add(new ModelClass("In the last week, how often have you been angered because of things that were outside of your control?","Never","Almost Never","Sometimes","Fairly Often","Very Often"));
        List.add(new ModelClass("In the last week, how often have you felt difficulties were piling up so high that you could not overcome them?","Never","Almost Never","Sometimes","Fairly Often","Very Often"));
        Collections.shuffle(List);
        modelClass=List.get(index);

        setdata();
        arsize= List.size();

//        if(index<List.size()-1){
            nxtBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
//                    if (index < arsize - 1) {
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
                        }
//                        if(index==arsize){
//                            updateresult();
//                        }

                }

//                    else{
//                        Intent intent=new Intent(QuizActivity.this,ResultActivity.class);
//                        startActivity(intent);
//                        finish();
//                    }
//                }

            });

    }


    private void updatescore(int selectedId) {
        switch (selectedId){
            case R.id.choice1:score=0;
                res+=score;break;
            case R.id.choice2:score=1;
                res+=score;break;
            case R.id.choice3:score=2;
                res+=score;break;
            case R.id.choice4:score=3;
                res+=score;break;
            case R.id.choice5:score=4;
                res+=score;break;

        }

        System.out.println("res-------"+res);

    }
//    private void updateresult() {
//        System.out.println("----------------------------IN update result-------------------------------------");
//        if (res > 0 && res <= 13) {
//             System.out.println(res+"/40 " +" Low stress");
//            result.setText("Low Stress");
//        }
//        if (res > 14 && res <= 26) {
//             System.out.println(res+"/40 " +" Moderate stress");
//            result.setText(" Moderate stress");
//        }
//        if (res > 27 && res <= 40) {
//             System.out.println(res+"/40 " +"  High perceived stress");
//            result.setText(" High perceived stress");
//        }
//    }

    private void updateTextView() {
        if(index<arsize-1) {
            index++;
            System.out.println("index-is-------------"+index+"arzise-----"+arsize);
        }
        else{
            System.out.println("updateTextView else------------------"+index);

//            index--;
//            nxtBtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
                    Intent intent=new Intent(QuizActivity.this,ResultActivity.class);
                    startActivity(intent);
                    finish();
//                    updateresult();

                }
//            });
        }
//    }

//        }
//        else if(index==List.size()-1){
//            nxtBtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent=new Intent(QuizActivity.this,ResultActivity.class);
//                    startActivity(intent);
//                }
//            });
//        }
//    }

    private void setdata() {
        question.setText(modelClass.getQuestion());
        choice1.setText(modelClass.getChoice1());
        choice2.setText(modelClass.getChoice2());
        choice3.setText(modelClass.getChoice3());
        choice4.setText(modelClass.getChoice4());
        choice5.setText(modelClass.getChoice5());
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

//}

}