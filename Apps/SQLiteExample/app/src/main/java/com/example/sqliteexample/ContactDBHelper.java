package com.example.sqliteexample;

import android.content.ContentValues;
import android.content.Context;
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

}
