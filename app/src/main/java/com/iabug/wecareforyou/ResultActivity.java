package com.iabug.wecareforyou;

import static com.iabug.wecareforyou.QuizActivity.res;
import static com.iabug.wecareforyou.QuizActivity.index;
import static com.iabug.wecareforyou.QuizActivity.arsize;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class ResultActivity extends AppCompatActivity {
    public static TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        result = findViewById(R.id.textView);
        if (index >= arsize-1) {
            System.out.println("----------------------------IN update result-------------------------------------");
            if (res >= 0 && res <= 13) {
                System.out.println(res + "/40 " + " Low stress");
                result.setText("Low Stress");
                res=0;
            }
            if (res >= 14 && res <= 26) {
                System.out.println(res + "/40 " + " Moderate stress");
                result.setText(" Moderate stress");
                res=0;
            }
            if (res >= 27 && res <= 40) {
                System.out.println(res + "/40 " + "  High perceived stress");
                result.setText(" High perceived stress");
                res=0;
            }
            index=0;
        }
    }
}