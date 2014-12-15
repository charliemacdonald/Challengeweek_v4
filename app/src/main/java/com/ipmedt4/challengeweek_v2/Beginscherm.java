package com.ipmedt4.challengeweek_v2;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Beginscherm extends ActionBarActivity {
Button OverzichtStudenten;
Button OverzichtKlassen; 
Button Instellingen; 
TextView Overzicht; 
ImageView hsleidenlogo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_beginscherm);
		 TextView Challengeweek = (TextView) findViewById(R.id.Challengeweek); 
	     ImageView hsleidenlogo = (ImageView) findViewById(R.id.hsleidenlogo); 
	     Button OverzichtStudenten = (Button) findViewById(R.id.Overzichtstudenten); 
	     Button OverzichtKlassen = (Button) findViewById(R.id.Overzichtklassen); 
	     Button Instellingen = (Button) findViewById(R.id.instellingen); 
	     OverzichtStudenten.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(v.getContext(), OverzichtStudenten.class); 
					startActivityForResult(intent, 0); 
				
			 
	    }});
	
	OverzichtKlassen.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {
            Intent myintent2 = new Intent(v.getContext(), OverzichtKlassen.class);
            startActivity(myintent2);

        }
	}); 
	
	Instellingen.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {
            Intent myintent2 = new Intent(v.getContext(), Instellingen.class);
            startActivity(myintent2);

        }
	});}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.beginscherm, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
