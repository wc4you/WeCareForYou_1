package com.iabug.wecareforyou;

import static com.iabug.wecareforyou.MusicActivity.ambbut;
import static com.iabug.wecareforyou.MusicActivity.clasbut;
import static com.iabug.wecareforyou.MusicActivity.insbut;
import static com.iabug.wecareforyou.MusicActivity.natbut;
import static com.iabug.wecareforyou.PlayActivity.Sname;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class MusicListActivity extends AppCompatActivity {
    ImageView image;
    TextView text;
    TextView text1;
    TextView text2;
    TextView text3;
//    Button pbutton;
    public static boolean textb1=false;
    public static boolean textb2=false;
    public static boolean textb3=false;
    public static boolean textb4=false;
    public static boolean textb5=false;
    public static boolean textb6=false;
    public static boolean textb7=false;
    public static boolean textb8=false;
    public static boolean textb9=false;
    public static boolean textb10=false;
    public static boolean textb11=false;
    public static boolean textb12=false;

     public static MediaPlayer mediaPlayer=new MediaPlayer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musiclist);
        image=(ImageView) findViewById(R.id.image);
        text=(TextView) findViewById(R.id.textView8);
        text1=(TextView) findViewById(R.id.textView9);
        text2=(TextView) findViewById(R.id.textView10);
        text3=(TextView) findViewById(R.id.textView11);


        if(natbut) {
        image.setImageResource(R.mipmap.ic_launcher_natureimage);
        text.setText("Nature Sounds");
        text1.setText("Forest sounds");
        text2.setText("River Sounds");
        text3.setText("Rain Sounds");
        text1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                try {

                    mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/finalyear-628f8.appspot.com/o/ForestSounds.mp3?alt=media&token=dc3f20b2-316d-4c60-a2c3-40551d347171");
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            mediaPlayer.start();
                        }
                    });
                    mediaPlayer.prepare();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
                textb1=true;
                Intent intent=new Intent(MusicListActivity.this,PlayActivity.class);
                startActivity(intent);
            }
        });
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/finalyear-628f8.appspot.com/o/RiverSounds.mp3?alt=media&token=d46056dd-0f64-4b61-bc21-3bbdc6c403fe");
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            mediaPlayer.start();
                        }
                    });
                    mediaPlayer.prepare();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
                textb2=true;
                Intent intent=new Intent(MusicListActivity.this,PlayActivity.class);
                startActivity(intent);
            }
        });
        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/finalyear-628f8.appspot.com/o/RainSounds.mp3?alt=media&token=67e966c9-d9f9-44fd-be0f-68c6f87abf76");
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            mediaPlayer.start();
                        }
                    });
                    mediaPlayer.prepare();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
                textb3=true;
                Intent intent=new Intent(MusicListActivity.this,PlayActivity.class);
                startActivity(intent);
            }
        });

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
//        pbutton=(Button) findViewById(R.id.button5);
//
//        pbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Uri myUri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/finalyear-628f8.appspot.com/o/Sand%20and%20Sea.mp3?alt=media&token=f30efe8f-edf4-4b16-b61d-cffde58f0887");
//                try {
//
//                    mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/finalyear-628f8.appspot.com/o/Sand%20and%20Sea.mp3?alt=media&token=f30efe8f-edf4-4b16-b61d-cffde58f0887");
//                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                        @Override
//                        public void onPrepared(MediaPlayer mediaPlayer) {
//                            mediaPlayer.start();
//                        }
//                    });
//                    mediaPlayer.prepare();
//                }
//                catch (IOException e){
//                    e.printStackTrace();
//                }
//
//                Intent intent=new Intent(MusicListActivity.this,PlayActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}