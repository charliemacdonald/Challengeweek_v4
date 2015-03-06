package com.ipmedt4.challengeweek_v2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class OverzichtKlassenGroepen extends ActionBarActivity {
    public Button inf1abutton;
    Button inf1bbutton;
    Button inf1cbutton;
    Button inf1dbutton;
    Button inf1ebutton;
    Button inf1fbutton;
    Button inf1gbutton;
    Button inf1hbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overzicht_klassen_groepen);
        Button inf1abutton = (Button) findViewById(R.id.inf1abutton);
        Button inf1bbutton = (Button) findViewById(R.id.inf1bbutton);
        Button inf1cbutton = (Button) findViewById(R.id.inf1cbutton);
        final Button inf1dbutton = (Button) findViewById(R.id.inf1dbutton);
        Button inf1ebutton = (Button) findViewById(R.id.inf1ebutton);
        Button inf1fbutton = (Button) findViewById(R.id.inf1fbutton);
        Button inf1gbutton = (Button) findViewById(R.id.inf1gbutton);
        Button inf1hbutton = (Button) findViewById(R.id.inf1hbutton);
        inf1abutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent in = new Intent(v.getContext(), Groepenscherm.class);
                String klas = "INF1A";
                in.putExtra("INF1A", klas);
                startActivityForResult(in, 0);

            }});
        inf1bbutton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent in = new Intent(v.getContext(), Groepenscherm.class);
                String klas = "INF1B";
                in.putExtra("INF1B", klas);
                startActivityForResult(in, 0);

            }
        });

        inf1cbutton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent in = new Intent(v.getContext(), Groepenscherm.class);
                String klas = "INF1C";
                in.putExtra("INF1C", klas);
                startActivityForResult(in, 0);

            }
        });

        inf1dbutton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent in = new Intent(v.getContext(), Groepenscherm.class);
                String klas = "INF1D";
                in.putExtra("INF1D", klas);
                startActivityForResult(in, 0);

            }
        });

        inf1ebutton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent in = new Intent(v.getContext(), Groepenscherm.class);
                String klas = "INF1E";
                in.putExtra("INF1E", klas);
                startActivityForResult(in, 0);

            }
        });

        inf1fbutton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent in = new Intent(v.getContext(), Groepenscherm.class);
                String klas = "INF1F";
                in.putExtra("INF1F", klas);
                startActivityForResult(in, 0);
            }
        });

        inf1gbutton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent in = new Intent(v.getContext(), Groepenscherm.class);
                String klas = "INF1G";
                in.putExtra("INF1G", klas);
                startActivityForResult(in, 0);

            }
        });

        inf1hbutton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent in = new Intent(v.getContext(), Groepenscherm.class);
                String klas = "INF1H";
                in.putExtra("INF1H", klas);
                startActivityForResult(in, 0);

            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_overzicht_klassen_groepen, menu);
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
