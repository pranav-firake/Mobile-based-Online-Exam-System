package com.example.Aphexams;


import java.io.*;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.*;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseObject;

public class MainActivity extends Activity {
	 TextView welcome;
	 
	 TextView textforregistered;
	 TextView textfornew;
	Button adminLoginbutton;
	 Button studentLoginbutton;
	 Button adminLsignupbutton;
	 Button studentsignupbutton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		adminLoginbutton = (Button)findViewById(R.id.button1);
		adminLoginbutton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent indexIntent=new Intent(MainActivity.this,AdminLogin.class);
					startActivity(indexIntent);	
			}
		});

		
		
		studentLoginbutton = (Button)findViewById(R.id.button2);
		studentLoginbutton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent indexIntent=new Intent(MainActivity.this,StudentLogin.class);
					startActivity(indexIntent);	
			}
		});


		adminLsignupbutton = (Button)findViewById(R.id.button3);
		adminLsignupbutton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent indexIntent=new Intent(MainActivity.this,AdminReg.class);
					startActivity(indexIntent);	
			}
		});
		
		
		
		studentsignupbutton = (Button)findViewById(R.id.button4);
		studentsignupbutton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent indexIntent=new Intent(MainActivity.this,StudentReg.class);
					startActivity(indexIntent);	
			}
		});
		
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu paramMenu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, paramMenu);
		return true;
	}


}
