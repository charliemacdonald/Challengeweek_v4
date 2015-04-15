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
import android.widget.Toast;


public class Instellingen extends ActionBarActivity {
Button versiebutton;
Button disclaimerbutton;
Button uitlogbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instellingen);
        Button versiebutton = (Button) findViewById(R.id.versiebutton);
        Button disclaimerbutton = (Button) findViewById(R.id.disclaimerbutton);
        Button uitlogbutton = (Button) findViewById(R.id.uitlogbutton);
        versiebutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Dit is versie 1.0",
                        Toast.LENGTH_LONG).show();


            }});

        disclaimerbutton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Aan deze applicatie kunnen " + "" + "" +
                        " geen rechten worden ontleend. ", Toast.LENGTH_LONG).show();

            }
        });

        uitlogbutton.setOnClickListener(new View.OnClickListener() {

            public void onClick(final View v) {
                AlertDialog.Builder builder;
                builder = new AlertDialog.Builder(Instellingen.this);
                builder.setMessage("Weet u zeker dat u wilt uitloggen?");
                builder.setTitle("Uitloggen");


                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Intent myintent2 = new Intent(v.getContext(), Loginscherm.class);
                        startActivity(myintent2);


                    }
                });

                builder.setNegativeButton("Annuleren", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                  

                    }
                });
                builder.show();


            }

        });


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_instellingen, menu);
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
