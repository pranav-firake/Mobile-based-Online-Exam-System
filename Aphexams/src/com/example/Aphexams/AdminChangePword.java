package com.example.Aphexams;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;

public class AdminChangePword extends Activity{
	Button acpsubmit,acpcancel;
	EditText et1,et2,et3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admin_c_pword);

		
		acpcancel = (Button)findViewById(R.id.acp2);
		acpcancel.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent indexIntent=new Intent(AdminChangePword.this,HomeAdmin.class);
					startActivity(indexIntent);	
			}
		});
		
		
		
		
}
}