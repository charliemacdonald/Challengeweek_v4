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


public class BevestigingschermGroepen extends ActionBarActivity {
    private ProgressDialog pDialog;
    private static final String url_cijferbevestigengroepen = "http://charlenemacdonald.com/updateCijferGroep.php";
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_STUDENTEN = "studenten";
    private static final String TAG_NAAM = "Naam";
    private static final String TAG_STUDENTNUMMER = "Studentnummer";
    private static final String TAG_KLAS = "Klas";
    private static final String TAG_GROEP = "Groep";
    private static final String TAG_CIJFER = "Cijfer";

    InputStream is=null;
    String result=null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bevestigingscherm_groepen);
        Intent in = getIntent();
        final String Klas = in.getStringExtra("Klas");
        final String Groep = in.getStringExtra("Groep");
        final String Cijfer = in.getStringExtra("Cijfer");
       System.out.println(Klas + Groep + Cijfer);

        Button beoordelingbevestigen = (Button) findViewById(R.id.beoordelingbevestigen);
        Button beoordelingannuleren = (Button) findViewById(R.id.bevestingannuleren);

        TextView tekstbeoordelingstudenten = (TextView) findViewById(R.id.beoordelingtekst);
        tekstbeoordelingstudenten.setText("Groep " + "" + "" +
        Groep + " uit klas " + "" + "" + Klas + "" + "" + " heeft een "
        + "" + "" + Cijfer + "" + "" + " behaald.");

        beoordelingbevestigen.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                new updateCijferGroep().execute("Klas", "Groep", "Cijfer");


            }
        });







        beoordelingannuleren.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), BeoordelingschermGroepen.class);
                intent.getStringExtra("Klas");
               intent.getStringExtra("Groep");


                startActivityForResult(intent, 0);

            }

        });


    }
    public class updateCijferGroep extends AsyncTask<String, String, String> {




        /**
         * Before starting background thread Show Progress Dialog
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(BevestigingschermGroepen.this);
            pDialog.setMessage("Opslaan van cijfer ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        /**
         * Saving product
         */
        protected String doInBackground(String... args) {
            Intent i = getIntent();
            String Klas = i.getStringExtra("Klas");
            String Groep = i.getStringExtra("Groep");
            String Cijfer = i.getStringExtra("Cijfer");



            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();

            params.add(new BasicNameValuePair(TAG_KLAS, Klas));
            params.add(new BasicNameValuePair(TAG_GROEP, Groep));
            params.add(new BasicNameValuePair(TAG_CIJFER, Cijfer));
            System.out.println("Intents:" + Klas + Groep + Cijfer);

            JSONParser p  = new JSONParser();
            // sending modified data through http request
            // Notice that update product url accepts POST method
            JSONObject json = p.makeHttpRequest(url_cijferbevestigengroepen, "POST", params );
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
        getMenuInflater().inflate(R.menu.menu_bevestigingscherm_groepen, menu);
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
