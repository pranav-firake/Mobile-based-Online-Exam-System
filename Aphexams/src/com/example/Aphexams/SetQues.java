package com.example.Aphexams;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;
public class SetQues extends Activity{
	
	Button bgo;
	public static int i;
	String selectx;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.set_ques);
		
		
		int id = ((RadioGroup)findViewById( R.id.question_set_type)).getCheckedRadioButtonId();
		if(id==R.id.radioQuant){i=1;}else if(id==R.id.radioVerb){i=2;}
		

		bgo = (Button)findViewById(R.id.go);
		bgo.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int id = ((RadioGroup)findViewById( R.id.question_set_type)).getCheckedRadioButtonId();
				if(id==R.id.radioQuant){i=1;}else if(id==R.id.radioVerb){i=2;}
				if(i==1)
				{
				Intent indexIntent=new Intent(SetQues.this,SetQuant.class);
					startActivity(indexIntent);
				}else if(i==2)
				{
					Intent intent=new Intent(SetQues.this,SetVerb.class);
				startActivity(intent);
				}
				}
				
			
		});
		
		
		
		
		
		
		
		
	}}


