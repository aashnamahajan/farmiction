package com.example.aashna.farmiction;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class Homescreen extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager LayoutManager;
    private ArrayList<Home> list = new ArrayList<Home>();
    private String[] name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        name = getResources().getStringArray(R.array.header_title);
        int count = 0;
        for (String Name : name) {
            Home contact = new Home(Name);
            count++;
            list.add(contact);
        }
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_homescreen);
        LayoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(LayoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new Home_Adapter(list);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(
                new HomeScreenRecyclerViewItemClickListener(Homescreen.this, new HomeScreenRecyclerViewItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        if (position == 0) {
                            Intent intent=new Intent(Homescreen.this,Weather.class);
                            startActivity(intent);
                        } else if (position == 1) {
                            Toast.makeText(getApplicationContext(),"clicked 2",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(Homescreen.this,grow_select_crop.class);
                            startActivity(intent);

                        }else if (position == 2) {
                            Toast.makeText(getApplicationContext(),"clicked Mycrops",Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(Homescreen.this,Mycrops.class);
                            startActivity(i);
                        }
                        else if (position == 3) {
                            Toast.makeText(getApplicationContext(),"clicked CropLibrary",Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(Homescreen.this,CropLibrary.class);
                            startActivity(i);
                        }
                        else if (position == 4) {
                            Intent i;
                            PackageManager manager=getPackageManager();
                            try{
                                i=manager.getLaunchIntentForPackage("ai.api.sample");
                                if (i==null)
                                    throw new PackageManager.NameNotFoundException();
                                i.addCategory(Intent.CATEGORY_LAUNCHER);
                                startActivity(i);
                            }catch (PackageManager.NameNotFoundException e){}


                        }
                        else if (position == 5) {
                            Toast.makeText(getApplicationContext(),"MAY I HELP YOU",Toast.LENGTH_SHORT).show();


                        }

                    }
                })
        );



    }

}
