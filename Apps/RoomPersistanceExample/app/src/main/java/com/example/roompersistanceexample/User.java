package com.example.roompersistanceexample;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "users") //oznacza ze klasa jest odpowiednikiem tabeli w bazie danych
public class User {

    @PrimaryKey // oznacza iz atrybut ten jest kluczem glownym w tabeli bazy danych
    private int id;

    @ColumnInfo(name = "user_name") // oznacza ze atrybut name odpowiada kolumnie user_name w tabeli bazy danych
    private String name;

    @ColumnInfo(name = "user_email")
    private String email;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
