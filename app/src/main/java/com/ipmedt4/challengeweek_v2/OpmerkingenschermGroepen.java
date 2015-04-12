package com.ipmedt4.challengeweek_v2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class OpmerkingenschermGroepen extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opmerkingenscherm_groepen);
        EditText opmerkingentekst = (EditText) findViewById(R.id.opmerkingentekst);
        final String opmerkingen  = opmerkingentekst.getText().toString();

        Button opmerkingenopslaan = (Button) findViewById(R.id.opmerkingenopslaanbutton);
        opmerkingenopslaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(v.getContext(), BevestigingschermGroepen.class);
                String klas = in.getStringExtra("klas");
                String groep = in.getStringExtra("groep");
                String cijfer = in.getStringExtra("cijfer");
                in.putExtra("klas", klas);
                in.putExtra("groep", groep);
                in.putExtra("cijfer", cijfer);
                in.putExtra("opmerkingen", opmerkingen);
                startActivityForResult(in, 0);


            }
        });
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_opmerkingenscherm_groepen, menu);
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
