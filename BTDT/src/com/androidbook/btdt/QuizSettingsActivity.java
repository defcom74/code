package com.androidbook.btdt;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


import android.widget.Toast;




public class QuizSettingsActivity extends QuizActivity implements NoticeDialogFragment.NoticeDialogListener {

	SharedPreferences mGameSetting;
	static final int DATE_DIALOG_ID = 0;
	static final int PASSWORD_DIALOG_ID = 1;

	public static class DatePickerFragment extends DialogFragment implements OnDateSetListener  {

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			// Use the current time as the default values for the picker
			
			final Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);	

			// Create a new instance of TimePickerDialog and return it
			return new DatePickerDialog(getActivity(),  this, year,  month,  day);
		}

		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			// TODO Auto-generated method stub
			
			
		}

		/* (non-Javadoc)
		 * @see android.app.DialogFragment#onStart()
		 */
		@Override
		public void onStart() {
			// TODO Auto-generated method stub
			super.onStart();
		}
		
		
	}

	
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        
        mGameSetting = getSharedPreferences(GAME_PREFERENCES, MODE_PRIVATE);
        
        Spinner spin = (Spinner) findViewById(R.id.Spinner_Gender);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View itemSelected,
					int selectedItemPosition, long selectedId) {
				// TODO Auto-generated method stub
				//write preference
		        getSharedPreferences(GAME_PREFERENCES, MODE_PRIVATE).edit().putInt(GAME_PREFERENCES_GENDER, selectedItemPosition).commit();
		        Toast.makeText(QuizSettingsActivity.this,"Gender Dialog", Toast.LENGTH_LONG).show();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parect) {
				// TODO Auto-generated method stub
				
			}
        	
		});
        
        final EditText nicknameText = (EditText) findViewById(R.id.EditText_Nickname);
        if (mGameSetting.contains(GAME_PREFERENCES_NICKNAME)){
        	nicknameText.setText(mGameSetting.getString(GAME_PREFERENCES_NICKNAME, ""));
        	
        }
        
        final EditText emailText = (EditText) findViewById(R.id.EditText_Email);
        if (mGameSetting.contains(GAME_PREFERENCES_EMAIL)){
        	emailText.setText(mGameSetting.getString(GAME_PREFERENCES_EMAIL, ""));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.quiz_splash, menu);
        return true;
    }
    
    public void onSetPasswordButtonClick(View view){
    	try {
			//Toast.makeText(QuizSettingsActivity.this,"Password Dialog", Toast.LENGTH_LONG).show();
			DialogFragment dialog = new NoticeDialogFragment();
			dialog.show(getFragmentManager(), "NoticeDialogFragment");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    public void onPickDateButtonClick(View view){
    	//Toast.makeText(QuizSettingsActivity.this,"DataPicker Dialog", Toast.LENGTH_LONG).show();
    	
    	DialogFragment newFragment = new DatePickerFragment(){
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
            	Time dateOfBirth = new Time();
            	dateOfBirth.set(day, month, year);
            	long dtDob = dateOfBirth.toMillis(true);
            	
              TextView text = (TextView) findViewById(R.id.TextView_date);
              text.setText(DateFormat.format("MMMM dd,  yyyy", dtDob));
              Editor editor = mGameSetting.edit();
              editor.putLong(GAME_PREFERENCES_DOB, dtDob);
              editor.commit();
              
            }

			/* (non-Javadoc)
			 * @see com.androidbook.btdt.QuizSettingsActivity.DatePickerFragment#onStart()
			 */
			@Override
			public void onStart() {
				// TODO Auto-generated method stub
				super.onStart();
				
				
					
				
			}

			/* (non-Javadoc)
			 * @see com.androidbook.btdt.QuizSettingsActivity.DatePickerFragment#onCreateDialog(android.os.Bundle)
			 */
			@Override
			public Dialog onCreateDialog(Bundle savedInstanceState) {
				// TODO Auto-generated method stub
				int iDay, iMOnt, iYear;
				if (mGameSetting.contains(GAME_PREFERENCES_DOB)){
					long msBirthDate = mGameSetting.getLong(GAME_PREFERENCES_DOB, 0);
					Time dateOfBirth = new Time();
					dateOfBirth.set(msBirthDate);
					iDay = dateOfBirth.monthDay;
					iMOnt = dateOfBirth.month;
					iYear = dateOfBirth.year;
									
				} else {
					Calendar cal = Calendar.getInstance();
					iDay = cal.get(Calendar.DAY_OF_MONTH);
					iMOnt = cal.get(Calendar.MONTH);
					iYear = cal.get(Calendar.YEAR );
					
				}
				
				return new DatePickerDialog(getActivity(),  this, iYear,  iMOnt,  iDay);
			}
			
			
            
            
         };
        newFragment.show(getFragmentManager(), "datePicker");
        
        

    }


	/* (non-Javadoc)
	 * @see android.app.Activity#onPause()
	 */
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		final EditText nicknameText = (EditText) findViewById(R.id.EditText_Nickname);
		String sNickName = nicknameText.getText().toString();
		Editor editor = mGameSetting.edit();
		editor.putString(GAME_PREFERENCES_NICKNAME, sNickName);
		
		final EditText emailText = (EditText) findViewById(R.id.EditText_Email);
		String sEmail = emailText.getText().toString();
		editor.putString(GAME_PREFERENCES_EMAIL, sEmail);
		
		editor.commit();
		
	}


	@Override
	public void onDialogPositiveClick(DialogFragment dialog, String strPass1, String strPass2 ) {
		// TODO Auto-generated method stub
		
		TextView passInfo = (TextView) findViewById(R.id.TextView_Passwrod_Info);
		String strPassword1 = strPass1;
		String strPassword2 = strPass2;
		if (strPassword1.equals(strPassword2)){
			Editor editor = mGameSetting.edit();
			editor.putString(GAME_PREFERENCES_PASSWORD, strPassword1);
			editor.commit();
			passInfo.setText(R.string.setting_pwd_set);
			
		}else {
			Log.d(APP_TAG, "Password don not match. Not saving. Keeping old password (if set)");
		}
		
	}


	@Override
	public void onDialogNegativeClick(DialogFragment dialog) {
		// TODO Auto-generated method stub
		
		
	}
	
	
    
	
    
}


