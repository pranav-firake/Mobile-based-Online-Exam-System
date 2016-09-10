package com.example.Aphexams;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;

public class SucStudReg extends Activity{
	Button sucloginbutton1;
	Button succancelbutton1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.success_student_login);

		sucloginbutton1 = (Button)findViewById(R.id.suclogin1);
		sucloginbutton1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent indexIntent=new Intent(SucStudReg.this,StudentLogin.class);
					startActivity(indexIntent);	
			}
		});
		
		succancelbutton1 = (Button)findViewById(R.id.succancel1);
		succancelbutton1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent indexIntent=new Intent(SucStudReg.this,MainActivity.class);
					startActivity(indexIntent);	
			}
		});
		
		
		
		
}
}
