package com.example.Aphexams;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;

public class StudentChangePword extends Activity{
	Button bscpsubmit,bscpcancel;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.student_c_pword);

		
		bscpcancel = (Button)findViewById(R.id.scpcancel);
		bscpcancel.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent indexIntent=new Intent(StudentChangePword.this,HomeStudent.class);
					startActivity(indexIntent);	
			}
		});
		
		
		
		
}
}