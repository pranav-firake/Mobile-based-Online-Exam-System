package com.example.Aphexams;
import java.util.*;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.*;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class Result extends Activity{

	Button brhome,gr,y,n,grf;
	TextView q4,v5,t6,w10;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		Parse.initialize(this, "eX31t72OF1l2SfT72YlLNkBiCiMwRGCf6S8QGMHB", "r70qpWRJ6IMNgTn7YW2dLZUFMmvTn5GQRfNQcwsd");
		
		gr = (Button)findViewById(R.id.button1);
		
		Intent intentIndex = getIntent(); // gets the previously created intent
        final String studname = intentIndex.getStringExtra("studentInvoking"); 
        final String quanto=intentIndex.getStringExtra("quanto");
        final int quantor=Integer.parseInt(quanto);
        //final int quantor=Integer.parseInt(Global.qu);
        //final int verbor=Integer.parseInt(Global.ve);
        final String verbo=intentIndex.getStringExtra("verbo");
        final int verbor=Integer.parseInt(verbo);
        final TextView stdnm= (TextView)findViewById(R.id.textView9);
        final String whichOne = intentIndex.getStringExtra("which"); 
        stdnm.setText(studname);
        final TextView w10 = (TextView) findViewById(R.id.textView10);
        w10.setText("Wish to give "+whichOne+"   test?");
        final String tillNow = intentIndex.getStringExtra("tillnow");
       
        y=(Button)findViewById(R.id.button2);
        n=(Button)findViewById(R.id.button3);
        
        if(tillNow.equals("qv")||tillNow.equals("vq")){
        	
        	y.setVisibility(View.GONE);
        	n.setVisibility(View.GONE);
        	w10.setVisibility(View.GONE);
        	
        	
        	 gr.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						
						
						ParseQuery<ParseObject> query = ParseQuery.getQuery("results");
						query.whereEqualTo("Studname",studname);
						query.getFirstInBackground(new GetCallback<ParseObject>() {
						  public void done(ParseObject object, ParseException e) {
						    if (object == null) {
						      Log.d("Studname", "The getFirst request failed.");
						      ParseObject res = new ParseObject("results");
						        res.put("Studname",studname);
						        res.put("quantmarks",quantor);
						        res.put("verbmarks",verbor);
						        res.put("totalmarks",(quantor+verbor));
						        
						        final TextView q4 = (TextView) findViewById(R.id.textView4);
							      q4.setText(Integer.toString(quantor));
							      final TextView v5 = (TextView) findViewById(R.id.textView5);
							      v5.setText(Integer.toString(verbor));
							      final TextView t6 = (TextView) findViewById(R.id.textView6);
							      t6.setText(Integer.toString(quantor+verbor));
							      
						        
						        res.saveInBackground();
						    } else {
						      Log.d("Studname", "Retrieved the object.");
						    
						      object.put("quantmarks",quantor);
						      object.put("verbmarks",verbor);
						      object.put("totalmarks",quantor+verbor);
						      
						      /*final TextView q4 = (TextView) findViewById(R.id.textView4);
						      q4.setText(Integer.toString(quantor));
						      final TextView v5 = (TextView) findViewById(R.id.textView5);
						      v5.setText(Integer.toString(verbor));
						      final TextView t6 = (TextView) findViewById(R.id.textView6);
						      t6.setText(Integer.toString(quantor+verbor));*/
						      
						      
						      
						    }
						  }
						});
						
						ParseQuery<ParseObject> fquery = ParseQuery.getQuery("results");
						fquery.whereEqualTo("Studname",studname);
						fquery.getFirstInBackground(new GetCallback<ParseObject>() {
						  public void done(ParseObject object, ParseException e) {
						    if (object == null) {
						      Log.d("Studname", "The getFirst request failed.");
						    } else {
						      Log.d("Studname", "Retrieved the object.");
						      int qm=object.getInt("quantmarks");
						      final TextView q4 = (TextView) findViewById(R.id.textView4);
						      q4.setText(Integer.toString(qm));
						      int vm=object.getInt("verbmarks");
						      final TextView v5 = (TextView) findViewById(R.id.textView5);
						      v5.setText(Integer.toString(vm)); 
						      int tm=object.getInt("totalmarks");
						      final TextView t6 = (TextView) findViewById(R.id.textView6);
						      t6.setText(Integer.toString(tm));
						      
						      
						     
						    }
						  }
						});
						
						
						
						
					}
				});
        }
        /* ParseQuery<ParseObject> query = ParseQuery.getQuery("results");
		query.whereEqualTo("Studname",studname);
		query.getFirstInBackground(new GetCallback<ParseObject>() {
		  public void done(ParseObject object, ParseException e) {
		    if (object == null) {
		      Log.d("Studname", "The getFirst request failed.");
		      ParseObject res = new ParseObject("results");
		        res.put("Studname",studname);
		        res.put("quantmarks",quantor);
		        res.put("verbmarks",verbor);
		        res.put("totalmarks",(quantor+verbor));
		        res.saveInBackground();
		    } else {
		      Log.d("Studname", "Retrieved the object.");
		      int fverbo=object.getInt("verbmarks");
		      int fquanto=object.getInt("quantmarks");
		      if(fquanto==0){object.put("quantmarks",quantor);}
		      else{}
		      if(fverbo==0){object.put("verbmarks",verbor);}
		      else{}
		      
		      
		    }
		  }
		}); */
        
		y.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				if(whichOne.equals("quant")){Intent indexIntent=new Intent(Result.this,QTestStart.class);
				indexIntent.putExtra("studentInvoking",stdnm.getText().toString());
				indexIntent.putExtra("quanto",quanto);
				indexIntent.putExtra("verbo",verbo);
				indexIntent.putExtra("tillnow",tillNow);
					startActivity(indexIntent);	}
				else{Intent indexIntent=new Intent(Result.this,VTestStart.class);
				indexIntent.putExtra("studentInvoking",stdnm.getText().toString());
				indexIntent.putExtra("quanto",quanto);
				indexIntent.putExtra("verbo",verbo);
				indexIntent.putExtra("tillnow",tillNow);
					startActivity(indexIntent);	}
				
			}
		});
		
		
		
        
		
		
        
		
		n.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				if(tillNow.equals("q")){
					
					ParseQuery<ParseObject> query = ParseQuery.getQuery("results");
					query.whereEqualTo("Studname",studname);
					query.getFirstInBackground(new GetCallback<ParseObject>() {
					  public void done(ParseObject object, ParseException e) {
					    if (object == null) {
					      Log.d("Studname", "The getFirst request failed.");
					      ParseObject res = new ParseObject("results");
					        res.put("Studname",studname);
					        res.put("quantmarks",quantor);
					        res.put("verbmarks",0);
					        res.put("totalmarks",quantor);
					        res.saveInBackground();
					    } else {
					      Log.d("Studname", "Retrieved the object.");
					      
					      object.put("quantmarks",quantor);
					      object.put("verbmarks",0);
					      object.put("totalmarks",quantor);
					      
					      
					      
					    }
					  }
					});
					
					
					
					gr.setOnClickListener(new OnClickListener() {
						
						public void onClick(View v) {
							
							
							ParseQuery<ParseObject> query = ParseQuery.getQuery("results");
							query.whereEqualTo("Studname",studname);
							query.getFirstInBackground(new GetCallback<ParseObject>() {
							  public void done(ParseObject object, ParseException e) {
							    if (object == null) {
							      Log.d("Studname", "The getFirst request failed.");
							    } else {
							      Log.d("Studname", "Retrieved the object.");
							      int qm=object.getInt("quantmarks");
							      final TextView q4 = (TextView) findViewById(R.id.textView4);
							      q4.setText(Integer.toString(qm));
							      int vm=object.getInt("verbmarks");
							      final TextView v5 = (TextView) findViewById(R.id.textView5);
							      v5.setText(Integer.toString(vm)); 
							      int tm=object.getInt("totalmarks");
							      final TextView t6 = (TextView) findViewById(R.id.textView6);
							      t6.setText(Integer.toString(tm));
							      
							      
							     
							    }
							  }
							});
							
						}
					});
					
					
					
					/*ParseQuery<ParseObject> query = ParseQuery.getQuery("results");
					query.whereEqualTo("Studname",studname);
					query.getFirstInBackground(new GetCallback<ParseObject>() {
					  public void done(ParseObject object, ParseException e) {
					    if (object == null) {
					      Log.d("Studname", "The getFirst request failed.");
					    } else {
					      Log.d("Studname", "Retrieved the object.");
					      int qm=object.getInt("quantmarks");
					      final TextView q4 = (TextView) findViewById(R.id.textView4);
					      q4.setText(Integer.toString(qm));
					      int vm=0;
					      final TextView v5 = (TextView) findViewById(R.id.textView5);
					      v5.setText(Integer.toString(vm)); 
					      int tm=object.getInt("totalmarks");
					      final TextView t6 = (TextView) findViewById(R.id.textView6);
					      t6.setText(Integer.toString(tm));
					      
					      
					     
					    }
					  }
					});*/
					
					
				}
				else if(tillNow.equals("v")){
					
					ParseQuery<ParseObject> query = ParseQuery.getQuery("results");
					query.whereEqualTo("Studname",studname);
					query.getFirstInBackground(new GetCallback<ParseObject>() {
					  public void done(ParseObject object, ParseException e) {
					    if (object == null) {
					      Log.d("Studname", "The getFirst request failed.");
					      ParseObject res = new ParseObject("results");
					        res.put("Studname",studname);
					        res.put("quantmarks",0);
					        res.put("verbmarks",verbor);
					        res.put("totalmarks",verbor);
					        res.saveInBackground();
					    } else {
					      Log.d("Studname", "Retrieved the object.");
					      
					      object.put("quantmarks",0);
					      object.put("verbmarks",verbor);
					      object.put("totalmarks",verbor);
					      
					      
					      
					    }
					  }
					});
					
					
					
					gr.setOnClickListener(new OnClickListener() {
						
						public void onClick(View v) {
							
							
							ParseQuery<ParseObject> query = ParseQuery.getQuery("results");
							query.whereEqualTo("Studname",studname);
							query.getFirstInBackground(new GetCallback<ParseObject>() {
							  public void done(ParseObject object, ParseException e) {
							    if (object == null) {
							      Log.d("Studname", "The getFirst request failed.");
							    } else {
							      Log.d("Studname", "Retrieved the object.");
							      int qm=object.getInt("quantmarks");
							      final TextView q4 = (TextView) findViewById(R.id.textView4);
							      q4.setText(Integer.toString(qm));
							      int vm=object.getInt("verbmarks");
							      final TextView v5 = (TextView) findViewById(R.id.textView5);
							      v5.setText(Integer.toString(vm)); 
							      int tm=object.getInt("totalmarks");
							      final TextView t6 = (TextView) findViewById(R.id.textView6);
							      t6.setText(Integer.toString(tm));
							      
							      
							     
							    }
							  }
							});
							
						}
					});
					
					
					
					/*ParseQuery<ParseObject> query = ParseQuery.getQuery("results");
					query.whereEqualTo("Studname",studname);
					query.getFirstInBackground(new GetCallback<ParseObject>() {
					  public void done(ParseObject object, ParseException e) {
					    if (object == null) {
					      Log.d("Studname", "The getFirst request failed.");
					    } else {
					      Log.d("Studname", "Retrieved the object.");
					      int qm=object.getInt("quantmarks");
					      final TextView q4 = (TextView) findViewById(R.id.textView4);
					      q4.setText(Integer.toString(qm));
					      int vm=0;
					      final TextView v5 = (TextView) findViewById(R.id.textView5);
					      v5.setText(Integer.toString(vm)); 
					      int tm=object.getInt("totalmarks");
					      final TextView t6 = (TextView) findViewById(R.id.textView6);
					      t6.setText(Integer.toString(tm));
					      
					      
					     
					    }
					  }
					});*/
					
					
					
					
					
					
				}
			}
		});
        
        
		
		
		
		
		
		
		brhome = (Button)findViewById(R.id.rhome);
		brhome.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent indexIntent=new Intent(Result.this,HomeStudent.class);
				indexIntent.putExtra("studentInvoking",stdnm.getText().toString());
					startActivity(indexIntent);	
			}
		});
	
	
}
}

