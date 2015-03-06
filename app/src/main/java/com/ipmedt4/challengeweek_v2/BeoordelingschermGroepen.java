package com.ipmedt4.challengeweek_v2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;


public class BeoordelingschermGroepen extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beoordelingscherm_groepen);
        Intent in = getIntent();



        Button verzendbutton = (Button) findViewById(R.id.verzendbutton);
        verzendbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent in = new Intent(getApplicationContext(), OpmerkingenschermGroepen.class);
                String klas = in.getStringExtra("klas");
                String groep = in.getStringExtra("groep");
                in.putExtra("klas", klas);
                in.putExtra("groep", groep);

                startActivityForResult(in, 0);


            }});}}