package com.example.aashna.farmiction;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText email, pass;
    private Button log_in,reg;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        log_in = (Button) findViewById(R.id.login_btn);
        reg = (Button) findViewById(R.id.reg);
        email = (EditText) findViewById(R.id.id);
        pass = (EditText) findViewById(R.id.password);
        mAuthListener=new FirebaseAuth.AuthStateListener(){

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if(firebaseAuth.getCurrentUser() !=null)
                {

                }
            }
        };



        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                start_sign_in();

            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,Signup.class);
                startActivity(intent);

            }
        });

    }


    protected void onStart()
    {
       super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }



    private void start_sign_in(){

        final ProgressDialog progressDialog=ProgressDialog.show(MainActivity.this,"Please wait","Processing",true);

        mAuth.signInWithEmailAndPassword(email.getText().toString(), pass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                progressDialog.dismiss();
                if(task.isSuccessful())
                {
                    Intent intent=new Intent(MainActivity.this,Homescreen.class);
                    startActivity(intent);
                }
                else {
                    Log.e("ERROR",task.getException().toString());
                    Toast.makeText(MainActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}