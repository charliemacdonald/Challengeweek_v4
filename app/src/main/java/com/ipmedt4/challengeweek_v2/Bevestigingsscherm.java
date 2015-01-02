package com.ipmedt4.challengeweek_v2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Bevestigingsscherm extends ActionBarActivity {
    Button beoordelingbevestigen;
    Button beoordelingannuleren;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bevestigingsscherm);
        Button beoordelingbevestigen = (Button) findViewById(R.id.beoordelingbevestigen);
        Button beoordelingannuleren = (Button) findViewById(R.id.bevestingannuleren);
        beoordelingbevestigen.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                AlertDialog.Builder builder;
                builder = new AlertDialog.Builder(Bevestigingsscherm.this);
                builder.setMessage("Uw beoordeling is succesvol opgeslagen!");
                builder.setTitle("Beoordeling succesvol");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Intent myintent2 = new Intent(v.getContext(), OverzichtStudenten.class);
                        startActivity(myintent2);


                    }
                });
                builder.show();



            }});

        beoordelingannuleren.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(v.getContext(), Beoordelingscherm.class);
                startActivityForResult(intent, 0);


            }});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bevestigingsscherm, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
