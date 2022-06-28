package com.iabug.wecareforyou;

import static com.iabug.wecareforyou.MusicActivity.ambbut;
import static com.iabug.wecareforyou.MusicActivity.clasbut;
import static com.iabug.wecareforyou.MusicActivity.insbut;
import static com.iabug.wecareforyou.MusicActivity.natbut;

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

        if(natbut) {
        image.setImageResource(R.mipmap.ic_launcher_natureimage);
        text.setText("Nature Sounds");
        natbut=false;
        }
        else if(clasbut){
            image.setImageResource(R.mipmap.ic_launcher_classicalimage);
            text.setText("Classical Sounds");
            clasbut=false;
        }
        else if(insbut){
            image.setImageResource(R.mipmap.ic_launcher_instrumentalimage);
            text.setText("Instrumental Sounds");
            insbut=false;
        }
        else if(ambbut){
            image.setImageResource(R.mipmap.ic_launcher_ambientimage);
            text.setText("Ambient Sounds");
            ambbut=false;
        }
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