package com.example.Aphexams;
import com.parse.*;

import java.io.*;
import java.util.*;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.*;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
public class ViewV extends Activity{
	
	TextView oop1,oop2,oop3,oop4,ccoreect,textView1,qquestn;
	Button ddelete,vvqcancel,nnext,pprev;
	//Button bback,banother,bsub;
	//TextView qvtop1,qvtop2,qvtop3,qvtop4,qvtque,qvtcorrect;
	public static int  num3=1;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_v);
		Parse.initialize(this, "eX31t72OF1l2SfT72YlLNkBiCiMwRGCf6S8QGMHB", "r70qpWRJ6IMNgTn7YW2dLZUFMmvTn5GQRfNQcwsd");

		
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Vex");
		query.whereEqualTo("vqno",num3);
		query.getFirstInBackground(new GetCallback<ParseObject>() {
		  public void done(ParseObject object, ParseException e) {
		    if (object == null) {
		      Log.d("vque", "The getFirst request failed.");
		    } else {
		      Log.d("vque", "Retrieved the object.");
		      String questiondata=object.getString("vque");
		      final TextView qquestn = (TextView) findViewById(R.id.questn);
		      qquestn.setText(questiondata);
		      String option1=object.getString("vopt1");
		      final TextView oop1 = (TextView) findViewById(R.id.op1);
		      oop1.setText(option1); 
		      String option2=object.getString("vopt2");
		      final TextView oop2 = (TextView) findViewById(R.id.op2);
		      oop2.setText(option2); 
		      String option3=object.getString("vopt3");
		      final TextView oop3 = (TextView) findViewById(R.id.op3);
		      oop3.setText(option3);
		      String option4=object.getString("vopt4");
		      final TextView oop4 = (TextView) findViewById(R.id.op4);
		      oop4.setText(option4);
		      int righta=object.getInt("vrightans");
		      final TextView ccorrect = (TextView) findViewById(R.id.correct);
		     ccorrect.setText(Integer.toString(righta));
		     
		    }
		  }
		});
		
	
		
		vvqcancel = (Button)findViewById(R.id.vqcancel);
		vvqcancel.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent indexIntent=new Intent(ViewV.this,HomeAdmin.class);
					startActivity(indexIntent);	
			}
		});

		
		
		ddelete = (Button)findViewById(R.id.delete);
		ddelete.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent indexIntent=new Intent(ViewV.this,HomeAdmin.class);
					startActivity(indexIntent);	
			}
		});


		nnext = (Button)findViewById(R.id.next);
		nnext.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				num3++;
				ParseQuery<ParseObject> query = ParseQuery.getQuery("Vex");
				query.whereEqualTo("vqno",num3);
				query.getFirstInBackground(new GetCallback<ParseObject>() {
				  public void done(ParseObject object, ParseException e) {
				    if (object == null) {
				      Log.d("vque", "The getFirst request failed.");
				    } else {
				      Log.d("vque", "Retrieved the object.");
				      String questiondata=object.getString("vque");
				      final TextView qquestn = (TextView) findViewById(R.id.questn);
				      qquestn.setText(questiondata);
				      String option1=object.getString("vopt1");
				      final TextView oop1 = (TextView) findViewById(R.id.op1);
				      oop1.setText(option1); 
				      String option2=object.getString("vopt2");
				      final TextView oop2 = (TextView) findViewById(R.id.op2);
				      oop2.setText(option2); 
				      String option3=object.getString("vopt3");
				      final TextView oop3 = (TextView) findViewById(R.id.op3);
				      oop3.setText(option3);
				      String option4=object.getString("vopt4");
				      final TextView oop4 = (TextView) findViewById(R.id.op4);
				      oop4.setText(option4);
				      int righta=object.getInt("vrightans");
				      final TextView ccorrect = (TextView) findViewById(R.id.correct);
				     ccorrect.setText(Integer.toString(righta));
				     
				    }
				  }
				});
				
				
				

			}
		});
		
		
		
		pprev = (Button)findViewById(R.id.prev);
		pprev.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				num3--;
				ParseQuery<ParseObject> query = ParseQuery.getQuery("Vex");
				query.whereEqualTo("vqno",num3);
				query.getFirstInBackground(new GetCallback<ParseObject>() {
				  public void done(ParseObject object, ParseException e) {
				    if (object == null) {
				      Log.d("vque", "The getFirst request failed.");
				    } else {
				      Log.d("vque", "Retrieved the object.");
				      String questiondata=object.getString("vque");
				      final TextView qquestn = (TextView) findViewById(R.id.questn);
				      qquestn.setText(questiondata);
				      String option1=object.getString("vopt1");
				      final TextView oop1 = (TextView) findViewById(R.id.op1);
				      oop1.setText(option1); 
				      String option2=object.getString("vopt2");
				      final TextView oop2 = (TextView) findViewById(R.id.op2);
				      oop2.setText(option2); 
				      String option3=object.getString("vopt3");
				      final TextView oop3 = (TextView) findViewById(R.id.op3);
				      oop3.setText(option3);
				      String option4=object.getString("vopt4");
				      final TextView oop4 = (TextView) findViewById(R.id.op4);
				      oop4.setText(option4);
				      int righta=object.getInt("vrightans");
				      final TextView ccorrect = (TextView) findViewById(R.id.correct);
				     ccorrect.setText(Integer.toString(righta));
				     
				    }
				  }
				});
				
				
				
			}
		});
		
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu paramMenu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, paramMenu);
		return true;
	}

	
	
	
	

}
