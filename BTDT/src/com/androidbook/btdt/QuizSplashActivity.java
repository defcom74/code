package com.androidbook.btdt;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class QuizSplashActivity extends QuizActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(APP_TAG, "In Activity QuizSplashActivity");
        setContentView(R.layout.splash);
        String sLastDate = "Empty";
        if (getSharedPreferences(GAME_PREFERENCES, MODE_PRIVATE).contains("LastDate") == true)
        {
            sLastDate = getSharedPreferences(GAME_PREFERENCES, MODE_PRIVATE).getString("LastDate","None");
            Log.i(APP_TAG,"DATE: " + sLastDate);

        }
        Log.i(APP_TAG,"DATE: " + sLastDate);
        //update the date in preference
        final Date  dtDate = new Date();


        final SimpleDateFormat sDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ",Locale.US);
        
        //write preference
        getSharedPreferences(GAME_PREFERENCES, MODE_PRIVATE).edit().putString("LastDate",sDF.format(dtDate) ).commit();

        TextView logo1 = (TextView) findViewById(R.id.textViewTopTitle);
        Animation fade1 = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        logo1.startAnimation(fade1);


        Animation spinin = AnimationUtils.loadAnimation(this, R.anim.custom_anim);
        LayoutAnimationController controller = new LayoutAnimationController((spinin));
        TableLayout table = (TableLayout) findViewById(R.id.TableLayout01);
        for (int i = 0; i < table.getChildCount(); i++){
            TableRow row = (TableRow) table.getChildAt(i);
            row.setLayoutAnimation(controller);
            controller.setOrder(LayoutAnimationController.ORDER_RANDOM);

        }

        TextView logo2 = (TextView) findViewById(R.id.textViewBottomTitle);
        Animation fade2 = AnimationUtils.loadAnimation(this, R.anim.fade_in2);
        logo2.startAnimation((fade2));

        fade2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(QuizSplashActivity.this, QuizMenuActivity.class));
                QuizSplashActivity.this.finish();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.quiz_splash, menu);
        return true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        //stop Animation
        TextView logo1 = (TextView) findViewById(R.id.textViewTopTitle);
        logo1.clearAnimation();

        TextView logo2 = (TextView) findViewById(R.id.textViewBottomTitle);
        logo2.clearAnimation();

        TableLayout table = (TableLayout) findViewById(R.id.TableLayout01);
        for (int i =0; i < table.getChildCount(); i++){
            TableRow row = (TableRow) table.getChildAt(i);
            row.clearAnimation();
        }

    }
}
