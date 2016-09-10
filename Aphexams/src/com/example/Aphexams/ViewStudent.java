package com.example.Aphexams;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.*;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
public class ViewStudent extends Activity{
	TextView tqmarks,tvmarks,ttotal,tphn,tname,q,v,t,EnterText;
	EditText tsid;
	Button vscancelbutton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_students);
		
		vscancelbutton = (Button)findViewById(R.id.vscancel);
		vscancelbutton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent indexIntent=new Intent(ViewStudent.this,HomeAdmin.class);
					startActivity(indexIntent);	
			}
		});
	
	}
}
