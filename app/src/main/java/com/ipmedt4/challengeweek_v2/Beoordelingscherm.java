package com.ipmedt4.challengeweek_v2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;


public class Beoordelingscherm extends ActionBarActivity {
Button verzendbutton;

String cijfer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beoordelingscherm);
        Intent in = getIntent();
        String naam = in.getStringExtra("Naam");
        String studentnummer = in.getStringExtra("Studentnummer");
        String klas = in.getStringExtra("Klas");

        Button verzendbutton = (Button) findViewById(R.id.verzendbutton);
        verzendbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent in = new Intent(getApplicationContext(), Opmerkingenscherm.class);
                String naam = in.getStringExtra("Naam");
                String studentnummer = in.getStringExtra("Studentnummer");
                in.putExtra("Naam", naam);
                in.putExtra("Studentnummer", studentnummer);
                in.putExtra("cijfer", cijfer);

                startActivityForResult(in, 0);


            }
        });
        final CheckBox checkbox1 = (CheckBox) findViewById(R.id.checkBox);
        checkbox1.setOnClickListener(new View.OnClickListener()
        {
        @Override
        public void onClick(View v) {
        if (checkbox1.isChecked())
        cijfer = "10";
        else
        cijfer = "1";
}});
        final CheckBox checkbox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkbox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkbox2.isChecked())
                    cijfer = "10" ;
                if (checkbox1.isChecked());
                else cijfer = "9.5";

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
