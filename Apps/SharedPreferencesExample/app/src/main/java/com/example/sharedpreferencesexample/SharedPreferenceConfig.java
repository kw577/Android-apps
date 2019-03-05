package com.example.sharedpreferencesexample;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceConfig {

    private SharedPreferences sharedPreferences;
    private Context context;

    //konstruktor
    public SharedPreferenceConfig(Context context){
        this.context = context;

        // pobiera string z pliku strings.xml - zmienna o nazwie login_preference
        sharedPreferences = context.getSharedPreferences(context.getResources()
                .getString(R.string.login_preference), Context.MODE_PRIVATE);
    }

    public void writeLoginStatus(boolean status){
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // zapisuje stan logowania
        editor.putBoolean(context.getResources()
                .getString(R.string.login_status_preference), status);

    }


    public boolean readLoginStatus(){
        boolean status = false;

        status = sharedPreferences.getBoolean(context.getResources()
                .getString(R.string.login_status_preference), false);


        return status;


    }

}
