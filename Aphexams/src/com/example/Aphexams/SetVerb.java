package com.example.Aphexams;
import com.parse.*;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;
public class SetVerb extends Activity{
	
	public static int  num1=1;
	Button vbback,vbanother,vbsub;
	TextView vtop1,vtop2,vtop3,vtop4,vtque,vtcorrect;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.set_verb);
		Parse.initialize(this, "eX31t72OF1l2SfT72YlLNkBiCiMwRGCf6S8QGMHB", "r70qpWRJ6IMNgTn7YW2dLZUFMmvTn5GQRfNQcwsd");

		vtque = (EditText)findViewById(R.id.editText1);
		vtop1 = (EditText)findViewById(R.id.editText2);
		vtop2 = (EditText)findViewById(R.id.editText3);
		vtop3 = (EditText)findViewById(R.id.editText4);
		vtop4 = (EditText)findViewById(R.id.editText5);
		vtcorrect = (EditText)findViewById(R.id.editText6);
		
		vbsub = (Button)findViewById(R.id.button1);
		vbsub.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				
				ParseObject vex = new ParseObject("Vex");
				vex.put("vqno", num1);
				vex.put("vque", vtque.getText().toString());
				vex.put("vopt1", vtop1.getText().toString());
				vex.put("vopt2", vtop2.getText().toString());
				vex.put("vopt3", vtop3.getText().toString());
				vex.put("vopt4", vtop4.getText().toString());
				vex.put("vrightans", Integer.parseInt(vtcorrect.getText().toString()));
				vex.saveInBackground();	
				num1++;
				vtque.setText("");
				vtop1.setText("");
				vtop2.setText("");
				vtop3.setText("");
				vtop4.setText("");
				vtcorrect.setText("");
				
			}
		});
		
		
		vbanother = (Button)findViewById(R.id.button2);
		vbanother.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				vtque.setText("");
				vtop1.setText("");
				vtop2.setText("");
				vtop3.setText("");
				vtop4.setText("");
				vtcorrect.setText("");
				
			}
		});
		
		
		
		
		
		
		vbback = (Button)findViewById(R.id.button3);
		vbback.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent indexIntent=new Intent(SetVerb.this,HomeAdmin.class);
					startActivity(indexIntent);	
			}
		});
	}}


