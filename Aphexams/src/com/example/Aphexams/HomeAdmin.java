package com.example.Aphexams;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;

public class HomeAdmin extends Activity {
	Button viewstudentbutton;
	Button viewquebutton;
	Button setquebutton;
	Button changepwordbutton;
	Button hacancelbutton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_admin);

		viewstudentbutton = (Button)findViewById(R.id.viewstudent);
		viewstudentbutton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				final ProgressDialog dlg = new ProgressDialog(HomeAdmin.this);
		        dlg.setTitle("Please wait.");
		        dlg.setMessage("Processing request.  Navigating to student details.  Please wait.");
		        dlg.show();
				Intent indexIntent=new Intent(HomeAdmin.this,ViewStudent.class);
					startActivity(indexIntent);	
			}
		});
		
		viewquebutton = (Button)findViewById(R.id.viewque);
		viewquebutton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				final ProgressDialog dlg = new ProgressDialog(HomeAdmin.this);
		        dlg.setTitle("Please wait.");
		        dlg.setMessage("Processing request.  Navigating to questions.  Please wait.");
		        dlg.show();
				Intent indexIntent=new Intent(HomeAdmin.this,ViewQues.class);
					startActivity(indexIntent);	
			}
		});
		
		setquebutton = (Button)findViewById(R.id.setque);
		setquebutton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				final ProgressDialog dlg = new ProgressDialog(HomeAdmin.this);
		        dlg.setTitle("Please wait.");
		        dlg.setMessage("Processing request.  Navigating to set questions.  Please wait.");
		        dlg.show();
				Intent indexIntent=new Intent(HomeAdmin.this,SetQues.class);
					startActivity(indexIntent);	
			}
		});
		
		changepwordbutton = (Button)findViewById(R.id.changepword);
		changepwordbutton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				final ProgressDialog dlg = new ProgressDialog(HomeAdmin.this);
		        dlg.setTitle("Please wait.");
		        dlg.setMessage("Processing request.  Navigating to change password.  Please wait.");
		        dlg.show();
				Intent indexIntent=new Intent(HomeAdmin.this,AdminChangePword.class);
					startActivity(indexIntent);	
			}
		});
		
		hacancelbutton = (Button)findViewById(R.id.hacancel);
		hacancelbutton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				Intent indexIntent=new Intent(HomeAdmin.this,MainActivity.class);
					startActivity(indexIntent);	
			}
		});
		
		
		
		
}
}
	
	

