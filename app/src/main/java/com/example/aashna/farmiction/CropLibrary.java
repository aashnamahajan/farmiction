package com.example.aashna.farmiction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import static com.example.aashna.farmiction.R.id.parent;

public class CropLibrary extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button  btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_library);
        Spinner spinner=(Spinner)findViewById(R.id.crop_spinner);


        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,
                R.array.crops_name,android.R.layout.simple_spinner_dropdown_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, final int i, long l) {
        final String selected = adapterView.getItemAtPosition(i).toString();


        btn=(Button)findViewById(R.id.btn_go);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i==0)
                {
                    Intent intent=new Intent(CropLibrary.this,Rice.class);
                    startActivity(intent);
                }else if(i==1)
                {
                    Intent intent=new Intent(CropLibrary.this,Carrot.class);
                    startActivity(intent);
                }else if(i==2)
                {
                    Intent intent=new Intent(CropLibrary.this,Wheat.class);
                    startActivity(intent);
                }else if(i==3)
                {
                    Intent intent=new Intent(CropLibrary.this,Sugarcane.class);
                    startActivity(intent);
                }
            }
        });



    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
