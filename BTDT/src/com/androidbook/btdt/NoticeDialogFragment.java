/**
 * 
 */
package com.androidbook.btdt;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


/**
 * @author cpayan
 *
 */
public class NoticeDialogFragment extends DialogFragment {

	
	/* The activity that creates an instance of this dialog fragment must
     * implement this interface in order to receive event callbacks.
     * Each method passes the DialogFragment in case the host needs to query it. */
    public interface NoticeDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog, String strPass1, String strPass2);
        public void onDialogNegativeClick(DialogFragment dialog);
		
    }
    
    // Use this instance of the interface to deliver action events
    NoticeDialogListener mListener;
    
    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (NoticeDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener");
        }
    }
    
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        View view = inflater.inflate(R.layout.dialog_password, null);
        final TextView error = (TextView) view.findViewById(R.id.textView_PwdProblem);
		final EditText p1 = (EditText) view.findViewById(R.id.password1);
		final EditText p2 = (EditText) view.findViewById(R.id.password2);
        builder.setView(view)
        // Add action buttons
               .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int id) {
                       // sign in the user ...
                	   String strPass1 = p1.getText().toString();
                	   String strPass2 = p2.getText().toString();
                	   mListener.onDialogPositiveClick(NoticeDialogFragment.this, strPass1, strPass2);
                	   
                   }
               })
               
               .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                	   NoticeDialogFragment.this.getDialog().cancel();
                   }
               });      
       //looks better with out title
        //builder.setTitle(R.string.passwd_title);
        
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
					error.setTextColor(getResources().getColor(R.color.ok_color));
				} else {
					error.setText(R.string.passwd_pwd_noequal);
					error.setTextColor(getResources().getColor(R.color.error_color));
				}


			}
		});
        return builder.create();
    }

}
