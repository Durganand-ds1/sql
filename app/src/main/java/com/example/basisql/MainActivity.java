package com.example.basisql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;

import com.example.basisql.Model.Contact;
import com.example.basisql.values.MydbHandeler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addB = (Button) findViewById(R.id.addB);
        Button disB = (Button) findViewById(R.id.dispB);
        disB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainActivity.this, Display.class);
                startActivity(j);
            }
        });
        addB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainActivity.this, Adder.class);
                startActivity(j);
            }
        });



    }




}