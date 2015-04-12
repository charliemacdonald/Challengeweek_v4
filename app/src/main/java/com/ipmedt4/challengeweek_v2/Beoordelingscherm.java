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
        final Intent intent = getIntent();
        final String Naam = intent.getStringExtra("Naam");
        final String Studentnummer = intent.getStringExtra("Studentnummer");




        Button verzendbutton = (Button) findViewById(R.id.verzendbutton);
        verzendbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent in = new Intent(getApplicationContext(), Opmerkingenscherm.class);
                in.putExtra("Naam", Naam);
                in.putExtra("Studentnummer", Studentnummer);
                String.valueOf(cijfer);
                in.putExtra("cijfer", cijfer);

                startActivityForResult(in, 0);


            }
        });
        final CheckBox checkbox1 = (CheckBox) findViewById(R.id.checkBox);
        final CheckBox checkbox2 = (CheckBox) findViewById(R.id.checkBox2);
        final CheckBox checkbox3 = (CheckBox) findViewById(R.id.checkBox3);
        final CheckBox checkbox4 = (CheckBox) findViewById(R.id.checkBox4);
        final CheckBox checkbox5 = (CheckBox) findViewById(R.id.checkBox5);
        final CheckBox checkbox6 = (CheckBox) findViewById(R.id.checkBox6);
        final CheckBox checkbox7 = (CheckBox) findViewById(R.id.checkBox7);
        final CheckBox checkbox8 = (CheckBox) findViewById(R.id.checkBox8);
        final CheckBox checkbox9 = (CheckBox) findViewById(R.id.checkBox9);
        final CheckBox checkbox10 = (CheckBox) findViewById(R.id.checkBox10);
        final CheckBox checkbox11 = (CheckBox) findViewById(R.id.checkBox11);
        final CheckBox checkbox12 = (CheckBox) findViewById(R.id.checkBox12);

        checkbox1.setOnClickListener(new View.OnClickListener()
        {
        @Override
        public void onClick(View v) {
        if (checkbox1.isChecked() && (checkbox2.isChecked()) && (checkbox3.isChecked())
        && (checkbox4.isChecked()) && (checkbox5.isChecked()) && (checkbox6.isChecked())
                && (checkbox7.isChecked()) && (checkbox8.isChecked()) && (checkbox9.isChecked())
                && (checkbox10.isChecked()) && (checkbox11.isChecked()) && (checkbox12.isChecked()))
        cijfer = "10";
        else
        cijfer = "1";
            System.out.println("Cijfer is " + cijfer);
}});
    checkbox2.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {
        if (checkbox1.isChecked() && (checkbox2.isChecked()) && (checkbox3.isChecked())
                && (checkbox4.isChecked()) && (checkbox5.isChecked()) && (checkbox6.isChecked())
                && (checkbox7.isChecked()) && (checkbox8.isChecked()) && (checkbox9.isChecked())
                && (checkbox10.isChecked()) && (checkbox11.isChecked()) && (checkbox12.isChecked()))
            cijfer = "10";
        else
            cijfer = "1";
        System.out.println("Cijfer is " + cijfer);
    }});


    checkbox3.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {
        if (checkbox1.isChecked() && (checkbox2.isChecked()) && (checkbox3.isChecked())
                && (checkbox4.isChecked()) && (checkbox5.isChecked()) && (checkbox6.isChecked())
                && (checkbox7.isChecked()) && (checkbox8.isChecked()) && (checkbox9.isChecked())
                && (checkbox10.isChecked()) && (checkbox11.isChecked()) && (checkbox12.isChecked()))
            cijfer = "10";
        else
            cijfer = "1";
        System.out.println("Cijfer is " + cijfer);
    }});

    checkbox4.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {
        if (checkbox1.isChecked() && (checkbox2.isChecked()) && (checkbox3.isChecked())
                && (checkbox4.isChecked()) && (checkbox5.isChecked()) && (checkbox6.isChecked())
                && (checkbox7.isChecked()) && (checkbox8.isChecked()) && (checkbox9.isChecked())
                && (checkbox10.isChecked()) && (checkbox11.isChecked()) && (checkbox12.isChecked()))
            cijfer = "10";
        else
            cijfer = "1";
        System.out.println("Cijfer is " + cijfer);
    }});

    checkbox5.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {
        if (checkbox1.isChecked() && (checkbox2.isChecked()) && (checkbox3.isChecked())
                && (checkbox4.isChecked()) && (checkbox5.isChecked()) && (checkbox6.isChecked())
                && (checkbox7.isChecked()) && (checkbox8.isChecked()) && (checkbox9.isChecked())
                && (checkbox10.isChecked()) && (checkbox11.isChecked()) && (checkbox12.isChecked()))
            cijfer = "10";
        else
            cijfer = "1";
        System.out.println("Cijfer is " + cijfer);
    }});


    checkbox6.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {
        if (checkbox1.isChecked() && (checkbox2.isChecked()) && (checkbox3.isChecked())
                && (checkbox4.isChecked()) && (checkbox5.isChecked()) && (checkbox6.isChecked())
                && (checkbox7.isChecked()) && (checkbox8.isChecked()) && (checkbox9.isChecked())
                && (checkbox10.isChecked()) && (checkbox11.isChecked()) && (checkbox12.isChecked()))
            cijfer = "10";
        else
            cijfer = "1";
        System.out.println("Cijfer is " + cijfer);
    }});

    checkbox7.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {
        if (checkbox1.isChecked() && (checkbox2.isChecked()) && (checkbox3.isChecked())
                && (checkbox4.isChecked()) && (checkbox5.isChecked()) && (checkbox6.isChecked())
                && (checkbox7.isChecked()) && (checkbox8.isChecked()) && (checkbox9.isChecked())
                && (checkbox10.isChecked()) && (checkbox11.isChecked()) && (checkbox12.isChecked()))
            cijfer = "10";
        else
            cijfer = "1";
        System.out.println("Cijfer is " + cijfer);
    }});

    checkbox8.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {
        if (checkbox1.isChecked() && (checkbox2.isChecked()) && (checkbox3.isChecked())
                && (checkbox4.isChecked()) && (checkbox5.isChecked()) && (checkbox6.isChecked())
                && (checkbox7.isChecked()) && (checkbox8.isChecked()) && (checkbox9.isChecked())
                && (checkbox10.isChecked()) && (checkbox11.isChecked()) && (checkbox12.isChecked()))
            cijfer = "10";
        else
            cijfer = "1";
        System.out.println("Cijfer is " + cijfer);
    }});

    checkbox9.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {
        if (checkbox1.isChecked() && (checkbox2.isChecked()) && (checkbox3.isChecked())
                && (checkbox4.isChecked()) && (checkbox5.isChecked()) && (checkbox6.isChecked())
                && (checkbox7.isChecked()) && (checkbox8.isChecked()) && (checkbox9.isChecked())
                && (checkbox10.isChecked()) && (checkbox11.isChecked()) && (checkbox12.isChecked()))
            cijfer = "10";
        else
            cijfer = "1";
        System.out.println("Cijfer is " + cijfer);
    }});


    checkbox10.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {
        if (checkbox1.isChecked() && (checkbox2.isChecked()) && (checkbox3.isChecked())
                && (checkbox4.isChecked()) && (checkbox5.isChecked()) && (checkbox6.isChecked())
                && (checkbox7.isChecked()) && (checkbox8.isChecked()) && (checkbox9.isChecked())
                && (checkbox10.isChecked()) && (checkbox11.isChecked()) && (checkbox12.isChecked()))
            cijfer = "10";
        else
            cijfer = "1";
        System.out.println("Cijfer is " + cijfer);
    }});


    checkbox11.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {
        if (checkbox1.isChecked() && (checkbox2.isChecked()) && (checkbox3.isChecked())
                && (checkbox4.isChecked()) && (checkbox5.isChecked()) && (checkbox6.isChecked())
                && (checkbox7.isChecked()) && (checkbox8.isChecked()) && (checkbox9.isChecked())
                && (checkbox10.isChecked()) && (checkbox11.isChecked()) && (checkbox12.isChecked()))
            cijfer = "10";
        else
            cijfer = "1";
        System.out.println("Cijfer is " + cijfer);
    }});


    checkbox12.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {
        if (checkbox1.isChecked() && (checkbox2.isChecked()) && (checkbox3.isChecked())
                && (checkbox4.isChecked()) && (checkbox5.isChecked()) && (checkbox6.isChecked())
                && (checkbox7.isChecked()) && (checkbox8.isChecked()) && (checkbox9.isChecked())
                && (checkbox10.isChecked()) && (checkbox11.isChecked()) && (checkbox12.isChecked()))
            cijfer ="10";
        else
            cijfer = "1";
        System.out.println("Cijfer is " + cijfer);
    }});}














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
