package com.iabug.wecareforyou;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;

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
    Button plbutton;
    Button pabutton;
    SeekBar seekb;
    EditText progtime;
    EditText tottime;
    MediaPlayer mediaPlayer=new MediaPlayer();
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        plbutton=(Button) findViewById(R.id.butpl);
        pabutton=(Button) findViewById(R.id.butpa);
        seekb=(SeekBar) findViewById(R.id.seekBar);
        progtime=(EditText) findViewById(R.id.editTextTime);
        tottime=(EditText) findViewById(R.id.editTextTime2);

        databaseReference= FirebaseDatabase.getInstance().getReference("Music");
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
//                try {
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
//            }
//        });
    }
    public void play_song(View v){
        try {
//            mediaPlayer.create()
            mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/finalyear-628f8.appspot.com/o/Sand%20and%20Sea.mp3?alt=media&token=f30efe8f-edf4-4b16-b61d-cffde58f0887");
                        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                    System.out.println("progresstime"+mediaPlayer.getDuration());
                    System.out.println("totoaltime"+mediaPlayer.getCurrentPosition());
                }
            });
            mediaPlayer.prepare();
        }
        catch (IOException e){
            e.printStackTrace();
        }

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
                tottime.setText(String.format("%d:%d ", TimeUnit.MILLISECONDS.toMinutes((long) finalTime), TimeUnit.MILLISECONDS.toSeconds((long) finalTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) finalTime))));
                progtime.setText(String.format("%d:%d ", TimeUnit.MILLISECONDS.toMinutes((long) timeElapsed), TimeUnit.MILLISECONDS.toSeconds((long) timeElapsed) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) timeElapsed))));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

}