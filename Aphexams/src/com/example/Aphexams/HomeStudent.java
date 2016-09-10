package com.example.Aphexams;



import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;

public class HomeStudent extends Activity {
	Button hsstartbutton;
	Button hseditbutton;
	Button hschangepwordbutton;
	Button hscancelbutton;
	private RadioGroup radioGroup;
    private RadioButton hsqradio1;
    private RadioButton hsvradio2;
     
    
    
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_student);
        radioGroup = (RadioGroup)findViewById(R.id.group1);
        hsqradio1 = (RadioButton)findViewById(R.id.qradio1);
        hsvradio2= (RadioButton)findViewById(R.id.vradio2);
	
        
        Intent intentIndex = getIntent(); // gets the previously created intent
        final String studname = intentIndex.getStringExtra("studentInvoking"); 
        final TextView tw= (TextView)findViewById(R.id.textView2);
        tw.setText("Hello "+studname);
        
        
        hsstartbutton = (Button)findViewById(R.id.hsstart);
        hsstartbutton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				if(R.id.qradio1==radioGroup.getCheckedRadioButtonId())
				{
					final ProgressDialog dlg = new ProgressDialog(HomeStudent.this);
			        dlg.setTitle("Please wait.");
			        dlg.setMessage("Processing request.  Navigating to quant questions.  Please wait.");
			        dlg.show();
					Intent indexIntent=new Intent(HomeStudent.this,QTestStart.class);
					indexIntent.putExtra("studentInvoking",studname);
					indexIntent.putExtra("tillnow","");
					indexIntent.putExtra("quanto","0");
					indexIntent.putExtra("verbo","0");
					startActivity(indexIntent);
				}
				else
				{
					final ProgressDialog dlg = new ProgressDialog(HomeStudent.this);
			        dlg.setTitle("Please wait.");
			        dlg.setMessage("Processing the request. Navigating to verbal questions. Please wait.");
			        dlg.show();
					Intent indexIntent=new Intent(HomeStudent.this,VTestStart.class);
					indexIntent.putExtra("studentInvoking",studname);
					indexIntent.putExtra("tillnow","");
					indexIntent.putExtra("quanto","0");
					indexIntent.putExtra("verbo","0");
					startActivity(indexIntent);
				}
			}
		});

        hschangepwordbutton = (Button)findViewById(R.id.hschangepword);
        hschangepwordbutton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				final ProgressDialog dlg = new ProgressDialog(HomeStudent.this);
		        dlg.setTitle("Please wait.");
		        dlg.setMessage("Processing request.  Navigating to change password.  Please wait.");
		        dlg.show();
				Intent indexIntent=new Intent(HomeStudent.this,StudentChangePword.class);
					startActivity(indexIntent);	
			}
		});
		
		hscancelbutton = (Button)findViewById(R.id.hscancel);
		hscancelbutton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				final ProgressDialog dlg = new ProgressDialog(HomeStudent.this);
		        dlg.setTitle("Please wait.");
		        dlg.setMessage("Processing request.  Navigating back.  Please wait.");
		        dlg.show();
				Intent indexIntent=new Intent(HomeStudent.this,MainActivity.class);
					startActivity(indexIntent);	
			}
		});
		
		
	

}}
    
