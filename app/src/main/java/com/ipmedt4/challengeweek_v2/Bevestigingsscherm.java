package com.ipmedt4.challengeweek_v2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class Bevestigingsscherm extends ActionBarActivity {
    Button beoordelingbevestigen;
    Button beoordelingannuleren;
    private static final String url_cijferbevestigen = "http://charlenemacdonald.com/updateCijferStudent.php";
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_STUDENTEN = "studenten";
    private static final String TAG_NAAM = "Naam";
    private static final String TAG_STUDENTNUMMER = "Studentnummer";
    private static final String TAG_KLAS = "Klas";
    private static final String TAG_CIJFER = "Cijfer";

    InputStream is=null;
    String result=null;
    String line=null;
    int code;

    private ProgressDialog pDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bevestigingsscherm);
        Intent in = getIntent();
        final String Naam = in.getStringExtra("Naam");
         final String Studentnummer = in.getStringExtra("Studentnummer");
         final String Cijfer = in.getStringExtra("Cijfer");
        

        System.out.println(Naam + Studentnummer + Cijfer);




        Button beoordelingbevestigen = (Button) findViewById(R.id.beoordelingbevestigen);
        Button beoordelingannuleren = (Button) findViewById(R.id.bevestingannuleren);
        TextView beoordelingtekst = (TextView) findViewById(R.id.beoordelingtekst);
        String tekstbeoordeling = Naam + "" + "" + " met studentnummer " + "" + "" + Studentnummer + " heeft een " + Cijfer + "" + "" + " behaald. ";
        beoordelingtekst.setText(tekstbeoordeling);
        System.out.println(tekstbeoordeling);


        beoordelingbevestigen.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                new updateCijferStudent().execute("Naam", "Studentnummer", "Cijfer");








                    }
                });







        beoordelingannuleren.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), Beoordelingscherm.class);
                startActivityForResult(intent, 0);


            }
        });


    }
   public class updateCijferStudent extends AsyncTask<String, String, String> {




       /**
         * Before starting background thread Show Progress Dialog
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Bevestigingsscherm.this);
            pDialog.setMessage("Saving product ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        /**
         * Saving product
         */
        protected String doInBackground(String... args) {
            Intent i = getIntent();
            String Naam = i.getStringExtra("Naam");
            String Studentnummer = i.getStringExtra("Studentnummer");
            String Cijfer = i.getStringExtra("Cijfer");



            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();

            params.add(new BasicNameValuePair(TAG_STUDENTNUMMER, Studentnummer));
            params.add(new BasicNameValuePair(TAG_CIJFER, Cijfer));
            System.out.println("Intents:" + Naam + Studentnummer + Cijfer);

            JSONParser p  = new JSONParser();
            // sending modified data through http request
            // Notice that update product url accepts POST method
            JSONObject json = p.makeHttpRequest(url_cijferbevestigen, "POST", params );
                System.out.println(json);
            // check json success tag
            try {
                int success = json.getInt(TAG_SUCCESS);

                if (json != null && success == 1) {
                    // successfully updated
                    Intent ine = getIntent();
                    // send result code 100 to notify about product update
                    setResult(100, i);
                    finish();
                } else {
                    // failed to update product
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         * *
         */
        protected void onPostExecute(String file_url) {
            // dismiss the dialog once product uupdated
            pDialog.dismiss();
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bevestigingsscherm, menu);
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
    }}







