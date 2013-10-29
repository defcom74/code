package com.androidbook.btdt;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import android.os.Bundle;


import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;

import android.view.Menu;

import android.widget.TextView;

public class QuizHelpActivity extends QuizActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);
        InputStream iFile = getResources().openRawResource(R.raw.quizhelp);
        try {
			String sFile = inputStreamToString(iFile);
			TextView textHelp = (TextView) findViewById(R.id.TextView_HelpText);
			textHelp.setText(sFile);
			textHelp.setMovementMethod(new ScrollingMovementMethod());
			textHelp.setMovementMethod(new LinkMovementMethod());
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.quiz_splash, menu);
        return true;
    }
    
    @SuppressWarnings("deprecation")
	public String inputStreamToString(InputStream is) throws IOException {
    	StringBuffer sBuffer = new StringBuffer();
    	DataInputStream dataIO = new DataInputStream(is);
    	String strLine = null;
    	while ((strLine = dataIO.readLine()) != null) {
    	sBuffer.append(strLine + '\n');
    	}
    	dataIO.close();
    	is.close();
    	return sBuffer.toString();
    	}
    
}
