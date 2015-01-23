package com.ipmedt4.challengeweek_v2;

import android.annotation.TargetApi;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;


public class Overzicht_Studenten1H extends ActionBarActivity {
    private StudentDBAdapter dbHelper;
    private SimpleCursorAdapter dataAdapter;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overzicht__studenten1h);
        dbHelper = new StudentDBAdapter(this);
        dbHelper.open();

        //maak alle data schoon
        dbHelper.deleteAllStudenten();

        //toevoegen van data
        dbHelper.insertStudenten();

        //genereren ListView van SQLiteDatabase
        displayListView();

    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void displayListView(){
        Cursor cursor = dbHelper.SelecteerStudenten1H();

        //selecteer gewenste kolommen
        String[] columns = new String[]{
                StudentDBAdapter.KEY_NAAM,
                StudentDBAdapter.KEY_STUDENTNUMMER,
                StudentDBAdapter.KEY_KLAS,
                StudentDBAdapter.KEY_GROEP
        };

        //In XML gedefiniërde Views
        int[] to = new int[]{
                R.id.naam,
                R.id.studentnummer,
                R.id.klas,
                R.id.groep
        };


        dataAdapter = new SimpleCursorAdapter(
                this, R.layout.student_info,
                cursor,
                columns,
                to,
                0);

        ListView listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(dataAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View view, int position, long id) {
                Cursor cursor = (Cursor) listView.getItemAtPosition(position);
                Intent myintent2 = new Intent(view.getContext(), Beoordelingscherm.class);
                startActivity(myintent2);


            }
        });

        EditText myFilter = (EditText) findViewById(R.id.myFilter);
        myFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                { dataAdapter.getFilter().filter(s.toString());
                }}

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        dataAdapter.setFilterQueryProvider(new FilterQueryProvider() {
            @Override
            public Cursor runQuery(CharSequence constraint) {
                return dbHelper.fetchStudentenbyName(constraint.toString());
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_overzicht__studenten1_h, menu);
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
