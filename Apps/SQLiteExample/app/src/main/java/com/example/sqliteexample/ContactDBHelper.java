package com.example.sqliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ContactDBHelper extends SQLiteOpenHelper {

    // informacje o bazie danych
   public static final String DATABASE_NAME = "contact_db";
   public static final int DATABASE_VERSION = 1;

   //komenda tworzaca tabele
   public static final String CREATE_TABLE = "create table "
           + ContactContract.ContactEntry.TABLE_NAME
           + "(" + ContactContract.ContactEntry.CONTACT_ID
           + " number," + ContactContract.ContactEntry.NAME
           + " text," + ContactContract.ContactEntry.EMAIL + " text);";

   //komenda do usuwania tabeli
    public static final String DROP_TABLE = "drop table if exists "
           + ContactContract.ContactEntry.TABLE_NAME;

   //konstruktor
   public ContactDBHelper(Context context){
       super(context, DATABASE_NAME, null, DATABASE_VERSION);
       Log.d("Database Operations", "Database created...");
   }

    // po utworzeniu obiektu klasy ContactDBHelper - zasotaje utworzona tabela w bazie dancych SQLite
    @Override
    public void onCreate(SQLiteDatabase db) {
        // utworzenie tabeli
        db.execSQL(CREATE_TABLE);

        //komunikat
        Log.d("Database Operations", "Table created...");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);

        // utworzenie nowej wersji tabeli
        onCreate(db);
    }

    public void addContact(int id, String name, String email, SQLiteDatabase database){
        ContentValues contentValues = new ContentValues(); // przechowuje atrubuty w formacie: klucz - wartosc

        contentValues.put(ContactContract.ContactEntry.CONTACT_ID, id);
        contentValues.put(ContactContract.ContactEntry.NAME, name);
        contentValues.put(ContactContract.ContactEntry.EMAIL, email);


        database.insert(ContactContract.ContactEntry.TABLE_NAME, null, contentValues);

        Log.d("Database Operations", "One Row Inserted");
    }


    public Cursor readContacts(SQLiteDatabase database){

       // kolumny bazy danych
       String[] projections = {ContactContract.ContactEntry.CONTACT_ID,
               ContactContract.ContactEntry.NAME, ContactContract.ContactEntry.EMAIL};

       Cursor cursor = database.query(ContactContract.ContactEntry.TABLE_NAME,
               projections, null, null, null, null, null);

        return cursor;

    }


    //metoda update'owania danych w bazie
    public void updateContact(int id, String name, String email, SQLiteDatabase database){

       ContentValues contentValues = new ContentValues();
       contentValues.put(ContactContract.ContactEntry.NAME, name);
       contentValues.put(ContactContract.ContactEntry.EMAIL, email);

       String selection = ContactContract.ContactEntry.CONTACT_ID + " = " + id;
       database.update(ContactContract.ContactEntry.TABLE_NAME, contentValues, selection, null);




    }


    public void deleteContact(int id, SQLiteDatabase database){
       //warunek dla zapytania do bazy
       String selection = ContactContract.ContactEntry.CONTACT_ID + " = " + id;

       //usuniecie wybranej pozycji z bazy danych
        database.delete(ContactContract.ContactEntry.TABLE_NAME, selection, null);



    }



}
