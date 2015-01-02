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
    StudentDBAdapter db = new StudentDBAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opmerkingenscherm);
        Button opmerkingenopslaan = (Button) findViewById(R.id.opmerkingenopslaanbutton);
        opmerkingenopslaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             db.open();
                long id;

                EditText opmerkingentekst = (EditText) findViewById(R.id.opmerkingentekst);
                String opmerkingen = opmerkingentekst.getText().toString();
                db.OpmerkingenOpslaan(opmerkingen);
                db.close();
                Intent intent = new Intent(v.getContext(), Bevestigingsscherm.class);
                startActivityForResult(intent, 0);


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
