package com.example.aashna.farmiction;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.io.IOException;
import java.text.SimpleDateFormat;


public class grow_select_crop extends AppCompatActivity {

    private EditText cropname;
    private DatabaseReference databaseReference,databaseReference2;
    private FirebaseAuth mAuth;
    Button a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grow_select_crop);

        a= (Button) findViewById(R.id.button);
        b= (Button) findViewById(R.id.button2);
        c= (Button) findViewById(R.id.button3);

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    private void user()
    {


        long date=System.currentTimeMillis();
        SimpleDateFormat adf=new SimpleDateFormat("MM DD YYY");
        String datastring=adf.format(date);
        databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://farmicition-cbd36.firebaseio.com/users/");
        mAuth = FirebaseAuth.getInstance();
        final String cropdate=datastring;
        //FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        // String userID = user.getUid().toString();
        databaseReference.child("O4zZHGyXJ0WbaSQEeDN3N9gbcaa2").child("crop").setValue("Rice");
        databaseReference2 = FirebaseDatabase.getInstance().getReferenceFromUrl("https://farmicition-cbd36.firebaseio.com/users/O4zZHGyXJ0WbaSQEeDN3N9gbcaa2/crop");
        databaseReference2.child("date").setValue(cropdate);

        Toast.makeText(this, "SUCCESSFULL", Toast.LENGTH_SHORT).show();
        // Intent intent=new Intent(this,weather.class);
        //startActivity(intent);

    }

    private void user2(){
        long date=System.currentTimeMillis();
        SimpleDateFormat adf=new SimpleDateFormat("MM DD YYY");
        String datastring=adf.format(date);
        databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://farmicition-cbd36.firebaseio.com/users");
        mAuth = FirebaseAuth.getInstance();
        final String cropdate=datastring;
        //FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        // String userID = user.getUid().toString();
        databaseReference.child("O4zZHGyXJ0WbaSQEeDN3N9gbcaa2").child("crop1").setValue("Carrot");
        databaseReference2 = FirebaseDatabase.getInstance().getReferenceFromUrl("https://farmicition-cbd36.firebaseio.com/users/O4zZHGyXJ0WbaSQEeDN3N9gbcaa2/crop1");
        databaseReference2.child("date").setValue(cropdate);


        Toast.makeText(this, "SUCCESSFULL", Toast.LENGTH_SHORT).show();

    }
    private void user3(){

        long date=System.currentTimeMillis();
        SimpleDateFormat adf=new SimpleDateFormat("MM DD YYY");
        String datastring=adf.format(date);
        databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://farmicition-cbd36.firebaseio.com/users");
        mAuth = FirebaseAuth.getInstance();
        final String cropdate=datastring;
        //FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        // String userID = user.getUid().toString();
        databaseReference.child("O4zZHGyXJ0WbaSQEeDN3N9gbcaa2").child("crop2").setValue("Sugarcane");
        databaseReference2 = FirebaseDatabase.getInstance().getReferenceFromUrl("https://farmicition-cbd36.firebaseio.com/users/O4zZHGyXJ0WbaSQEeDN3N9gbcaa2/crop2");
        databaseReference2.child("date").setValue(cropdate);

        Toast.makeText(this, "SUCCESSFULL", Toast.LENGTH_SHORT).show();
    }
    public void upload(View view) {
        user();
    }

    public void upload2(View view) {
        user2();
    }

    public void upload3(View view) {
        user3();
    }

}

