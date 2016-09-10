package com.example.Aphexams;

import android.os.Bundle;

import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.ParseObject;
import com.parse.SignUpCallback;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;

public class StudentReg extends Activity {
	Button srsubmitbutton;
	Button srcancelbutton;
	EditText sruname1;
	EditText srpword1;
	EditText srconfpword1;
	EditText srphn1;
	String a="Invalid";
	String b="blank password";
	String c="Mismatch";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.student_registration);
		Parse.initialize(this, "eX31t72OF1l2SfT72YlLNkBiCiMwRGCf6S8QGMHB", "r70qpWRJ6IMNgTn7YW2dLZUFMmvTn5GQRfNQcwsd");
		
		sruname1 = (EditText) findViewById(R.id.sruname);
		srpword1 = (EditText) findViewById(R.id.srpword);
		srconfpword1 = (EditText)findViewById(R.id.srconfpword);
		srphn1 = (EditText)findViewById(R.id.srphn);
		
		
		
		srsubmitbutton = (Button)findViewById(R.id.srsubmit);
		srsubmitbutton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v){
				
				// Validate the sign up data
		        boolean validationError = false;
		        StringBuilder validationErrorMessage =
		            new StringBuilder(a);
		        if (isEmpty(sruname1)) {
		          validationError = true;
		          validationErrorMessage.append(a);
		        }
		        if (isEmpty(srpword1)||isEmpty(srphn1)) {
		          if (validationError) {
		            validationErrorMessage.append(a);
		          }
		          validationError = true;
		          validationErrorMessage.append(b);
		        }
		        if (!isMatching(srpword1, srconfpword1)) {
		          if (validationError) {
		            validationErrorMessage.append(a);
		          }
		          validationError = true;
		          validationErrorMessage.append(c);
		        }
		        validationErrorMessage.append(a);

		        // If there is a validation error, display the error
		        if (validationError) {
		          Toast.makeText(StudentReg.this, validationErrorMessage.toString(), Toast.LENGTH_LONG)
		              .show();
		          return;
		        }

		        
		        
		        ParseObject studAuth = new ParseObject("studAuth");
		        studAuth.put("StudUserName",sruname1.getText().toString());
		        studAuth.put("StudPassword",srpword1.getText().toString());
		        studAuth.put("StudPhnNo",srphn1.getText().toString());
		        studAuth.saveInBackground();
		        // Set up a progress dialog
		        final ProgressDialog dlg = new ProgressDialog(StudentReg.this);
		        dlg.setTitle("Please wait.");
		        dlg.setMessage("Signing up.  Please wait.");
		        dlg.show();
		        
		       
		        

	
		              // Start an intent for the dispatch activity
		              Intent intent = new Intent(StudentReg.this, SucStudReg.class);
		              intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
		              startActivity(intent);
			}  
		      }
				);    
				
				
			
		
		
		srcancelbutton = (Button)findViewById(R.id.srcancel);
		srcancelbutton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent indexIntent=new Intent(StudentReg.this,MainActivity.class);
					startActivity(indexIntent);	
			}
		});
		
	
	}
	private boolean isEmpty(EditText etText) {
	    if (etText.getText().toString().trim().length() > 0) {
	      return false;
	    } else {
	      return true;
	    }
	  }

	  private boolean isMatching(EditText etText1, EditText etText2) {
	    if (etText1.getText().toString().equals(etText2.getText().toString())) {
	      return true;
	    } else {
	      return false;
	    }
	  }
		
		}



