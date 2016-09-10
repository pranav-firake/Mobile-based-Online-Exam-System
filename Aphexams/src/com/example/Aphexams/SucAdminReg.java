package com.example.Aphexams;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;

public class SucAdminReg extends Activity{
	Button sucloginbutton;
	Button succancelbutton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.success_admin_registration);

		sucloginbutton = (Button)findViewById(R.id.suclogin);
		sucloginbutton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent indexIntent=new Intent(SucAdminReg.this,AdminLogin.class);
					startActivity(indexIntent);	
			}
		});
		
		succancelbutton = (Button)findViewById(R.id.succancel);
		succancelbutton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent indexIntent=new Intent(SucAdminReg.this,MainActivity.class);
					startActivity(indexIntent);	
			}
		});
		
		
		
		
}
}