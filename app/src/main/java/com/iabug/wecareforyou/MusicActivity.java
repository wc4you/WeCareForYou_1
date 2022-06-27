package com.iabug.wecareforyou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MusicActivity extends AppCompatActivity {

    ImageView natimg;
    ImageView classimg;
    ImageView instimg;
    ImageView ambimg;
    ImageView img;
    TextView textimg;
    TextView nattxt;
    TextView classtxt;
    TextView insttxt;
    TextView ambtxt;
    Button nbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        natimg=(ImageView)findViewById(R.id.natureimg);
        classimg=(ImageView) findViewById(R.id.classicalimg);
        instimg=(ImageView) findViewById(R.id.instrumentalimg);
        ambimg=(ImageView) findViewById(R.id.ambientimg);
        img=(ImageView)findViewById(R.id.image);
        textimg=(TextView)findViewById(R.id.textView8);
        nattxt=(TextView) findViewById(R.id.Naturetxt);
        classtxt=(TextView) findViewById(R.id.Classicaltxt);
        insttxt=(TextView) findViewById(R.id.instrumentaltxt);
        ambtxt=(TextView) findViewById(R.id.ambienttxt);
        nbutton=(Button)findViewById(R.id.button);

//        natimg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                img.setImageResource(R.mipmap.ic_launcher_natureimage);
//                Intent intent=new Intent(MusicActivity.this,MusicListActivity.class);
//                startActivity(intent);
//
//            }
//        });

        nbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                img.setImageResource(R.mipmap.ic_launcher_natureimage);
//                textimg.setText((CharSequence) nattxt);
                Intent intent=new Intent(MusicActivity.this,MusicListActivity.class);
                startActivity(intent);
            }
        });


    }
}