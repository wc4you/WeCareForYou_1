package com.iabug.wecareforyou;

import static com.iabug.wecareforyou.QuizActivity.arsize;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    LinearLayout ll1;
    LinearLayout ll2;
    LinearLayout ll3;
    TextView tv;
    TextView tv2;
    public static ArrayList<ModelClass> List;
    public static int count=0;
    DatabaseReference databaseReference;
    DatabaseReference databaseReferences;
    DatabaseReference databaseReferenced;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tv=(TextView)findViewById(R.id.textView3);
        tv.setText("Take on your assessment");
        ll1=(LinearLayout) findViewById(R.id.linearlayout1);
        ll2=(LinearLayout)findViewById(R.id.linearlayout2);
        ll3=(LinearLayout)findViewById(R.id.linearlayout3);

        tv2=(TextView)findViewById(R.id.textView4);
        tv2.setText("Listein to Relaxing  Music");
        ll2.setOnClickListener(v->{
            Intent intent =new Intent(HomeActivity.this,MusicActivity.class);
            startActivity(intent);
        });
        ll3.setOnClickListener(v->{
            Intent intent =new Intent(HomeActivity.this,ToDoActivity.class);
            startActivity(intent);
        });

        List =new ArrayList<>();


        databaseReference= FirebaseDatabase.getInstance().getReference("Stress");
        databaseReferences= FirebaseDatabase.getInstance().getReference("Anxiety");
        databaseReferenced= FirebaseDatabase.getInstance().getReference("Depression");
        System.out.println("user is logged in home ------"+ FirebaseAuth.getInstance().getCurrentUser());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    ModelClass modelClass=dataSnapshot.getValue(ModelClass.class);
                    List.add(modelClass);
                }
//                Collections.shuffle(List);
                arsize= List.size();
                ll1.setOnClickListener(v->{
                    Intent intent =new Intent(HomeActivity.this,QuizActivity.class);
                    startActivity(intent);
                });
            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        databaseReferences.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    ModelClass modelClass=dataSnapshot.getValue(ModelClass.class);
                    List.add(modelClass);
                }
//                Collections.shuffle(List);
                arsize= List.size();
                ll1.setOnClickListener(v->{
                    Intent intent =new Intent(HomeActivity.this,QuizActivity.class);
                    startActivity(intent);
                });
            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        databaseReferenced.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    ModelClass modelClass=dataSnapshot.getValue(ModelClass.class);
                    List.add(modelClass);
                }
//                Collections.shuffle(List);
                arsize= List.size();
                ll1.setOnClickListener(v->{
                    Intent intent =new Intent(HomeActivity.this,QuizActivity.class);
                    startActivity(intent);
                });
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//        db.collection(userid).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                count=task.getResult().size();
//                System.out.println("current count is ----------------"+count);
//            }
//        });



    }
    @Override
    public void onBackPressed() {
//        mediaPlayer.stop();
        Intent intent=new Intent(HomeActivity.this,MainActivity.class);
        startActivity(intent);
    }

}