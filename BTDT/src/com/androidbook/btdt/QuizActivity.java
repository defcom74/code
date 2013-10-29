package com.androidbook.btdt;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class QuizActivity extends Activity {

    public static final String  GAME_PREFERENCES = "GamePrefs";
    public static  final String APP_TAG = "Game";
    
    public static  final String GAME_PREFERENCES_NICKNAME = "Nickname"; //String
    public static  final String GAME_PREFERENCES_EMAIL = "Email"; //string
    public static  final String GAME_PREFERENCES_PASSWORD = "Password"; //string
    public static  final String GAME_PREFERENCES_DOB = "DOB"; // lONG
    public static  final String GAME_PREFERENCES_GENDER = "Gender"; // Int
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.quiz_splash, menu);
        return true;
    }
    
}
