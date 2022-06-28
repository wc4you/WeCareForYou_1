package com.iabug.wecareforyou;

import static com.iabug.wecareforyou.MusicListActivity.mediaPlayer;
import static com.iabug.wecareforyou.MusicListActivity.textb1;
import static com.iabug.wecareforyou.MusicListActivity.textb10;
import static com.iabug.wecareforyou.MusicListActivity.textb11;
import static com.iabug.wecareforyou.MusicListActivity.textb12;
import static com.iabug.wecareforyou.MusicListActivity.textb2;
import static com.iabug.wecareforyou.MusicListActivity.textb3;
import static com.iabug.wecareforyou.MusicListActivity.textb4;
import static com.iabug.wecareforyou.MusicListActivity.textb5;
import static com.iabug.wecareforyou.MusicListActivity.textb6;
import static com.iabug.wecareforyou.MusicListActivity.textb7;
import static com.iabug.wecareforyou.MusicListActivity.textb8;
import static com.iabug.wecareforyou.MusicListActivity.textb9;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.text.Format;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class PlayActivity extends AppCompatActivity {
    Button pabutton;
    SeekBar seekb;
    EditText progtime;
    EditText tottime;
    ImageView clbut;
    public static TextView Sname;

//    MediaPlayer mediaPlayer=new MediaPlayer();
    DatabaseReference databaseReference;
    boolean isPlaying = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
//        plbutton=(Button) findViewById(R.id.butpl);
        pabutton=(Button) findViewById(R.id.button);
        Sname=(TextView)findViewById(R.id.textView6);
        seekb=(SeekBar) findViewById(R.id.seekBar);
        clbut=(ImageView)findViewById(R.id.imageView3);
//        progtim=(TextView)findViewById(R.id.textView12);
//        tottim=(TextView)findViewById(R.id.textView13);
        progtime=(EditText) findViewById(R.id.editTextTime);
        tottime=(EditText) findViewById(R.id.editTextTime2);

        if(textb1){
            Sname.setText("Forest Sounds");
            textb1=false;
        }
        else if(textb2){
            Sname.setText("River Sounds");
            textb2=false;
        }
        else if(textb3){
            Sname.setText("Rain Sounds");
            textb3=false;
        }
        else if(textb4){
            Sname.setText("Relaxing Classic");
            textb4=false;
        }
        else if(textb5){
            Sname.setText("Classic Violin");
            textb5=false;
        }
        else if(textb6){
            Sname.setText("Mozart Classic");
            textb6=false;
        }
        else if(textb7){
            Sname.setText("Relaxing flute");
            textb7=false;
        }
        else if(textb8){
            Sname.setText("Relaxing Piano");
            textb8=false;
        }
        else if(textb9){
            Sname.setText("Relaxing Instrumental Mix");
            textb9=false;
        }
        else if(textb10){
            Sname.setText("Galaxy Sounds");
            textb10=false;
        }
        else if(textb11){
            Sname.setText("Medatation Sounds");
            textb11=false;
        }
        else if(textb12){
            Sname.setText("Space Sounds");
            textb12=false;
        }



        databaseReference= FirebaseDatabase.getInstance().getReference("Music");
        seekb.setMax(mediaPlayer.getDuration());
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seekb.setProgress(mediaPlayer.getCurrentPosition());
            }
        },0,900);

        seekb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mediaPlayer.seekTo(seekb.getProgress());
                int timeElapsed=mediaPlayer.getCurrentPosition();
                int finalTime=mediaPlayer.getDuration();
//                int timeRemaining = finalTime - timeElapsed;
                tottime.setText(String.format("%d : %d ", TimeUnit.MILLISECONDS.toMinutes((long) finalTime), TimeUnit.MILLISECONDS.toSeconds((long) finalTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) finalTime))));
                progtime.setText(String.format("%d : %d ", TimeUnit.MILLISECONDS.toMinutes((long) timeElapsed), TimeUnit.MILLISECONDS.toSeconds((long) timeElapsed) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) timeElapsed))));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                System.out.println("keyof music -------"+String.valueOf(snapshot.getValue()));

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


//        try {
//            mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/finalyear-628f8.appspot.com/o/Sand%20and%20Sea.mp3?alt=media&token=f30efe8f-edf4-4b16-b61d-cffde58f0887");
//            mediaPlayer.start();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        plbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////            play();
//            }
//
//        });
//        plbutton.performClick();
        final int[] currentPos = {0};
        pabutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                mediaPlayer.pause();
                if (mediaPlayer.isPlaying()) {
                    currentPos[0] = mediaPlayer.getCurrentPosition();
                    mediaPlayer.pause();
                    //change image to play
                } else {
                    mediaPlayer.seekTo(currentPos[0]);
                    mediaPlayer.start();
                    //again revert image to pause
                }
            }
        });

        clbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                Intent intent=new Intent(PlayActivity.this,MusicListActivity.class);
                startActivity(intent);
            }
        });



    }

    @Override
    public void onBackPressed() {
        mediaPlayer.stop();
        Intent intent=new Intent(PlayActivity.this,MusicListActivity.class);
        startActivity(intent);
    }
}