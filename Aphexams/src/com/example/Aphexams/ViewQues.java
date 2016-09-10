package com.example.Aphexams;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;

public class ViewQues extends Activity{
	
	Button bgo,bso;
	public static int i;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_ques);
	
		
		
		
		bgo = (Button)findViewById(R.id.button1);
		bgo.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent=new Intent(ViewQues.this,ViewQ.class);
				startActivity(intent);
				}
				
			
		});
		bso = (Button)findViewById(R.id.button2);
		bso.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent=new Intent(ViewQues.this,ViewV.class);
				startActivity(intent);
				}
				
			
		});
		
		
		
		
		
		
		
		
	}}


