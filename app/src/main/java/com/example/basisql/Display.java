package com.example.basisql;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.basisql.Model.Contact;
import com.example.basisql.values.MydbHandeler;

import java.util.ArrayList;
import java.util.List;

public class Display extends AppCompatActivity {
    ListView listView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        MydbHandeler db = new MydbHandeler(this);
        Contact dur = new Contact();
        /*dur.setId(1);
        dur.setName("durga godess of war");
        dur.setEmail("lolfra.@ss.com");
        db.addContact(dur);
        Contact cr = new Contact();
        cr.setId(2);
        cr.setEmail("sdff@guy");
        cr.setName("lolo");
        db.addContact(cr);
        cr.setId(1);
        cr.setEmail("raugf@guy");
        cr.setName("dsdrsdf");
         int affected=db.updateContact(cr);//to update content
        Log.d("updi", "onCreate: "+ affected);

        // delte
        db.deleteContact(cr);
        //count
        Log.d("plzzcount", "onCreate: " + db.getCount());


*/
        //adding list view here
        listView = (ListView)findViewById(R.id.lview);

        ArrayList<String> contacts =new ArrayList<>();
        List<Contact> allContact= db.getAllContact();
        for(Contact contact: allContact ){
            Log.d("MyListD", "onCreate: "+contact.getId()+ "\n" +contact.getName()+"\n"+ contact.getEmail()+"\n");
            contacts.add(contact.getName()+" ("+contact.getEmail()+")" );
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,contacts);
        listView.setAdapter(arrayAdapter);


    }
}