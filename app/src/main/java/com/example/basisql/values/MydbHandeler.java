package com.example.basisql.values;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.basisql.Model.Contact;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static com.example.basisql.values.Params.DB_NAME;
import static com.example.basisql.values.Params.DB_VERSION;
import static com.example.basisql.values.Params.TABLE_NAME;

public class MydbHandeler extends SQLiteOpenHelper {
    public MydbHandeler(@Nullable Context context) {
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE " + Params.TABLE_NAME + "("
                + Params.KEY_ID + " INTEGER PRIMARY KEY," + Params.KEY_NAME
                + " TEXT, " + Params.KEY_EMAIL + " TEXT" + ")";
        Log.d("dbharry", "Query being run is : "+ create);
        db.execSQL(create);


    }
    public void addContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Params.KEY_NAME,contact.getName());
        values.put(Params.KEY_EMAIL,contact.getEmail());
        db.insert(Params.TABLE_NAME,null,values);
        Log.d("contactdd", "addContact: sucessfull");
        db.close();

    }
    public List<Contact> getAllContact(){
        List<Contact> contactList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String select = "SELECT * FROM " + Params.TABLE_NAME;
        Cursor cursor = db.rawQuery(select, null);
        if(cursor.moveToFirst()){
            do{
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setEmail(cursor.getString(2));
                contactList.add(contact);

            }while(cursor.moveToNext());


        }
        return  contactList;
    }
    public int updateContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Params.KEY_NAME,contact.getEmail());
        values.put(Params.KEY_EMAIL,contact.getEmail());
        return db.update(Params.TABLE_NAME, values, Params.KEY_ID + "=?",
                new String[]{String.valueOf(contact.getId())});
    }
    public void deleteContact(Contact contact){
        SQLiteDatabase db= this.getWritableDatabase();
        db.delete(TABLE_NAME,Params.KEY_ID +"=?",new String[]{String.valueOf(contact.getId())});
        db.close();
    }
    public void deleteContactById(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Params.TABLE_NAME, Params.KEY_ID +"=?", new String[]{String.valueOf(id)});
        db.close();
    }
    public int getCount(){
        SQLiteDatabase db =this.getWritableDatabase();
        String query = "SELECT * FROM " + Params.TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        return cursor.getCount();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
