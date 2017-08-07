package com.example.aashna.farmiction;


        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.TextView;

        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;

public class Mycrops extends AppCompatActivity {

    private DatabaseReference mref2, mref;
    private TextView mview, mview1, mview2, mview3, mview4, mview5, mview6, mview7, mview8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycrops);
        mview = (TextView) findViewById(R.id.textView_mycrops);
        mview1 = (TextView) findViewById(R.id.textView_mycrops1);
        mview2 = (TextView) findViewById(R.id.textView_mycrops2);
        mview3 = (TextView) findViewById(R.id.textView_mycrops3);
        mview4 = (TextView) findViewById(R.id.textView_mycrops4);
       // mview5 = (TextView) findViewById(R.id.textView_mycrops5);
        mview6 = (TextView) findViewById(R.id.textView_mycrops6);
        mview7 = (TextView) findViewById(R.id.textView_mycrops7);
        mview8 = (TextView) findViewById(R.id.textView_mycrops8);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String userID = user.getUid().toString();
        final String st = "stage1";
        mref2 = FirebaseDatabase.getInstance().getReferenceFromUrl("https://farmicition-cbd36.firebaseio.com/users/" + userID);
        mref2.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.child("crop1").getValue().toString();
                mref = FirebaseDatabase.getInstance().getReferenceFromUrl("https://farmicition-cbd36.firebaseio.com/crop/carrot") ;

                mref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String value1 = dataSnapshot.child("stage 1").child("fertilizer").getValue().toString();
                        String value2 = dataSnapshot.child("stage 1").child("labour").getValue().toString();
                        String value3 = dataSnapshot.child("stage 1").child("maxtemp").getValue().toString();
                        String value4 = dataSnapshot.child("stage 1").child("mintemp").getValue().toString();
                        String value5 = dataSnapshot.child("stage 1").child("rainfall").getValue().toString();
                        String value7 = dataSnapshot.child("stage 1").child("season").getValue().toString();
                        String value8 = dataSnapshot.child("stage 1").child("soil").getValue().toString();
                        String value9 = dataSnapshot.child("stage 1").child("surface").getValue().toString();
                        mview.setText(value1);
                        mview1.setText(value2);
                        mview2.setText(value3);
                        mview3.setText(value4);
                        mview4.setText(value5);
                        mview6.setText(value7);
                        mview7.setText(value8);
                        mview8.setText(value9);

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });









            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });

    }

}