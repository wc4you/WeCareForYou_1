package com.iabug.wecareforyou;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
    public static boolean natbut;
     public static boolean clasbut;
     public static boolean insbut;
     public static boolean ambbut;

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
//        nbutton=(Button)findViewById(R.id.button);
        natbut=false;
        clasbut=false;
        insbut=false;
        ambbut=false;
//        natimg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                img.setImageResource(R.mipmap.ic_launcher_natureimage);
//                Intent intent=new Intent(MusicActivity.this,MusicListActivity.class);
//                startActivity(intent);
//
//            }
//        });
        nattxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                img.setImageResource(R.mipmap.ic_launcher_natureimage);
//                textimg.setText("Nature Sounds");
                natbut=true;
                Intent intent=new Intent(MusicActivity.this,MusicListActivity.class);
                startActivity(intent);
            }
        });
        natimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                natbut=true;
                Intent intent=new Intent(MusicActivity.this,MusicListActivity.class);
                startActivity(intent);
            }
        });

        classtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clasbut=true;
                Intent intent=new Intent(MusicActivity.this,MusicListActivity.class);
                startActivity(intent);

            }
        });
        classimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clasbut=true;
                Intent intent=new Intent(MusicActivity.this,MusicListActivity.class);
                startActivity(intent);
            }
        });
        insttxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insbut=true;
                Intent intent=new Intent(MusicActivity.this,MusicListActivity.class);
                startActivity(intent);
            }
        });
        instimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insbut=true;
                Intent intent=new Intent(MusicActivity.this,MusicListActivity.class);
                startActivity(intent);
            }
        });
        ambtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ambbut=true;
                Intent intent=new Intent(MusicActivity.this,MusicListActivity.class);
                startActivity(intent);
            }
        });
        ambimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ambbut=true;
                Intent intent=new Intent(MusicActivity.this,MusicListActivity.class);
                startActivity(intent);
            }
        });



    }
    @Override
    public void onBackPressed() {
//        mediaPlayer.stop();
        Intent intent=new Intent(MusicActivity.this,HomeActivity.class);
        startActivity(intent);
    }
}