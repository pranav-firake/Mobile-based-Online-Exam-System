package com.example.Aphexams;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.widget.*;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;


public class AdminLogin extends Activity {
	Button aloginbutton;
	Button acancelbutton;
	EditText aid;
	EditText apword;
	String a="error";
	String b="  Blank user name field";
	String c="   Blank password field";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admin_login);
		Parse.initialize(this, "eX31t72OF1l2SfT72YlLNkBiCiMwRGCf6S8QGMHB", "r70qpWRJ6IMNgTn7YW2dLZUFMmvTn5GQRfNQcwsd");
		
		
		aid = (EditText) findViewById(R.id.adminid);
		apword = (EditText) findViewById(R.id.adminpword);
		
		
		
		
		
		aloginbutton = (Button)findViewById(R.id.albutton1);
		aloginbutton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				// Validate the log in data
		        boolean validationError = false;
		        StringBuilder validationErrorMessage =
		            new StringBuilder(a);
		        if (isEmpty(aid)) {
		          validationError = true;
		          validationErrorMessage.append(b);
		        }
		        if (isEmpty(apword)) {
		          if (validationError) {
		            validationErrorMessage.append(a);
		          }
		          validationError = true;
		          validationErrorMessage.append(c);
		        }
		        validationErrorMessage.append(a);

		        // If there is a validation error, display the error
		        if (validationError) {
		          Toast.makeText(AdminLogin.this, validationErrorMessage.toString(), Toast.LENGTH_LONG)
		              .show();
		          return;
		        }

		        // Set up a progress dialog
		        final ProgressDialog dlg = new ProgressDialog(AdminLogin.this);
		        dlg.setTitle("Please wait.");
		        dlg.setMessage("Logging in.  Please wait.");
		        dlg.show();
		        // Call the Parse login method
		        ParseUser.logInInBackground(aid.getText().toString(), apword.getText()
		            .toString(), new LogInCallback() {

		          @Override
		          public void done(ParseUser user, ParseException e) {
		            dlg.dismiss();
		            if (e != null) {
		              // Show the error message
		              Toast.makeText(AdminLogin.this, e.getMessage(), Toast.LENGTH_LONG).show();
		            } else {
		              // Start an intent for the dispatch activity
		              Intent intent = new Intent(AdminLogin.this, HomeAdmin.class);
		              intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
		              startActivity(intent);
		            }
		          }
		        });
				
			}
		});
		
		acancelbutton = (Button)findViewById(R.id.albutton2);
		acancelbutton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent indexIntent=new Intent(AdminLogin.this,MainActivity.class);
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
}