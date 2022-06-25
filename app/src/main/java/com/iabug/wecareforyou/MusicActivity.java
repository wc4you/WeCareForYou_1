package com.iabug.wecareforyou;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MusicActivity extends AppCompatActivity {
    ImageView natureimg;
    ImageView classicalimg;
    ImageView instrumentalimg;
    ImageView ambientimg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        natureimg=(ImageView)findViewById(R.id.natureimg);
        classicalimg=(ImageView)findViewById(R.id.classicalimg);
        instrumentalimg=(ImageView) findViewById(R.id.instrumentalimg);
        ambientimg=(ImageView) findViewById(R.id.ambientimg);

    }
}