package com.example.roompersistanceexample;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

// entities = {User.class} - oznacza do jakiej klasy odnosi sie tabela bazy danych
@Database(entities = {User.class}, version = 1)
public abstract class MyAppDatabase extends RoomDatabase {

    public abstract  MyDAO myDAO();

}
