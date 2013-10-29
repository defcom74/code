package com.androidbook.btdt;


import android.app.DialogFragment;


import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;



public class PasswordDialog  extends DialogFragment{
	
	public PasswordDialog() {
		// Empty constructor required for DialogFragment

	}

	/* (non-Javadoc)
	 * @see android.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.password_dialog, container);
		
		 final TextView error = (TextView) view.findViewById(R.id.textView_PwdProblem);
		 final TextView p1 = (TextView) view.findViewById(R.id.textView_Pwd1);
		 final TextView p2 = (TextView) view.findViewById(R.id.textView_Pwd2);
		p2.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				String strPass1 = p1.getText().toString();
				String strPass2 = p2.getText().toString();
				if (strPass1.equals(strPass2)){
					error.setText(R.string.passwd_pwd_equal);
				}else
				{
					error.setText(R.string.passwd_pwd_noequal);
				}
				
			}
		});
		
		Button btnOk = (Button) view.findViewById(R.id.button_OK);
		btnOk.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		return view;
		
		
		
	}
	
	
	
	

	
	

}
