package com.ipmedt4.challengeweek_v2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Groepenscherm extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groepenscherm);
        Intent i = getIntent();
        final String Klas = i.getStringExtra("Klas");

        TextView Groepen = (TextView) findViewById(R.id.textView2);
        Button Groep1 = (Button) findViewById(R.id.Groep1);
        Button Groep2 = (Button) findViewById(R.id.Groep2);
        Button Groep3 = (Button) findViewById(R.id.Groep3);
        Button Groep4 = (Button) findViewById(R.id.Groep4);
        Button Groep5 = (Button) findViewById(R.id.Groep5);
        Groep1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent in = new Intent(v.getContext(), BeoordelingschermGroepen.class);
                String Groep = "1";
                in.putExtra("Klas", Klas);
                in.putExtra("Groep", Groep);
                startActivityForResult(in, 0);

            }});
        Groep2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent in = new Intent(v.getContext(), BeoordelingschermGroepen.class);
                String Groep = "2";
                in.putExtra("Klas", Klas);
                in.putExtra("Groep", Groep);
                startActivityForResult(in, 0);

            }
        });

        Groep3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent in = new Intent(v.getContext(), BeoordelingschermGroepen.class);
                String Groep = "3";
                in.putExtra("Klas", Klas);
                in.putExtra("Groep", Groep);
                startActivityForResult(in, 0);

            }
        });

        Groep4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent in = new Intent(v.getContext(), BeoordelingschermGroepen.class);
                String Groep = "4";
                in.putExtra("Klas", Klas);
                in.putExtra("Groep", Groep);
                startActivityForResult(in, 0);

            }
        });

        Groep5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent in = new Intent(v.getContext(), BeoordelingschermGroepen.class);
                String Groep = "5";
                in.putExtra("Klas", Klas);
                in.putExtra("Groep", Groep);
                startActivityForResult(in, 0);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_groepenscherm, menu);
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
