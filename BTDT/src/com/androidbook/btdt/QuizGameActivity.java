package com.androidbook.btdt;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;

/**
 * @author cpayan
 *
 */
public class QuizGameActivity extends QuizActivity {

	
	private TextSwitcher mQuestionText;
	private ImageSwitcher mQuestionImage;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        
        mQuestionText = (TextSwitcher) findViewById(R.id.TextSwitcher_QuestionText);
        mQuestionText.setFactory(new MyTextSwitcherFactory(){

			/* (non-Javadoc)
			 * @see com.androidbook.btdt.MyTextSwitcherFactory#makeView()
			 */
			@Override
			public View makeView() {
				// TODO Auto-generated method stub
				TextView textView = (TextView) LayoutInflater.from(getApplicationContext()).inflate(
						R.layout.text_switcher_view, mQuestionText, false);
				return textView;
			}
        	
        });
        
        mQuestionImage = (ImageSwitcher) findViewById(R.id.ImagenSwithcer_QuestionImage);
        mQuestionImage.setFactory(new MyImageSwitcherFactory(){

			/* (non-Javadoc)
			 * @see com.androidbook.btdt.MyImageSwitcherFactory#makeView()
			 */
			@Override
			public View makeView() {
				// TODO Auto-generated method stub
				ImageView imageView = (ImageView) LayoutInflater.from(getApplicationContext()).inflate(
						R.layout.imagen_switcher_view, mQuestionImage,false);
				return imageView;
			}
        	
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.gameoptions, menu);
        menu.findItem(R.id.help_menu_item).setIntent(new Intent(this, QuizHelpActivity.class));
        
        menu.findItem(R.id.settings_menu_item).setIntent(new Intent(this, QuizSettingsActivity.class));
        
        menu.findItem(R.id.scores_menu_tem).setIntent(new Intent(this, QuizScoresActivity.class));
        return true;
    }


	/* (non-Javadoc)
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return super.onOptionsItemSelected(item);
	}
    
    public void onYesClick(View view){
    	
    }
    
    public void onNoClick(View view){
    	
    }
    
}
