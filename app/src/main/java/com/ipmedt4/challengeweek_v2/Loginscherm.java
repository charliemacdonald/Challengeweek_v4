package com.ipmedt4.challengeweek_v2;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Loginscherm extends ActionBarActivity {
Button aanmeldknop;
TextView Challengeweek; 
ImageView hsleidenlogo;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginscherm);
        TextView Challengeweek = (TextView) findViewById(R.id.Challengeweek); 
        ImageView hsleidenlogo = (ImageView) findViewById(R.id.hsleidenlogo); 
        Button aanmeldknop = (Button) findViewById(R.id.aanmeldknop); 
        aanmeldknop.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(v.getContext(), Beginscherm.class); 
				startActivityForResult(intent, 0); 
			
		 
    }});} 


    
    public boolean onCreateOptionsMenu(Menu menu) {
       // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.loginscherm, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) 
            return true;
        
        return super.onOptionsItemSelected(item);
        
   
    }}

