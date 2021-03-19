package com.example.basisql;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basisql.Model.Contact;
import com.example.basisql.values.MydbHandeler;

import java.util.ArrayList;
import java.util.List;

public class Adder extends AppCompatActivity {
    private  String names;
    private String emails;
    EditText name;
    EditText email;
    Contact adds;
    MydbHandeler ss;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input);
        ss = new MydbHandeler(this);
        adds = new Contact();
        Button btn = (Button) findViewById(R.id.btnad);
        name = (EditText) findViewById(R.id.nameA);
        email = (EditText) findViewById(R.id.emailA);
        //using the input data
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String names = name.getText().toString();
               String emails = email.getText().toString();
               adds.setName(names);
               adds.setEmail(emails);
               if(name.length()!=0){
                   ss.addContact(adds);
                   Intent intent = new Intent(Adder.this, Display.class);
                   startActivity(intent);
               } else {
                   Toast.makeText(Adder.this,"items selected for first",Toast.LENGTH_SHORT).show();
               }
               }
       });
    }


    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case(R.id.g):
                Toast.makeText(this,"items selected for first",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
