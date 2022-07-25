package com.iabug.wecareforyou;

import static com.iabug.wecareforyou.MusicActivity.ambbut;
import static com.iabug.wecareforyou.MusicActivity.clasbut;
import static com.iabug.wecareforyou.MusicActivity.insbut;
import static com.iabug.wecareforyou.MusicActivity.natbut;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
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


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musiclist);
        image= findViewById(R.id.image);
        text= findViewById(R.id.textView8);
        text1= findViewById(R.id.textView9);
        text2= findViewById(R.id.textView10);
        text3= findViewById(R.id.textView11);

        LoadingDialog loadingDialog=new LoadingDialog(MusicListActivity.this);


        if(natbut) {
        image.setImageResource(R.mipmap.ic_launcher_natureimage);
        text.setText("Nature Sounds");
        text1.setText("Forest sounds");
        text2.setText("River Sounds");
        text3.setText("Rain Sounds");
        text1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                loadingDialog.startLoadingDialog();
                try {
//                    mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/wc4you-6b4db.appspot.com/o/Music%2FForestSounds.mp3?alt=media&token=36bab843-7447-4e31-baf5-27edd271e276");
                    mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/finalyear-628f8.appspot.com/o/ForestSounds.mp3?alt=media&token=517e3539-e63a-4493-9202-2a8a74c3a5d2");
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
                text2.setClickable(false);
                text3.setClickable(false);
                Intent intent=new Intent(MusicListActivity.this,PlayActivity.class);
                startActivity(intent);
            }
        });
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
//                    mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/wc4you-6b4db.appspot.com/o/Music%2FRiverSounds.mp3?alt=media&token=3cc5a21b-24ea-427f-bc0f-a33812a33bde");
                    mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/finalyear-628f8.appspot.com/o/RiverSounds.mp3?alt=media&token=4cb8ceb5-bfde-438d-82cf-d28e0289b33e");
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
                text1.setClickable(false);
                text3.setClickable(false);
                Intent intent=new Intent(MusicListActivity.this,PlayActivity.class);
                startActivity(intent);
            }
        });
        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

//                    mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/wc4you-6b4db.appspot.com/o/Music%2FRainSounds.mp3?alt=media&token=d6fff301-4d5f-407c-93cf-4f743342d6ad");
                    mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/finalyear-628f8.appspot.com/o/RainSounds11.mp3?alt=media&token=1d902de3-305d-478c-8abf-1cec6d2b9a05");
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
                text1.setClickable(false);
                text2.setClickable(false);
                Intent intent=new Intent(MusicListActivity.this,PlayActivity.class);
                startActivity(intent);
            }
        });

        }
        else if(clasbut){
            image.setImageResource(R.mipmap.ic_launcher_classicalimage);
            text.setText("Classical Sounds");
            text1.setText("Relaxing Classic");
            text2.setText("Classic Violin");
            text3.setText("Mozart Classic");
            text1.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    try {

                        mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/finalyear-628f8.appspot.com/o/Classical%201.mp3?alt=media&token=239edb45-b802-4fa4-80e6-c07e537ec67f");
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
                    textb4=true;
                    text2.setClickable(false);
                    text3.setClickable(false);
                    Intent intent=new Intent(MusicListActivity.this,PlayActivity.class);
                    startActivity(intent);
                }
            });
            text2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {

                        mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/finalyear-628f8.appspot.com/o/Classical%202.mp3?alt=media&token=06cf0e63-a8d2-4a27-9815-12a4b81056f5");
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
                    textb5=true;
                    text1.setClickable(false);
                    text3.setClickable(false);
                    Intent intent=new Intent(MusicListActivity.this,PlayActivity.class);
                    startActivity(intent);
                }
            });
            text3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {

                        mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/finalyear-628f8.appspot.com/o/Classical%203.mp3?alt=media&token=d22ea4df-ee9e-44d8-a8b3-c8a2c728fa19");
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
                    textb6=true;
                    text1.setClickable(false);
                    text2.setClickable(false);
                    Intent intent=new Intent(MusicListActivity.this,PlayActivity.class);
                    startActivity(intent);
                }
            });

        }
        else if(insbut){
            image.setImageResource(R.mipmap.ic_launcher_instrumentalimage);
            text.setText("Instrumental Sounds");
            text1.setText("Relaxing flute");
            text2.setText("Relaxing Piano");
            text3.setText("Relaxing Instrumental Mix");
            text1.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    try {

                        mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/finalyear-628f8.appspot.com/o/Instrument%203%20Flute.mp3?alt=media&token=366b8269-70af-4e01-a499-a1873159782d");
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
                    textb7=true;
                    text2.setClickable(false);
                    text3.setClickable(false);
                    Intent intent=new Intent(MusicListActivity.this,PlayActivity.class);
                    startActivity(intent);
                }
            });
            text2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {

                        //                        mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/wc4you-6b4db.appspot.com/o/Music%2FInstrument%202%20Piano.mp3?alt=media&token=0a768512-94e7-4fb9-8df6-50eb74ea35fc")
                        mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/finalyear-628f8.appspot.com/o/Instrument%202%20Piano.mp3?alt=media&token=2afc499f-ac40-476a-bdc1-bafa7430d5e7");
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
                    textb8=true;
                    text1.setClickable(false);
                    text3.setClickable(false);
                    Intent intent=new Intent(MusicListActivity.this,PlayActivity.class);
                    startActivity(intent);
                }
            });
            text3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {

//                        mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/wc4you-6b4db.appspot.com/o/Music%2FInstrument%201%20Mix.mp3?alt=media&token=fdd70423-51cf-49b9-ae5b-aa521f5a09b9");
                        mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/finalyear-628f8.appspot.com/o/Instrument%201%20Mix.mp3?alt=media&token=3055ce60-8fdd-42e4-a2ee-3ad814327c2e");
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
                    textb9=true;
                    text1.setClickable(false);
                    text2.setClickable(false);
                    Intent intent=new Intent(MusicListActivity.this,PlayActivity.class);
                    startActivity(intent);
                }
            });


        }
        else if(ambbut){
            image.setImageResource(R.mipmap.ic_launcher_ambientimage);
            text.setText("Ambient Sounds");
            text1.setText("Galaxy Sounds");
            text2.setText("Medatation Sounds");
            text3.setText("Space Sounds");
            text1.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    try {

                        mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/finalyear-628f8.appspot.com/o/Ambient%201.mp3?alt=media&token=c5b8c87c-ba32-409a-8a3e-e6813e54001c");
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
                    textb10=true;
                    text2.setClickable(false);
                    text3.setClickable(false);
                    Intent intent=new Intent(MusicListActivity.this,PlayActivity.class);
                    startActivity(intent);
                }
            });
            text2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {

                        mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/finalyear-628f8.appspot.com/o/Ambient%202.mp3?alt=media&token=ec1fda69-aee4-40ba-9dc4-f53309ebcfdc");
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
                    textb11=true;
                    text1.setClickable(false);
                    text3.setClickable(false);
                    Intent intent=new Intent(MusicListActivity.this,PlayActivity.class);
                    startActivity(intent);
                }
            });
            text3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {

                        mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/finalyear-628f8.appspot.com/o/Ambient%203.mp3?alt=media&token=6aaa29ce-911d-495f-86a5-8fe5cb22111b");
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
                    textb12=true;
                    text1.setClickable(false);
                    text2.setClickable(false);
                    Intent intent=new Intent(MusicListActivity.this,PlayActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
    @Override
    public void onBackPressed() {
        mediaPlayer.stop();
        Intent intent=new Intent(MusicListActivity.this,MusicActivity.class);
        startActivity(intent);
    }
}
