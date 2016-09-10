package com.example.Aphexams;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;

import com.parse.*;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.widget.*;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;


public class StudentLogin extends Activity {
	Button sloginbutton;
	Button scancelbutton;
	EditText sid;
	EditText spword;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.student_login);
		Parse.initialize(this, "eX31t72OF1l2SfT72YlLNkBiCiMwRGCf6S8QGMHB", "r70qpWRJ6IMNgTn7YW2dLZUFMmvTn5GQRfNQcwsd");
		
		sid = (EditText) findViewById(R.id.studentid);
		spword = (EditText) findViewById(R.id.studentpword);
		
		
		sloginbutton = (Button)findViewById(R.id.slbutton1);
		sloginbutton.setOnClickListener(new OnClickListener() {
		
			public void onClick(View v) {
				
				ParseQuery<ParseObject> query = ParseQuery.getQuery("studAuth");
				 query.whereEqualTo("StudUserName",sid.getText().toString());
				 query.whereEqualTo("StudPassword",spword.getText().toString());
		
				 query.getFirstInBackground(new GetCallback<ParseObject>() {
					  public void done(ParseObject object, ParseException e) {
				            if (object != null) {
				            	final ProgressDialog dlg = new ProgressDialog(StudentLogin.this);
						        dlg.setTitle("Please wait.");
						        dlg.setMessage("Logging in.  Please wait.");
						        dlg.show();
				            	Intent indexIntent=new Intent(StudentLogin.this,HomeStudent.class);
				            	indexIntent.putExtra("studentInvoking",sid.getText().toString());
								startActivity(indexIntent);
				                }
				             else {
				            	Toast.makeText(StudentLogin.this, "Error: Check out data!!!", Toast.LENGTH_SHORT).show();
				            }

				        }
				    });
				
				
				
				
				
				
				
				
				
				
				
				
				
				
					
				

			}
		});
		
		scancelbutton = (Button)findViewById(R.id.slbutton2);
		scancelbutton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent indexIntent=new Intent(StudentLogin.this,MainActivity.class);
					startActivity(indexIntent);	
			}
		});
		
		

}

	private ParseObject ParseObject(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
