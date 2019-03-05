package com.example.sqliteexample;

public final class ContactContract {

    private ContactContract(){

    }


    public static class ContactEntry{

        //nazwa tabeli w bazie danych
        public static final String TABLE_NAME = "contact_info";

        //nazwy kolumn
        public static final String CONTACT_ID = "contact_id";
        public static final String NAME = "name";
        public static final String EMAIL = "email";
    }


}
