package com.ipmedt4.challengeweek_v2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Opmerkingenscherm extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opmerkingenscherm);
        final Intent intent = getIntent();
        final String Naam = intent.getStringExtra("Naam");
        final String Studentnummer = intent.getStringExtra("Studentnummer");
        final String cijfer = intent.getStringExtra("cijfer");
        EditText opmerkingentekst = (EditText) findViewById(R.id.opmerkingentekst);
        final String opmerkingen  = opmerkingentekst.getText().toString();
        System.out.println("Opmerkingen zijn:" + opmerkingen);



        Button opmerkingenopslaan = (Button) findViewById(R.id.opmerkingenopslaanbutton);
        opmerkingenopslaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(v.getContext(), Bevestigingsscherm.class);
                in.putExtra("Naam", Naam);
                in.putExtra("Studentnummer", Studentnummer);
                in.putExtra("cijfer", cijfer);
                in.putExtra("opmerkingen", opmerkingen);
                startActivityForResult(in, 0);


            }
        });
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_opmerkingenscherm, menu);
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
