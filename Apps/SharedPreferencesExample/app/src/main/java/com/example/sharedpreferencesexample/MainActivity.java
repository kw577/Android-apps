package com.example.sharedpreferencesexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferenceConfig preferenceConfig;
    private EditText userName, userPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferenceConfig = new SharedPreferenceConfig(getApplicationContext());


        // polaczenie z interfejsem - zdefiniowane komponenty w plikach layoutu .xml
        userName = findViewById(R.id.user_name);
        userPassword = findViewById(R.id.user_password);


        //sprawdzamy czy uzytkownik jest juz zalogowany
        if(preferenceConfig.readLoginStatus()){
            //przeniesienie do ekranu powitalnego - activity_success.xml
            startActivity(new Intent(this, SuccessActivity.class));

            // zkonczenie biezacego activity - ekranu logowania
            finish();
        }

    }

    public void loginUser(View view) {
        String username = userName.getText().toString();
        String userpassword = userPassword.getText().toString();

        // pobranie odpowiedniego loginu i hasla - w tym przykladzie zostaly one zapisane w res/values/strings.xml
        if(username.equals(getResources().getString(R.string.user_name)) && userpassword.equals(getResources().getString(R.string.user_password))){
            //przeniesienie do ekranu powitalnego - activity_success.xml
            startActivity(new Intent(this, SuccessActivity.class));
            preferenceConfig.writeLoginStatus(true);

            // zkonczenie biezacego activity - ekranu logowania
            finish();
        } else {
            // informacja o bledzie logowania
            Toast.makeText(this, "Login failed... Try again...", Toast.LENGTH_SHORT).show();

            // zyczyszczenie pol formularza logowania
            userName.setText("");
            userPassword.setText("");
        }
    }
}
