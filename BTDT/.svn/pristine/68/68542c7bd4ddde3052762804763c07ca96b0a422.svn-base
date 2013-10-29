package com.androidbook.btdt;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParserException;

import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class QuizScoresActivity extends QuizActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scores);
        
        TabHost host = (TabHost) findViewById(R.id.TabHost1);
        host.setup();
        
        TabSpec allScoresTab = host.newTabSpec("allTab");
        allScoresTab.setIndicator(getResources().getString(R.string.all_scores), 
        		getResources().getDrawable(android.R.drawable.star_big_on));
        allScoresTab.setContent(R.id.ScrollViewAllScores);
        host.addTab(allScoresTab);
        
        TabSpec friendScores = host.newTabSpec("friendScores");
        friendScores.setIndicator(getResources().getString(R.string.friends_scores),
        		getResources().getDrawable(android.R.drawable.star_on));
        friendScores.setContent(R.id.ScrollViewFriendScores);
        host.addTab(friendScores);
        
        host.setCurrentTabByTag("allTab");
        
        XmlResourceParser xmlAllScores = getResources().getXml(R.xml.allscores);
        XmlResourceParser xmlFriendScores = getResources().getXml(R.xml.friendcores);
        
     // Retrieve the TableLayout references
        TableLayout allScoresTable = (TableLayout) findViewById(R.id.TableLayout_AllScores);
        TableLayout friendScoresTable = (TableLayout) findViewById(R.id.TableLayout_FriendScores);
        try {
        	initializeHeaderRow(allScoresTable);
			processScores(allScoresTable, xmlAllScores);
			initializeHeaderRow(friendScoresTable);
			processScores(friendScoresTable, xmlFriendScores);
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			Log.e(APP_TAG, "Failed to load scores", e);
		}
        
        
    }
    
    /**
     * Add a header {@code TableRow} to the {@code TableLayout} (styled)
     * 
     * @param scoreTable
     *            the {@code TableLayout} that the header row will be added to
     */
    private void initializeHeaderRow(TableLayout scoreTable) {
        // Create the Table header row
        TableRow headerRow = new TableRow(this);
        int textColor = getResources().getColor(R.color.logo_color);
        float textSize = getResources().getDimension(R.dimen.help_text_size);
        addTextToRowWithValues(headerRow, getResources().getString(R.string.username), textColor, textSize);
        addTextToRowWithValues(headerRow, getResources().getString(R.string.score), textColor, textSize);
        addTextToRowWithValues(headerRow, getResources().getString(R.string.rank), textColor, textSize);
        scoreTable.addView(headerRow);
    }

    /**
     * Churn through an XML score information and populate a {@code TableLayout}
     * 
     * @param scoreTable
     *            The {@code TableLayout} to populate
     * @param scores
     *            A standard {@code XmlResourceParser} containing the scores
     * @throws XmlPullParserException
     *             Thrown on XML errors
     * @throws IOException
     *             Thrown on IO errors reading the XML
     */
    private void processScores(final TableLayout scoreTable, XmlResourceParser scores) throws XmlPullParserException,
            IOException {
        int eventType = -1;
        boolean bFoundScores = false;
        // Find Score records from XML
        while (eventType != XmlResourceParser.END_DOCUMENT) {
            if (eventType == XmlResourceParser.START_TAG) {
                // Get the name of the tag (eg scores or score)
                String strName = scores.getName();
                if (strName.equals("score")) {
                    bFoundScores = true;
                    String scoreValue = scores.getAttributeValue(null, "score");
                    String scoreRank = scores.getAttributeValue(null, "rank");
                    String scoreUserName = scores.getAttributeValue(null, "username");
                    insertScoreRow(scoreTable, scoreValue, scoreRank, scoreUserName);
                }
            }
            eventType = scores.next();
        }
        // Handle no scores available
        if (bFoundScores == false) {
            final TableRow newRow = new TableRow(this);
            TextView noResults = new TextView(this);
            noResults.setText(getResources().getString(R.string.no_scores));
            newRow.addView(noResults);
            scoreTable.addView(newRow);
        }
    }

    /**
     * {@code processScores()} helper method -- Inserts a new score {@code
     * TableRow} in the {@code TableLayout}
     * 
     * @param scoreTable
     *            The {@code TableLayout} to add the score to
     * @param scoreValue
     *            The value of the score
     * @param scoreRank
     *            The ranking of the score
     * @param scoreUserName
     *            The user who made the score
     */
    private void insertScoreRow(final TableLayout scoreTable, String scoreValue, String scoreRank, String scoreUserName) {
        final TableRow newRow = new TableRow(this);
        int textColor = getResources().getColor(R.color.title_color);
        float textSize = getResources().getDimension(R.dimen.help_text_size);
        addTextToRowWithValues(newRow, scoreUserName, textColor, textSize);
        addTextToRowWithValues(newRow, scoreValue, textColor, textSize);
        addTextToRowWithValues(newRow, scoreRank, textColor, textSize);
        scoreTable.addView(newRow);
    }

    /**
     * {@code insertScoreRow()} helper method -- Populate a {@code TableRow} with
     * three columns of {@code TextView} data (styled)
     * 
     * @param tableRow
     *            The {@code TableRow} the text is being added to
     * @param text
     *            The text to add
     * @param textColor
     *            The color to make the text
     * @param textSize
     *            The size to make the text
     */
    private void addTextToRowWithValues(final TableRow tableRow, String text, int textColor, float textSize) {
        TextView textView = new TextView(this);
        textView.setTextSize(textSize);
        textView.setTextColor(textColor);
        textView.setText(text);
        tableRow.addView(textView);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.quiz_splash, menu);
        return true;
    }
    
}
