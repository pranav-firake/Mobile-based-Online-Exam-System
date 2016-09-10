package com.example.Aphexams;
import com.parse.*;
import java.io.*;
import java.util.*;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;
public class SetQuant extends Activity{
	
	public static int  num=1;
	Button bback,banother,bsub;
	TextView top1,top2,top3,top4,tque,tcorrect;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.set_quant);
		Parse.initialize(this, "eX31t72OF1l2SfT72YlLNkBiCiMwRGCf6S8QGMHB", "r70qpWRJ6IMNgTn7YW2dLZUFMmvTn5GQRfNQcwsd");

		tque = (EditText)findViewById(R.id.editText1);
		top1 = (EditText)findViewById(R.id.editText2);
		top2 = (EditText)findViewById(R.id.editText3);
		top3 = (EditText)findViewById(R.id.editText4);
		top4 = (EditText)findViewById(R.id.editText5);
		tcorrect = (EditText)findViewById(R.id.editText6);
		
		bsub = (Button)findViewById(R.id.button1);
		bsub.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				
				ParseObject exams = new ParseObject("exams");
				exams.put("qno", num);
				exams.put("que", tque.getText().toString());
				exams.put("opt1", top1.getText().toString());
				exams.put("opt2", top2.getText().toString());
				exams.put("opt3", top3.getText().toString());
				exams.put("opt4", top4.getText().toString());
				exams.put("rightans",Integer.parseInt(tcorrect.getText().toString()));
				exams.saveInBackground();	
				num++;
				tque.setText("");
				top1.setText("");
				top2.setText("");
				top3.setText("");
				top4.setText("");
				tcorrect.setText("");
				
			}
		});
		
		
		banother = (Button)findViewById(R.id.button2);
		banother.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				tque.setText("");
				top1.setText("");
				top2.setText("");
				top3.setText("");
				top4.setText("");
				tcorrect.setText("");
				
			}
		});
		
		
		
		
		
		
		bback = (Button)findViewById(R.id.button3);
		bback.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent indexIntent=new Intent(SetQuant.this,HomeAdmin.class);
					startActivity(indexIntent);	
			}
		});
	}}


