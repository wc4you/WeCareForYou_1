package com.iabug.wecareforyou;

import static com.iabug.wecareforyou.QuizActivity.index;
import static com.iabug.wecareforyou.QuizActivity.arsize;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collections;

public class HomeActivity extends AppCompatActivity {
    LinearLayout ll1;
    TextView tv;
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
}