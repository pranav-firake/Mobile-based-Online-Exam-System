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

public class VTestStart extends Activity{

	Button bvsubmit,bvnext,bvexit;
	TextView oop1,oop2,oop3,oop4,textView1,qquestn;
	EditText ccorrect;
	public static int  num5=1;
	public static int counter1=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vtest_start);
		Parse.initialize(this, "eX31t72OF1l2SfT72YlLNkBiCiMwRGCf6S8QGMHB", "r70qpWRJ6IMNgTn7YW2dLZUFMmvTn5GQRfNQcwsd");
		Intent intentIndex = getIntent(); // gets the previously created intent
        final String studname = intentIndex.getStringExtra("studentInvoking"); 
        final TextView tw= (TextView)findViewById(R.id.textView9);
        tw.setText("Hello "+studname);
        final String tillNow = intentIndex.getStringExtra("tillnow");
        final String quanto = intentIndex.getStringExtra("quanto"); 
        final String verbo = intentIndex.getStringExtra("verbo");
        num5=1;
        counter1=0;
		
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Vex");
		query.whereEqualTo("vqno",num5);
		query.getFirstInBackground(new GetCallback<ParseObject>() {
		  public void done(ParseObject object, ParseException e) {
		    if (object == null) {
		      Log.d("vque", "The getFirst request failed.");
		    } else {
		      Log.d("vque", "Retrieved the object.");
		      String questiondata=object.getString("vque");
		      final TextView qquestn = (TextView) findViewById(R.id.textView2);
		      qquestn.setText(questiondata);
		      String option1=object.getString("vopt1");
		      final TextView oop1 = (TextView) findViewById(R.id.textView3);
		      oop1.setText(option1); 
		      String option2=object.getString("vopt2");
		      final TextView oop2 = (TextView) findViewById(R.id.textView4);
		      oop2.setText(option2); 
		      String option3=object.getString("vopt3");
		      final TextView oop3 = (TextView) findViewById(R.id.textView5);
		      oop3.setText(option3);
		      String option4=object.getString("vopt4");
		      final TextView oop4 = (TextView) findViewById(R.id.textView6);
		      oop4.setText(option4);
		      
		     
		    }
		  }
		});
		
		bvsubmit = (Button)findViewById(R.id.vsubmit);
		bvsubmit.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				
		if(num5==20){
			final ProgressDialog dlg = new ProgressDialog(VTestStart.this);
	        dlg.setTitle("Please wait.");
	        dlg.setMessage("Processing request.  Navigating to result evaluation.  Please wait.");
	        dlg.show();
				Intent indexIntent=new Intent(VTestStart.this,Result.class);
				indexIntent.putExtra("studentInvoking",studname);
				
				ParseObject res = new ParseObject("results");
			        res.put("Studname",studname);
			        res.put("verbmarks",counter1);
			        res.saveInBackground();
					startActivity(indexIntent);	}else{
						 
						
					     final EditText ccorrect = (EditText) findViewById(R.id.editText1);
					     String cor=ccorrect.getText().toString();
					     //ccorrect.setText("");
					     ParseQuery<ParseObject> query = ParseQuery.getQuery("Vex");
							query.whereEqualTo("vqno",num5);
							query.whereEqualTo("vrightans",Integer.parseInt(cor));
							query.getFirstInBackground(new GetCallback<ParseObject>() {
							  public void done(ParseObject object, ParseException e) {
							    if (object == null) {
							      Log.d("vque", "The getFirst request failed.");
							      counter1=counter1-1;
							      ccorrect.setEnabled(false);
							    } else {
							      Log.d("vque", "Retrieved the object.");
							      counter1=counter1+5;
							      ccorrect.setEnabled(false);
							     
							    }
							  }
							});
					     
					     
					     
					     
					     
					}
			}
		});
		
		
		
		bvnext = (Button)findViewById(R.id.vnext);
		bvnext.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				num5++;
				EditText ccorrect = (EditText) findViewById(R.id.editText1);
				ccorrect.setEnabled(true);
			     ccorrect.setText("");
				ParseQuery<ParseObject> query = ParseQuery.getQuery("Vex");
				query.whereEqualTo("vqno",num5);
				query.getFirstInBackground(new GetCallback<ParseObject>() {
				  public void done(ParseObject object, ParseException e) {
				    if (object == null) {
				      Log.d("vque", "The getFirst request failed.");
				    } else {
				      Log.d("vque", "Retrieved the object.");
				      String questiondata=object.getString("vque");
				      final TextView qquestn = (TextView) findViewById(R.id.textView2);
				      qquestn.setText(questiondata);
				      String option1=object.getString("vopt1");
				      final TextView oop1 = (TextView) findViewById(R.id.textView3);
				      oop1.setText(option1); 
				      String option2=object.getString("vopt2");
				      final TextView oop2 = (TextView) findViewById(R.id.textView4);
				      oop2.setText(option2); 
				      String option3=object.getString("vopt3");
				      final TextView oop3 = (TextView) findViewById(R.id.textView5);
				      oop3.setText(option3);
				      String option4=object.getString("vopt4");
				      final TextView oop4 = (TextView) findViewById(R.id.textView6);
				      oop4.setText(option4);
				      
				     
				    }
				  }
				});
					
					
					
					
					
			}
		});
		
		
		
		
		bvexit = (Button)findViewById(R.id.vexit);
		bvexit.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				final ProgressDialog dlg = new ProgressDialog(VTestStart.this);
		        dlg.setTitle("Please wait.");
		        dlg.setMessage("Processing request. Exiting the test.  Please wait.");
		        dlg.show();
				
				
				/*ParseQuery<ParseObject> query = ParseQuery.getQuery("results");
				query.whereEqualTo("Studname",studname);
				query.getFirstInBackground(new GetCallback<ParseObject>() {
				  public void done(ParseObject object, ParseException e) {
				    if (object == null) {
				      Log.d("Studname", "The getFirst request failed.");
				      ParseObject res = new ParseObject("results");
				        res.put("Studname",studname);
				        res.put("verbmarks",counter1);
				        res.saveInBackground();
				    } else {
				      Log.d("Studname", "Retrieved the object.");
				      object.put("verbmarks",counter1);
				    }
				  }
				});*/
		        
		        Intent indexIntent=new Intent(VTestStart.this,Result.class);
				indexIntent.putExtra("studentInvoking",studname);
				indexIntent.putExtra("quanto",quanto);
				indexIntent.putExtra("verbo",Integer.toString(counter1));
				indexIntent.putExtra("which","quant");
				if(tillNow.equals("")){indexIntent.putExtra("tillnow","v");}
				else if(tillNow.equals("q")){indexIntent.putExtra("tillnow","qv");}
				startActivity(indexIntent);
			}
		});
	
	
}
}
