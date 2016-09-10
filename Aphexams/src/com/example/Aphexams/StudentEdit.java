package com.example.Aphexams;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.*;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class StudentEdit extends Activity{
Button bsesubmit,bsecancel;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.student_edit);
		
		bsecancel = (Button)findViewById(R.id.secancel);
		bsecancel.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent indexIntent=new Intent(StudentEdit.this,HomeStudent.class);
					startActivity(indexIntent);	
			}
		});
	
	
}
}