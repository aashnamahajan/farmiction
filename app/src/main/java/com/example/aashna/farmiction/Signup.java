package com.example.aashna.farmiction;

import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;


public class Signup extends AppCompatActivity {

    EditText id, password, city, district;
    Button register_btn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        id = (EditText) findViewById(R.id.id);
        password = (EditText) findViewById(R.id.password);
        city = (EditText) findViewById(R.id.city);
        district = (EditText) findViewById(R.id.district);
        register_btn = (Button) findViewById(R.id.register_btn);

        FirebaseAuth.getInstance();

        mAuth = FirebaseAuth.getInstance();

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final ProgressDialog progressDialog=ProgressDialog.show(Signup.this,"Please wait","Processing",true);

                mAuth.createUserWithEmailAndPassword(id.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        progressDialog.dismiss();

                        if(task.isSuccessful())
                        {
                            Toast.makeText(Signup.this,"Registration successful",Toast.LENGTH_LONG).show();
                            Intent i=new Intent(Signup.this,MainActivity.class);
                            startActivity(i);
                        }
                        else {
                            Log.e("ERROR",task.getException().toString());
                            Toast.makeText(Signup.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }


                    }
                });
            }
        });

    }

}
