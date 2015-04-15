package com.ipmedt4.challengeweek_v2;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class StudentenGroepen extends ListActivity {

    private ProgressDialog pDialog;

    // URL to get contacts JSON
    private static String url_studentengroepen = "http://charlenemacdonald.com/getStudentenGroepen.php";

    // JSON Node names
    private static final String TAG_STUDENTEN = "studenten";
    private static final String TAG_NAAM = "Naam";
    private static final String TAG_STUDENTNUMMER = "Studentnummer";
    private static final String TAG_KLAS = "Klas";
    private static final String TAG_GROEP = "Groep";
    private static final String TAG_CIJFER = "Cijfer";

Button volgendebutton;

    // contacts JSONArray
    JSONArray studenten= null;

    // Hashmap for ListView
    ArrayList<HashMap<String, String>> studentList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studenten_groepen);
        Intent in = getIntent();
        final String Klas = in.getStringExtra("Klas");
        final String Groep = in.getStringExtra("Groep");



        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            System.out.println("*** My thread is now configured to allow connection");
        }
        Button volgendebutton = (Button) findViewById(R.id.button);

        volgendebutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), BeoordelingschermGroepen.class);
                Intent in = new Intent();
                in.putExtra("Klas", Klas);
                in.putExtra("Groep", Groep);
                startActivityForResult(intent, 0);




        }});

        studentList = new ArrayList<HashMap<String, String>>();

        ListView lv = (ListView) findViewById(android.R.id.list);
        Intent ine = getIntent();



        // Calling async task to get json
        new GetStudentenuitGroep().execute("Klas", "Groep");

    }


    /**
     * Async task class to get json by making HTTP call
     * */
    private class GetStudentenuitGroep extends AsyncTask<String, String, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                // Showing progress dialog
                pDialog = new ProgressDialog(StudentenGroepen.this);
                pDialog.setMessage("Even geduld a.u.b., studenten worden geladen...");
                pDialog.setCancelable(false);
                pDialog.show();


            }

            @Override
            protected String doInBackground(String... args) {
                Intent intent = getIntent();
                String Klas = intent.getStringExtra("Klas");
                String Groep = intent.getStringExtra("Groep");

                // Making a request to url and getting response
                ServiceHandler sh = new ServiceHandler();

                String jsonStr = sh.makeServiceCall(url_studentengroepen, ServiceHandler.GET);

                Log.d("Response: ", "> " + jsonStr);

                if (jsonStr != null) {
                    try {

                        JSONObject jsonObj = new JSONObject(jsonStr);


                        List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();

                        params.add(new BasicNameValuePair("Klas", Klas));
                        params.add(new BasicNameValuePair("Groep", Groep));


                        // Getting JSON Array node
                        studenten = jsonObj.getJSONArray(TAG_STUDENTEN);

                        // looping through All Contacts
                        for (int i = 0; i < studenten.length(); i++) {
                            JSONObject c = studenten.getJSONObject(i);

                            String Naam = c.getString(TAG_NAAM);
                            String Studentnummer = c.getString(TAG_STUDENTNUMMER);



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
            protected void onPostExecute(String file_url) {

                // Dismiss the progress dialog
                if (pDialog.isShowing())
                    pDialog.dismiss();
                /**
                 * Updating parsed JSON data into ListView
                 * */
                ListAdapter adapter = new SimpleAdapter(
                        StudentenGroepen.this, studentList,
                        R.layout.student_info, new String[]{TAG_NAAM, TAG_STUDENTNUMMER,
                        TAG_KLAS, TAG_GROEP}, new int[]{R.id.Naam,
                        R.id.Studentnummer, R.id.Klas, R.id.Groep});

                setListAdapter(adapter);
            }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_overzicht_studenten, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
