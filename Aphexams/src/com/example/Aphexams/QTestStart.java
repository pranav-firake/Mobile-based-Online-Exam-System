package com.example.Aphexams;

import com.parse.*;

import java.io.*;
import java.util.*;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.widget.*;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.content.Intent;
import android.widget.*;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

import java.util.*;
public class QTestStart extends Activity{

	Button bqtssubmit,bqtsnext,bqtsexit;
	TextView oop1,oop2,oop3,oop4,textView1,qquestn;
	EditText ccorrect;
	public static int  num4=1;
	public static int counter=0;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.qtest_start);
		Parse.initialize(this, "eX31t72OF1l2SfT72YlLNkBiCiMwRGCf6S8QGMHB", "r70qpWRJ6IMNgTn7YW2dLZUFMmvTn5GQRfNQcwsd");
		counter=0;
		num4=1;
		
		Intent intentIndex = getIntent(); // gets the previously created intent
        final String studname = intentIndex.getStringExtra("studentInvoking"); 
        final TextView tw= (TextView)findViewById(R.id.textView9);
        tw.setText("Hello "+studname);
        final String tillNow = intentIndex.getStringExtra("tillnow");
       final String verbo = intentIndex.getStringExtra("verbo");
       final String quanto = intentIndex.getStringExtra("quanto");
		
		
		ParseQuery<ParseObject> query = ParseQuery.getQuery("exams");
		query.whereEqualTo("qno",num4);
		query.getFirstInBackground(new GetCallback<ParseObject>() {
		  public void done(ParseObject object, ParseException e) {
		    if (object == null) {
		      Log.d("que", "The getFirst request failed.");
		    } else {
		      Log.d("que", "Retrieved the object.");
		      String questiondata=object.getString("que");
		      final TextView qquestn = (TextView) findViewById(R.id.textView2);
		      qquestn.setText(questiondata);
		      String option1=object.getString("opt1");
		      final TextView oop1 = (TextView) findViewById(R.id.textView3);
		      oop1.setText(option1); 
		      String option2=object.getString("opt2");
		      final TextView oop2 = (TextView) findViewById(R.id.textView4);
		      oop2.setText(option2); 
		      String option3=object.getString("opt3");
		      final TextView oop3 = (TextView) findViewById(R.id.textView5);
		      oop3.setText(option3);
		      String option4=object.getString("opt4");
		      final TextView oop4 = (TextView) findViewById(R.id.textView6);
		      oop4.setText(option4);
		      
		     
		    }
		  }
		});
		
		
		
		bqtssubmit = (Button)findViewById(R.id.qtssubmit);
		bqtssubmit.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				
		if(num4==20){
			final ProgressDialog dlg = new ProgressDialog(QTestStart.this);
	        dlg.setTitle("Please wait.");
	        dlg.setMessage("Processing request.  Navigating to result evaluation.  Please wait.");
	        dlg.show();
			
				Intent indexIntent=new Intent(QTestStart.this,Result.class);
				indexIntent.putExtra("studentInvoking",studname);
				
				ParseQuery<ParseObject> query = ParseQuery.getQuery("results");
				query.whereEqualTo("Studname",studname);
				query.getFirstInBackground(new GetCallback<ParseObject>() {
				  public void done(ParseObject object, ParseException e) {
				    if (object == null) {
				      Log.d("Studname", "The getFirst request failed.");
				      ParseObject res = new ParseObject("results");
				        res.put("Studname",studname);
				        res.put("quantmarks",counter);
				        res.saveInBackground();
				    } else {
				      Log.d("Studname", "Retrieved the object.");
				      object.put("quantmarks",counter);
				    }
				  }
				});
				
				
				
				
				
				
				
			       // Integer.toString(counter)
				
				
				
					startActivity(indexIntent);	}else{
						 
						
					    final EditText ccorrect = (EditText) findViewById(R.id.editText1);
					     String cor=ccorrect.getText().toString();
					     //ccorrect.setText("");
					     ParseQuery<ParseObject> query = ParseQuery.getQuery("exams");
							query.whereEqualTo("qno",num4);
							query.whereEqualTo("rightans",Integer.parseInt(cor));
							query.getFirstInBackground(new GetCallback<ParseObject>() {
							  public void done(ParseObject object, ParseException e) {
							    if (object == null) {
							      Log.d("que", "The getFirst request failed.");
							      ccorrect.setEnabled(false);
							      counter=counter-1;
							    } else {
							      Log.d("que", "Retrieved the object.");
							      counter=counter+5;
							      ccorrect.setEnabled(false);
							     
							    }
							  }
							});
					     
					     
					     
					     
					     
					}
			}
		});
		
		
		
		
		
		bqtsnext = (Button)findViewById(R.id.qtsnext);
		bqtsnext.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				num4++;
				final EditText ccorrect = (EditText) findViewById(R.id.editText1);
				ccorrect.setEnabled(true);
			     ccorrect.setText("");
				ParseQuery<ParseObject> query = ParseQuery.getQuery("exams");
				query.whereEqualTo("qno",num4);
				query.getFirstInBackground(new GetCallback<ParseObject>() {
				  public void done(ParseObject object, ParseException e) {
				    if (object == null) {
				      Log.d("que", "The getFirst request failed.");
				    } else {
				      Log.d("que", "Retrieved the object.");
				      String questiondata=object.getString("que");
				      final TextView qquestn = (TextView) findViewById(R.id.textView2);
				      qquestn.setText(questiondata);
				      String option1=object.getString("opt1");
				      final TextView oop1 = (TextView) findViewById(R.id.textView3);
				      oop1.setText(option1); 
				      String option2=object.getString("opt2");
				      final TextView oop2 = (TextView) findViewById(R.id.textView4);
				      oop2.setText(option2); 
				      String option3=object.getString("opt3");
				      final TextView oop3 = (TextView) findViewById(R.id.textView5);
				      oop3.setText(option3);
				      String option4=object.getString("opt4");
				      final TextView oop4 = (TextView) findViewById(R.id.textView6);
				      oop4.setText(option4);
				      
				     
				    }
				  }
				});
					
					
					
					
					
			}
		});
		
		
		final int fverbo=0;
		bqtsexit = (Button)findViewById(R.id.qtsexit);
		bqtsexit.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				final ProgressDialog dlg = new ProgressDialog(QTestStart.this);
		        dlg.setTitle("Please wait.");
		        dlg.setMessage("Processing request.  Exiting the test.  Please wait.");
		        dlg.show();
		        /* ParseQuery<ParseObject> query = ParseQuery.getQuery("results");
				query.whereEqualTo("Studname",studname);
				query.getFirstInBackground(new GetCallback<ParseObject>() {
				  public void done(ParseObject object, ParseException e) {
				    if (object == null) {
				      Log.d("Studname", "The getFirst request failed.");
				      ParseObject res = new ParseObject("results");
				        res.put("Studname",studname);
				        res.put("quantmarks",counter);
				        res.saveInBackground();
				    } else {
				      Log.d("Studname", "Retrieved the object.");
				      int fverbo=object.getInt("verbmarks");
				      object.put("quantmarks",counter);
				    }
				  }
				}); */
		        
		        
		        
				Intent indexIntent=new Intent(QTestStart.this,Result.class);
				indexIntent.putExtra("studentInvoking",studname);
				indexIntent.putExtra("quanto",Integer.toString(counter));
				indexIntent.putExtra("verbo",verbo);
				indexIntent.putExtra("which","verbal");
				if(tillNow.equals("")){indexIntent.putExtra("tillnow","q");}
				else if(tillNow.equals("v")){indexIntent.putExtra("tillnow","vq");}
				
				//indexIntent.putExtra("verbo",Integer.toString(fverbo));
			
					startActivity(indexIntent);	
					
					
					
					
					
			}
		});
	
	
}
}
