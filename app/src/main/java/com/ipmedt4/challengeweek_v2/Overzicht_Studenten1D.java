package com.ipmedt4.challengeweek_v2;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class Overzicht_Studenten1D extends ListActivity {


    // URL to get contacts JSON
    private ProgressDialog pDialog;

    // URL to get contacts JSON
    private static String url = "http://charlenemacdonald.com/getStudenten1D.php";

    // JSON Node names
    private static final String TAG_STUDENTEN = "studenten";
    private static final String TAG_NAAM = "Naam";
    private static final String TAG_STUDENTNUMMER = "Studentnummer";
    private static final String TAG_KLAS = "Klas";
    private static final String TAG_GROEP = "Groep";
    private static final String TAG_CIJFER = "Cijfer";
    private static final String TAG_OPMERKINGEN = "Opmerkingen";


    // contacts JSONArray
    JSONArray studenten= null;

    // Hashmap for ListView
    ArrayList<HashMap<String, String>> studentList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overzicht_studenten);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            System.out.println("*** My thread is now configured to allow connection");
        }

        studentList = new ArrayList<HashMap<String, String>>();

        ListView lv = (ListView) findViewById(android.R.id.list);
        // Listview on item click listener
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // getting values from selected ListItem
                String Naam = ((TextView) view.findViewById(R.id.Naam))
                        .getText().toString();
                String Studentnummer = ((TextView) view.findViewById(R.id.Studentnummer))
                        .getText().toString();
                String Klas = ((TextView) view.findViewById(R.id.Klas))
                        .getText().toString();
                String Groep = ((TextView) view.findViewById(R.id.Groep))
                        .getText().toString();

                // Starting single contact activity
                Intent in = new Intent(getApplicationContext(),
                        Beoordelingscherm.class);
                in.putExtra(TAG_NAAM, Naam);
                in.putExtra(TAG_STUDENTNUMMER, Studentnummer);
                in.putExtra(TAG_KLAS, Klas);
                startActivity(in);

            }
        });

        // Calling async task to get json
        new GetStudenten().execute();
    }

    /**
     * Async task class to get json by making HTTP call
     * */
    private class GetStudenten extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(Overzicht_Studenten1D.this);
            pDialog.setMessage("Even geduld a.u.b., studenten worden geladen...");
            pDialog.setCancelable(false);
            pDialog.show();


        }

        @Override
        protected Void doInBackground(Void... arg0) {
            // Creating service handler class instance
            ServiceHandler sh = new ServiceHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    studenten = jsonObj.getJSONArray(TAG_STUDENTEN);

                    // looping through All Contacts
                    for (int i = 0; i < studenten.length(); i++) {
                        JSONObject c = studenten.getJSONObject(i);

                        String Naam = c.getString(TAG_NAAM);
                        String Studentnummer = c.getString(TAG_STUDENTNUMMER);
                        String Klas = c.getString(TAG_KLAS);
                        String Groep = c.getString(TAG_GROEP);


                        // tmp hashmap for single contact
                        HashMap<String, String> student = new HashMap<String, String>();

                        // adding each child node to HashMap key => value
                        student.put(TAG_NAAM, Naam);
                        student.put(TAG_STUDENTNUMMER, Studentnummer);
                        student.put(TAG_KLAS, Klas);
                        student.put(TAG_GROEP, Groep);

                        // adding contact to contact list
                        studentList.add(student);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            ListAdapter adapter = new SimpleAdapter(
                    Overzicht_Studenten1D.this, studentList,
                    R.layout.student_info, new String[] { TAG_NAAM, TAG_STUDENTNUMMER,
                    TAG_KLAS, TAG_GROEP }, new int[] { R.id.Naam,
                    R.id.Studentnummer, R.id.Klas, R.id.Groep });

            setListAdapter(adapter);
        }

    }

}