package com.example.roompersistanceexample;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MyDAO {

    @Insert // oznacza ze ta metoda sluzy do dodawania nowych rekordow do bazy danych
    public void addUser(User user);

    @Query("select * from users")
    public List<User> getUsers();
}
