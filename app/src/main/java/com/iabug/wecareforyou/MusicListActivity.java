package com.iabug.wecareforyou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MusicListActivity extends AppCompatActivity {
    ImageView image;
    TextView text;
    Button pbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musiclist);

        image=(ImageView) findViewById(R.id.image);
        text=(TextView) findViewById(R.id.textView8);

        image.setImageResource(R.mipmap.ic_launcher_natureimage);
        text.setText("Nature Sounds");
        pbutton=(Button) findViewById(R.id.button5);

        pbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MusicListActivity.this,PlayActivity.class);
                startActivity(intent);
            }
        });
    }
}