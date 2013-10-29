package com.androidbook.btdt;

import android.app.DatePickerDialog.OnDateSetListener;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.TextView;

public class EditSessionActivity extends FragmentActivity implements OnDateSetListener {

	@Override
	public void onDateSet(DatePicker view, int year, int monthOfYear,
			int dayOfMonth) {
		try {
			// TODO Auto-generated method stub
			Log.w("DatePicker","Date = " + year);
			TextView text = (TextView) findViewById(R.id.TextView_date);
			text.setText("Date  "  );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
