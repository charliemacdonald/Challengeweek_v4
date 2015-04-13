package com.ipmedt4.challengeweek_v2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;


public class Beoordelingscherm extends ActionBarActivity {
Button verzendbutton;
TextView textviewbeoordelingstudenten;


String cijfer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        setContentView(R.layout.activity_beoordelingscherm);
        TextView textviewbeoordelingstudenten = (TextView) findViewById(R.id.texviewbeoordelingstudent);
        Switch switch1 = (Switch) findViewById(R.id.switch1);
        Switch switch2 = (Switch) findViewById(R.id.switch2);
        Switch switch3 = (Switch) findViewById(R.id.switch3);
        Switch switch4 = (Switch) findViewById(R.id.switch4);
        Switch switch5 = (Switch) findViewById(R.id.switch5);
        Switch switch6 = (Switch) findViewById(R.id.switch6);

        final Intent intent = getIntent();
        final String Naam = intent.getStringExtra("Naam");
        final String Studentnummer = intent.getStringExtra("Studentnummer");
        textviewbeoordelingstudenten.setText("Beoordeling voor "+ "" + "" + Naam + " met studentnummer " + "" + Studentnummer );


        if (switch1 != null ) {
            switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        cijfer = "voldoende";
                    } else {
                        cijfer = "onvoldoende";
                        System.out.println("Cijfer is " + cijfer);
                    }
                }

            });
        }
        if (switch2 != null ) {
            switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        cijfer = "voldoende";
                    } else {
                        cijfer = "onvoldoende";
                        System.out.println("Cijfer is " + cijfer);
                    }
                }
            });}

        if (switch3 != null ) {
            switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        cijfer = "voldoende";
                    } else {
                        cijfer = "onvoldoende";
                        System.out.println("Cijfer is " + cijfer);
                    }
                }
            });}

        if (switch4 != null) {
            switch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        cijfer = "voldoende";
                    } else {
                        cijfer = "onvoldoende";
                        System.out.println("Cijfer is " + cijfer);
                    }
                }
            });}

        if (switch5 != null) {
            switch5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        cijfer = "voldoende";
                    } else {
                        cijfer = "onvoldoende";
                        System.out.println("Cijfer is " + cijfer);
                    }
                }
            });}

        if (switch6 != null) {
            switch6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        cijfer = "voldoende";
                    } else {
                        cijfer = "onvoldoende";
                        System.out.println("Cijfer is " + cijfer);
                    }
                }
            });}






        Button verzendbutton = (Button) findViewById(R.id.verzendbutton);
        verzendbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent in = new Intent(getApplicationContext(), Bevestigingsscherm.class);
                in.putExtra("Naam", Naam);
                in.putExtra("Studentnummer", Studentnummer);

                in.putExtra("Cijfer", cijfer);

                startActivityForResult(in, 0);


            }
        });}


        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_beoordelingscherm, menu);
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
