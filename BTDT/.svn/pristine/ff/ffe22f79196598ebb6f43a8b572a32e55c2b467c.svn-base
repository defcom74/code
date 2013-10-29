package com.androidbook.btdt;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class QuizMenuActivity extends QuizActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        ListView menuList = (ListView) findViewById(R.id.listView_Menu);
        
//        String[] items = {getResources().getString(R.string.menu_item_play),
//        getResources().getString(R.string.menu_item_scores),
//        getResources().getString(R.string.menu_item_settings),
//        getResources().getString(R.string.menu_item_help)};
        
        String[] items = getResources().getStringArray(R.array.menu_options_array);
        
        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this, R.layout.menu_item, items);
        menuList.setAdapter(adapt);

        RelativeLayout relLayout = (RelativeLayout) findViewById(R.id.relativeLayoutMain);
        Animation anim1 = AnimationUtils.loadAnimation(this, R.anim.fade_in2);
        
        relLayout.startAnimation(anim1);
        
        
        
        

        menuList.setOnItemClickListener( new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id){
                TextView textView = (TextView) itemClicked;
                String strText = textView.getText().toString();
                if (strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_play)))
                {
                    startActivity(new Intent(QuizMenuActivity.this,  QuizGameActivity.class));


                } else if (strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_help))){
                    startActivity(new Intent(QuizMenuActivity.this, QuizHelpActivity.class));

                } else if (strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_scores))){
                    startActivity(new Intent(QuizMenuActivity.this, QuizScoresActivity.class));
                } else if (strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_settings))){
                    startActivity(new Intent(QuizMenuActivity.this, QuizSettingsActivity.class));
                }

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.quiz_splash, menu);
        return true;
    }


    
}
